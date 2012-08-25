/**
 * 
 */
package se.sics.kompics.ide.builder;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.AnonymousClassDeclaration;
import org.eclipse.jdt.core.dom.Assignment;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.QualifiedName;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationExpression;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;

import se.sics.kompics.ide.Activator;
import se.sics.kompics.ide.Model;
import se.sics.kompics.ide.model.ast.ASTChannel;
import se.sics.kompics.ide.model.ast.ASTComponent;
import se.sics.kompics.ide.model.ast.ASTComponentDefinition;
import se.sics.kompics.ide.model.ast.ASTEvent;
import se.sics.kompics.ide.model.ast.ASTHandler;
import se.sics.kompics.ide.model.ast.ASTModelObject;
import se.sics.kompics.ide.model.ast.ASTPort;
import se.sics.kompics.ide.model.ast.ASTPortType;
import se.sics.kompics.ide.model.ast.ASTSubscription;
import se.sics.kompics.model.kompicsComponents.Channel;
import se.sics.kompics.model.kompicsComponents.ComponentDefinition;
import se.sics.kompics.model.kompicsComponents.Event;
import se.sics.kompics.model.kompicsComponents.Handler;
import se.sics.kompics.model.kompicsComponents.KompicsComponentsFactory;
import se.sics.kompics.model.kompicsComponents.Port;
import se.sics.kompics.model.kompicsComponents.PortType;
import se.sics.kompics.model.kompicsComponents.Subscription;

/**
 * The <code>ModelVisitor</code> .
 * 
 * @author Lars Kroll <lkr@lars-kroll.com>
 * @version $Id: $
 * 
 */
public class ModelVisitor extends ASTVisitor {

	private ASTNode root;
	private KompicsModelBuilder builder;

	private KompicsComponentsFactory factory = KompicsComponentsFactory.eINSTANCE;

	private Stack<ASTModelObject> visitStack = new Stack<ASTModelObject>();

	private Map<String, ASTHandler> handlerVars = new HashMap<String, ASTHandler>();
	private Map<String, ASTPort> portVars = new HashMap<String, ASTPort>();
	private Map<String, ASTComponent> componentVars = new HashMap<String, ASTComponent>();

	private List<MethodInvocation> deferredMethods = new LinkedList<MethodInvocation>();
	private boolean retryFlag = false;

	public ModelVisitor(ASTNode root, KompicsModelBuilder builder) {
		this.setRoot(root);
		this.setBuilder(builder);
	}

	/**
	 * @return the builder
	 */
	public KompicsModelBuilder getBuilder() {
		return builder;
	}

	/**
	 * @param builder
	 *            the builder to set
	 */
	public void setBuilder(KompicsModelBuilder builder) {
		this.builder = builder;
	}

	/**
	 * @return the root
	 */
	public ASTNode getRoot() {
		return root;
	}

	/**
	 * @param root
	 *            the root to set
	 */
	public void setRoot(ASTNode root) {
		this.root = root;
	}

	//
	// OVERRIDES
	//

	@Override
	public boolean visit(TypeDeclaration type) {
		ITypeBinding binding = type.resolveBinding();
		return createModel(type, binding);
	}

	@Override
	public void endVisit(TypeDeclaration type) {
		if (!visitStack.isEmpty()) {
			ITypeBinding binding = type.resolveBinding();
			IBinding stackBinding = visitStack.peek().getBinding();
			if (binding.isEqualTo(stackBinding)) {
				if (isInSupertypes(binding, "se.sics.kompics.ComponentDefinition")) {
					retryDeferred();
					deferredMethods.clear();
					portVars.clear(); // Assume that only top-leve;
					handlerVars.clear(); // components define handlers
					componentVars.clear(); // , ports and component instances

				}
				visitStack.pop();
			}
		}
	}

	@Override
	public boolean visit(MethodInvocation method) {
		IMethodBinding binding = method.resolveMethodBinding();
		createModel(method, binding);
		return false;
	}

