/**
 * 
 */
package se.sics.kompics.ide.editor.part;

import java.util.Random;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import se.sics.kompics.ide.editor.figure.ComponentDefinitionFigure;
import se.sics.kompics.ide.editor.figure.ComponentFigure;
import se.sics.kompics.ide.model.ast.ASTComponent;
import se.sics.kompics.ide.model.ast.ASTComponentDefinition;
import se.sics.kompics.model.kompicsComponents.Component;

/**
 * The <code>ComponentPart</code> .
 *
 * @author Lars Kroll <lkr@lars-kroll.com>
 * @version $Id: $
 *
 */
public class ComponentPart extends AbstractGraphicalEditPart {
	
	Random rand = new Random();

	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
	 */
	@Override
	protected IFigure createFigure() {
		return new ComponentFigure();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
	 */
	@Override
	protected void createEditPolicies() {
		// TODO Auto-generated method stub

	}
	
	@Override
	protected void refreshVisuals() {
		ComponentFigure figure = (ComponentFigure) getFigure();
		ASTComponent astModel = (ASTComponent) getModel();
		Component model = astModel.getModel();
		AbstractGraphicalEditPart parent = (AbstractGraphicalEditPart) getParent();

		figure.getLabel().setText(model.getVar() + " : " + model.getType().getType());
	}

}
