package br.com.systemsgs.exception;

import java.util.Map;

import javax.faces.FacesException;
import javax.faces.application.NavigationHandler;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;

public class CustomExceptionHandler extends ExceptionHandlerWrapper{
	
	private ExceptionHandler handler;
	
	final FacesContext facesContext = FacesContext.getCurrentInstance();
	
	final Map<String, Object> requestMap = facesContext.getExternalContext().getRequestMap();
	
	final NavigationHandler navigationHandler = facesContext.getApplication().getNavigationHandler();
	
	public CustomExceptionHandler(ExceptionHandler exceptionHandler) {
		this.handler = exceptionHandler;
	}

	@Override
	public ExceptionHandler getWrapped() {
		return handler;
	}
	
	@Override
	public void handle() throws FacesException {
		super.handle();
	}

}
