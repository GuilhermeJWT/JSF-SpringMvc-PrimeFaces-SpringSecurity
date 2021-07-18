package br.com.systemsgs.config;

import org.springframework.stereotype.Component;

import br.com.systemsgs.enums.StatusPersistencia;
import br.com.systemsgs.interfaces.ActionView;

@Component
public abstract class BeanViewAbstract implements ActionView {

	private static final long serialVersionUID = 1L;
	
	protected void sucesso() throws Exception{
		statusOperation(StatusPersistencia.SUCESSO);
	}
	
	protected void error() throws Exception{
		statusOperation(StatusPersistencia.ERRO);
	}

	@Override
	public String novo() throws Exception {
		return null;
	}

	@Override
	public String save() throws Exception {
		return null;
	}

	@Override
	public String ativar() throws Exception {
		return null;
	}

	@Override
	public String editar() throws Exception {
		return null;
	}

	@Override
	public String redirecionarNewEntidade() throws Exception {
		return null;
	}

	@Override
	public String redirecionarFindEntidade() throws Exception {
		return null;
	}

	@Override
	public void limparLista() throws Exception {

	}

	@Override
	public void saveNotReturn() throws Exception {

	}

	@Override
	public void saveEdit() throws Exception {

	}

	@Override
	public void excluir() throws Exception {

	}

	@Override
	public void setarVariaveisNulas() throws Exception {

	}

	@Override
	public void consultarEntidade() throws Exception {

	}

	@Override
	public void statusOperation(StatusPersistencia status) throws Exception {
		Mensagens.responseOperation(status);
	}

	@Override
	public void addMsg(String msg) {
		Mensagens.msg(msg);
	}

}
