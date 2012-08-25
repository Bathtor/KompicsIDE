/**
 * 
 */
package se.sics.kompics.ide.model.ast;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.dom.ASTNode;

import se.sics.kompics.model.kompicsComponents.Event;
import se.sics.kompics.model.kompicsComponents.Handler;
import se.sics.kompics.model.kompicsComponents.KompicsComponentsPackage;
import se.sics.kompics.model.kompicsComponents.Subscription;

/**
 * The <code>ASTHandler</code> .
 * 
 * @author Lars Kroll <lkr@lars-kroll.com>
 * @version $Id: $
 * 
 */
public class ASTHandler extends ASTModelObject {
	private final Handler model;

	public ASTHandler(String id, Handler model, ASTNode node) {
		super(id, node, model.eClass());
		this.model = model;
	}

	public Handler getModel() {
		return this.model;
	}
	
	@Override
	public EObject getEObject() {
		return model;
	}

	@Override
	public void addToModel(EObject obj, int environmentModifier) {
		int classifID = obj.eClass().getClassifierID();
		if (classifID == KompicsComponentsPackage.EVENT) {
			model.setEventType((Event) obj);
		} else if (classifID == KompicsComponentsPackage.SUBSCRIPTION) {
			model.getSubscriptions().add((Subscription) obj);
		}
		
	}
}