	@Override
	public boolean visit(AnonymousClassDeclaration type) {
		ITypeBinding binding = type.resolveBinding();
		// Activator.log("Anonymous Class with supertypes: "
		// + listSuperTypes(binding));
		return createModel(type, binding);
	}

	//
	// PRIVATE
	//

	private void createModel(MethodInvocation method, IMethodBinding binding) {
		// Activator.log("Method: " + binding.getName() + " from "
		// + binding.getDeclaringClass().getQualifiedName());
		String name = binding.getName();
		String decClass = binding.getDeclaringClass().getQualifiedName();
		if ((name.equals("provides")) || (name.equals("negative"))
				&& decClass.equals("se.sics.kompics.ComponentDefinition")) {
			createPort(method, ASTModelObject.PROVIDED_PORT);
		} else if ((name.equals("requires")) || (name.equals("positive"))
				&& decClass.equals("se.sics.kompics.ComponentDefinition")) {
			createPort(method, ASTModelObject.REQUIRED_PORT);
		} else if ((name.equals("indication")) || (name.equals("positive"))
				&& decClass.equals("se.sics.kompics.PortType")) {
			createEvent(method, ASTModelObject.PROVIDED_PORT);
		} else if ((name.equals("request")) || (name.equals("negative"))
				&& decClass.equals("se.sics.kompics.PortType")) {
			createEvent(method, ASTModelObject.REQUIRED_PORT);
		} else if ((name.equals("subscribe") && decClass
				.equals("se.sics.kompics.ComponentDefinition"))) {
			addSubscription(method);
		} else if ((name.equals("connect"))
				&& decClass.equals("se.sics.kompics.ComponentDefinition")) {
			createChannel(method);
		} else if ((name.equals("create"))
				&& decClass.equals("se.sics.kompics.ComponentDefinition")) {
			createComponentInstance(method);
		}
	}

	private boolean createModel(TypeDeclaration type, ITypeBinding binding) {
		if (isInSupertypes(binding, "se.sics.kompics.ComponentDefinition")) {
			createComponent(type);
			return true;
		} else if (isInSupertypes(binding, "se.sics.kompics.PortType")) {
			createPortType(type);
			return true;
		} else if (isInSupertypes(binding, "se.sics.kompics.Event")) {
			createEvent(type);
			return false;
		} else if (isInSupertypes(binding, "se.sics.kompics.Handler")) {
			createHandler(type, binding);
			return false;
		}
		return true;
	}

	private boolean createModel(AnonymousClassDeclaration type, ITypeBinding binding) {
		// if (isInSupertypes(binding, "se.sics.kompics.ComponentDefinition")) {
		// createComponent(type);
		// return true;
		// } else if (isInSupertypes(binding, "se.sics.kompics.PortType")) {
		// createPortType(type);
		// return true;
		// } else if (isInSupertypes(binding, "se.sics.kompics.Event")) {
		// createEvent(type);
		// return false;
		// } else
		if (isInSupertypes(binding, "se.sics.kompics.Handler")) {
			createHandler(type, binding);
			return false;
		}
		return true;
	}

