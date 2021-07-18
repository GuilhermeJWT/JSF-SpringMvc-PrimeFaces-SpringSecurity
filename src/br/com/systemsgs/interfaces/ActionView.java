package br.com.systemsgs.interfaces;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import br.com.systemsgs.enums.StatusPersistencia;

public interface ActionView extends Serializable{
	
	@PostConstruct
	abstract String novo() throws Exception;
	
	abstract String save() throws Exception;
	
	abstract String ativar () throws Exception;
	
	abstract String editar() throws Exception;
	
	abstract String redirecionarNewEntidade() throws Exception;
	
	abstract String redirecionarFindEntidade() throws Exception;
	
	abstract void limparLista() throws Exception;
	
	abstract void saveNotReturn() throws Exception;
	
	abstract void saveEdit() throws Exception;
	
	abstract void excluir() throws Exception;
	
	abstract void setarVariaveisNulas() throws Exception;
	
	abstract void consultarEntidade() throws Exception;
	
	abstract void statusOperation(StatusPersistencia status) throws Exception;
	
	abstract void addMsg(String msg);

}
