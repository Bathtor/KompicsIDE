/**
 * 
 */
package se.sics.kompics.ide.model.ast;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.dom.ASTNode;

import se.sics.kompics.model.kompicsComponents.Component;
import se.sics.kompics.model.kompicsComponents.ComponentDefinition;
import se.sics.kompics.model.kompicsComponents.KompicsComponentsPackage;
import se.sics.kompics.model.kompicsComponents.Port;

/**
 * The <code>ASTComponent</code> .
 *
 * @author Lars Kroll <lkr@lars-kroll.com>
 * @version $Id: $
 *
 */
public class ASTComponent extends ASTModelObject {
	private final Component model;
	
	private Map<String, ASTPort> required = new HashMap<String, ASTPort>();
	private Map<String, ASTPort> provided = new HashMap<String, ASTPort>();
	private ASTPort controlPort;
	
	public ASTComponent(String id, Component model, ASTNode node) {
		super(id, node, model.eClass());
		this.model = model;
	}

	public Component getModel() {
		return this.model;
	}
	
	@Override
	public EObject getEObject() {
		return model;
	}

	@Override
	public void addToModel(EObject obj, int environmentModifier) {
		switch(obj.eClass().getClassifierID()) {
		case KompicsComponentsPackage.COMPONENT_DEFINITION:
			model.setType((ComponentDefinition) obj); break;
		case KompicsComponentsPackage.PORT:
			if (environmentModifier == ASTModelObject.PROVIDED_PORT) {
				model.getProvides().add((Port) obj);
			} else if (environmentModifier == ASTModelObject.REQUIRED_PORT) {
				model.getRequires().add((Port) obj);
			}
		}
		
	}
	
	public void addProvided(ASTPort p) {
		this.provided.put(p.getModel().getPortType().getType(), p);
	}
	
	public void addRequired(ASTPort p) {
		this.required.put(p.getModel().getPortType().getType(), p);
	}
	
	public ASTPort getProvided(String type) {
		return this.provided.get(type);
	}
	
	public ASTPort getRequired(String type) {
		return this.required.get(type);
	}

	/**
	 * @return the controlPort
	 */
	public ASTPort getControlPort() {
		return controlPort;
	}

	/**
	 * @param controlPort the controlPort to set
	 */
	public void setControlPort(ASTPort controlPort) {
		this.controlPort = controlPort;
	}
}
