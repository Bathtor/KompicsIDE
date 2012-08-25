/**
 */
package se.sics.kompics.model.kompicsComponents;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link se.sics.kompics.model.kompicsComponents.Component#getProvides <em>Provides</em>}</li>
 *   <li>{@link se.sics.kompics.model.kompicsComponents.Component#getRequires <em>Requires</em>}</li>
 *   <li>{@link se.sics.kompics.model.kompicsComponents.Component#getVar <em>Var</em>}</li>
 *   <li>{@link se.sics.kompics.model.kompicsComponents.Component#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see se.sics.kompics.model.kompicsComponents.KompicsComponentsPackage#getComponent()
 * @model
 * @generated
 */
public interface Component extends EObject {
	/**
	 * Returns the value of the '<em><b>Provides</b></em>' containment reference list.
	 * The list contents are of type {@link se.sics.kompics.model.kompicsComponents.Port}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provides</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provides</em>' containment reference list.
	 * @see se.sics.kompics.model.kompicsComponents.KompicsComponentsPackage#getComponent_Provides()
	 * @model containment="true"
	 * @generated
	 */
	EList<Port> getProvides();

	/**
	 * Returns the value of the '<em><b>Requires</b></em>' containment reference list.
	 * The list contents are of type {@link se.sics.kompics.model.kompicsComponents.Port}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requires</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requires</em>' containment reference list.
	 * @see se.sics.kompics.model.kompicsComponents.KompicsComponentsPackage#getComponent_Requires()
	 * @model containment="true"
	 * @generated
	 */
	EList<Port> getRequires();

	/**
	 * Returns the value of the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Var</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Var</em>' attribute.
	 * @see #setVar(String)
	 * @see se.sics.kompics.model.kompicsComponents.KompicsComponentsPackage#getComponent_Var()
	 * @model
	 * @generated
	 */
	String getVar();

	/**
	 * Sets the value of the '{@link se.sics.kompics.model.kompicsComponents.Component#getVar <em>Var</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Var</em>' attribute.
	 * @see #getVar()
	 * @generated
	 */
	void setVar(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(ComponentDefinition)
	 * @see se.sics.kompics.model.kompicsComponents.KompicsComponentsPackage#getComponent_Type()
	 * @model required="true"
	 * @generated
	 */
	ComponentDefinition getType();

	/**
	 * Sets the value of the '{@link se.sics.kompics.model.kompicsComponents.Component#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(ComponentDefinition value);

} // Component
