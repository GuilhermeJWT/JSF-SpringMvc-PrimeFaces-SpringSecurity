package br.com.systemsgs.config;

import java.util.HashMap;
import java.util.Map;

import javax.faces.component.UIViewRoot;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.PostConstructCustomScopeEvent;
import javax.faces.event.PostConstructViewMapEvent;
import javax.faces.event.PreDestroyViewMapEvent;
import javax.faces.event.SystemEvent;
import javax.faces.event.ViewMapListener;

public class ViewScopeCallBackRegistrer implements ViewMapListener{

	@Override
	public boolean isListenerForSource(Object source) {
		return source instanceof UIViewRoot;
	}

	@Override
	public void processEvent(SystemEvent event) throws AbortProcessingException {
		if(event instanceof PostConstructCustomScopeEvent) {
			PostConstructViewMapEvent viewMapEvent = (PostConstructViewMapEvent) event;
			UIViewRoot uiViewRoot = (UIViewRoot) viewMapEvent.getComponent();
			uiViewRoot.getViewMap().put(ViewScopeConfiguration.VIEW_SCOPE_CALLBACKS, new HashMap<String, Runnable>());
		}else if(event instanceof PreDestroyViewMapEvent){
			PreDestroyViewMapEvent viewMapEvent = (PreDestroyViewMapEvent) event;
			UIViewRoot uiViewRoot = (UIViewRoot) viewMapEvent.getComponent();
			Map<String, Runnable> callbacks = (Map<String, Runnable>) uiViewRoot.getViewMap().get(ViewScopeConfiguration.VIEW_SCOPE_CALLBACKS);
			
			if(callbacks != null) {
				for(Runnable execute: callbacks.values()) {
					execute.run();
				}
				callbacks.clear();
			}
		}
	}
}
