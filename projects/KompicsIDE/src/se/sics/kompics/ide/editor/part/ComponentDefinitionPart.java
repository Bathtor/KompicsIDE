/**
 * 
 */
package se.sics.kompics.ide.editor.part;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import se.sics.kompics.ide.Model;
import se.sics.kompics.ide.editor.figure.ComponentDefinitionFigure;
import se.sics.kompics.ide.model.ast.ASTComponentDefinition;
import se.sics.kompics.ide.model.ast.ASTModelObject;
import se.sics.kompics.model.kompicsComponents.ComponentDefinition;

/**
 * The <code>ComponentDefinitionPart</code> .
 * 
 * @author Lars Kroll <lkr@lars-kroll.com>
 * @version $Id: $
 * 
 */
public class ComponentDefinitionPart extends AbstractGraphicalEditPart {

	Random rand = new Random();
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
	 */
	@Override
	protected IFigure createFigure() {
		return new ComponentDefinitionFigure();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
	 */
	@Override
	protected void createEditPolicies() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void refreshVisuals() {
		ComponentDefinitionFigure figure = (ComponentDefinitionFigure) getFigure();
		ASTComponentDefinition model = (ASTComponentDefinition) getModel();
		ModelPart parent = (ModelPart) getParent();

		figure.getLabel().setText(model.getModel().getType());
//		int size = model.getModel().getType().length();
//		Rectangle layout = new Rectangle(rand.nextInt(300), rand.nextInt(300), size*10, size*10);
//		parent.setLayoutConstraint(this, figure, layout);
	}
	
	@Override
	protected List<ASTModelObject> getModelChildren() {
		ASTComponentDefinition model = (ASTComponentDefinition) getModel();
		List<ASTModelObject> retVal = new ArrayList<ASTModelObject>();
		retVal.addAll(model.getSubInstances());
		return retVal;
	}

}
