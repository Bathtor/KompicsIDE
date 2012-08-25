/**
 * 
 */
package se.sics.kompics.ide.editor.part;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

import se.sics.kompics.ide.Model;
import se.sics.kompics.ide.model.ast.ASTComponent;
import se.sics.kompics.ide.model.ast.ASTComponentDefinition;

/**
 * The <code>KompicsPartFactory</code> .
 *
 * @author Lars Kroll <lkr@lars-kroll.com>
 * @version $Id: $
 *
 */
public class KompicsPartFactory implements EditPartFactory {

	@Override
	public EditPart createEditPart(EditPart context, Object model) {
		EditPart part = null;
		
		if (model instanceof Model) {
			part = new ModelPart();
		} else if (model instanceof ASTComponentDefinition) {
			part = new ComponentDefinitionPart();
		} else if(model instanceof ASTComponent) {
			part = new ComponentPart();
		}
		
		if (part != null) {
			part.setModel(model);
		}
		
		return part;
	}

}
