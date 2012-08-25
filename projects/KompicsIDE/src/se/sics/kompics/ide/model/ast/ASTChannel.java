/**
 * 
 */
package se.sics.kompics.ide.model.ast;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.dom.ASTNode;

import se.sics.kompics.model.kompicsComponents.Channel;
import se.sics.kompics.model.kompicsComponents.KompicsComponentsPackage;
import se.sics.kompics.model.kompicsComponents.Port;
import se.sics.kompics.model.kompicsComponents.PortType;

/**
 * The <code>ASTChannel</code> .
 *
 * @author Lars Kroll <lkr@lars-kroll.com>
 * @version $Id: $
 *
 */
public class ASTChannel extends ASTModelObject {
	private final Channel model;
	
	
	public ASTChannel(String id, Channel model, ASTNode node) {
		super(id, node, model.eClass());
		this.model = model;
	}

	public Channel getModel() {
		return this.model;
	}

	@Override
	public EObject getEObject() {
		return model;
	}

	@Override
	public void addToModel(EObject obj, int environmentModifier) {
		if (obj.eClass().getClassifierID() == KompicsComponentsPackage.PORT) {
			if (environmentModifier == ASTModelObject.PROVIDED_PORT) {
				model.setProvided((Port) obj);
			} else if (environmentModifier == ASTModelObject.REQUIRED_PORT) {
				model.setRequired((Port) obj);
			}
		} else if (obj.eClass().getClassifierID() == KompicsComponentsPackage.PORT_TYPE) {
			model.setPortType((PortType) obj);
		}
	}

	
}