	private void createChannel(MethodInvocation method) {
		if (visitStack.isEmpty())
			return; // need Component as top level element
		// Activator.log("Trying to scan channel from method invocation: " +
		// method);
		ASTModelObject stackObject = visitStack.peek();
		List<Expression> args = method.arguments();
		if (args.size() < 2) {
			Activator
					.log("Method 'connect' called with less than two arguments. (Doesn't make much sense, does it?)");
			return; // need at least two arguments to connect
		}
		Expression ex1 = args.get(0);
		// Activator.log("Expression 1: " + ex1.toString() + " of type " +
		// ASTNode.nodeClassForType(ex1.getNodeType()));

		// Activator.log("Method Invocation Expression: " +
		// mi1.getExpression().toString() + " of type " +
		// ASTNode.nodeClassForType(mi1.getExpression().getNodeType()));
		Expression ex2 = args.get(1);
		ITypeBinding bind1 = ex1.resolveTypeBinding();
		ITypeBinding bind2 = ex2.resolveTypeBinding();
		// Activator.log("Bind 1: " + listSuperTypes(bind1));
		// Activator.log("Bind 2: " + listSuperTypes(bind2));
		ITypeBinding posBind = null, negBind = null;
		Expression posEx = null, negEx = null;
		if (isInSupertypes(bind1, "se.sics.kompics.Positive")) {
			posBind = bind1;
			posEx = ex1;
			if (isInSupertypes(bind2, "se.sics.kompics.Positive"))
				return; // Can't connect two positive ports
		} else if (isInSupertypes(bind1, "se.sics.kompics.Negative")) {
			negBind = bind1;
			negEx = ex1;
			if (isInSupertypes(bind2, "se.sics.kompics.Negative"))
				return; // Can't connect two negative ports
		}
		if (isInSupertypes(bind2, "se.sics.kompics.Positive")) {
			posBind = bind2;
			posEx = ex2;
			if (isInSupertypes(bind1, "se.sics.kompics.Positive"))
				return; // Can't connect two positive ports
		} else if (isInSupertypes(bind2, "se.sics.kompics.Negative")) {
			negBind = bind2;
			negEx = ex2;
			if (isInSupertypes(bind1, "se.sics.kompics.Negative"))
				return; // Can't connect two negative ports
		}
		if ((posBind == null) || (negBind == null)) {
			Activator.log("Either " + bind1.getQualifiedName() + " or " + bind2.getQualifiedName()
					+ " appears to be a non matching type for 'connect'.");
			return; // One of the arguments has wrong type
		}
		ITypeBinding[] posTypes = posBind.getTypeArguments();
		ITypeBinding[] negTypes = negBind.getTypeArguments();
		if ((posTypes.length < 1) || (negTypes.length < 1)) {
			Activator.log("Either " + posTypes + " or " + negTypes
					+ " doesn't have enough type parameters (< 1).");
			return; // One is missing type arguments
		}
		ITypeBinding posTypeBind = posTypes[0];
		ITypeBinding negTypeBind = negTypes[0];
		// if (!posTypeBind.isEqualTo(negTypeBind))
		// return; // Can't connect two ports of different types

		// Try to get ports out of the variables
		ASTPort posPort = findPort(posEx, posTypeBind, ASTModelObject.PROVIDED_PORT);
		ASTPort negPort = findPort(negEx, negTypeBind, ASTModelObject.REQUIRED_PORT);
		if (posPort == null) {
			if (!retryFlag) {
				defer(method);
				return;
			}
			Activator.log("Couldn't find port for expression: " + posEx);
			return;
		}
		if (negPort == null) {
			if (!retryFlag) {
				defer(method);
				return;
			}
			Activator.log("Couldn't find port for expression: " + negEx);
			return;
		}
		Channel ch = factory.createChannel();
		String chID = "Channel:(" + posPort.getId() + "," + negPort.getId() + ")";
		ASTChannel astch = new ASTChannel(chID, ch, method);
		astch = Model.add(astch);
		ch.setPortType(posPort.getModel().getPortType());
		ch.setProvided(posPort.getModel());
		ch.setRequired(negPort.getModel());
		astch.setBinding(method.resolveMethodBinding());
		astch.setLocationBinding(findBinding(method.getParent()));
		astch.addChild(posPort);
		astch.addChild(negPort);
		stackObject.addChild(astch);
		astch.setParent(stackObject);
	}

