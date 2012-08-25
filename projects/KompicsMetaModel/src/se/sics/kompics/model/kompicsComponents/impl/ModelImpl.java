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
import org.eclipse.emf.ecore.util.InternalEList;

import se.sics.kompics.model.kompicsComponents.Channel;
import se.sics.kompics.model.kompicsComponents.ComponentDefinition;
import se.sics.kompics.model.kompicsComponents.Event;
import se.sics.kompics.model.kompicsComponents.KompicsComponentsPackage;
import se.sics.kompics.model.kompicsComponents.Model;
import se.sics.kompics.model.kompicsComponents.PortType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link se.sics.kompics.model.kompicsComponents.impl.ModelImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link se.sics.kompics.model.kompicsComponents.impl.ModelImpl#getPortTypes <em>Port Types</em>}</li>
 *   <li>{@link se.sics.kompics.model.kompicsComponents.impl.ModelImpl#getEvents <em>Events</em>}</li>
 *   <li>{@link se.sics.kompics.model.kompicsComponents.impl.ModelImpl#getComponents <em>Components</em>}</li>
 *   <li>{@link se.sics.kompics.model.kompicsComponents.impl.ModelImpl#getChannels <em>Channels</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelImpl extends EObjectImpl implements Model {
	/**
	 * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String TITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected String title = TITLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPortTypes() <em>Port Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPortTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<PortType> portTypes;

	/**
	 * The cached value of the '{@link #getEvents() <em>Events</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<Event> events;

	/**
	 * The cached value of the '{@link #getComponents() <em>Components</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponents()
	 * @generated
	 * @ordered
	 */
	protected EList<ComponentDefinition> components;

	/**
	 * The cached value of the '{@link #getChannels() <em>Channels</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChannels()
	 * @generated
	 * @ordered
	 */
	protected EList<Channel> channels;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KompicsComponentsPackage.Literals.MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTitle(String newTitle) {
		String oldTitle = title;
		title = newTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KompicsComponentsPackage.MODEL__TITLE, oldTitle, title));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PortType> getPortTypes() {
		if (portTypes == null) {
			portTypes = new EObjectContainmentEList<PortType>(PortType.class, this, KompicsComponentsPackage.MODEL__PORT_TYPES);
		}
		return portTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Event> getEvents() {
		if (events == null) {
			events = new EObjectContainmentEList<Event>(Event.class, this, KompicsComponentsPackage.MODEL__EVENTS);
		}
		return events;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComponentDefinition> getComponents() {
		if (components == null) {
			components = new EObjectContainmentEList<ComponentDefinition>(ComponentDefinition.class, this, KompicsComponentsPackage.MODEL__COMPONENTS);
		}
		return components;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Channel> getChannels() {
		if (channels == null) {
			channels = new EObjectContainmentEList<Channel>(Channel.class, this, KompicsComponentsPackage.MODEL__CHANNELS);
		}
		return channels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case KompicsComponentsPackage.MODEL__PORT_TYPES:
				return ((InternalEList<?>)getPortTypes()).basicRemove(otherEnd, msgs);
			case KompicsComponentsPackage.MODEL__EVENTS:
				return ((InternalEList<?>)getEvents()).basicRemove(otherEnd, msgs);
			case KompicsComponentsPackage.MODEL__COMPONENTS:
				return ((InternalEList<?>)getComponents()).basicRemove(otherEnd, msgs);
			case KompicsComponentsPackage.MODEL__CHANNELS:
				return ((InternalEList<?>)getChannels()).basicRemove(otherEnd, msgs);
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
			case KompicsComponentsPackage.MODEL__TITLE:
				return getTitle();
			case KompicsComponentsPackage.MODEL__PORT_TYPES:
				return getPortTypes();
			case KompicsComponentsPackage.MODEL__EVENTS:
				return getEvents();
			case KompicsComponentsPackage.MODEL__COMPONENTS:
				return getComponents();
			case KompicsComponentsPackage.MODEL__CHANNELS:
				return getChannels();
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
			case KompicsComponentsPackage.MODEL__TITLE:
				setTitle((String)newValue);
				return;
			case KompicsComponentsPackage.MODEL__PORT_TYPES:
				getPortTypes().clear();
				getPortTypes().addAll((Collection<? extends PortType>)newValue);
				return;
			case KompicsComponentsPackage.MODEL__EVENTS:
				getEvents().clear();
				getEvents().addAll((Collection<? extends Event>)newValue);
				return;
			case KompicsComponentsPackage.MODEL__COMPONENTS:
				getComponents().clear();
				getComponents().addAll((Collection<? extends ComponentDefinition>)newValue);
				return;
			case KompicsComponentsPackage.MODEL__CHANNELS:
				getChannels().clear();
				getChannels().addAll((Collection<? extends Channel>)newValue);
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
			case KompicsComponentsPackage.MODEL__TITLE:
				setTitle(TITLE_EDEFAULT);
				return;
			case KompicsComponentsPackage.MODEL__PORT_TYPES:
				getPortTypes().clear();
				return;
			case KompicsComponentsPackage.MODEL__EVENTS:
				getEvents().clear();
				return;
			case KompicsComponentsPackage.MODEL__COMPONENTS:
				getComponents().clear();
				return;
			case KompicsComponentsPackage.MODEL__CHANNELS:
				getChannels().clear();
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
			case KompicsComponentsPackage.MODEL__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
			case KompicsComponentsPackage.MODEL__PORT_TYPES:
				return portTypes != null && !portTypes.isEmpty();
			case KompicsComponentsPackage.MODEL__EVENTS:
				return events != null && !events.isEmpty();
			case KompicsComponentsPackage.MODEL__COMPONENTS:
				return components != null && !components.isEmpty();
			case KompicsComponentsPackage.MODEL__CHANNELS:
				return channels != null && !channels.isEmpty();
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
		result.append(" (title: ");
		result.append(title);
		result.append(')');
		return result.toString();
	}

} //ModelImpl
