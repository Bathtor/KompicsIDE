/**
 */
package se.sics.kompics.model.kompicsComponents;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see se.sics.kompics.model.kompicsComponents.KompicsComponentsFactory
 * @model kind="package"
 * @generated
 */
public interface KompicsComponentsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "kompicsComponents";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://kompicsComponents/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "kompicsComponents";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	KompicsComponentsPackage eINSTANCE = se.sics.kompics.model.kompicsComponents.impl.KompicsComponentsPackageImpl.init();

	/**
	 * The meta object id for the '{@link se.sics.kompics.model.kompicsComponents.impl.ComponentImpl <em>Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see se.sics.kompics.model.kompicsComponents.impl.ComponentImpl
	 * @see se.sics.kompics.model.kompicsComponents.impl.KompicsComponentsPackageImpl#getComponent()
	 * @generated
	 */
	int COMPONENT = 0;

	/**
	 * The feature id for the '<em><b>Provides</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__PROVIDES = 0;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__REQUIRES = 1;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__VAR = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__TYPE = 3;

	/**
	 * The number of structural features of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link se.sics.kompics.model.kompicsComponents.impl.PortImpl <em>Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see se.sics.kompics.model.kompicsComponents.impl.PortImpl
	 * @see se.sics.kompics.model.kompicsComponents.impl.KompicsComponentsPackageImpl#getPort()
	 * @generated
	 */
	int PORT = 1;

	/**
	 * The feature id for the '<em><b>Subscribers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__SUBSCRIBERS = 0;

	/**
	 * The feature id for the '<em><b>Port Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__PORT_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__COMPONENT = 2;

	/**
	 * The feature id for the '<em><b>Provided</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__PROVIDED = 3;

	/**
	 * The number of structural features of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link se.sics.kompics.model.kompicsComponents.impl.HandlerImpl <em>Handler</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see se.sics.kompics.model.kompicsComponents.impl.HandlerImpl
	 * @see se.sics.kompics.model.kompicsComponents.impl.KompicsComponentsPackageImpl#getHandler()
	 * @generated
	 */
	int HANDLER = 2;

	/**
	 * The feature id for the '<em><b>Event Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HANDLER__EVENT_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Subscriptions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HANDLER__SUBSCRIPTIONS = 1;

	/**
	 * The number of structural features of the '<em>Handler</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HANDLER_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link se.sics.kompics.model.kompicsComponents.impl.ChannelImpl <em>Channel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see se.sics.kompics.model.kompicsComponents.impl.ChannelImpl
	 * @see se.sics.kompics.model.kompicsComponents.impl.KompicsComponentsPackageImpl#getChannel()
	 * @generated
	 */
	int CHANNEL = 3;

	/**
	 * The feature id for the '<em><b>Connects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL__CONNECTS = 0;

	/**
	 * The feature id for the '<em><b>Port Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL__PORT_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Provided</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL__PROVIDED = 2;

	/**
	 * The feature id for the '<em><b>Required</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL__REQUIRED = 3;

	/**
	 * The number of structural features of the '<em>Channel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link se.sics.kompics.model.kompicsComponents.impl.EventImpl <em>Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see se.sics.kompics.model.kompicsComponents.impl.EventImpl
	 * @see se.sics.kompics.model.kompicsComponents.impl.KompicsComponentsPackageImpl#getEvent()
	 * @generated
	 */
	int EVENT = 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__TYPE = 0;

	/**
	 * The number of structural features of the '<em>Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_FEATURE_COUNT = 1;


	/**
	 * The meta object id for the '{@link se.sics.kompics.model.kompicsComponents.impl.PortTypeImpl <em>Port Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see se.sics.kompics.model.kompicsComponents.impl.PortTypeImpl
	 * @see se.sics.kompics.model.kompicsComponents.impl.KompicsComponentsPackageImpl#getPortType()
	 * @generated
	 */
	int PORT_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_TYPE__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Indications</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_TYPE__INDICATIONS = 1;

	/**
	 * The feature id for the '<em><b>Requests</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_TYPE__REQUESTS = 2;

	/**
	 * The number of structural features of the '<em>Port Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_TYPE_FEATURE_COUNT = 3;


	/**
	 * The meta object id for the '{@link se.sics.kompics.model.kompicsComponents.impl.ComponentDefinitionImpl <em>Component Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see se.sics.kompics.model.kompicsComponents.impl.ComponentDefinitionImpl
	 * @see se.sics.kompics.model.kompicsComponents.impl.KompicsComponentsPackageImpl#getComponentDefinition()
	 * @generated
	 */
	int COMPONENT_DEFINITION = 6;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DEFINITION__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DEFINITION__REQUIRES = 1;

	/**
	 * The feature id for the '<em><b>Provides</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DEFINITION__PROVIDES = 2;

	/**
	 * The feature id for the '<em><b>Handlers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DEFINITION__HANDLERS = 3;

	/**
	 * The feature id for the '<em><b>Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DEFINITION__INSTANCES = 4;

	/**
	 * The feature id for the '<em><b>Subscriptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DEFINITION__SUBSCRIPTIONS = 5;

	/**
	 * The number of structural features of the '<em>Component Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DEFINITION_FEATURE_COUNT = 6;


	/**
	 * The meta object id for the '{@link se.sics.kompics.model.kompicsComponents.impl.ModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see se.sics.kompics.model.kompicsComponents.impl.ModelImpl
	 * @see se.sics.kompics.model.kompicsComponents.impl.KompicsComponentsPackageImpl#getModel()
	 * @generated
	 */
	int MODEL = 7;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__TITLE = 0;

	/**
	 * The feature id for the '<em><b>Port Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__PORT_TYPES = 1;

	/**
	 * The feature id for the '<em><b>Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__EVENTS = 2;

	/**
	 * The feature id for the '<em><b>Components</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__COMPONENTS = 3;

	/**
	 * The feature id for the '<em><b>Channels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__CHANNELS = 4;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link se.sics.kompics.model.kompicsComponents.impl.SubscriptionImpl <em>Subscription</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see se.sics.kompics.model.kompicsComponents.impl.SubscriptionImpl
	 * @see se.sics.kompics.model.kompicsComponents.impl.KompicsComponentsPackageImpl#getSubscription()
	 * @generated
	 */
	int SUBSCRIPTION = 8;

	/**
	 * The feature id for the '<em><b>Handler</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSCRIPTION__HANDLER = 0;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSCRIPTION__PORT = 1;

	/**
	 * The number of structural features of the '<em>Subscription</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSCRIPTION_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link se.sics.kompics.model.kompicsComponents.Component <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component</em>'.
	 * @see se.sics.kompics.model.kompicsComponents.Component
	 * @generated
	 */
	EClass getComponent();

	/**
	 * Returns the meta object for the containment reference list '{@link se.sics.kompics.model.kompicsComponents.Component#getProvides <em>Provides</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Provides</em>'.
	 * @see se.sics.kompics.model.kompicsComponents.Component#getProvides()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_Provides();

	/**
	 * Returns the meta object for the containment reference list '{@link se.sics.kompics.model.kompicsComponents.Component#getRequires <em>Requires</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Requires</em>'.
	 * @see se.sics.kompics.model.kompicsComponents.Component#getRequires()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_Requires();

	/**
	 * Returns the meta object for the attribute '{@link se.sics.kompics.model.kompicsComponents.Component#getVar <em>Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Var</em>'.
	 * @see se.sics.kompics.model.kompicsComponents.Component#getVar()
	 * @see #getComponent()
	 * @generated
	 */
	EAttribute getComponent_Var();

	/**
	 * Returns the meta object for the reference '{@link se.sics.kompics.model.kompicsComponents.Component#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see se.sics.kompics.model.kompicsComponents.Component#getType()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_Type();

	/**
	 * Returns the meta object for class '{@link se.sics.kompics.model.kompicsComponents.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port</em>'.
	 * @see se.sics.kompics.model.kompicsComponents.Port
	 * @generated
	 */
	EClass getPort();

	/**
	 * Returns the meta object for the reference list '{@link se.sics.kompics.model.kompicsComponents.Port#getSubscribers <em>Subscribers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Subscribers</em>'.
	 * @see se.sics.kompics.model.kompicsComponents.Port#getSubscribers()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_Subscribers();

	/**
	 * Returns the meta object for the reference '{@link se.sics.kompics.model.kompicsComponents.Port#getPortType <em>Port Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Port Type</em>'.
	 * @see se.sics.kompics.model.kompicsComponents.Port#getPortType()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_PortType();

	/**
	 * Returns the meta object for the reference '{@link se.sics.kompics.model.kompicsComponents.Port#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Component</em>'.
	 * @see se.sics.kompics.model.kompicsComponents.Port#getComponent()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_Component();

	/**
	 * Returns the meta object for the attribute '{@link se.sics.kompics.model.kompicsComponents.Port#isProvided <em>Provided</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Provided</em>'.
	 * @see se.sics.kompics.model.kompicsComponents.Port#isProvided()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_Provided();

	/**
	 * Returns the meta object for class '{@link se.sics.kompics.model.kompicsComponents.Handler <em>Handler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Handler</em>'.
	 * @see se.sics.kompics.model.kompicsComponents.Handler
	 * @generated
	 */
	EClass getHandler();

	/**
	 * Returns the meta object for the reference '{@link se.sics.kompics.model.kompicsComponents.Handler#getEventType <em>Event Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Event Type</em>'.
	 * @see se.sics.kompics.model.kompicsComponents.Handler#getEventType()
	 * @see #getHandler()
	 * @generated
	 */
	EReference getHandler_EventType();

	/**
	 * Returns the meta object for the reference list '{@link se.sics.kompics.model.kompicsComponents.Handler#getSubscriptions <em>Subscriptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Subscriptions</em>'.
	 * @see se.sics.kompics.model.kompicsComponents.Handler#getSubscriptions()
	 * @see #getHandler()
	 * @generated
	 */
	EReference getHandler_Subscriptions();

	/**
	 * Returns the meta object for class '{@link se.sics.kompics.model.kompicsComponents.Channel <em>Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Channel</em>'.
	 * @see se.sics.kompics.model.kompicsComponents.Channel
	 * @generated
	 */
	EClass getChannel();

	/**
	 * Returns the meta object for the reference list '{@link se.sics.kompics.model.kompicsComponents.Channel#getConnects <em>Connects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Connects</em>'.
	 * @see se.sics.kompics.model.kompicsComponents.Channel#getConnects()
	 * @see #getChannel()
	 * @generated
	 */
	EReference getChannel_Connects();

	/**
	 * Returns the meta object for the reference '{@link se.sics.kompics.model.kompicsComponents.Channel#getPortType <em>Port Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Port Type</em>'.
	 * @see se.sics.kompics.model.kompicsComponents.Channel#getPortType()
	 * @see #getChannel()
	 * @generated
	 */
	EReference getChannel_PortType();

	/**
	 * Returns the meta object for the reference '{@link se.sics.kompics.model.kompicsComponents.Channel#getProvided <em>Provided</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Provided</em>'.
	 * @see se.sics.kompics.model.kompicsComponents.Channel#getProvided()
	 * @see #getChannel()
	 * @generated
	 */
	EReference getChannel_Provided();

	/**
	 * Returns the meta object for the reference '{@link se.sics.kompics.model.kompicsComponents.Channel#getRequired <em>Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Required</em>'.
	 * @see se.sics.kompics.model.kompicsComponents.Channel#getRequired()
	 * @see #getChannel()
	 * @generated
	 */
	EReference getChannel_Required();

	/**
	 * Returns the meta object for class '{@link se.sics.kompics.model.kompicsComponents.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event</em>'.
	 * @see se.sics.kompics.model.kompicsComponents.Event
	 * @generated
	 */
	EClass getEvent();

	/**
	 * Returns the meta object for the attribute '{@link se.sics.kompics.model.kompicsComponents.Event#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see se.sics.kompics.model.kompicsComponents.Event#getType()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_Type();

	/**
	 * Returns the meta object for class '{@link se.sics.kompics.model.kompicsComponents.PortType <em>Port Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port Type</em>'.
	 * @see se.sics.kompics.model.kompicsComponents.PortType
	 * @generated
	 */
	EClass getPortType();

	/**
	 * Returns the meta object for the attribute '{@link se.sics.kompics.model.kompicsComponents.PortType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see se.sics.kompics.model.kompicsComponents.PortType#getType()
	 * @see #getPortType()
	 * @generated
	 */
	EAttribute getPortType_Type();

	/**
	 * Returns the meta object for the reference list '{@link se.sics.kompics.model.kompicsComponents.PortType#getIndications <em>Indications</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Indications</em>'.
	 * @see se.sics.kompics.model.kompicsComponents.PortType#getIndications()
	 * @see #getPortType()
	 * @generated
	 */
	EReference getPortType_Indications();

	/**
	 * Returns the meta object for the reference list '{@link se.sics.kompics.model.kompicsComponents.PortType#getRequests <em>Requests</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Requests</em>'.
	 * @see se.sics.kompics.model.kompicsComponents.PortType#getRequests()
	 * @see #getPortType()
	 * @generated
	 */
	EReference getPortType_Requests();

	/**
	 * Returns the meta object for class '{@link se.sics.kompics.model.kompicsComponents.ComponentDefinition <em>Component Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Definition</em>'.
	 * @see se.sics.kompics.model.kompicsComponents.ComponentDefinition
	 * @generated
	 */
	EClass getComponentDefinition();

	/**
	 * Returns the meta object for the attribute '{@link se.sics.kompics.model.kompicsComponents.ComponentDefinition#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see se.sics.kompics.model.kompicsComponents.ComponentDefinition#getType()
	 * @see #getComponentDefinition()
	 * @generated
	 */
	EAttribute getComponentDefinition_Type();

	/**
	 * Returns the meta object for the reference list '{@link se.sics.kompics.model.kompicsComponents.ComponentDefinition#getRequires <em>Requires</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Requires</em>'.
	 * @see se.sics.kompics.model.kompicsComponents.ComponentDefinition#getRequires()
	 * @see #getComponentDefinition()
	 * @generated
	 */
	EReference getComponentDefinition_Requires();

	/**
	 * Returns the meta object for the reference list '{@link se.sics.kompics.model.kompicsComponents.ComponentDefinition#getProvides <em>Provides</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Provides</em>'.
	 * @see se.sics.kompics.model.kompicsComponents.ComponentDefinition#getProvides()
	 * @see #getComponentDefinition()
	 * @generated
	 */
	EReference getComponentDefinition_Provides();

	/**
	 * Returns the meta object for the containment reference list '{@link se.sics.kompics.model.kompicsComponents.ComponentDefinition#getHandlers <em>Handlers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Handlers</em>'.
	 * @see se.sics.kompics.model.kompicsComponents.ComponentDefinition#getHandlers()
	 * @see #getComponentDefinition()
	 * @generated
	 */
	EReference getComponentDefinition_Handlers();

	/**
	 * Returns the meta object for the containment reference list '{@link se.sics.kompics.model.kompicsComponents.ComponentDefinition#getInstances <em>Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Instances</em>'.
	 * @see se.sics.kompics.model.kompicsComponents.ComponentDefinition#getInstances()
	 * @see #getComponentDefinition()
	 * @generated
	 */
	EReference getComponentDefinition_Instances();

	/**
	 * Returns the meta object for the containment reference list '{@link se.sics.kompics.model.kompicsComponents.ComponentDefinition#getSubscriptions <em>Subscriptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Subscriptions</em>'.
	 * @see se.sics.kompics.model.kompicsComponents.ComponentDefinition#getSubscriptions()
	 * @see #getComponentDefinition()
	 * @generated
	 */
	EReference getComponentDefinition_Subscriptions();

	/**
	 * Returns the meta object for class '{@link se.sics.kompics.model.kompicsComponents.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see se.sics.kompics.model.kompicsComponents.Model
	 * @generated
	 */
	EClass getModel();

	/**
	 * Returns the meta object for the attribute '{@link se.sics.kompics.model.kompicsComponents.Model#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see se.sics.kompics.model.kompicsComponents.Model#getTitle()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_Title();

	/**
	 * Returns the meta object for the containment reference list '{@link se.sics.kompics.model.kompicsComponents.Model#getPortTypes <em>Port Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Port Types</em>'.
	 * @see se.sics.kompics.model.kompicsComponents.Model#getPortTypes()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_PortTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link se.sics.kompics.model.kompicsComponents.Model#getEvents <em>Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Events</em>'.
	 * @see se.sics.kompics.model.kompicsComponents.Model#getEvents()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Events();

	/**
	 * Returns the meta object for the containment reference list '{@link se.sics.kompics.model.kompicsComponents.Model#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Components</em>'.
	 * @see se.sics.kompics.model.kompicsComponents.Model#getComponents()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Components();

	/**
	 * Returns the meta object for the containment reference list '{@link se.sics.kompics.model.kompicsComponents.Model#getChannels <em>Channels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Channels</em>'.
	 * @see se.sics.kompics.model.kompicsComponents.Model#getChannels()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Channels();

	/**
	 * Returns the meta object for class '{@link se.sics.kompics.model.kompicsComponents.Subscription <em>Subscription</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Subscription</em>'.
	 * @see se.sics.kompics.model.kompicsComponents.Subscription
	 * @generated
	 */
	EClass getSubscription();

	/**
	 * Returns the meta object for the reference '{@link se.sics.kompics.model.kompicsComponents.Subscription#getHandler <em>Handler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Handler</em>'.
	 * @see se.sics.kompics.model.kompicsComponents.Subscription#getHandler()
	 * @see #getSubscription()
	 * @generated
	 */
	EReference getSubscription_Handler();

	/**
	 * Returns the meta object for the reference '{@link se.sics.kompics.model.kompicsComponents.Subscription#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Port</em>'.
	 * @see se.sics.kompics.model.kompicsComponents.Subscription#getPort()
	 * @see #getSubscription()
	 * @generated
	 */
	EReference getSubscription_Port();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	KompicsComponentsFactory getKompicsComponentsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link se.sics.kompics.model.kompicsComponents.impl.ComponentImpl <em>Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see se.sics.kompics.model.kompicsComponents.impl.ComponentImpl
		 * @see se.sics.kompics.model.kompicsComponents.impl.KompicsComponentsPackageImpl#getComponent()
		 * @generated
		 */
		EClass COMPONENT = eINSTANCE.getComponent();

		/**
		 * The meta object literal for the '<em><b>Provides</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__PROVIDES = eINSTANCE.getComponent_Provides();

		/**
		 * The meta object literal for the '<em><b>Requires</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__REQUIRES = eINSTANCE.getComponent_Requires();

		/**
		 * The meta object literal for the '<em><b>Var</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT__VAR = eINSTANCE.getComponent_Var();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__TYPE = eINSTANCE.getComponent_Type();

		/**
		 * The meta object literal for the '{@link se.sics.kompics.model.kompicsComponents.impl.PortImpl <em>Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see se.sics.kompics.model.kompicsComponents.impl.PortImpl
		 * @see se.sics.kompics.model.kompicsComponents.impl.KompicsComponentsPackageImpl#getPort()
		 * @generated
		 */
		EClass PORT = eINSTANCE.getPort();

		/**
		 * The meta object literal for the '<em><b>Subscribers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT__SUBSCRIBERS = eINSTANCE.getPort_Subscribers();

		/**
		 * The meta object literal for the '<em><b>Port Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT__PORT_TYPE = eINSTANCE.getPort_PortType();

		/**
		 * The meta object literal for the '<em><b>Component</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT__COMPONENT = eINSTANCE.getPort_Component();

		/**
		 * The meta object literal for the '<em><b>Provided</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__PROVIDED = eINSTANCE.getPort_Provided();

		/**
		 * The meta object literal for the '{@link se.sics.kompics.model.kompicsComponents.impl.HandlerImpl <em>Handler</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see se.sics.kompics.model.kompicsComponents.impl.HandlerImpl
		 * @see se.sics.kompics.model.kompicsComponents.impl.KompicsComponentsPackageImpl#getHandler()
		 * @generated
		 */
		EClass HANDLER = eINSTANCE.getHandler();

		/**
		 * The meta object literal for the '<em><b>Event Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HANDLER__EVENT_TYPE = eINSTANCE.getHandler_EventType();

		/**
		 * The meta object literal for the '<em><b>Subscriptions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HANDLER__SUBSCRIPTIONS = eINSTANCE.getHandler_Subscriptions();

		/**
		 * The meta object literal for the '{@link se.sics.kompics.model.kompicsComponents.impl.ChannelImpl <em>Channel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see se.sics.kompics.model.kompicsComponents.impl.ChannelImpl
		 * @see se.sics.kompics.model.kompicsComponents.impl.KompicsComponentsPackageImpl#getChannel()
		 * @generated
		 */
		EClass CHANNEL = eINSTANCE.getChannel();

		/**
		 * The meta object literal for the '<em><b>Connects</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHANNEL__CONNECTS = eINSTANCE.getChannel_Connects();

		/**
		 * The meta object literal for the '<em><b>Port Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHANNEL__PORT_TYPE = eINSTANCE.getChannel_PortType();

		/**
		 * The meta object literal for the '<em><b>Provided</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHANNEL__PROVIDED = eINSTANCE.getChannel_Provided();

		/**
		 * The meta object literal for the '<em><b>Required</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHANNEL__REQUIRED = eINSTANCE.getChannel_Required();

		/**
		 * The meta object literal for the '{@link se.sics.kompics.model.kompicsComponents.impl.EventImpl <em>Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see se.sics.kompics.model.kompicsComponents.impl.EventImpl
		 * @see se.sics.kompics.model.kompicsComponents.impl.KompicsComponentsPackageImpl#getEvent()
		 * @generated
		 */
		EClass EVENT = eINSTANCE.getEvent();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__TYPE = eINSTANCE.getEvent_Type();

		/**
		 * The meta object literal for the '{@link se.sics.kompics.model.kompicsComponents.impl.PortTypeImpl <em>Port Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see se.sics.kompics.model.kompicsComponents.impl.PortTypeImpl
		 * @see se.sics.kompics.model.kompicsComponents.impl.KompicsComponentsPackageImpl#getPortType()
		 * @generated
		 */
		EClass PORT_TYPE = eINSTANCE.getPortType();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT_TYPE__TYPE = eINSTANCE.getPortType_Type();

		/**
		 * The meta object literal for the '<em><b>Indications</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT_TYPE__INDICATIONS = eINSTANCE.getPortType_Indications();

		/**
		 * The meta object literal for the '<em><b>Requests</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT_TYPE__REQUESTS = eINSTANCE.getPortType_Requests();

		/**
		 * The meta object literal for the '{@link se.sics.kompics.model.kompicsComponents.impl.ComponentDefinitionImpl <em>Component Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see se.sics.kompics.model.kompicsComponents.impl.ComponentDefinitionImpl
		 * @see se.sics.kompics.model.kompicsComponents.impl.KompicsComponentsPackageImpl#getComponentDefinition()
		 * @generated
		 */
		EClass COMPONENT_DEFINITION = eINSTANCE.getComponentDefinition();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_DEFINITION__TYPE = eINSTANCE.getComponentDefinition_Type();

		/**
		 * The meta object literal for the '<em><b>Requires</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_DEFINITION__REQUIRES = eINSTANCE.getComponentDefinition_Requires();

		/**
		 * The meta object literal for the '<em><b>Provides</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_DEFINITION__PROVIDES = eINSTANCE.getComponentDefinition_Provides();

		/**
		 * The meta object literal for the '<em><b>Handlers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_DEFINITION__HANDLERS = eINSTANCE.getComponentDefinition_Handlers();

		/**
		 * The meta object literal for the '<em><b>Instances</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_DEFINITION__INSTANCES = eINSTANCE.getComponentDefinition_Instances();

		/**
		 * The meta object literal for the '<em><b>Subscriptions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_DEFINITION__SUBSCRIPTIONS = eINSTANCE.getComponentDefinition_Subscriptions();

		/**
		 * The meta object literal for the '{@link se.sics.kompics.model.kompicsComponents.impl.ModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see se.sics.kompics.model.kompicsComponents.impl.ModelImpl
		 * @see se.sics.kompics.model.kompicsComponents.impl.KompicsComponentsPackageImpl#getModel()
		 * @generated
		 */
		EClass MODEL = eINSTANCE.getModel();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__TITLE = eINSTANCE.getModel_Title();

		/**
		 * The meta object literal for the '<em><b>Port Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__PORT_TYPES = eINSTANCE.getModel_PortTypes();

		/**
		 * The meta object literal for the '<em><b>Events</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__EVENTS = eINSTANCE.getModel_Events();

		/**
		 * The meta object literal for the '<em><b>Components</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__COMPONENTS = eINSTANCE.getModel_Components();

		/**
		 * The meta object literal for the '<em><b>Channels</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__CHANNELS = eINSTANCE.getModel_Channels();

		/**
		 * The meta object literal for the '{@link se.sics.kompics.model.kompicsComponents.impl.SubscriptionImpl <em>Subscription</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see se.sics.kompics.model.kompicsComponents.impl.SubscriptionImpl
		 * @see se.sics.kompics.model.kompicsComponents.impl.KompicsComponentsPackageImpl#getSubscription()
		 * @generated
		 */
		EClass SUBSCRIPTION = eINSTANCE.getSubscription();

		/**
		 * The meta object literal for the '<em><b>Handler</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBSCRIPTION__HANDLER = eINSTANCE.getSubscription_Handler();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBSCRIPTION__PORT = eINSTANCE.getSubscription_Port();

	}

} //KompicsComponentsPackage
