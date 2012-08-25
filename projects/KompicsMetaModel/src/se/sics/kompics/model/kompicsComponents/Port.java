/**
 */
package se.sics.kompics.model.kompicsComponents;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link se.sics.kompics.model.kompicsComponents.Port#getSubscribers <em>Subscribers</em>}</li>
 *   <li>{@link se.sics.kompics.model.kompicsComponents.Port#getPortType <em>Port Type</em>}</li>
 *   <li>{@link se.sics.kompics.model.kompicsComponents.Port#getComponent <em>Component</em>}</li>
 *   <li>{@link se.sics.kompics.model.kompicsComponents.Port#isProvided <em>Provided</em>}</li>
 * </ul>
 * </p>
 *
 * @see se.sics.kompics.model.kompicsComponents.KompicsComponentsPackage#getPort()
 * @model
 * @generated
 */
public interface Port extends EObject {
	/**
	 * Returns the value of the '<em><b>Subscribers</b></em>' reference list.
	 * The list contents are of type {@link se.sics.kompics.model.kompicsComponents.Subscription}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subscribers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subscribers</em>' reference list.
	 * @see se.sics.kompics.model.kompicsComponents.KompicsComponentsPackage#getPort_Subscribers()
	 * @model
	 * @generated
	 */
	EList<Subscription> getSubscribers();

	/**
	 * Returns the value of the '<em><b>Port Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port Type</em>' reference.
	 * @see #setPortType(PortType)
	 * @see se.sics.kompics.model.kompicsComponents.KompicsComponentsPackage#getPort_PortType()
	 * @model required="true"
	 * @generated
	 */
	PortType getPortType();

	/**
	 * Sets the value of the '{@link se.sics.kompics.model.kompicsComponents.Port#getPortType <em>Port Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port Type</em>' reference.
	 * @see #getPortType()
	 * @generated
	 */
	void setPortType(PortType value);

	/**
	 * Returns the value of the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component</em>' reference.
	 * @see #setComponent(Component)
	 * @see se.sics.kompics.model.kompicsComponents.KompicsComponentsPackage#getPort_Component()
	 * @model required="true"
	 * @generated
	 */
	Component getComponent();

	/**
	 * Sets the value of the '{@link se.sics.kompics.model.kompicsComponents.Port#getComponent <em>Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component</em>' reference.
	 * @see #getComponent()
	 * @generated
	 */
	void setComponent(Component value);

	/**
	 * Returns the value of the '<em><b>Provided</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provided</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provided</em>' attribute.
	 * @see #setProvided(boolean)
	 * @see se.sics.kompics.model.kompicsComponents.KompicsComponentsPackage#getPort_Provided()
	 * @model required="true"
	 * @generated
	 */
	boolean isProvided();

	/**
	 * Sets the value of the '{@link se.sics.kompics.model.kompicsComponents.Port#isProvided <em>Provided</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provided</em>' attribute.
	 * @see #isProvided()
	 * @generated
	 */
	void setProvided(boolean value);

} // Port
