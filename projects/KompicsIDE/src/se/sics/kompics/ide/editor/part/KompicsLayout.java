/**
 * 
 */
package se.sics.kompics.ide.editor.part;

import java.util.List;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

import se.sics.kompics.ide.Activator;

/**
 * The <code>KompicsLayout</code> .
 *
 * @author Lars Kroll <lkr@lars-kroll.com>
 * @version $Id: $
 *
 */
public class KompicsLayout extends AbstractLayout {

	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.LayoutManager#layout(org.eclipse.draw2d.IFigure)
	 */
	@Override
	public void layout(IFigure container) {
		// TODO Auto-generated method stub
		//container.setBounds(new Rectangle(new Point(0, 0), container.getPreferredSize()));
		Activator.log("Laying out figure: "+container.getClass() + " at (0,0), size" + container.getPreferredSize());
		List children = container.getChildren();
		int xPos = 0, yPos = 0, dist = 10;
		for (int i = 0; i < children.size(); i++) {
			IFigure f = (IFigure) children.get(i);
			Dimension d = f.getPreferredSize();
			f.setBounds(new Rectangle(new Point(xPos, yPos), d));
			xPos += d.width + dist;
			yPos += d.height + dist;
			layout(f);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.AbstractLayout#calculatePreferredSize(org.eclipse.draw2d.IFigure, int, int)
	 */
	@Override
	protected Dimension calculatePreferredSize(IFigure container, int wHint, int hHint) {
		Activator.log("Calculating size for figure: "+container.getClass());
		container.validate();
		List children = container.getChildren();
		Rectangle result = new Rectangle().setLocation(container
				.getClientArea().getLocation());
		for (int i = 0; i < children.size(); i++)
			result.union(((IFigure) children.get(i)).getBounds());
		result.resize(container.getInsets().getWidth(), container.getInsets()
				.getHeight());
		return result.getSize();
	}

}
