/**
 * 
 */
package se.sics.kompics.ide.builder;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.IExtendedModifier;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.Modifier;

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
import se.sics.kompics.model.kompicsComponents.Channel;
import se.sics.kompics.model.kompicsComponents.Event;
import se.sics.kompics.model.kompicsComponents.Handler;
import se.sics.kompics.model.kompicsComponents.KompicsComponentsPackage;
import se.sics.kompics.model.kompicsComponents.Port;
import se.sics.kompics.model.kompicsComponents.PortType;
import se.sics.kompics.model.kompicsComponents.Subscription;

/**
 * The <code>ModelValidator</code> .
 * 
 * @author Lars Kroll <lkr@lars-kroll.com>
 * @version $Id: $
 * 
 */
public class ModelValidator {

	public static final String NON_FINAL_EVENT_FIELD = "A field that is not final in an Event can lead to unexpected concurrency issues!";
	public static final String UNCONNECTED_PORT = "The port of type {0} on this component does not appear to be connected to any other port.";
	public static final String PORT_NO_SUBSCRIBERS = "This port does not appear to have any handlers subscribed to it.";
	public static final String PORT_NO_SUBSCRIBERS_FOR_EVENT = "This port does not appear to have any handlers subscribed that handle events of type {0}.";
	public static final String HANDLER_NOT_SUBSCRIBED = "This handler does not appear to be subscribed to any port.";

	private KompicsModelBuilder builder;

	private Stack<ASTModelObject> visitStack = new Stack<ASTModelObject>();
	
	private Set<String> scannedIds = new HashSet<String>();

	public ModelValidator(KompicsModelBuilder builder) {
		this.builder = builder;
	}

	public void validate() {
		visitStack.clear();
		scannedIds.clear();
		
		Collection<ASTComponentDefinition> components = Model.getComponents();
		for (ASTComponentDefinition cd : components) {
			validate(cd);
		}
		Collection<ASTEvent> events = Model.getEvents();
		for (ASTEvent e : events) {
			validate(e);
		}
	}

	public void validate(ASTChannel c) {

	}

	public void validate(ASTComponentDefinition cd) {
		visitStack.push(cd);
		for (ASTModelObject astmo : cd.getChildren()) {
			validate(astmo);
		}
		visitStack.pop();
	}

	public void validate(ASTComponent c) {
		visitStack.push(c);
		for (ASTModelObject astmo : c.getChildren()) {
			validate(astmo);
		}
		visitStack.pop();
	}

	public void validate(ASTEvent e) {
		if (scannedIds.contains(e.getId())) {
			return;
		}
		scannedIds.add(e.getId());
		
		ASTNode node = e.getNode();
		if (node != null) {
			node.accept(new ValidationVisitor());
		} else {
			Activator.log("No AST scanned for Event " + e.getModel().getType());
		}
	}

	public void validate(ASTHandler asth) {
		if (scannedIds.contains(asth.getId())) {
			return;
		}
		scannedIds.add(asth.getId());
		
		Handler h = asth.getModel();
		ASTNode node = asth.getNode();
		// Check if this handler is actually subscribed anywhere
		if (!isSubscribed(h)) {
			String markerId = "Marker:HANDLER_NOT_SUBSCRIBED:" + asth.getId();
			builder.addMarker(markerId, getResource(node), HANDLER_NOT_SUBSCRIBED,
					getLineNumber(node), IMarker.SEVERITY_WARNING);
		}
	}

	private boolean isSubscribed(Handler h) {
		return !h.getSubscriptions().isEmpty();
	}

