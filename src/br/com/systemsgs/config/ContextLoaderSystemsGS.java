package br.com.systemsgs.config;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@ApplicationScoped
public class ContextLoaderSystemsGS extends ContextLoaderListener implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private static WebApplicationContext getContext() {
		return WebApplicationContextUtils.getWebApplicationContext(getCurrentWebApplicationContext().getServletContext());
	}
	
	public static Object getBean(String idNomeBean) {
		return getContext().getBean(idNomeBean);
	}
	
	public static Object getBean(Class<?> classe) {
		return getContext().getBean(classe);
	}

}
