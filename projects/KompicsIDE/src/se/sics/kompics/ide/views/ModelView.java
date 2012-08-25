package se.sics.kompics.ide.views;

import java.util.ArrayList;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.*;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.viewers.*;
import org.eclipse.swt.graphics.Image;
import org.eclipse.jface.action.*;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.*;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;

import se.sics.kompics.ide.Activator;
import se.sics.kompics.ide.Model;
import se.sics.kompics.ide.model.ast.ASTModelObject;

/**
 * This sample class demonstrates how to plug-in a new workbench view. The view
 * shows data obtained from the model. The sample creates a dummy model on the
 * fly, but a real implementation would connect to the model available either in
 * this or another plug-in (e.g. the workspace). The view is connected to the
 * model using a content provider.
 * <p>
 * The view uses a label provider to define how model objects should be
 * presented in the view. Each view can present the same model objects using
 * different labels and icons, if needed. Alternatively, a single label provider
 * can be shared between views in order to ensure that objects of the same type
 * are presented in the same way everywhere.
 * <p>
 */

public class ModelView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "se.sics.kompics.ide.views.ModelView";

	private TreeViewer viewer;
	private ModelContentProvider contentProvider;
	private DrillDownAdapter drillDownAdapter;
	private Action action1;
	private Action action2;
	private Action doubleClickAction;
	
	private boolean fullyExpanded = false; //this variable will probably get fucked up over time

	class ModelSorter extends ViewerSorter {
		@Override
		public int category(Object element) {
			if (element instanceof ModelTreeObject) {
				ModelTreeObject mto = (ModelTreeObject) element;
				ASTModelObject astmo = mto.getObject();
				return astmo.getClassifierID();
			}
			return 0;
		}
	}

	/**
	 * The constructor.
	 */
	public ModelView() {
		Model.eINSTANCE.setViewPart(this);
	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		contentProvider = new ModelContentProvider(this, viewer);
		drillDownAdapter = new DrillDownAdapter(viewer);
		viewer.setContentProvider(contentProvider);
		viewer.setLabelProvider(new ModelLabelProvider());
		viewer.setSorter(new ModelSorter());
		viewer.setInput(getViewSite());

		// Create the help context id for the viewer's control
		PlatformUI.getWorkbench().getHelpSystem()
				.setHelp(viewer.getControl(), "KompicsIDE.viewer");
		makeActions();
		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();
	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				ModelView.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(action1);
		manager.add(new Separator());
		manager.add(action2);
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(action1);
		manager.add(action2);
		manager.add(new Separator());
		drillDownAdapter.addNavigationActions(manager);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(action1);
		manager.add(action2);
		manager.add(new Separator());
		drillDownAdapter.addNavigationActions(manager);
	}

	private void makeActions() {
		action1 = new Action() {
			public void run() {
				contentProvider.refresh(); // Refresh the view (not the model, though)
				//showMessage("Action 1 executed");
			}
		};
		action1.setText("Refresh");
		action1.setToolTipText("Refresh the view");
		action1.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_ELCL_SYNCED));

		action2 = new Action() {
			public void run() { // Expand or Collapse all tree nodes
				if (fullyExpanded) {
					viewer.collapseAll();
					fullyExpanded = false;
					action2.setText("Expand All");
				} else {
					viewer.expandAll();
					fullyExpanded = true;
					action2.setText("Collapse All");
				}
			}
		};
		action2.setText("(Un)Fold All");
		action2.setToolTipText("Folds or unfolds all Nodes.");
		action2.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_ELCL_COLLAPSEALL));
		doubleClickAction = new LookupAction();
	}

	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});
	}

	private void showMessage(String message) {
		MessageDialog.openInformation(viewer.getControl().getShell(),
				"Kompics Model View", message);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}
	
	private class LookupAction extends Action {
		public void run() {
			ISelection selection = viewer.getSelection();
			Object obj = ((IStructuredSelection) selection)
					.getFirstElement();
			// showMessage("Double-click detected on " + obj.toString());
			if (obj instanceof ModelTreeObject) {
				ASTModelObject astmo = ((ModelTreeObject) obj).getObject();
				ASTNode node = astmo.getNode();
				IBinding binding = astmo.getLocationBinding();
				if (binding == null)
					return;
				// If there's no binding there's nothing we can do, to show
				// position			
				int offset = 0;
				int length = 0;
				if (node != null) {
					offset = node.getStartPosition();
					length = node.getLength();
				}
				IJavaElement javaElement = binding.getJavaElement();
				try {
					IEditorPart editorPart = JavaUI
							.openInEditor(javaElement);
					if (editorPart != null) {
						JavaUI.revealInEditor(editorPart, javaElement);
						
						if (editorPart instanceof ITextEditor) {
							ITextEditor fEdit = (ITextEditor) editorPart;
							EditorUtility.selectInEditor(fEdit, offset, length);
						}
						
					}
				} catch (PartInitException e) {
					Activator.log(IStatus.ERROR, "Could not open editor."); //$NON-NLS-1$
				} catch (JavaModelException e) {
					Activator.log(IStatus.ERROR, "Could not open editor."); //$NON-NLS-1$
				}
				//EditorUtility.selectInEditor(fEditor, offset, length);
			}
		}
	}
}