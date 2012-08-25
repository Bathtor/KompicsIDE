/**
 * 
 */
package se.sics.kompics.ide.views;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Display;

import se.sics.kompics.ide.Activator;
import se.sics.kompics.ide.Model;
import se.sics.kompics.ide.model.ast.ASTChannel;
import se.sics.kompics.ide.model.ast.ASTComponentDefinition;
import se.sics.kompics.ide.model.ast.ASTEvent;
import se.sics.kompics.ide.model.ast.ASTHandler;
import se.sics.kompics.ide.model.ast.ASTModelObject;
import se.sics.kompics.ide.model.ast.ASTPortType;

/**
 * The <code>ModelContentProvider</code> .
 * 
 * @author Lars Kroll <lkr@lars-kroll.com>
 * @version $Id: $
 * 
 */
public class ModelContentProvider implements IStructuredContentProvider, ITreeContentProvider {

	private Model model = Model.eINSTANCE;
	private final ModelView view;
	private TreeViewer viewer;

	private TreeObject invisibleRoot = null;

	private AtomicBoolean refreshing = new AtomicBoolean(false);

	public ModelContentProvider(ModelView view, TreeViewer viewer) {
		model.setContentProvider(this);
		this.view = view;
		this.viewer = viewer;
	}

	@Override
	public void dispose() {
		model.unsetContentProvider();
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof TreeObject) {
			return ((TreeObject) parentElement).getChildren();
		}
		return new Object[0];
	}

	private void initialize() {
		refreshing.set(false);

		invisibleRoot = new TreeObject("");

		TreeObject components = new TreeObject("Components");
		TreeObject ports = new TreeObject("Port Types");
		TreeObject events = new TreeObject("Event Types");
		TreeObject channels = new TreeObject("Channels");
		TreeObject handlers = new TreeObject("Handlers");

		invisibleRoot.addChild(components);
		invisibleRoot.addChild(ports);
		invisibleRoot.addChild(events);
		invisibleRoot.addChild(channels);
		invisibleRoot.addChild(handlers);

		Collection<ASTComponentDefinition> comps = Model.getComponents();
		for (ASTComponentDefinition c : comps) {
			ModelTreeObject mto = new ModelTreeObject(c);
			components.addChild(mto);
			initializeChildren(c, mto);
		}
		Collection<ASTEvent> evs = Model.getEvents();
		for (ASTEvent e : evs) {
			ModelTreeObject mto = new ModelTreeObject(e);
			events.addChild(mto);
			initializeChildren(e, mto);
		}
		Collection<ASTPortType> pts = Model.getPorts();
		for (ASTPortType p : pts) {
			ModelTreeObject mto = new ModelTreeObject(p);
			ports.addChild(mto);
			initializeChildren(p, mto);
		}
		Collection<ASTChannel> chs = Model.getChannels();
		for (ASTChannel c : chs) {
			ModelTreeObject mto = new ModelTreeObject(c);
			channels.addChild(mto);
			initializeChildren(c, mto);
		}
		Collection<ASTHandler> hs = Model.getHandlers();
		for (ASTHandler h : hs) {
			ModelTreeObject mto = new ModelTreeObject(h);
			handlers.addChild(mto);
			initializeChildren(h, mto);
		}
	}

	private void initializeChildren(ASTModelObject obj, ModelTreeObject parent) {
		Set<ASTModelObject> children = obj.getChildren();
		for (ASTModelObject child : children) {
			ModelTreeObject mto = new ModelTreeObject(child);
			parent.addChild(mto);
			initializeChildren(child, mto);
		}
	}

	@Override
	public Object getParent(Object element) {
		if (element instanceof TreeObject) {
			return ((TreeObject) element).getParent();
		}
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof TreeObject) {
			return ((TreeObject) element).hasChildren();
		}
		return false;
	}

	@Override
	public Object[] getElements(Object inputElement) {
		if (inputElement.equals(view.getViewSite())) {
			if (invisibleRoot == null)
				initialize();
			return getChildren(invisibleRoot);
		}
		return getChildren(inputElement);
	}

	public void refresh() {
		String log = "Trying to refresh the Content Provider...";
		if (refreshing.compareAndSet(false, true)) {
			Display.getDefault().asyncExec(new Runnable() {

				@Override
				public void run() {
					viewer.refresh();
				}

			});
			log += "success!";
			invisibleRoot = null;
		} else {
			log += "fail :(";
		}
		//Activator.log(log);
	}

}
