/**
 */
package se.sics.kompics.model.kompicsComponents;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link se.sics.kompics.model.kompicsComponents.PortType#getType <em>Type</em>}</li>
 *   <li>{@link se.sics.kompics.model.kompicsComponents.PortType#getIndications <em>Indications</em>}</li>
 *   <li>{@link se.sics.kompics.model.kompicsComponents.PortType#getRequests <em>Requests</em>}</li>
 * </ul>
 * </p>
 *
 * @see se.sics.kompics.model.kompicsComponents.KompicsComponentsPackage#getPortType()
 * @model
 * @generated
 */
public interface PortType extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see se.sics.kompics.model.kompicsComponents.KompicsComponentsPackage#getPortType_Type()
	 * @model required="true"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link se.sics.kompics.model.kompicsComponents.PortType#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Indications</b></em>' reference list.
	 * The list contents are of type {@link se.sics.kompics.model.kompicsComponents.Event}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Indications</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Indications</em>' reference list.
	 * @see se.sics.kompics.model.kompicsComponents.KompicsComponentsPackage#getPortType_Indications()
	 * @model
	 * @generated
	 */
	EList<Event> getIndications();

	/**
	 * Returns the value of the '<em><b>Requests</b></em>' reference list.
	 * The list contents are of type {@link se.sics.kompics.model.kompicsComponents.Event}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requests</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requests</em>' reference list.
	 * @see se.sics.kompics.model.kompicsComponents.KompicsComponentsPackage#getPortType_Requests()
	 * @model
	 * @generated
	 */
	EList<Event> getRequests();

} // PortType