	private void addSubscription(MethodInvocation method) {
		if (!visitStack.isEmpty()) {
			ASTModelObject stackObject = visitStack.peek();
			List<Expression> args = method.arguments();
			if (args.size() > 1) {
				Expression handlerEx = args.get(0);
				Expression portEx = args.get(1);
				ITypeBinding handlerBind = handlerEx.resolveTypeBinding();
				ITypeBinding portBind = portEx.resolveTypeBinding();

				// Get Handler
				ITypeBinding[] handlerTypes = handlerBind.getTypeArguments();
				if (handlerTypes.length < 1)
					return;
				ITypeBinding handlerParamBind = handlerTypes[0];
				String handlerVar = findVariableName(handlerEx, handlerBind);
				if (handlerVar == null)
					return; // Can't find the right handler without a variable
							// name
				ASTHandler asth = handlerVars.get(handlerVar);
				if (asth == null) {
					String error = "Could not find Handler for Event "
							+ handlerParamBind.getQualifiedName();
					error += "\n trying to defer...";
					if (!defer(method)) {
						error += "failed";
						// TODO Add warning marker for missing handler
					} else {
						error += "done";
					}
					Activator.log(error);
					return;
				}

				// Get Port
				if (portEx.getNodeType() == ASTNode.METHOD_INVOCATION) {
					MethodInvocation mi = (MethodInvocation) portEx;
					if (mi.getName().getIdentifier().equals("control")) {
						Expression miEx = mi.getExpression();
						if (miEx.getNodeType() == ASTNode.SIMPLE_NAME) {
							String miVar = ((SimpleName) miEx).getIdentifier();
							ASTComponent comp = componentVars.get(miVar);
							if (comp == null) {
								Activator.log("Couldn't find component for variable " + miVar);
								defer(method);
								return;
							}
							ASTPort astp = comp.getControlPort();
							Subscription s = factory.createSubscription();
							String sID = "Subscription:(" + astp.getId() + "," + asth.getId() + ")";
							ASTSubscription asts = new ASTSubscription(sID, s, method);
							asts.setBinding(method.resolveMethodBinding());
							asts.setLocationBinding(findBinding(method));
							asts.setHandler(asth);
							asts.setPort(astp);
							asts.addToModel(asth.getModel(), ASTModelObject.NONE);
							asts.addToModel(astp.getModel(), ASTModelObject.NONE);
							astp.addChild(asts);
							astp.addToModel(asts.getModel(), ASTModelObject.NONE);
							asth.addToModel(asts.getModel(), ASTModelObject.NONE);
							
							return;
						} else {
							return; // The component will be out of scope and hard to locate.
						}
					} else {
						return; // The port will be out of scope and hard to locate.
					}
				}
				
				ITypeBinding[] portTypes = portBind.getTypeArguments();
				if (handlerTypes.length < 1)
					return;
				ITypeBinding portParamBind = portTypes[0];
				String portVar = findVariableName(portEx, portBind);
				if (portVar == null)
					return; // Can't find the right port without a variable name
				ASTPort astp = portVars.get(portVar);
				if (astp == null) {
					String error = "Could not find Port of Type "
							+ portParamBind.getQualifiedName();
					error += "\n trying to defer...";
					if (!defer(method)) {
						error += "failed";
						// TODO Add warning marker for missing port
					} else {
						error += "done";
					}
					Activator.log(error);
					return;
				}

				// add handler subscription to port
				// Activator.log("Handler "
				// + asth.getModel().getEventType().getType()
				// + " subscribed to port "
				// + astp.getModel().getPortType().getType()
				// + " in Component "
				// + astp.getParent().getBinding().getName());

				Subscription s = factory.createSubscription();
				String sID = "Subscription:(" + astp.getId() + "," + asth.getId() + ")";
				ASTSubscription asts = new ASTSubscription(sID, s, method);
				asts.setBinding(method.resolveMethodBinding());
				asts.setLocationBinding(findBinding(method));
				asts.setHandler(asth);
				asts.setPort(astp);
				asts.addToModel(asth.getModel(), ASTModelObject.NONE);
				asts.addToModel(astp.getModel(), ASTModelObject.NONE);
				astp.addChild(asts);
				astp.addToModel(asts.getModel(), ASTModelObject.NONE);
				asth.addToModel(asts.getModel(), ASTModelObject.NONE);
			}
		}
	}

	private void createEvent(TypeDeclaration type) {
		ITypeBinding binding = type.resolveBinding();
		ASTEvent aste = Model.getEvent(binding.getQualifiedName());
		if (aste == null) {
			Event e = factory.createEvent();
			e.setType(binding.getQualifiedName());
			aste = new ASTEvent("Event:" + binding.getQualifiedName(), e, type);
			aste = Model.add(aste);
			aste.setBinding(binding);
		} else {
			aste.setNode(type);
		}
		if (!visitStack.isEmpty()) {
			ASTModelObject astmo = visitStack.peek();
			astmo.addChild(aste);
			aste.setParent(astmo);
			astmo.addToModel(aste.getModel(), ASTModelObject.NONE);
		}
	}

