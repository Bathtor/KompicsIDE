/**
 * 
 */
package se.sics.kompics.ide.model.ast;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.dom.ASTNode;

import se.sics.kompics.model.kompicsComponents.Event;

/**
 * The <code>ASTEvent</code> .
 * 
 * @author Lars Kroll <lkr@lars-kroll.com>
 * @version $Id: $
 * 
 */
public class ASTEvent extends ASTModelObject {

	private Event model;

	public ASTEvent(String id, Event model, ASTNode node) {
		super(id, node, model.eClass());
		this.model = model;
	}

	public Event getModel() {
		return this.model;
	}
	
	public void setMode(Event event) {
		this.model = event;
	}

	@Override
	public EObject getEObject() {
		return model;
	}

	@Override
	public void addToModel(EObject obj, int environmentModifier) {
		// do nothing, since we don't need to add any model elements
		
	}
	
	
}
