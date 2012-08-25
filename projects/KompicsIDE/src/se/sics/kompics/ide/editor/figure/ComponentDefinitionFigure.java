/**
 * 
 */
package se.sics.kompics.ide.editor.figure;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * The <code>ComponentDefinitionFigure</code> .
 * 
 * @author Lars Kroll <lkr@lars-kroll.com>
 * @version $Id: $
 * 
 */
public class ComponentDefinitionFigure extends Figure {

	private Label label;
	//private RoundedRectangle rectangle;

	public ComponentDefinitionFigure() {
		label = new Label();
		add(label);
		setLayoutManager(new XYLayout());
//		rectangle = new RoundedRectangle();
//		rectangle.setFill(false);
//		rectangle.setLayoutManager(new StackLayout());
//		add(rectangle);
		
	}

	@Override
	protected void paintFigure(Graphics graphics) {
		super.paintFigure(graphics);
//		Rectangle r = getBounds().getCopy();
//		setConstraint(rectangle, new Rectangle(0, 0, r.width, r.height));
//		setConstraint(label, new Rectangle(0, 0, r.width, 15));
	}

	public Label getLabel() {
		return label;
	}
	
	public Dimension getPreferredSize(int wHint, int hHint) {
		Dimension dim = new Dimension();
		dim.width = label.getPreferredSize().width;
		dim.width += getInsets().getWidth();
		dim.height += getInsets().getHeight();
		return dim;
	}
	
	public void setBounds(Rectangle rect) {
		super.setBounds(rect);
		rect = Rectangle.SINGLETON;
		getClientArea(rect);
		//rectangle.setBounds(rect);
		Dimension size = label.getPreferredSize();
		label.setSize(size);
		label.setLocation(rect.getLocation());
				
	}
}