	private void createHandler(ASTNode type, ITypeBinding binding) {
		// Activator.log("Creating Handler");
		ITypeBinding[] paramBind = binding.getSuperclass().getTypeArguments();
		if (paramBind.length > 0) { // Should have exactly 1, but anyway
			ITypeBinding eventBinding = paramBind[0];
			ASTEvent aste = Model.getEvent(eventBinding.getQualifiedName());
			if (aste == null) { // The compilation unit, where the Event
								// is declared hasn't been scanned yet
				Event e = factory.createEvent();
				e.setType(eventBinding.getQualifiedName());
				aste = new ASTEvent("Event:" + eventBinding.getQualifiedName(), e, null);
				// can't add the ASTNode because we don't know the compilation
				// unit
				aste = Model.add(aste);
				aste.setBinding(eventBinding);

			} else {
				if (aste.getBinding() == null) {
					aste.setBinding(eventBinding);
				}
			}
			
			Handler h = factory.createHandler();
			h.setEventType(aste.getModel());
			ASTHandler asth = null;
			String hID = "";
			if (!visitStack.isEmpty()) {
				ASTModelObject astmo = visitStack.peek();
				hID = astmo.getId() + "/Handler:" + aste.getId();
				asth = new ASTHandler(hID, h, type);
				asth = Model.add(asth);
				astmo.addChild(asth);
				astmo.addToModel(h, ASTModelObject.NONE);
				String varName = findVariableName(type, binding);
				if (varName != null) {
					handlerVars.put(varName, asth);
				} else {
					Activator.log("Couldn't find variable for handler of type "
							+ eventBinding.getQualifiedName());
				}
			} else {
				hID = binding.getQualifiedName() + "/Handler:" + aste.getId();
				asth = new ASTHandler(hID, h, type);
				asth = Model.add(asth);
			}
			asth.setBinding(binding);
		}

	}

	private void createPort(MethodInvocation method, int envMod) {
		if (visitStack.isEmpty())
			return; // Can't add ports anywhere but in ComponentDefinitions
		ASTModelObject astmo = visitStack.peek();
		if (!(astmo instanceof ASTComponentDefinition))
			return; // Can't add ports anywhere but in ComponentDefinitions

		ASTComponentDefinition astcd = (ASTComponentDefinition) astmo;

		List<Expression> args = method.arguments();
		// String argStr = "";
		// for (Expression e : args) {
		// argStr += e.resolveTypeBinding().getQualifiedName() + " // ";
		// }
		// Activator.log("Method " + binding.getName() + " has type args: " +
		// argStr);
		if (!args.isEmpty()) {
			Expression e = args.get(0);
			ITypeBinding eBind = e.resolveTypeBinding();
			ITypeBinding[] paramBind = eBind.getTypeArguments();
			// Activator.log("Method " + binding.getName() +
			// " has generic type arg: " + paramBind[0].getQualifiedName());
			if (paramBind.length > 0) {
				ITypeBinding portTypeBinding = paramBind[0];
				ASTPortType apt = Model.getPort(portTypeBinding.getQualifiedName());
				if (apt == null) { // The compilation unit, where the PortType
									// is declared hasn't been scanned yet
					PortType pt = factory.createPortType();
					pt.setType(portTypeBinding.getQualifiedName());
					apt = new ASTPortType("PortType:" + portTypeBinding.getQualifiedName(), pt,
							null);
					// can't add ASTNode because we don't know the compilation
					// unit
					apt = Model.add(apt);
					apt.setBinding(portTypeBinding);
				}
				Port p = factory.createPort();
				p.setPortType(apt.getModel());
				String pID = astcd.getId() + "/Port:" + apt.getId() + ":"
						+ method.getStartPosition();
				ASTPort astp = new ASTPort(pID, p, method);
				astp.setBinding(method.resolveMethodBinding()); // Might not be
																// very helpful
				ASTNode parent = method.getParent();
				IBinding parentBind = findBinding(parent);
				astp.setLocationBinding(parentBind); // may be null

				astp = Model.add(astp);
				switch (envMod) {
				case ASTModelObject.PROVIDED_PORT:
					p.setProvided(true);
					astcd.addProvided(astp);
					break;
				case ASTModelObject.REQUIRED_PORT:
					p.setProvided(false);
					astcd.addRequired(astp);
				}

				astmo.addChild(astp);
				astp.setParent(astmo);
				String varName = findVariableName(method, method.resolveTypeBinding());
				if (varName != null) {
					portVars.put(varName, astp);
				} else {
					Activator.log("Couldn't find variable for port of type "
							+ astp.getModel().getPortType().getType());
				}
			}
		}

	}

