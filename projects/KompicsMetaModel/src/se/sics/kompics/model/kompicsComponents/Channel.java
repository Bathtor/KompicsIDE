/**
 */
package se.sics.kompics.model.kompicsComponents;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Channel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link se.sics.kompics.model.kompicsComponents.Channel#getConnects <em>Connects</em>}</li>
 *   <li>{@link se.sics.kompics.model.kompicsComponents.Channel#getPortType <em>Port Type</em>}</li>
 *   <li>{@link se.sics.kompics.model.kompicsComponents.Channel#getProvided <em>Provided</em>}</li>
 *   <li>{@link se.sics.kompics.model.kompicsComponents.Channel#getRequired <em>Required</em>}</li>
 * </ul>
 * </p>
 *
 * @see se.sics.kompics.model.kompicsComponents.KompicsComponentsPackage#getChannel()
 * @model
 * @generated
 */
public interface Channel extends EObject {
	/**
	 * Returns the value of the '<em><b>Connects</b></em>' reference list.
	 * The list contents are of type {@link se.sics.kompics.model.kompicsComponents.Port}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connects</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connects</em>' reference list.
	 * @see se.sics.kompics.model.kompicsComponents.KompicsComponentsPackage#getChannel_Connects()
	 * @model lower="2" upper="2"
	 * @generated
	 */
	EList<Port> getConnects();

	/**
	 * Returns the value of the '<em><b>Port Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port Type</em>' reference.
	 * @see #setPortType(PortType)
	 * @see se.sics.kompics.model.kompicsComponents.KompicsComponentsPackage#getChannel_PortType()
	 * @model required="true"
	 * @generated
	 */
	PortType getPortType();

	/**
	 * Sets the value of the '{@link se.sics.kompics.model.kompicsComponents.Channel#getPortType <em>Port Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port Type</em>' reference.
	 * @see #getPortType()
	 * @generated
	 */
	void setPortType(PortType value);

	/**
	 * Returns the value of the '<em><b>Provided</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provided</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provided</em>' reference.
	 * @see #setProvided(Port)
	 * @see se.sics.kompics.model.kompicsComponents.KompicsComponentsPackage#getChannel_Provided()
	 * @model required="true"
	 * @generated
	 */
	Port getProvided();

	/**
	 * Sets the value of the '{@link se.sics.kompics.model.kompicsComponents.Channel#getProvided <em>Provided</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provided</em>' reference.
	 * @see #getProvided()
	 * @generated
	 */
	void setProvided(Port value);

	/**
	 * Returns the value of the '<em><b>Required</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required</em>' reference.
	 * @see #setRequired(Port)
	 * @see se.sics.kompics.model.kompicsComponents.KompicsComponentsPackage#getChannel_Required()
	 * @model required="true"
	 * @generated
	 */
	Port getRequired();

	/**
	 * Sets the value of the '{@link se.sics.kompics.model.kompicsComponents.Channel#getRequired <em>Required</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required</em>' reference.
	 * @see #getRequired()
	 * @generated
	 */
	void setRequired(Port value);

} // Channel
