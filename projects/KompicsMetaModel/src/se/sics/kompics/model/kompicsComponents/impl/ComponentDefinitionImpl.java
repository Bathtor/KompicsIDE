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
import org.eclipse.emf.ecore.util.InternalEList;

import se.sics.kompics.model.kompicsComponents.Component;
import se.sics.kompics.model.kompicsComponents.ComponentDefinition;
import se.sics.kompics.model.kompicsComponents.Handler;
import se.sics.kompics.model.kompicsComponents.KompicsComponentsPackage;
import se.sics.kompics.model.kompicsComponents.PortType;
import se.sics.kompics.model.kompicsComponents.Subscription;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link se.sics.kompics.model.kompicsComponents.impl.ComponentDefinitionImpl#getType <em>Type</em>}</li>
 *   <li>{@link se.sics.kompics.model.kompicsComponents.impl.ComponentDefinitionImpl#getRequires <em>Requires</em>}</li>
 *   <li>{@link se.sics.kompics.model.kompicsComponents.impl.ComponentDefinitionImpl#getProvides <em>Provides</em>}</li>
 *   <li>{@link se.sics.kompics.model.kompicsComponents.impl.ComponentDefinitionImpl#getHandlers <em>Handlers</em>}</li>
 *   <li>{@link se.sics.kompics.model.kompicsComponents.impl.ComponentDefinitionImpl#getInstances <em>Instances</em>}</li>
 *   <li>{@link se.sics.kompics.model.kompicsComponents.impl.ComponentDefinitionImpl#getSubscriptions <em>Subscriptions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentDefinitionImpl extends EObjectImpl implements ComponentDefinition {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRequires() <em>Requires</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequires()
	 * @generated
	 * @ordered
	 */
	protected EList<PortType> requires;

	/**
	 * The cached value of the '{@link #getProvides() <em>Provides</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvides()
	 * @generated
	 * @ordered
	 */
	protected EList<PortType> provides;

	/**
	 * The cached value of the '{@link #getHandlers() <em>Handlers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHandlers()
	 * @generated
	 * @ordered
	 */
	protected EList<Handler> handlers;

	/**
	 * The cached value of the '{@link #getInstances() <em>Instances</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<Component> instances;

	/**
	 * The cached value of the '{@link #getSubscriptions() <em>Subscriptions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubscriptions()
	 * @generated
	 * @ordered
	 */
	protected EList<Subscription> subscriptions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KompicsComponentsPackage.Literals.COMPONENT_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KompicsComponentsPackage.COMPONENT_DEFINITION__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PortType> getRequires() {
		if (requires == null) {
			requires = new EObjectResolvingEList<PortType>(PortType.class, this, KompicsComponentsPackage.COMPONENT_DEFINITION__REQUIRES);
		}
		return requires;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PortType> getProvides() {
		if (provides == null) {
			provides = new EObjectResolvingEList<PortType>(PortType.class, this, KompicsComponentsPackage.COMPONENT_DEFINITION__PROVIDES);
		}
		return provides;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Handler> getHandlers() {
		if (handlers == null) {
			handlers = new EObjectContainmentEList<Handler>(Handler.class, this, KompicsComponentsPackage.COMPONENT_DEFINITION__HANDLERS);
		}
		return handlers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Component> getInstances() {
		if (instances == null) {
			instances = new EObjectContainmentEList<Component>(Component.class, this, KompicsComponentsPackage.COMPONENT_DEFINITION__INSTANCES);
		}
		return instances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Subscription> getSubscriptions() {
		if (subscriptions == null) {
			subscriptions = new EObjectContainmentEList<Subscription>(Subscription.class, this, KompicsComponentsPackage.COMPONENT_DEFINITION__SUBSCRIPTIONS);
		}
		return subscriptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case KompicsComponentsPackage.COMPONENT_DEFINITION__HANDLERS:
				return ((InternalEList<?>)getHandlers()).basicRemove(otherEnd, msgs);
			case KompicsComponentsPackage.COMPONENT_DEFINITION__INSTANCES:
				return ((InternalEList<?>)getInstances()).basicRemove(otherEnd, msgs);
			case KompicsComponentsPackage.COMPONENT_DEFINITION__SUBSCRIPTIONS:
				return ((InternalEList<?>)getSubscriptions()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KompicsComponentsPackage.COMPONENT_DEFINITION__TYPE:
				return getType();
			case KompicsComponentsPackage.COMPONENT_DEFINITION__REQUIRES:
				return getRequires();
			case KompicsComponentsPackage.COMPONENT_DEFINITION__PROVIDES:
				return getProvides();
			case KompicsComponentsPackage.COMPONENT_DEFINITION__HANDLERS:
				return getHandlers();
			case KompicsComponentsPackage.COMPONENT_DEFINITION__INSTANCES:
				return getInstances();
			case KompicsComponentsPackage.COMPONENT_DEFINITION__SUBSCRIPTIONS:
				return getSubscriptions();
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
			case KompicsComponentsPackage.COMPONENT_DEFINITION__TYPE:
				setType((String)newValue);
				return;
			case KompicsComponentsPackage.COMPONENT_DEFINITION__REQUIRES:
				getRequires().clear();
				getRequires().addAll((Collection<? extends PortType>)newValue);
				return;
			case KompicsComponentsPackage.COMPONENT_DEFINITION__PROVIDES:
				getProvides().clear();
				getProvides().addAll((Collection<? extends PortType>)newValue);
				return;
			case KompicsComponentsPackage.COMPONENT_DEFINITION__HANDLERS:
				getHandlers().clear();
				getHandlers().addAll((Collection<? extends Handler>)newValue);
				return;
			case KompicsComponentsPackage.COMPONENT_DEFINITION__INSTANCES:
				getInstances().clear();
				getInstances().addAll((Collection<? extends Component>)newValue);
				return;
			case KompicsComponentsPackage.COMPONENT_DEFINITION__SUBSCRIPTIONS:
				getSubscriptions().clear();
				getSubscriptions().addAll((Collection<? extends Subscription>)newValue);
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
			case KompicsComponentsPackage.COMPONENT_DEFINITION__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case KompicsComponentsPackage.COMPONENT_DEFINITION__REQUIRES:
				getRequires().clear();
				return;
			case KompicsComponentsPackage.COMPONENT_DEFINITION__PROVIDES:
				getProvides().clear();
				return;
			case KompicsComponentsPackage.COMPONENT_DEFINITION__HANDLERS:
				getHandlers().clear();
				return;
			case KompicsComponentsPackage.COMPONENT_DEFINITION__INSTANCES:
				getInstances().clear();
				return;
			case KompicsComponentsPackage.COMPONENT_DEFINITION__SUBSCRIPTIONS:
				getSubscriptions().clear();
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
			case KompicsComponentsPackage.COMPONENT_DEFINITION__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case KompicsComponentsPackage.COMPONENT_DEFINITION__REQUIRES:
				return requires != null && !requires.isEmpty();
			case KompicsComponentsPackage.COMPONENT_DEFINITION__PROVIDES:
				return provides != null && !provides.isEmpty();
			case KompicsComponentsPackage.COMPONENT_DEFINITION__HANDLERS:
				return handlers != null && !handlers.isEmpty();
			case KompicsComponentsPackage.COMPONENT_DEFINITION__INSTANCES:
				return instances != null && !instances.isEmpty();
			case KompicsComponentsPackage.COMPONENT_DEFINITION__SUBSCRIPTIONS:
				return subscriptions != null && !subscriptions.isEmpty();
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
		result.append(" (type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //ComponentDefinitionImpl