	private void createEvent(MethodInvocation method, int envMod) {
		if (!visitStack.isEmpty()) {
			ASTModelObject astmo = visitStack.peek();
			List<Expression> args = method.arguments();
			// String argStr = "";
			// for (Expression e : args) {
			// argStr += e.resolveTypeBinding().getQualifiedName() + " // ";
			// }
			// Activator.log("Method " + binding.getName() + " has type args: "
			// +
			// argStr);
			if (!args.isEmpty()) {
				Expression ex = args.get(0);
				ITypeBinding eBind = ex.resolveTypeBinding();
				ITypeBinding[] paramBind = eBind.getTypeArguments();
				// Activator.log("Method " + binding.getName() +
				// " has generic type arg: " + paramBind[0].getQualifiedName());
				if (paramBind.length > 0) {
					ITypeBinding eventBinding = paramBind[0];
					ASTEvent aste = Model.getEvent(eventBinding.getQualifiedName());
					if (aste == null) { // The compilation unit, where the Event
										// is declared hasn't been scanned yet
						Event e = factory.createEvent();
						e.setType(eventBinding.getQualifiedName());
						aste = new ASTEvent("Event:" + eventBinding.getQualifiedName(), e, null);
						// can't add ASTNode because we don't know the
						// compilation unit
						aste = Model.add(aste);
						aste.setBinding(eventBinding);
					}
					astmo.addChild(aste);
					astmo.addToModel(aste.getModel(), envMod);

				}
			}
		}

	}

	private void createPortType(TypeDeclaration type) {
		ITypeBinding binding = type.resolveBinding();
		PortType p = factory.createPortType();
		p.setType(binding.getQualifiedName());
		ASTPortType astp = new ASTPortType("PortType:" + binding.getQualifiedName(), p, type);
		astp = Model.add(astp);
		astp.setBinding(binding);
		if (!visitStack.isEmpty()) {
			ASTModelObject astmo = visitStack.peek();
			astmo.addChild(astp);
			astp.setParent(astmo);
			astmo.addToModel(p, ASTModelObject.NONE);
		}
		visitStack.push(astp);
	}

	private void createComponent(TypeDeclaration type) {
		ITypeBinding binding = type.resolveBinding();
		ComponentDefinition c = factory.createComponentDefinition();
		c.setType(binding.getQualifiedName());
		ASTComponentDefinition astc = new ASTComponentDefinition("ComponentDefinition:"
				+ binding.getQualifiedName(), c, type);
		astc = Model.add(astc);
		astc.setBinding(binding);
		if (!visitStack.isEmpty()) {
			ASTModelObject astmo = visitStack.peek();
			astmo.addChild(astc);
			astc.setParent(astmo);
			astmo.addToModel(c, ASTModelObject.NONE);
		}
		visitStack.push(astc);
	}

