/**
 */
package se.sics.kompics.model.kompicsComponents.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import se.sics.kompics.model.kompicsComponents.Channel;
import se.sics.kompics.model.kompicsComponents.KompicsComponentsPackage;
import se.sics.kompics.model.kompicsComponents.Port;
import se.sics.kompics.model.kompicsComponents.PortType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Channel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link se.sics.kompics.model.kompicsComponents.impl.ChannelImpl#getConnects <em>Connects</em>}</li>
 *   <li>{@link se.sics.kompics.model.kompicsComponents.impl.ChannelImpl#getPortType <em>Port Type</em>}</li>
 *   <li>{@link se.sics.kompics.model.kompicsComponents.impl.ChannelImpl#getProvided <em>Provided</em>}</li>
 *   <li>{@link se.sics.kompics.model.kompicsComponents.impl.ChannelImpl#getRequired <em>Required</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChannelImpl extends EObjectImpl implements Channel {
	/**
	 * The cached value of the '{@link #getConnects() <em>Connects</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnects()
	 * @generated
	 * @ordered
	 */
	protected EList<Port> connects;

	/**
	 * The cached value of the '{@link #getPortType() <em>Port Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPortType()
	 * @generated
	 * @ordered
	 */
	protected PortType portType;

	/**
	 * The cached value of the '{@link #getProvided() <em>Provided</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvided()
	 * @generated
	 * @ordered
	 */
	protected Port provided;

	/**
	 * The cached value of the '{@link #getRequired() <em>Required</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequired()
	 * @generated
	 * @ordered
	 */
	protected Port required;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChannelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KompicsComponentsPackage.Literals.CHANNEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Port> getConnects() {
		if (connects == null) {
			connects = new EObjectResolvingEList<Port>(Port.class, this, KompicsComponentsPackage.CHANNEL__CONNECTS);
		}
		return connects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PortType getPortType() {
		if (portType != null && portType.eIsProxy()) {
			InternalEObject oldPortType = (InternalEObject)portType;
			portType = (PortType)eResolveProxy(oldPortType);
			if (portType != oldPortType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KompicsComponentsPackage.CHANNEL__PORT_TYPE, oldPortType, portType));
			}
		}
		return portType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PortType basicGetPortType() {
		return portType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPortType(PortType newPortType) {
		PortType oldPortType = portType;
		portType = newPortType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KompicsComponentsPackage.CHANNEL__PORT_TYPE, oldPortType, portType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port getProvided() {
		if (provided != null && provided.eIsProxy()) {
			InternalEObject oldProvided = (InternalEObject)provided;
			provided = (Port)eResolveProxy(oldProvided);
			if (provided != oldProvided) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KompicsComponentsPackage.CHANNEL__PROVIDED, oldProvided, provided));
			}
		}
		return provided;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port basicGetProvided() {
		return provided;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProvided(Port newProvided) {
		Port oldProvided = provided;
		provided = newProvided;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KompicsComponentsPackage.CHANNEL__PROVIDED, oldProvided, provided));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port getRequired() {
		if (required != null && required.eIsProxy()) {
			InternalEObject oldRequired = (InternalEObject)required;
			required = (Port)eResolveProxy(oldRequired);
			if (required != oldRequired) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KompicsComponentsPackage.CHANNEL__REQUIRED, oldRequired, required));
			}
		}
		return required;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port basicGetRequired() {
		return required;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequired(Port newRequired) {
		Port oldRequired = required;
		required = newRequired;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KompicsComponentsPackage.CHANNEL__REQUIRED, oldRequired, required));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KompicsComponentsPackage.CHANNEL__CONNECTS:
				return getConnects();
			case KompicsComponentsPackage.CHANNEL__PORT_TYPE:
				if (resolve) return getPortType();
				return basicGetPortType();
			case KompicsComponentsPackage.CHANNEL__PROVIDED:
				if (resolve) return getProvided();
				return basicGetProvided();
			case KompicsComponentsPackage.CHANNEL__REQUIRED:
				if (resolve) return getRequired();
				return basicGetRequired();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case KompicsComponentsPackage.CHANNEL__CONNECTS:
				getConnects().clear();
				getConnects().addAll((Collection<? extends Port>)newValue);
				return;
			case KompicsComponentsPackage.CHANNEL__PORT_TYPE:
				setPortType((PortType)newValue);
				return;
			case KompicsComponentsPackage.CHANNEL__PROVIDED:
				setProvided((Port)newValue);
				return;
			case KompicsComponentsPackage.CHANNEL__REQUIRED:
				setRequired((Port)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case KompicsComponentsPackage.CHANNEL__CONNECTS:
				getConnects().clear();
				return;
			case KompicsComponentsPackage.CHANNEL__PORT_TYPE:
				setPortType((PortType)null);
				return;
			case KompicsComponentsPackage.CHANNEL__PROVIDED:
				setProvided((Port)null);
				return;
			case KompicsComponentsPackage.CHANNEL__REQUIRED:
				setRequired((Port)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case KompicsComponentsPackage.CHANNEL__CONNECTS:
				return connects != null && !connects.isEmpty();
			case KompicsComponentsPackage.CHANNEL__PORT_TYPE:
				return portType != null;
			case KompicsComponentsPackage.CHANNEL__PROVIDED:
				return provided != null;
			case KompicsComponentsPackage.CHANNEL__REQUIRED:
				return required != null;
		}
		return super.eIsSet(featureID);
	}

} //ChannelImpl
