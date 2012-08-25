/**
 * 
 */
package se.sics.kompics.ide.model.ast;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.dom.ASTNode;

import se.sics.kompics.model.kompicsComponents.Handler;
import se.sics.kompics.model.kompicsComponents.KompicsComponentsFactory;
import se.sics.kompics.model.kompicsComponents.KompicsComponentsPackage;
import se.sics.kompics.model.kompicsComponents.Port;
import se.sics.kompics.model.kompicsComponents.Subscription;

/**
 * The <code>ASTSubscription</code> .
 *
 * @author Lars Kroll <lkr@lars-kroll.com>
 * @version $Id: $
 *
 */
public class ASTSubscription extends ASTModelObject {
	
	private KompicsComponentsFactory factory = KompicsComponentsFactory.eINSTANCE;
	
	private Subscription model;
	
	private ASTHandler handler;
	private ASTPort port;

	public ASTSubscription(String id, Subscription model, ASTNode node) {
		super(id, node, model.eClass());
		this.model = model;
	}

	@Override
	public EObject getEObject() {
		return this.model;
	}

	public Subscription getModel() {
		return this.model;
	}

	public void setModel(Subscription model) {
		this.model = model;
	}

	/**
	 * @return the handler
	 */
	public ASTHandler getHandler() {
		return handler;
	}

	/**
	 * @param handler the handler to set
	 */
	public void setHandler(ASTHandler handler) {
		this.handler = handler;
	}

	/**
	 * @return the port
	 */
	public ASTPort getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(ASTPort port) {
		this.port = port;
	}

	@Override
	public void addToModel(EObject obj, int environmentModifier) {
		int classifID = obj.eClass().getClassifierID();
		if (classifID == KompicsComponentsPackage.PORT) {
			model.setPort((Port) obj);
		} else if (classifID == KompicsComponentsPackage.HANDLER) {
			model.setHandler((Handler) obj);
		}
		
	}
	
	ASTSubscription copy(ASTPort p) {
		Subscription s = factory.createSubscription();
		s.setHandler(model.getHandler());
		s.setPort(p.getModel());
		String sID = "Subscription:(" + p.getId() + "," + handler.getId() + ")";
		ASTSubscription asts = new ASTSubscription(sID, s, this.getNode());
		asts.setHandler(handler);
		asts.setPort(p);
		asts.setBinding(getBinding());
		asts.setLocationBinding(getLocationBinding());
		
		return asts;
	}

}
