/**
 */
package se.sics.kompics.model.kompicsComponents.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import se.sics.kompics.model.kompicsComponents.Component;
import org.eclipse.emf.ecore.util.InternalEList;

import se.sics.kompics.model.kompicsComponents.Event;
import se.sics.kompics.model.kompicsComponents.Handler;
import se.sics.kompics.model.kompicsComponents.KompicsComponentsPackage;
import se.sics.kompics.model.kompicsComponents.Port;
import se.sics.kompics.model.kompicsComponents.PortType;
import se.sics.kompics.model.kompicsComponents.Subscription;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link se.sics.kompics.model.kompicsComponents.impl.PortImpl#getSubscribers <em>Subscribers</em>}</li>
 *   <li>{@link se.sics.kompics.model.kompicsComponents.impl.PortImpl#getPortType <em>Port Type</em>}</li>
 *   <li>{@link se.sics.kompics.model.kompicsComponents.impl.PortImpl#getComponent <em>Component</em>}</li>
 *   <li>{@link se.sics.kompics.model.kompicsComponents.impl.PortImpl#isProvided <em>Provided</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PortImpl extends EObjectImpl implements Port {
	/**
	 * The cached value of the '{@link #getSubscribers() <em>Subscribers</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubscribers()
	 * @generated
	 * @ordered
	 */
	protected EList<Subscription> subscribers;

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
	 * The cached value of the '{@link #getComponent() <em>Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponent()
	 * @generated
	 * @ordered
	 */
	protected Component component;

	/**
	 * The default value of the '{@link #isProvided() <em>Provided</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isProvided()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PROVIDED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isProvided() <em>Provided</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isProvided()
	 * @generated
	 * @ordered
	 */
	protected boolean provided = PROVIDED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KompicsComponentsPackage.Literals.PORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Subscription> getSubscribers() {
		if (subscribers == null) {
			subscribers = new EObjectResolvingEList<Subscription>(Subscription.class, this, KompicsComponentsPackage.PORT__SUBSCRIBERS);
		}
		return subscribers;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KompicsComponentsPackage.PORT__PORT_TYPE, oldPortType, portType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, KompicsComponentsPackage.PORT__PORT_TYPE, oldPortType, portType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component getComponent() {
		if (component != null && component.eIsProxy()) {
			InternalEObject oldComponent = (InternalEObject)component;
			component = (Component)eResolveProxy(oldComponent);
			if (component != oldComponent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KompicsComponentsPackage.PORT__COMPONENT, oldComponent, component));
			}
		}
		return component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component basicGetComponent() {
		return component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponent(Component newComponent) {
		Component oldComponent = component;
		component = newComponent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KompicsComponentsPackage.PORT__COMPONENT, oldComponent, component));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isProvided() {
		return provided;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProvided(boolean newProvided) {
		boolean oldProvided = provided;
		provided = newProvided;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KompicsComponentsPackage.PORT__PROVIDED, oldProvided, provided));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KompicsComponentsPackage.PORT__SUBSCRIBERS:
				return getSubscribers();
			case KompicsComponentsPackage.PORT__PORT_TYPE:
				if (resolve) return getPortType();
				return basicGetPortType();
			case KompicsComponentsPackage.PORT__COMPONENT:
				if (resolve) return getComponent();
				return basicGetComponent();
			case KompicsComponentsPackage.PORT__PROVIDED:
				return isProvided();
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
			case KompicsComponentsPackage.PORT__SUBSCRIBERS:
				getSubscribers().clear();
				getSubscribers().addAll((Collection<? extends Subscription>)newValue);
				return;
			case KompicsComponentsPackage.PORT__PORT_TYPE:
				setPortType((PortType)newValue);
				return;
			case KompicsComponentsPackage.PORT__COMPONENT:
				setComponent((Component)newValue);
				return;
			case KompicsComponentsPackage.PORT__PROVIDED:
				setProvided((Boolean)newValue);
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
			case KompicsComponentsPackage.PORT__SUBSCRIBERS:
				getSubscribers().clear();
				return;
			case KompicsComponentsPackage.PORT__PORT_TYPE:
				setPortType((PortType)null);
				return;
			case KompicsComponentsPackage.PORT__COMPONENT:
				setComponent((Component)null);
				return;
			case KompicsComponentsPackage.PORT__PROVIDED:
				setProvided(PROVIDED_EDEFAULT);
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
			case KompicsComponentsPackage.PORT__SUBSCRIBERS:
				return subscribers != null && !subscribers.isEmpty();
			case KompicsComponentsPackage.PORT__PORT_TYPE:
				return portType != null;
			case KompicsComponentsPackage.PORT__COMPONENT:
				return component != null;
			case KompicsComponentsPackage.PORT__PROVIDED:
				return provided != PROVIDED_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (provided: ");
		result.append(provided);
		result.append(')');
		return result.toString();
	}

} //PortImpl