	private void createComponentInstance(MethodInvocation method) {
		List<Expression> args = method.arguments();
		if (args.isEmpty())
			return;
		Expression classEx = args.get(0);
		ITypeBinding classBind = classEx.resolveTypeBinding();
		ITypeBinding[] paramBind = classBind.getTypeArguments();
		if (paramBind.length < 1)
			return;
		ITypeBinding compBind = paramBind[0];
		ASTComponentDefinition astcd = Model.getComponent(compBind.getQualifiedName());
		if (astcd == null) {
			String error = "Could not find a ComponentDefinition of type ";
			error += compBind.getQualifiedName() + "\n";
			error += " If it is in your path, then it most likely hasn't been scanned, yet.\n";
			// error +=
			// " This represents somewhat of a problem, though, since Component creation calls can't be deferred";
			// error +=
			// " until another compilation unit has been scanned. \n Thus I have no idea how to fix that problem ;(";
			error += "Trying to defer...";
			Activator.log(error);
			builder.defer(root);
			return;
		}
		String varName = findVariableName(method, method.resolveTypeBinding());
		ASTComponent c = astcd.createInstance(varName, method);
		c.setBinding(astcd.getBinding());
		ASTNode parent = method.getParent();
		IBinding parentBind = findBinding(parent);
		c.setLocationBinding(parentBind);
		if (!visitStack.isEmpty()) {
			ASTModelObject astmo = visitStack.peek();
			astmo.addChild(c);
			if (astmo instanceof ASTComponentDefinition) {
				ASTComponentDefinition astcdLoc = (ASTComponentDefinition) astmo;
				astcdLoc.addSubInstance(c);
			}
			if (varName != null) {
				componentVars.put(varName, c);
			} else {
				Activator.log("Couldn't find variable for component instance of type "
						+ c.getModel().getType().getType());
			}
		}
	}

	//
	// HELPERS
	//

	private boolean defer(MethodInvocation method) {
		if (retryFlag)
			return false;
		deferredMethods.add(method);
		return true;
	}

	private void retryDeferred() {
		// Activator.log("Retrying deferred methods for " +
		// visitStack.peek().getBinding().getName());
		retryFlag = true;
		for (MethodInvocation method : deferredMethods) {
			IMethodBinding binding = method.resolveMethodBinding();
			createModel(method, binding);
		}
		retryFlag = false;
	}

	private boolean isInSupertypes(ITypeBinding binding, String qualifiedName) {
		if (binding == null)
			return false;
		String typeName = binding.getQualifiedName();
		if (typeName.equalsIgnoreCase(qualifiedName) || typeName.startsWith(qualifiedName + "<")) {
			return true;
		} else if (typeName.equalsIgnoreCase("java.lang.Object")) {
			return false;
		} else {
			return isInSupertypes(binding.getSuperclass(), qualifiedName);
		}
	}

	private String listSuperTypes(ITypeBinding binding) {
		if (binding == null)
			return "";
		if (binding.getQualifiedName().equalsIgnoreCase("java.lang.Object")) {
			return "java.lang.Object";
		} else {
			return binding.getQualifiedName() + " extends "
					+ listSuperTypes(binding.getSuperclass());
		}

	}

	private IBinding findBinding(ASTNode node) {
		if (node == null) {
			return null;
		}
		switch (node.getNodeType()) {
		case ASTNode.ANONYMOUS_CLASS_DECLARATION:
			return ((AnonymousClassDeclaration) node).resolveBinding();
		case ASTNode.METHOD_DECLARATION:
			return ((MethodDeclaration) node).resolveBinding();
		case ASTNode.TYPE_DECLARATION:
			return ((TypeDeclaration) node).resolveBinding();
		default:
			ASTNode parent = node.getParent();
			if (parent.equals(node)) {
				return null;
			} else {
				return findBinding(parent);
			}
		}
	}

	private String findVariableName(ASTNode node, ITypeBinding type) {
		// Activator.log("Scanning node of type " + node.getClass() +
		// " for variable information.");
		if (node.getNodeType() == ASTNode.SIMPLE_NAME) {
			return ((SimpleName) node).getIdentifier();
		} else if (node.getNodeType() == ASTNode.QUALIFIED_NAME) {
			return ((QualifiedName) node).getName().getIdentifier();
		} else if (node.getNodeType() == ASTNode.ASSIGNMENT) {
			return findVariableName((Assignment) node, type);
		} else if (node.getNodeType() == ASTNode.VARIABLE_DECLARATION_FRAGMENT) {
			VariableDeclarationFragment vdf = (VariableDeclarationFragment) node;
			return findVariableName(vdf, type);
		} else if (node.getNodeType() == ASTNode.TYPE_DECLARATION) {
			ITypeBinding declBind = ((TypeDeclaration) node).resolveBinding();
			if (declBind.isEqualTo(type)) {
				return findVariableName(node.getParent(), type);
			} else {
				Activator.log("Reached top-level definition (" + declBind.getQualifiedName()
						+ ") while searching for variable name.");
				return null;
			}
		} else {
			return findVariableName(node.getParent(), type);
		}
	}

