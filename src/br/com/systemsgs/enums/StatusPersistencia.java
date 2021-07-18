package br.com.systemsgs.enums;

public enum StatusPersistencia {
	
	SUCESSO("Sucesso"),
	ERRO("Erro"),
	OBJETO_REFERENCIADO("Esse Objeto não pode ser Apagado, pois possui Referência com outro Objeto!");
	
	private String name;
	
	private StatusPersistencia(String status) {
		this.name = status;
	}
	
	@Override
	public String toString() {
		return this.name;
	}

}
