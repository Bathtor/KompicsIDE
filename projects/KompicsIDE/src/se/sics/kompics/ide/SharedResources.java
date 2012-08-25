/**
 * 
 */
package se.sics.kompics.ide;

import java.io.InputStream;
import java.net.URL;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

/**
 * The <code>SharedResources</code> .
 * 
 * @author Lars Kroll <lkr@lars-kroll.com>
 * @version $Id: $
 * 
 */
public class SharedResources {

	private static final String PORT_TYPE_URL = "platform:/plugin/KompicsIDE/icons/ethernet-port.jpg";
	private static final String CHANNEL_URL = "platform:/plugin/KompicsIDE/icons/pipe.png";
	private static final String COMPONENT_URL = "platform:/plugin/KompicsIDE/icons/Component.png";
	private static final String COMPONENT_DEFINITION_URL = "platform:/plugin/KompicsIDE/icons/ComponentDef.gif";
	private static final String PORT_URL = "platform:/plugin/KompicsIDE/icons/iconPort.gif";
	private static final String HANDLER_URL = "platform:/plugin/KompicsIDE/icons/handler.png";
	private static final String EVENT_URL = "platform:/plugin/KompicsIDE/icons/mail-icon.png";

	public static final String IMG_PORT = "se.sics.kompics.images.port";
	public static final String IMG_CHANNEL = "se.sics.kompics.images.channel";
	public static final String IMG_COMPONENT = "se.sics.kompics.images.component";
	public static final String IMG_COMPONENT_DEFINITION = "se.sics.kompics.images.componentDefinition";
	public static final String IMG_PORT_TYPE = "se.sics.kompics.images.portType";
	public static final String IMG_HANDLER = "se.sics.kompics.images.handler";
	public static final String IMG_EVENT = "se.sics.kompics.images.event";

	private Image portImage;
	private Image channelImage;
	private Image componentImage;
	private Image componentDefImage;
	private Image portTypeImage;
	private Image handlerImage;
	private Image eventImage;

	public static Display getDisplay() {
		Display display = Display.getCurrent();
		// may be null if outside the UI thread
		if (display == null)
			display = Display.getDefault();
		return display;
	}

	SharedResources() {
		super();
	}

	public Image getSharedImage(String key) {
		if (key.equals(IMG_PORT)) {
			return getPortImage();
		} else if (key.equals(IMG_CHANNEL)) {
			return getChannelImage();
		} else if (key.equals(IMG_COMPONENT)) {
			return getComponentImage();
		} else if (key.equals(IMG_COMPONENT_DEFINITION)) {
			return getComponentDefImage();
		} else if (key.equals(IMG_PORT_TYPE)) {
			return getPortTypeImage();
		} else if (key.equals(IMG_HANDLER)) {
			return getHandlerImage();
		} else if (key.equals(IMG_EVENT)) {
			return getEventImage();
		} else {
			return null;
		}
	}

	private Image getPortImage() {
		if (portImage == null) {
			try {
				URL portUrl = new URL(PORT_URL);
				InputStream iS = portUrl.openConnection().getInputStream();
				portImage = new Image(getDisplay(), iS);
			} catch (Exception e) {
				Activator.log(IStatus.ERROR, e.getMessage());
			}
		}

		return portImage;
	}

	private Image getPortTypeImage() {
		if (portTypeImage == null) {
			try {
				URL portUrl = new URL(PORT_TYPE_URL);
				InputStream iS = portUrl.openConnection().getInputStream();
				portTypeImage = new Image(getDisplay(), iS);
			} catch (Exception e) {
				Activator.log(IStatus.ERROR, e.getMessage());
			}
		}

		return portTypeImage;
	}

	private Image getChannelImage() {
		if (channelImage == null) {
			try {
				URL portUrl = new URL(CHANNEL_URL);
				InputStream iS = portUrl.openConnection().getInputStream();
				channelImage = new Image(getDisplay(), iS);
			} catch (Exception e) {
				Activator.log(IStatus.ERROR, e.getMessage());
			}
		}

		return channelImage;
	}

	private Image getEventImage() {
		if (eventImage == null) {
			try {
				URL portUrl = new URL(EVENT_URL);
				InputStream iS = portUrl.openConnection().getInputStream();
				eventImage = new Image(getDisplay(), iS);
			} catch (Exception e) {
				Activator.log(IStatus.ERROR, e.getMessage());
			}
		}

		return eventImage;
	}

	private Image getHandlerImage() {
		if (handlerImage == null) {
			try {
				URL portUrl = new URL(HANDLER_URL);
				InputStream iS = portUrl.openConnection().getInputStream();
				handlerImage = new Image(getDisplay(), iS);
			} catch (Exception e) {
				Activator.log(IStatus.ERROR, e.getMessage());
			}
		}

		return handlerImage;
	}

	private Image getComponentImage() {
		if (componentImage == null) {
			try {
				URL portUrl = new URL(COMPONENT_URL);
				InputStream iS = portUrl.openConnection().getInputStream();
				componentImage = new Image(getDisplay(), iS);
			} catch (Exception e) {
				Activator.log(IStatus.ERROR, e.getMessage());
			}
		}
		return componentImage;
	}

	private Image getComponentDefImage() {
		if (componentDefImage == null) {
			try {
				URL portUrl = new URL(COMPONENT_DEFINITION_URL);
				InputStream iS = portUrl.openConnection().getInputStream();
				componentDefImage = new Image(getDisplay(), iS);
			} catch (Exception e) {
				Activator.log(IStatus.ERROR, e.getMessage());
			}
		}
		return componentDefImage;
	}

	public void dispose() {
		if (portImage != null) {
			portImage.dispose();
			portImage = null;
		}

		if (channelImage != null) {
			channelImage.dispose();
			channelImage = null;
		}
		if (componentImage != null) {
			componentImage.dispose();
			componentImage = null;
		}
		if (componentDefImage != null) {
			componentDefImage.dispose();
			componentDefImage = null;
		}
		if (portTypeImage != null) {
			portTypeImage.dispose();
			portTypeImage = null;
		}
		if (handlerImage != null) {
			handlerImage.dispose();
			handlerImage = null;
		}
		if (eventImage != null) {
			eventImage.dispose();
			eventImage = null;
		}
	}
}
