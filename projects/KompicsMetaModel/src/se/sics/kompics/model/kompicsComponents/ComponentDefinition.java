/**
 */
package se.sics.kompics.model.kompicsComponents;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link se.sics.kompics.model.kompicsComponents.ComponentDefinition#getType <em>Type</em>}</li>
 *   <li>{@link se.sics.kompics.model.kompicsComponents.ComponentDefinition#getRequires <em>Requires</em>}</li>
 *   <li>{@link se.sics.kompics.model.kompicsComponents.ComponentDefinition#getProvides <em>Provides</em>}</li>
 *   <li>{@link se.sics.kompics.model.kompicsComponents.ComponentDefinition#getHandlers <em>Handlers</em>}</li>
 *   <li>{@link se.sics.kompics.model.kompicsComponents.ComponentDefinition#getInstances <em>Instances</em>}</li>
 *   <li>{@link se.sics.kompics.model.kompicsComponents.ComponentDefinition#getSubscriptions <em>Subscriptions</em>}</li>
 * </ul>
 * </p>
 *
 * @see se.sics.kompics.model.kompicsComponents.KompicsComponentsPackage#getComponentDefinition()
 * @model
 * @generated
 */
public interface ComponentDefinition extends EObject {
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
	 * @see se.sics.kompics.model.kompicsComponents.KompicsComponentsPackage#getComponentDefinition_Type()
	 * @model required="true"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link se.sics.kompics.model.kompicsComponents.ComponentDefinition#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Requires</b></em>' reference list.
	 * The list contents are of type {@link se.sics.kompics.model.kompicsComponents.PortType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requires</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requires</em>' reference list.
	 * @see se.sics.kompics.model.kompicsComponents.KompicsComponentsPackage#getComponentDefinition_Requires()
	 * @model
	 * @generated
	 */
	EList<PortType> getRequires();

	/**
	 * Returns the value of the '<em><b>Provides</b></em>' reference list.
	 * The list contents are of type {@link se.sics.kompics.model.kompicsComponents.PortType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provides</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provides</em>' reference list.
	 * @see se.sics.kompics.model.kompicsComponents.KompicsComponentsPackage#getComponentDefinition_Provides()
	 * @model
	 * @generated
	 */
	EList<PortType> getProvides();

	/**
	 * Returns the value of the '<em><b>Handlers</b></em>' containment reference list.
	 * The list contents are of type {@link se.sics.kompics.model.kompicsComponents.Handler}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Handlers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Handlers</em>' containment reference list.
	 * @see se.sics.kompics.model.kompicsComponents.KompicsComponentsPackage#getComponentDefinition_Handlers()
	 * @model containment="true"
	 * @generated
	 */
	EList<Handler> getHandlers();

	/**
	 * Returns the value of the '<em><b>Instances</b></em>' containment reference list.
	 * The list contents are of type {@link se.sics.kompics.model.kompicsComponents.Component}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instances</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instances</em>' containment reference list.
	 * @see se.sics.kompics.model.kompicsComponents.KompicsComponentsPackage#getComponentDefinition_Instances()
	 * @model containment="true"
	 * @generated
	 */
	EList<Component> getInstances();

	/**
	 * Returns the value of the '<em><b>Subscriptions</b></em>' containment reference list.
	 * The list contents are of type {@link se.sics.kompics.model.kompicsComponents.Subscription}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subscriptions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subscriptions</em>' containment reference list.
	 * @see se.sics.kompics.model.kompicsComponents.KompicsComponentsPackage#getComponentDefinition_Subscriptions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Subscription> getSubscriptions();

} // ComponentDefinition
