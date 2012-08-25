/**
 * 
 */
package se.sics.kompics.ide.views;

import java.util.ArrayList;

import org.eclipse.core.runtime.IAdaptable;

/**
 * The <code>TreeObject</code> .
 * 
 * @author Lars Kroll <lkr@lars-kroll.com>
 * @version $Id: $
 * 
 */
public class TreeObject implements IAdaptable {

	private String name;
	private TreeObject parent;
	private ArrayList<TreeObject> children = new ArrayList<TreeObject>();

	public TreeObject(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setParent(TreeObject parent) {
		this.parent = parent;
	}

	public TreeObject getParent() {
		return parent;
	}

	/**
	 * @return the children
	 */
	public TreeObject[] getChildren() {
		return children.toArray(new TreeObject[children.size()]);
	}

	public void addChild(TreeObject child) {
		children.add(child);
		child.setParent(this);
	}

	public void removeChild(TreeObject child) {
		children.remove(child);
		child.setParent(null);
	}
	
	public boolean hasChildren() {
		return !children.isEmpty();
	}
	
	public int countChildren() {
		return children.size();
	}

	public String toString() {
		return getName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 */
	@Override
	public Object getAdapter(Class adapter) {
		// TODO Auto-generated method stub
		return null;
	}

}
