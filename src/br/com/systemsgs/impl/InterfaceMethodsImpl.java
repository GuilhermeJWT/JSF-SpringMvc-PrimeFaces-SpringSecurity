package br.com.systemsgs.impl;

import java.io.Serializable;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public interface InterfaceMethodsImpl<G> extends Serializable{
	
	void save(G obj) throws Exception;
	
	void persist(G obj) throws Exception;
	
	void salvaOrUpdate(G obj) throws Exception;
	
	void update(G obj) throws Exception;
	
	void delete (G obj) throws Exception;
	
	G merge (G obj) throws Exception;

}
