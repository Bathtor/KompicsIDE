/**
 * 
 */
package se.sics.kompics.ide.model.ast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.IBinding;

/**
 * The <code>ASTModelObject</code> .
 *
 * @author Lars Kroll <lkr@lars-kroll.com>
 * @version $Id: $
 *
 */
public abstract class ASTModelObject {
	// Environment Modifiers
	public static final int NONE = 0;
	public static final int REQUIRED_PORT = 1;
	public static final int PROVIDED_PORT = 2;
	
	//
	private ASTNode node;
	private final EClass eClass;
	private IBinding binding;
	private IBinding locationBinding;
	private Set<ASTModelObject> children = new HashSet<ASTModelObject>();
	private ASTModelObject parent;
	private final String id;
	
	protected ASTModelObject(String id, ASTNode node, EClass eClass) {
		this.id = id;
		this.node = node;
		this.eClass = eClass;
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	public ASTNode getNode() {
		return this.node;
	}
	
	public void setNode(ASTNode node) {
		this.node = node;
	}
	
	public int getClassifierID() {
		return eClass.getClassifierID();
	}
	
	public abstract EObject getEObject();

	/**
	 * @return the binding
	 */
	public IBinding getBinding() {
		return binding;
	}

	/**
	 * @param binding the binding to set
	 */
	public void setBinding(IBinding binding) {
		if (this.locationBinding == null) { // If no location binding was set explicitly, 
			// the element's binding is a good guess for source location
			this.locationBinding = binding;
		}
		this.binding = binding;
	}
	
	/**
	 * @return the locationBinding
	 */
	public IBinding getLocationBinding() {
		return locationBinding;
	}

	/**
	 * @param locationBinding the locationBinding to set
	 */
	public void setLocationBinding(IBinding locationBinding) {
		this.locationBinding = locationBinding;
	}

	/**
	 * @return the parent
	 */
	public ASTModelObject getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(ASTModelObject parent) {
		this.parent = parent;
	}

	public Set<ASTModelObject> getChildren() {
		return children;
	}
	
	public void addChild(ASTModelObject obj) {
		children.add(obj);
	}
	
	public abstract void addToModel(EObject obj, int environmentModifier);
}
