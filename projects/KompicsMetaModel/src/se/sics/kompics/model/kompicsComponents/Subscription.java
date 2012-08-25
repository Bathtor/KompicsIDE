/**
 */
package se.sics.kompics.model.kompicsComponents;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Subscription</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link se.sics.kompics.model.kompicsComponents.Subscription#getHandler <em>Handler</em>}</li>
 *   <li>{@link se.sics.kompics.model.kompicsComponents.Subscription#getPort <em>Port</em>}</li>
 * </ul>
 * </p>
 *
 * @see se.sics.kompics.model.kompicsComponents.KompicsComponentsPackage#getSubscription()
 * @model
 * @generated
 */
public interface Subscription extends EObject {
	/**
	 * Returns the value of the '<em><b>Handler</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Handler</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Handler</em>' reference.
	 * @see #setHandler(Handler)
	 * @see se.sics.kompics.model.kompicsComponents.KompicsComponentsPackage#getSubscription_Handler()
	 * @model required="true"
	 * @generated
	 */
	Handler getHandler();

	/**
	 * Sets the value of the '{@link se.sics.kompics.model.kompicsComponents.Subscription#getHandler <em>Handler</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Handler</em>' reference.
	 * @see #getHandler()
	 * @generated
	 */
	void setHandler(Handler value);

	/**
	 * Returns the value of the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port</em>' reference.
	 * @see #setPort(Port)
	 * @see se.sics.kompics.model.kompicsComponents.KompicsComponentsPackage#getSubscription_Port()
	 * @model required="true"
	 * @generated
	 */
	Port getPort();

	/**
	 * Sets the value of the '{@link se.sics.kompics.model.kompicsComponents.Subscription#getPort <em>Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port</em>' reference.
	 * @see #getPort()
	 * @generated
	 */
	void setPort(Port value);

} // Subscription
