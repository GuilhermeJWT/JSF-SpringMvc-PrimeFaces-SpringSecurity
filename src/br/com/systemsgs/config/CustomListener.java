package br.com.systemsgs.config;

import java.io.Serializable;

import org.hibernate.envers.RevisionListener;
import org.springframework.stereotype.Service;

import br.com.systemsgs.model.InformacaoRevisao;
import br.com.systemsgs.model.ModelUsuario;

@Service
public class CustomListener implements RevisionListener, Serializable{

	private static final long serialVersionUID = 1L;

	@Override
	public void newRevision(Object entity) {
		InformacaoRevisao informacaoRevisao = (InformacaoRevisao) entity;
		Long idUser = UtilFramework.getThreadLocal().get();
		
		ModelUsuario modelUsuario = new ModelUsuario();
		
		if(idUser != null && idUser != 0L) {
			modelUsuario.setId(idUser);
			informacaoRevisao.setUsuario(modelUsuario);
		}
	}
}
