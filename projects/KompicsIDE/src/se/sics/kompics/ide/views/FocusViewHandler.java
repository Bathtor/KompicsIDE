/**
 * 
 */
package se.sics.kompics.ide.views;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import se.sics.kompics.ide.Activator;
import se.sics.kompics.ide.Model;

/**
 * The <code>FocusViewHandler</code> .
 *
 * @author Lars Kroll <lkr@lars-kroll.com>
 * @version $Id: $
 *
 */
public class FocusViewHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		//Activator.log("Focusing View");
		ModelView view = Model.eINSTANCE.getViewPart();
		view.setFocus();
		return null;
	}

}
