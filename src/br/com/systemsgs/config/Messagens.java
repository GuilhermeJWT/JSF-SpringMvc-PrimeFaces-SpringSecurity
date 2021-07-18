package br.com.systemsgs.config;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.systemsgs.enums.StatusPersistencia;

public abstract class Messagens extends FacesContext implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public static void responseOperation(StatusPersistencia status) {
		if (status != null && status.equals(StatusPersistencia.SUCESSO)) {
			sucesso();
		}else if (status != null && status.equals(StatusPersistencia.OBJETO_REFERENCIADO)) {
			msgServerFatal(StatusPersistencia.OBJETO_REFERENCIADO.toString());
		}else {
			erroOperacao();
		}
	}
	
	public static void sucesso() {
		msgServerInfo(MenssageResource.SUCESSO);
	}
	
	public static void msg(String msg) {
		if(facesContextValido()) {
			getFacesContext().addMessage("msg", new FacesMessage(msg));
		}
	}
	
	public static void erroOperacao() {
		if(facesContextValido()) {
			msgServerFatal(MenssageResource.ERRO);
		}
	}
	
	public static void msgServerInfo(String msg) {
		if(facesContextValido()) {
			getFacesContext().addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
		}
	}
	
	public static void msgServerWarning(String msg) {
		if(facesContextValido()) {
			getFacesContext().addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_WARN, msg, msg));
		}
	}
	
	public static void msgServerError(String msg) {
		if(facesContextValido()) {
			getFacesContext().addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
		}
	}
	
	public static void msgServerFatal(String msg) {
		if(facesContextValido()) {
			getFacesContext().addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_FATAL, msg, msg));
		}
	}

	private static boolean facesContextValido() {
		return getFacesContext() != null;
	}
	
	public static FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}
	
	public Messagens() {
		
	}

}
