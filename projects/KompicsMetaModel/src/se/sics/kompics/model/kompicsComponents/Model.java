/**
 */
package se.sics.kompics.model.kompicsComponents;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link se.sics.kompics.model.kompicsComponents.Model#getTitle <em>Title</em>}</li>
 *   <li>{@link se.sics.kompics.model.kompicsComponents.Model#getPortTypes <em>Port Types</em>}</li>
 *   <li>{@link se.sics.kompics.model.kompicsComponents.Model#getEvents <em>Events</em>}</li>
 *   <li>{@link se.sics.kompics.model.kompicsComponents.Model#getComponents <em>Components</em>}</li>
 *   <li>{@link se.sics.kompics.model.kompicsComponents.Model#getChannels <em>Channels</em>}</li>
 * </ul>
 * </p>
 *
 * @see se.sics.kompics.model.kompicsComponents.KompicsComponentsPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject {
	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see se.sics.kompics.model.kompicsComponents.KompicsComponentsPackage#getModel_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link se.sics.kompics.model.kompicsComponents.Model#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Port Types</b></em>' containment reference list.
	 * The list contents are of type {@link se.sics.kompics.model.kompicsComponents.PortType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port Types</em>' containment reference list.
	 * @see se.sics.kompics.model.kompicsComponents.KompicsComponentsPackage#getModel_PortTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<PortType> getPortTypes();

	/**
	 * Returns the value of the '<em><b>Events</b></em>' containment reference list.
	 * The list contents are of type {@link se.sics.kompics.model.kompicsComponents.Event}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Events</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Events</em>' containment reference list.
	 * @see se.sics.kompics.model.kompicsComponents.KompicsComponentsPackage#getModel_Events()
	 * @model containment="true"
	 * @generated
	 */
	EList<Event> getEvents();

	/**
	 * Returns the value of the '<em><b>Components</b></em>' containment reference list.
	 * The list contents are of type {@link se.sics.kompics.model.kompicsComponents.ComponentDefinition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Components</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Components</em>' containment reference list.
	 * @see se.sics.kompics.model.kompicsComponents.KompicsComponentsPackage#getModel_Components()
	 * @model containment="true"
	 * @generated
	 */
	EList<ComponentDefinition> getComponents();

	/**
	 * Returns the value of the '<em><b>Channels</b></em>' containment reference list.
	 * The list contents are of type {@link se.sics.kompics.model.kompicsComponents.Channel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Channels</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Channels</em>' containment reference list.
	 * @see se.sics.kompics.model.kompicsComponents.KompicsComponentsPackage#getModel_Channels()
	 * @model containment="true"
	 * @generated
	 */
	EList<Channel> getChannels();

} // Model