	public void validate(ASTPort astp) {
		if (scannedIds.contains(astp.getId())) {
			return;
		}
		scannedIds.add(astp.getId());
		
		visitStack.push(astp);

		ASTNode node = astp.getNode();
		Port p = astp.getModel();
		ASTModelObject parent = astp.getParent();
		//
		// Check if this port is connected to another one
		//
		if (parent instanceof ASTComponent) {
			ASTComponent astc = (ASTComponent) parent;
			if (!isConnected(p)) {
				// We want the warning to be displayed at the instantiation
				// of the parent component instead of the component definition
				// because that's where the ports are likely to be connected
				ASTNode cNode = astc.getNode();
				// This should be the only valid parent of ports
				String markerId = "Marker:UNCONNECTED_PORT:" + astp.getId();
				builder.addMarker(markerId, getResource(cNode),
						msg(UNCONNECTED_PORT, p.getPortType().getType()), getLineNumber(cNode),
						IMarker.SEVERITY_WARNING);
			}
			//
			// Check if there is at least one handler subscribed
			// so events don't end up in nirvana
			//
			if (p.getSubscribers().size() < 1) {
				Activator.log("Port " + astp.getId() + " in component " + astc.getId() + " has " + p.getSubscribers().size() + "/"  + astp.getSubs().size() + " handlers subscribed to it!");
				String markerId = "Marker:PORT_NO_SUBSCRIBERS:" + astp.getId();
				builder.addMarker(markerId, getResource(node), PORT_NO_SUBSCRIBERS,
						getLineNumber(node), IMarker.SEVERITY_WARNING);
			} else {
				checkForUnhandledEvents(p, astp);
			}
		}

		for (ASTModelObject astmo : astp.getChildren()) {
			validate(astmo);
		}
		visitStack.pop();
	}

	private boolean isConnected(Port p) {
		if (p.getPortType().getType().equals("se.sics.kompics.ControlPort")) {
			return true; // ControlPort gets automatically connected
		}
		List<ASTChannel> channels = Model.getChannels();
		for (ASTChannel astch : channels) {
			Channel ch = astch.getModel();
			Port p1, p2;
			p1 = ch.getProvided();
			p2 = ch.getRequired();
			if (p1.equals(p) || p2.equals(p)) { // simply compare references
				return true; // unless our model is badly wrong they should
			} // point to the same instances
		}
		return false;
	}

	private void checkForUnhandledEvents(Port p, ASTPort astp) {
		ASTNode node = astp.getNode();
		boolean provided = p.isProvided();
		PortType type = p.getPortType();
		if (provided) {
			for (Event e : type.getRequests()) {
				if (!isHandled(e, p)) {
					String markerId = "Marker:PORT_NO_SUBSCRIBERS_FOR_EVENT:(" + astp.getId() + ","
							+ e.getType() + ")";
					builder.addMarker(markerId, getResource(node),
							msg(PORT_NO_SUBSCRIBERS_FOR_EVENT, e.getType()), getLineNumber(node),
							IMarker.SEVERITY_WARNING);
				}
			}
		} else {
			for (Event e : type.getIndications()) {
				if (!isHandled(e, p)) {
					String markerId = "Marker:PORT_NO_SUBSCRIBERS_FOR_EVENT:(" + astp.getId() + ","
							+ e.getType() + ")";
					builder.addMarker(markerId, getResource(node),
							msg(PORT_NO_SUBSCRIBERS_FOR_EVENT, e.getType()), getLineNumber(node),
							IMarker.SEVERITY_WARNING);
				}
			}
		}
	}

	private boolean isHandled(Event e, Port p) {
		if (e.getType().equals("se.sics.kompics.Start")
				|| e.getType().equals("se.sics.kompics.Stop")) {
			return true;
		}
		for (Subscription s : p.getSubscribers()) {
			Handler h = s.getHandler();
			String checking = "Checking if Handler<" + h.getEventType().getType()
					+ "> handles event of type " + e.getType() + "...";
			if (isHandled(e, h)) {
				Activator.log(checking + "true");
				return true;
			}
			Activator.log(checking + "false");
		}
		Activator.log("Apparently no handler takes care of event " + e.getType());
		return false;
	}

