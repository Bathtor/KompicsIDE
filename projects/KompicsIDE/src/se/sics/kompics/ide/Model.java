/*******************************************************************************
 * Copyright (c) 2012 Lars Kroll.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     Lars Kroll - initial API and implementation
 ******************************************************************************/
package se.sics.kompics.ide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import se.sics.kompics.ide.model.ast.ASTChannel;
import se.sics.kompics.ide.model.ast.ASTComponent;
import se.sics.kompics.ide.model.ast.ASTComponentDefinition;
import se.sics.kompics.ide.model.ast.ASTEvent;
import se.sics.kompics.ide.model.ast.ASTHandler;
import se.sics.kompics.ide.model.ast.ASTModelObject;
import se.sics.kompics.ide.model.ast.ASTPort;
import se.sics.kompics.ide.model.ast.ASTPortType;
import se.sics.kompics.ide.views.ModelContentProvider;
import se.sics.kompics.ide.views.ModelView;
import se.sics.kompics.model.kompicsComponents.Event;
import se.sics.kompics.model.kompicsComponents.KompicsComponentsFactory;
import se.sics.kompics.model.kompicsComponents.PortType;

public final class Model {

	// Elements from Kompics Core
	public static final ASTPortType controlPort;
	public static final ASTEvent fault;
	public static final ASTEvent start;
	public static final ASTEvent stop;
	public static final ASTEvent init;

	private se.sics.kompics.model.kompicsComponents.Model model;

	private static KompicsComponentsFactory factory = KompicsComponentsFactory.eINSTANCE;

	static {
		PortType pt = factory.createPortType();
		pt.setType("se.sics.kompics.ControlPort");
		controlPort = new ASTPortType("PortType:se.sics.kompics.ControlPort", pt, null);

		Event f = factory.createEvent();
		f.setType("se.sics.kompics.Fault");
		controlPort.addToModel(f, ASTModelObject.PROVIDED_PORT);
		fault = new ASTEvent("Event:se.sics.kompics.Fault", f, null);
		controlPort.addChild(fault);

		Event sta = factory.createEvent();
		sta.setType("se.sics.kompics.Start");
		controlPort.addToModel(sta, ASTModelObject.REQUIRED_PORT);
		start = new ASTEvent("Event:se.sics.kompics.Start", sta, null);
		controlPort.addChild(start);

		Event sto = factory.createEvent();
		sto.setType("se.sics.kompics.Stop");
		controlPort.addToModel(sto, ASTModelObject.REQUIRED_PORT);
		stop = new ASTEvent("Event:se.sics.kompics.Stop", sto, null);
		controlPort.addChild(stop);

		Event in = factory.createEvent();
		in.setType("se.sics.kompics.Init");
		controlPort.addToModel(in, ASTModelObject.REQUIRED_PORT);
		init = new ASTEvent("Event:se.sics.kompics.Init", in, null);
		controlPort.addChild(init);
	}

	// Instance (eager Singleton)
	public static final Model eINSTANCE = new Model();

	// Maps model object ids to their instances
	private Map<String, ASTModelObject> objects = new HashMap<String, ASTModelObject>();

	// Map qualified type names to instances
	private Map<String, ASTComponentDefinition> components = new HashMap<String, ASTComponentDefinition>();
	private Map<String, ASTEvent> events = new HashMap<String, ASTEvent>();
	private Map<String, ASTPortType> ports = new HashMap<String, ASTPortType>();

	// No point in mapping here again
	private List<ASTHandler> handlers = new ArrayList<ASTHandler>();
	private List<ASTChannel> channels = new ArrayList<ASTChannel>();
	private List<ASTPort> portInstances = new ArrayList<ASTPort>();
	private List<ASTComponent> componentInstances = new ArrayList<ASTComponent>();

	// View related
	private ModelContentProvider view;
	private ModelView modelView;

	private Model() {
		this.model = factory.createModel();
	}

	public static List<ASTModelObject> getObjects() {
		return new ArrayList<ASTModelObject>(eINSTANCE.objects.values());
	}

	public static ASTModelObject getObject(String key) {
		return eINSTANCE.objects.get(key);
	}

	public static List<ASTComponentDefinition> getComponents() {
		return new LinkedList<ASTComponentDefinition>(eINSTANCE.components.values());
	}
	
	public static ASTComponentDefinition getComponent(String key) {
		return eINSTANCE.components.get(key);
	}
	
	public static List<ASTComponent> getComponentInstances() {
		return eINSTANCE.componentInstances;
	}

	public static List<ASTEvent> getEvents() {
		return new LinkedList<ASTEvent>(eINSTANCE.events.values());
	}
	
	public static ASTEvent getEvent(String key) {
		return eINSTANCE.events.get(key);
	}

	public static List<ASTPortType> getPorts() {
		return new LinkedList<ASTPortType>(eINSTANCE.ports.values());
	}
	
