/**
 * 
 */
package se.sics.kompics.ide.views;

import se.sics.kompics.ide.model.ast.ASTModelObject;

/**
 * The <code>ModelTreeObject</code> .
 *
 * @author Lars Kroll <lkr@lars-kroll.com>
 * @version $Id: $
 *
 */
public class ModelTreeObject extends TreeObject {
	
	private final ASTModelObject object;

	public ModelTreeObject(ASTModelObject obj) {
		super("ModelObject");
		object = obj;
	}
	
	public ASTModelObject getObject() {
		return object;
	}
}