	private String findVariableName(VariableDeclarationFragment node, ITypeBinding type) {
		ASTNode parent = node.getParent();
		ITypeBinding varType = null;
		if (parent.getNodeType() == ASTNode.VARIABLE_DECLARATION_STATEMENT) {
			VariableDeclarationStatement vds = (VariableDeclarationStatement) parent;
			varType = vds.getType().resolveBinding();
		} else if (parent.getNodeType() == ASTNode.VARIABLE_DECLARATION_EXPRESSION) {
			VariableDeclarationExpression vde = (VariableDeclarationExpression) parent;
			varType = vde.resolveTypeBinding();
		}

		SimpleName varName = node.getName();

		if (varType == null)
			return null;
		if (isInSupertypes(type, varType.getQualifiedName())) {
			return varName.getIdentifier();
		} else {
			Activator.log("Type " + varType.getQualifiedName() + " did not match "
					+ type.getQualifiedName());
			return null;
		}
	}

	private String findVariableName(Assignment node, ITypeBinding type) {
		Expression left = node.getLeftHandSide();
		Expression right = node.getRightHandSide();
		ITypeBinding rightBinding = right.resolveTypeBinding();
		if (isInSupertypes(type, rightBinding.getQualifiedName())) {
			if ((left.getNodeType() == ASTNode.SIMPLE_NAME)
					|| (left.getNodeType() == ASTNode.SIMPLE_NAME)) {
				return findVariableName(left, type);
			} else {
				Activator.log("Left Expression was " + left.toString());
				return null;
			}
		} else {
			Activator.log("Type " + rightBinding.getQualifiedName() + " did not match "
					+ type.getQualifiedName());
			return null;
		}
	}

	private ASTPort findPort(Expression ex, ITypeBinding portType, int envMod) {
		if (ex.getNodeType() == ASTNode.SIMPLE_NAME) {
			String varName = ((SimpleName) ex).getIdentifier();
			return portVars.get(varName);
		} else if (ex.getNodeType() == ASTNode.METHOD_INVOCATION) {
			MethodInvocation mi = (MethodInvocation) ex;
			Expression miEx = mi.getExpression();
			if (miEx.getNodeType() == ASTNode.SIMPLE_NAME) {
				String varName = ((SimpleName) miEx).getIdentifier();
				ASTComponent comp = componentVars.get(varName);
				if (comp == null) {
					Activator.log("Couldn't find Component for variable " + varName);
					return null;
				}
				switch (envMod) {
				case ASTModelObject.PROVIDED_PORT:
					return comp.getProvided(portType.getQualifiedName());
				case ASTModelObject.REQUIRED_PORT:
					return comp.getRequired(portType.getQualifiedName());
				default:
					return null;
				}
			} else {
				Activator.log("MethodInvocation Expression " + miEx + " is of type "
						+ miEx.getClass());
			}
		}
		Activator.log("Couldn't find a port for expression: " + ex + " of type " + ex.getClass());
		return null;
	}

	// private String getTypeName(Type type) {
	// String scName = "Unknown";
	// if (type != null) {
	// if (type.isSimpleType()) {
	// SimpleType scSType = (SimpleType) type;
	// scName = scSType.getName().getFullyQualifiedName();
	// } else if (type.isQualifiedType()) {
	// QualifiedType scQType = (QualifiedType) type;
	// scName = scQType.getName().getFullyQualifiedName();
	// }
	// }
	// return scName;
	// }
}
