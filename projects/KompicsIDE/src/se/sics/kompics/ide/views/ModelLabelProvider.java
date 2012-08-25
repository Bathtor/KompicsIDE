/**
 * 
 */
package se.sics.kompics.ide.views;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import se.sics.kompics.ide.Activator;
import se.sics.kompics.ide.SharedResources;
import se.sics.kompics.ide.model.ast.ASTModelObject;
import se.sics.kompics.model.kompicsComponents.Channel;
import se.sics.kompics.model.kompicsComponents.Component;
import se.sics.kompics.model.kompicsComponents.ComponentDefinition;
import se.sics.kompics.model.kompicsComponents.Event;
import se.sics.kompics.model.kompicsComponents.Handler;
import se.sics.kompics.model.kompicsComponents.Port;
import se.sics.kompics.model.kompicsComponents.PortType;
import se.sics.kompics.model.kompicsComponents.KompicsComponentsPackage;
import se.sics.kompics.model.kompicsComponents.Subscription;

/**
 * The <code>ModelLabelProvider</code> .
 * 
 * @author Lars Kroll <lkr@lars-kroll.com>
 * @version $Id: $
 * 
 */
public class ModelLabelProvider extends LabelProvider {

	public String getText(Object obj) {
		if (obj instanceof ModelTreeObject) {
			return getNameForType(((ModelTreeObject) obj).getObject());
		}
		if (obj instanceof TreeObject) {
			return ((TreeObject) obj).getName();
		}
		return "Unkown";
	}

	private String getNameForType(ASTModelObject obj) {
		EObject object = obj.getEObject();
		switch (obj.getClassifierID()) {
		case KompicsComponentsPackage.COMPONENT_DEFINITION:
			return ((ComponentDefinition) object).getType();
		case KompicsComponentsPackage.COMPONENT:
			return ((Component) object).getVar() + " : " + ((Component) object).getType().getType();
		case KompicsComponentsPackage.CHANNEL:
			return "Channel <" + ((Channel) object).getPortType().getType() + ">";
		case KompicsComponentsPackage.SUBSCRIPTION:
			Subscription s = (Subscription) object;
			return "Subscription <" + s.getPort().getPortType().getType() + "> <-- <" + s.getHandler().getEventType().getType() + ">";
		case KompicsComponentsPackage.EVENT:
			return ((Event) object).getType();
		case KompicsComponentsPackage.HANDLER:
			return "Handler <-- <" + ((Handler) object).getEventType().getType() + ">";
		case KompicsComponentsPackage.PORT:
			Port p = (Port) object;
			String sym = "?";
			if (p.isProvided()) {
				sym = "+";
			} else {
				sym = "-";
			}
			return sym + "Port <" + p.getPortType().getType() + ">";
		case KompicsComponentsPackage.PORT_TYPE:
			return ((PortType) object).getType();
		default:
			return "Unkown";
		}
	}

	public Image getImage(Object obj) {
		String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
		if (obj instanceof ModelTreeObject) {
			imageKey = getImageForType(((ModelTreeObject) obj).getObject());
			return Activator.getSharedImage(imageKey);
		} else if (obj instanceof TreeObject) {
			imageKey = ISharedImages.IMG_OBJ_FOLDER;			
		}
		return PlatformUI.getWorkbench().getSharedImages().getImage(imageKey);
		
	}

	private String getImageForType(ASTModelObject obj) {
		switch (obj.getClassifierID()) {
		case KompicsComponentsPackage.COMPONENT:
			return SharedResources.IMG_COMPONENT;
		case KompicsComponentsPackage.COMPONENT_DEFINITION:
			return SharedResources.IMG_COMPONENT_DEFINITION;
		case KompicsComponentsPackage.CHANNEL:
			return SharedResources.IMG_CHANNEL;
		case KompicsComponentsPackage.SUBSCRIPTION:
			return SharedResources.IMG_CHANNEL;
		case KompicsComponentsPackage.EVENT:
			return SharedResources.IMG_EVENT;
		case KompicsComponentsPackage.HANDLER:
			return SharedResources.IMG_HANDLER;
		case KompicsComponentsPackage.PORT:
			return SharedResources.IMG_PORT;
		case KompicsComponentsPackage.PORT_TYPE:
			return SharedResources.IMG_PORT_TYPE;
		default:
			return SharedResources.IMG_PORT;
		}
		
// OLD CODE		
//		switch (obj.getClassifierID()) {
//		case KompicsComponentsPackage.COMPONENT:
//			return ISharedImages.IMG_OBJ_ELEMENT;
//		case KompicsComponentsPackage.COMPONENT_DEFINITION:
//			return ISharedImages.IMG_OBJ_FILE;
//		case KompicsComponentsPackage.CHANNEL:
//			return ISharedImages.IMG_OBJ_ADD;
//		case KompicsComponentsPackage.EVENT:
//			return ISharedImages.IMG_TOOL_FORWARD;
//		case KompicsComponentsPackage.HANDLER:
//			return ISharedImages.IMG_TOOL_NEW_WIZARD;
//		case KompicsComponentsPackage.PORT:
//			return ISharedImages.IMG_TOOL_UP;
//		case KompicsComponentsPackage.PORT_TYPE:
//			return ISharedImages.IMG_LCL_LINKTO_HELP;
//		default:
//			return ISharedImages.IMG_OBJ_ELEMENT;
//		}
	}
}
