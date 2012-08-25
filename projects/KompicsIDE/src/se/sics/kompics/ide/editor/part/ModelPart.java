/**
 * 
 */
package se.sics.kompics.ide.editor.part;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import se.sics.kompics.ide.Model;
import se.sics.kompics.ide.editor.figure.TestLabel;
import se.sics.kompics.ide.model.ast.ASTModelObject;

/**
 * The <code>ModelPart</code> .
 * 
 * @author Lars Kroll <lkr@lars-kroll.com>
 * @version $Id: $
 * 
 */
public class ModelPart extends AbstractGraphicalEditPart {

	private TestLabel test1;
	private TestLabel test2;
	private TestLabel test3;
	private AtomicInteger count = new AtomicInteger(0);
	
	protected IFigure createFigure() {
		FreeformLayer layer = new FreeformLayer();
		layer.setLayoutManager(new KompicsLayout());
		test1 = new TestLabel("Test 1 Label String");
		test2 = new TestLabel("Test 2 Label String");
		test3 = new TestLabel("Test 3 Label String");
		layer.add(test1);
		layer.add(test2);
		layer.add(test3);
		return layer;
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
		int c = count.getAndIncrement();
		test1.setText("Test 1 Label String rev. " + c);
		test2.setText("Test 2 Label String rev. " + c);
		test3.setText("Test 3 Label String rev. " + c);
//		test.setSize(test.getPreferredSize());
//		test.setLocation(getFigure().getBounds().getLocation());
	}

	@Override
	protected List<ASTModelObject> getModelChildren() {
		List<ASTModelObject> retVal = new ArrayList<ASTModelObject>();
		retVal.addAll(Model.getComponentInstances());
		return retVal;
	}

}
