/**
 * 
 */
package se.sics.kompics.ide.model.ast;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.dom.ASTNode;

import se.sics.kompics.ide.Activator;
import se.sics.kompics.model.kompicsComponents.Event;
import se.sics.kompics.model.kompicsComponents.KompicsComponentsPackage;
import se.sics.kompics.model.kompicsComponents.PortType;

/**
 * The <code>ASTPortType</code> .
 * 
 * @author Lars Kroll <lkr@lars-kroll.com>
 * @version $Id: $
 * 
 */
public class ASTPortType extends ASTModelObject {
	private PortType model;

	public ASTPortType(String id, PortType model, ASTNode node) {
		super(id, node, model.eClass());
		this.model = model;
	}

	public PortType getModel() {
		return this.model;
	}

	public void setModel(PortType port) {
		this.model = port;
	}

	@Override
	public EObject getEObject() {
		return model;
	}

	@Override
	public void addToModel(EObject obj, int environmentModifier) {
		if (obj.eClass().getClassifierID() == KompicsComponentsPackage.EVENT) {
			Event e = (Event) obj;
			switch (environmentModifier) {
			case ASTModelObject.PROVIDED_PORT:
				model.getIndications().add(e);
				break;
			case ASTModelObject.REQUIRED_PORT:
				model.getRequests().add(e);
				break;
			default:
				Activator.log("Event " + e.getType()
						+ " is marked neither indication, nor request!");
			}
		}
	}
}
