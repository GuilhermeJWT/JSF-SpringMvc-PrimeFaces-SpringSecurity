package br.com.systemsgs.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

import br.com.systemsgs.config.CustomListener;

@Entity
@Table(name = "revinfo")
@RevisionEntity(CustomListener.class)
public class InformacaoRevisao extends DefaultRevisionEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@ForeignKey(name = "usuario_fk")
	@JoinColumn(nullable = false, name = "usuario")
	private ModelUsuario usuario;
	
	public ModelUsuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(ModelUsuario usuario) {
		this.usuario = usuario;
	}

}
