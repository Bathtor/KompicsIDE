/**
 * 
 */
package se.sics.kompics.ide.model.ast;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.dom.ASTNode;

import se.sics.kompics.ide.Activator;
import se.sics.kompics.ide.Model;
import se.sics.kompics.model.kompicsComponents.Component;
import se.sics.kompics.model.kompicsComponents.Handler;
import se.sics.kompics.model.kompicsComponents.KompicsComponentsFactory;
import se.sics.kompics.model.kompicsComponents.KompicsComponentsPackage;
import se.sics.kompics.model.kompicsComponents.Port;
import se.sics.kompics.model.kompicsComponents.PortType;
import se.sics.kompics.model.kompicsComponents.Subscription;

/**
 * The <code>ASTPort</code> .
 *
 * @author Lars Kroll <lkr@lars-kroll.com>
 * @version $Id: $
 *
 */
public class ASTPort extends ASTModelObject {
	
	private KompicsComponentsFactory factory = KompicsComponentsFactory.eINSTANCE;

	private Port model;
	
	private List<ASTSubscription> subscribers = new LinkedList<ASTSubscription>();
	
	public ASTPort(String id, Port model, ASTNode node) {
		super(id, node, model.eClass());
		this.model = model;
	}

	/* (non-Javadoc)
	 * @see se.sics.kompics.ide.model.ast.ASTModelObject#getEObject()
	 */
	@Override
	public EObject getEObject() {
		return model;
	}
	
	public Port getModel() {
		return model;
	}
	
	public List<ASTSubscription> getSubs() {
		return subscribers;
	}
	
	
	public void addChild(ASTSubscription asts) {
		super.addChild(asts);
		this.subscribers.add(asts);
	}

	/* (non-Javadoc)
	 * @see se.sics.kompics.ide.model.ast.ASTModelObject#addToModel(org.eclipse.emf.ecore.EObject, int)
	 */
	@Override
	public void addToModel(EObject obj, int environmentModifier) {
		int classifID = obj.eClass().getClassifierID();
		if (classifID == KompicsComponentsPackage.PORT_TYPE) {
			model.setPortType((PortType) obj);
		} else if (classifID == KompicsComponentsPackage.SUBSCRIPTION) {
			model.getSubscribers().add((Subscription) obj);
		}
	}

	public ASTPort copy(String id, Component c) {
		Port p = factory.createPort();
		ASTPort dupl = new ASTPort(id + "/Port:" + getIdCore(), p, this.getNode());
		ASTPort existing = Model.add(dupl);
		if (!existing.equals(dupl)) {
			return existing;
		}
		p.setComponent(c);
		p.setPortType(this.model.getPortType());
		p.setProvided(this.model.isProvided());
		for (ASTSubscription asts : this.subscribers) {
			ASTSubscription copyS = asts.copy(dupl);
			dupl.subscribers.add(copyS);
			dupl.model.getSubscribers().add(copyS.getModel());
		}
		
		dupl.setBinding(getBinding());
		dupl.setLocationBinding(getLocationBinding());
		for (ASTModelObject astmo : this.getChildren()) {
			dupl.addChild(astmo);
		}
		return dupl;
	}
	
	private String getIdCore() {
		String id = getId();
		Activator.log("Trying to split ID: " + id);
		//String[] split = getId().split("/Port:", 1);
		int i = id.indexOf("/Port:");
		if (i <= 0) {
			Activator.log("Substring '/Port:' not found :(");
		}
		String core = id.substring(i);
		return core;
	}

}
