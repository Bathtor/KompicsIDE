/**
 * 
 */
package se.sics.kompics.ide.editor.figure;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * The <code>ComponentFigure</code> .
 *
 * @author Lars Kroll <lkr@lars-kroll.com>
 * @version $Id: $
 *
 */
public class ComponentFigure extends Figure {
	private TestLabel label;
	private RoundedRectangle rectangle;

	public ComponentFigure() {
		setLayoutManager(new XYLayout());
		rectangle = new RoundedRectangle();
		rectangle.setBackgroundColor(ColorConstants.lightGreen);
		add(rectangle);
		label = new TestLabel("");
		add(label);
	}

//	@Override
//	protected void paintFigure(Graphics graphics) {
//		Rectangle r = getBounds().getCopy();
//		setConstraint(rectangle, new Rectangle(5, 5, r.width-10, r.height-10));
//		setConstraint(label, new Rectangle(0, 0, r.width, 15));
//	}
	
	

	public Label getLabel() {
		return label;
	}
	
	@Override
	public void setBounds(Rectangle rect) {
		super.setBounds(rect);
		setSize(getPreferredSize());
		setLocation(rect.getLocation());
		rect = Rectangle.SINGLETON;
		getClientArea(rect);
		rectangle.setBounds(rect);
	}
}