	public static ASTPortType getPort(String key) {
		return eINSTANCE.ports.get(key);
	}

	public static List<ASTPort> getPortInstances() {
		return eINSTANCE.portInstances;
	}

	public static List<ASTHandler> getHandlers() {
		return eINSTANCE.handlers;
	}

	public static List<ASTChannel> getChannels() {
		return eINSTANCE.channels;
	}

	public static ASTModelObject add(ASTModelObject obj) {
		ASTModelObject existing = eINSTANCE.objects.get(obj.getId());
		if (existing == null) {
			eINSTANCE.objects.put(obj.getId(), obj);
			existing = obj;
		} else {
			if (existing.getNode() == null) {
				existing.setNode(obj.getNode());
			}
		}
		if (obj.getEObject() == null) {
			Activator.log("Added ASTMO: " + obj.getClassifierID());
		}

		try {
			if (eINSTANCE.view != null) {
				eINSTANCE.view.refresh();
			}
		} catch (NullPointerException ex) {
			// just ignore...it will be initialized at a later point
		}
		return existing;
	}

	public static ASTComponentDefinition add(ASTComponentDefinition comp) {
		ASTComponentDefinition existing = (ASTComponentDefinition) add((ASTModelObject) comp);
		eINSTANCE.components.put(existing.getModel().getType(), existing);
		if (existing.equals(comp)) {
			eINSTANCE.model.getComponents().add(comp.getModel());
		}
		return existing;
	}
	
	public static ASTComponent add(ASTComponent comp) {
		ASTComponent existing = (ASTComponent) add((ASTModelObject) comp);
		if (existing.equals(comp)) {
			eINSTANCE.componentInstances.add(existing);
		}
		return existing;
	}

	public static ASTPort add(ASTPort port) {
		ASTPort existing = (ASTPort) add((ASTModelObject) port);
		if (existing.equals(port)) {
			eINSTANCE.portInstances.add(existing);
		}
		return existing;
	}

	public static ASTPortType add(ASTPortType port) {
		ASTPortType existing = (ASTPortType) add((ASTModelObject) port);
		eINSTANCE.ports.put(existing.getModel().getType(), existing);
		if (existing.equals(port)) {
			eINSTANCE.model.getPortTypes().add(port.getModel());
		}
		return existing;
	}

	public static ASTChannel add(ASTChannel ch) {
		ASTChannel existing = (ASTChannel) add((ASTModelObject) ch);
		if (existing.equals(ch)) {
			eINSTANCE.channels.add(existing);
			eINSTANCE.model.getChannels().add(ch.getModel());
		}
		return existing;
		// //
		// for (ASTChannel astch : eINSTANCE.channels) {
		// if (astch.getNode().equals(ch.getNode())) {
		// return;
		// }
		// }
		// String pos = " at position " + ch.getNode().getStartPosition();
		// pos += " with length " + ch.getNode().getLength();
		// Activator.log("Adding channel: " +
		// ch.getModel().getPortType().getType() + pos);
		// eINSTANCE.objects.add(ch);
		// eINSTANCE.channels.add(ch);
	}

	public static ASTEvent add(ASTEvent event) {
		ASTEvent existing = (ASTEvent) add((ASTModelObject) event);
		eINSTANCE.events.put(existing.getModel().getType(), existing);
		if (existing.equals(event)) {
			eINSTANCE.model.getEvents().add(event.getModel());
		}
		return existing;
	}

	public static ASTHandler add(ASTHandler handler) {
		ASTHandler existing = (ASTHandler) add((ASTModelObject) handler);
		if (existing.equals(handler)) {
			eINSTANCE.handlers.add(existing);
		}
		return existing;
		// for (ASTHandler asth : eINSTANCE.handlers) {
		// if (asth.getBinding().isEqualTo(handler.getBinding())) {
		// return;
		// }
		// }
		// eINSTANCE.objects.add(handler);
		// eINSTANCE.handlers.add(handler);
	}

	public static void clearAll() {
		eINSTANCE.objects.clear();
		eINSTANCE.components.clear();
		eINSTANCE.channels.clear();
		eINSTANCE.events.clear();
		eINSTANCE.handlers.clear();
		eINSTANCE.ports.clear();
		eINSTANCE.componentInstances.clear();
		eINSTANCE.portInstances.clear();

		eINSTANCE.model = factory.createModel();

		Model.add(fault);
		Model.add(start);
		Model.add(stop);
		Model.add(init);
		Model.add(controlPort);
	}

	public void setContentProvider(ModelContentProvider modelContentProvider) {
		view = modelContentProvider;
	}

	public void unsetContentProvider() {
		view = null;
	}

	public void setViewPart(ModelView modelView) {
		this.modelView = modelView;
	}

	public ModelView getViewPart() {
		return this.modelView;
	}

	public void unsetViewPart() {
		this.modelView = null;
	}

}
