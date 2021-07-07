package br.com.systemsgs.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.systemsgs.config.JdbcTemplateImpl;
import br.com.systemsgs.config.SimpleJdbcClassImpl;
import br.com.systemsgs.config.SimpleJdbcTemplateImpl;
import br.com.systemsgs.connection.HibernateUtilConnection;

@Component
@Transactional
public class ImplementationMethodsResource<G> implements InterfaceMethodsImpl<G> {

	private static final long serialVersionUID = 1L;

	private static SessionFactory sessionFactory = HibernateUtilConnection.getSessionFactory();

	@Autowired
	private JdbcTemplateImpl jdbcTemplateImpl;

	@Autowired
	private SimpleJdbcTemplateImpl simpleJdbcTemplateImpl;

	@Autowired
	private SimpleJdbcInsert simpleJdbcInsertImpl;
	
	@Autowired
	private SimpleJdbcClassImpl simpleJdbcClassImpl;

	@Override
	public void save(G obj) throws Exception {

	}

	@Override
	public void persist(G obj) throws Exception {

	}

	@Override
	public void salvaOrUpdate(G obj) throws Exception {

	}

	@Override
	public void update(G obj) throws Exception {

	}

	@Override
	public void delete(G obj) throws Exception {

	}

	@Override
	public void executeUpdateQuerySqlNative(String g) throws Exception {

	}

	@Override
	public void executeUpdateSql(String g) throws Exception {

	}

	@Override
	public void clearSession() throws Exception {

	}

	@Override
	public void evict(Object obj) throws Exception {

	}

	@Override
	public Long qtdRegistroTabelaBanco(String g) throws Exception {
		return null;
	}

	@Override
	public G merge(G obj) throws Exception {
		return null;
	}

	@Override
	public List<G> findList(Class<G> objs) throws Exception {
		return null;
	}

	@Override
	public G findByIdTo(Class<G> entidade, Long id) throws Exception {
		return null;
	}

	@Override
	public Object findById(Class<G> entidade, Long id) throws Exception {
		return null;
	}

	@Override
	public List<G> findListQuerySqlNative(String g) throws Exception {
		return null;
	}

	@Override
	public List<?> getListSqlDinamica(String g) throws Exception {
		return null;
	}

	@Override
	public List<G> findListByQueryDinamica(String g, int numeroInicial, int numeroFinal) throws Exception {
		return null;
	}

	@Override
	public Query obterQuery(String g) throws Exception {
		return null;
	}

	@Override
	public Session getSession() throws Exception {
		return null;
	}

	@Override
	public JdbcTemplate getJdbcTemplate() {
		return null;
	}

	@Override
	public SimpleJdbcTemplate getSimpleJdbcTemplate() {
		return null;
	}

	@Override
	public SimpleJdbcInsert getSimpleJdbcInsert() {
		return null;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public JdbcTemplateImpl getJdbcTemplateImpl() {
		return jdbcTemplateImpl;
	}

	public SimpleJdbcTemplateImpl getSimpleJdbcTemplateImpl() {
		return simpleJdbcTemplateImpl;
	}

	public SimpleJdbcInsert getSimpleJdbcInsertImpl() {
		return simpleJdbcInsertImpl;
	}

	public SimpleJdbcClassImpl getSimpleJdbcClassImpl() {
		return simpleJdbcClassImpl;
	}
	
}
