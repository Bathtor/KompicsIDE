/**
 * 
 */
package se.sics.kompics.ide.model.ast;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.dom.ASTNode;

import se.sics.kompics.ide.Model;
import se.sics.kompics.model.kompicsComponents.Component;
import se.sics.kompics.model.kompicsComponents.ComponentDefinition;
import se.sics.kompics.model.kompicsComponents.Handler;
import se.sics.kompics.model.kompicsComponents.KompicsComponentsFactory;
import se.sics.kompics.model.kompicsComponents.KompicsComponentsPackage;
import se.sics.kompics.model.kompicsComponents.Port;
import se.sics.kompics.model.kompicsComponents.PortType;

/**
 * The <code>ASTComponentDefinition</code> .
 * 
 * @author Lars Kroll <lkr@lars-kroll.com>
 * @version $Id: $
 * 
 */
public class ASTComponentDefinition extends ASTModelObject {

	private KompicsComponentsFactory factory = KompicsComponentsFactory.eINSTANCE;

	private final ComponentDefinition model;

	private List<ASTPort> providedPorts = new LinkedList<ASTPort>();
	private List<ASTPort> requiredPorts = new LinkedList<ASTPort>();
	private ASTPort controlPort;
	
	private List<ASTComponent> subInstances = new LinkedList<ASTComponent>();

	public ASTComponentDefinition(String id, ComponentDefinition model, ASTNode node) {
		super(id, node, model.eClass());
		this.model = model;
		
		model.getProvides().add(Model.controlPort.getModel());
		Port cP = factory.createPort();
		cP.setPortType(Model.controlPort.getModel());
		cP.setProvided(true);
		String pID = id + "/Port:" + Model.controlPort.getId() + ":-1";
		controlPort = new ASTPort(pID, cP, node); // just set node so it can be found later
		//providedPorts.add(controlPort);
		Model.add(controlPort);
		this.addChild(controlPort);
	}

	public ComponentDefinition getModel() {
		return this.model;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see se.sics.kompics.ide.model.ast.ASTModelObject#getEObject()
	 */
	@Override
	public EObject getEObject() {
		return this.model;
	}

	/**
	 * @return the subInstances
	 */
	public List<ASTComponent> getSubInstances() {
		return subInstances;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * se.sics.kompics.ide.model.ast.ASTModelObject#addToModel(org.eclipse.emf
	 * .ecore.EObject, int)
	 */
	@Override
	public void addToModel(EObject obj, int environmentModifier) {
		switch (obj.eClass().getClassifierID()) {
		case KompicsComponentsPackage.COMPONENT:
			model.getInstances().add((Component) obj);
			break;
		case KompicsComponentsPackage.HANDLER:
			model.getHandlers().add((Handler) obj);
			break;
		case KompicsComponentsPackage.PORT_TYPE:
			if (environmentModifier == ASTModelObject.PROVIDED_PORT) {
				model.getProvides().add((PortType) obj);
			} else if (environmentModifier == ASTModelObject.REQUIRED_PORT) {
				model.getRequires().add((PortType) obj);
			}
		}

	}

//	public boolean addSubscription(String portType, ASTHandler handler, int envMod) {
//		switch (envMod) {
//		case ASTModelObject.REQUIRED_PORT:
//			for (ASTPort p : this.requiredPorts) {
//				if (p.getModel().getPortType().getType().equals(portType)) {
//					p.addChild(handler);
//					p.addToModel(handler.getModel(), envMod);
//					return true;
//				}
//			}
//			break;
//		case ASTModelObject.PROVIDED_PORT:
//			for (ASTPort p : this.providedPorts) {
//				if (p.getModel().getPortType().getType().equals(portType)) {
//					p.addChild(handler);
//					p.addToModel(handler.getModel(), envMod);
//					return true;
//				}
//			}
//		default:
//			return false;
//		}
//		return false;
//	}

	public void addProvided(ASTPort p) {
		this.providedPorts.add(p);
	}

	public void addRequired(ASTPort p) {
		this.requiredPorts.add(p);
	}
	
	public void addSubInstance(ASTComponent astc) {
		this.subInstances.add(astc);
	}

	public ASTComponent createInstance(String variable, ASTNode node) {
		controlPort.setLocationBinding(getLocationBinding());
		
		Component c = factory.createComponent();
		c.setType(model);
		c.setVar(variable);
		String cID = getId() + "/Component:" + variable + ":" + node.getStartPosition();
		ASTComponent astc = new ASTComponent(cID, c, node);		
		ASTComponent existing = (ASTComponent) Model.add(astc); // in case the component already exists
		if (!existing.equals(astc)) return existing;
		astc.setParent(this);
		this.addChild(astc);
		addToModel(c, ASTModelObject.NONE);
		for (ASTPort p : this.providedPorts) {
			ASTPort copy = p.copy(cID, c);
			c.getProvides().add(copy.getModel());
			astc.addChild(copy);
			copy.setParent(astc);
			astc.addProvided(copy);
		}
		for (ASTPort p : this.requiredPorts) {
			ASTPort copy = p.copy(cID, c);
			c.getRequires().add(copy.getModel());
			astc.addChild(copy);
			copy.setParent(astc);
			astc.addRequired(copy);
		}
		ASTPort copy = controlPort.copy(cID, c);
		c.getProvides().add(copy.getModel());
		astc.addChild(copy);
		copy.setParent(astc);
		astc.addProvided(copy);
		astc.setControlPort(copy);
		
		return astc;
		
	}

}
