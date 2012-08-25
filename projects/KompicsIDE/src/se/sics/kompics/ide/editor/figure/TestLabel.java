/**
 * 
 */
package se.sics.kompics.ide.editor.figure;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * The <code>TestLabel</code> .
 *
 * @author Lars Kroll <lkr@lars-kroll.com>
 * @version $Id: $
 *
 */
public class TestLabel extends Label {
	
	public TestLabel(String name) {
		setIconTextGap(4);
		setText(name);
		setBorder(new MarginBorder(2, 0, 2, 9));
	}
	
	@Override
	protected void paintFigure(Graphics g) {
		super.paintFigure(g);
		Rectangle r = getTextBounds();

		r.resize(-1, -1);
		r.expand(1, 1);
		r.width -= 1;
		r.x -= 2;
		g.drawLine(r.x, r.y, r.right(), r.y); // Top line
		g.drawLine(r.x, r.bottom(), r.right(), r.bottom()); // Bottom line
		g.drawLine(r.x, r.bottom(), r.x, r.y); // left line

		g.drawLine(r.right() + 7, r.y + r.height / 2, r.right(), r.y);
		g.drawLine(r.right() + 7, r.y + r.height / 2, r.right(), r.bottom());
	}
	
	
	@Override
	public void setBounds(Rectangle rect) {
		super.setBounds(rect);
		setSize(getPreferredSize());
		setLocation(rect.getLocation());
	}
}