	private boolean isHandled(Event event, Handler h) {
		Event hEvent = h.getEventType();
		ASTEvent aste = Model.getEvent(event.getType());
		ASTEvent hAste = Model.getEvent(hEvent.getType());
		if (aste == null) {
			Activator.log("No Event node for type " + event.getType() + " could be found");
			return false;
		}
		if (hAste == null) {
			Activator.log("No Event node for type " + hEvent.getType() + " could be found");
			return false;
		}

		ITypeBinding eBinding = (ITypeBinding) aste.getBinding();
		//ITypeBinding heBinding = (ITypeBinding) hAste.getBinding();
		if (eBinding == null) {
			Activator.log("No type binding for type " + event.getType() + " could be found");
			return false;
		}

//		if (heBinding == null) {
//			// Can try it this way. Is probably a bit slower, but better than no
//			// information
//			Activator.log(event.getType() + " <-- " + hEvent.getType() + ": Checking for supertype the slow way...");
//			return isInSupertypes(eBinding, hEvent.getType());
//		}
		
		//Activator.log(event.getType() + " <-- " + hEvent.getType() + ": Checking for supertype the simple way..." + eBinding.isAssignmentCompatible(heBinding));
		//Activator.log(event.getType() + " <-- " + hEvent.getType() + ": Checking for supertype the slow way..." + isInSupertypes(eBinding, hEvent.getType()));
		//return eBinding.isAssignmentCompatible(heBinding);
		// TODO discover why the above doesn't work right
		
		
		return isInSupertypes(eBinding, hEvent.getType());
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

	public void validate(ASTPortType pt) {
		visitStack.push(pt);
		for (ASTModelObject astmo : pt.getChildren()) {
			validate(astmo);
		}
		visitStack.pop();
	}

	public void validate(ASTModelObject astmo) {
		switch (astmo.getClassifierID()) {
		case KompicsComponentsPackage.CHANNEL:
			validate((ASTChannel) astmo);
			break;
		case KompicsComponentsPackage.COMPONENT:
			validate((ASTComponent) astmo);
			break;
		case KompicsComponentsPackage.COMPONENT_DEFINITION:
			validate((ASTComponentDefinition) astmo);
			break;
		case KompicsComponentsPackage.EVENT:
			validate((ASTEvent) astmo);
			break;
		case KompicsComponentsPackage.HANDLER:
			validate((ASTHandler) astmo);
			break;
		case KompicsComponentsPackage.PORT:
			validate((ASTPort) astmo);
			break;
		case KompicsComponentsPackage.PORT_TYPE:
			validate((ASTPortType) astmo);
			break;
		case KompicsComponentsPackage.SUBSCRIPTION:
			break; // No need to validate this
		default:
			Activator.log("Couldn't find correct validator for " + astmo.getClass());
		}
	}

	private class ValidationVisitor extends ASTVisitor {
		@Override
		public boolean visit(FieldDeclaration node) {
			List<IExtendedModifier> modifiers = node.modifiers();
			for (IExtendedModifier iem : modifiers) {
				if (iem.isModifier()) {
					Modifier m = (Modifier) iem;
					if (m.isFinal())
						return false; // Everything is fine
				}
			}
			// If the was no final modifier add a warning
			int line = getLineNumber(node);
			IResource res = getResource(node);
			String markerId = "Marker:NON_FINAL_EVENT_FIELD:" + res.getName() + ":" + line;
			builder.addMarker(markerId, res, NON_FINAL_EVENT_FIELD, line, IMarker.SEVERITY_WARNING);
			return false;
		}
	}

	private IResource getResource(ASTNode node) {
		if (node == null)
			return null;
		ASTNode root = node.getRoot();
		if (root.getNodeType() != ASTNode.COMPILATION_UNIT)
			return null;
		CompilationUnit cu = (CompilationUnit) root;
		IJavaElement ije = cu.getJavaElement();
		return ije.getResource();
	}

	private int getLineNumber(ASTNode node) {
		if (node == null)
			return -1;
		ASTNode root = node.getRoot();
		if (root.getNodeType() != ASTNode.COMPILATION_UNIT)
			return -1;
		CompilationUnit cu = (CompilationUnit) root;
		return cu.getLineNumber(node.getStartPosition());
	}

	private String msg(String pattern, Object... args) {
		return MessageFormat.format(pattern, args);
	}
}
