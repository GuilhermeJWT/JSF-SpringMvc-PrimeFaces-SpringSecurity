package br.com.systemsgs.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
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
	
	void executeUpdateQuerySqlNative(String g) throws Exception;
	
	void executeUpdateSql(String g) throws Exception;
	
	void clearSession() throws Exception;
	
	void evict (Object obj) throws Exception;
	
	Long qtdRegistroTabelaBanco(String g) throws Exception;
	
	G merge (G obj) throws Exception;
	
	List<G> findList(Class<G> objs) throws Exception;
	
	G findByIdTo(Class<G> entidade, Long id) throws Exception;
	
	Object findById(Class<G> entidade, Long id) throws Exception;
	
	List<G> findListQuerySqlNative(String g) throws Exception;
		
	List<?> getListSqlDinamica(String g) throws Exception;
	
	List<G> findListByQueryDinamica(String g, int numeroInicial, int numeroFinal) throws Exception;
	
	Query obterQuery(String g) throws Exception;
	
	Session getSession() throws Exception;

	JdbcTemplate getJdbcTemplate();
	
	SimpleJdbcTemplate getSimpleJdbcTemplate();
	
	SimpleJdbcInsert getSimpleJdbcInsert();
	
}
