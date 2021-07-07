package br.com.systemsgs.impl;

import java.util.ArrayList;
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

	private void rollBackProcessoAjax() {
		sessionFactory.getCurrentSession().beginTransaction().rollback();
	}

	private void validaSessionFactory() {
		if (sessionFactory == null) {
			sessionFactory = HibernateUtilConnection.getSessionFactory();
		}
		validTransaction();
	}

	private void validTransaction() {
		if (!sessionFactory.getCurrentSession().getTransaction().isActive()) {
			sessionFactory.getCurrentSession().beginTransaction();
		}
	}
	
	private void executeFlushSession() {
		sessionFactory.getCurrentSession().flush();
	}

	private void commitProcessoAjax() {
		sessionFactory.getCurrentSession().beginTransaction().commit();
	}

	@Override
	public void save(G obj) throws Exception {
		validaSessionFactory();
		sessionFactory.getCurrentSession().save(obj);
		executeFlushSession();
	}

	@Override
	public void persist(G obj) throws Exception {
		validaSessionFactory();
		sessionFactory.getCurrentSession().persist(obj);
		executeFlushSession();
	}

	@Override
	public void salvaOrUpdate(G obj) throws Exception {
		validaSessionFactory();
		sessionFactory.getCurrentSession().saveOrUpdate(obj);
		executeFlushSession();
	}

	@Override
	public void update(G obj) throws Exception {
		validaSessionFactory();
		sessionFactory.getCurrentSession().update(obj);
		executeFlushSession();
	}

	@Override
	public void delete(G obj) throws Exception {
		validaSessionFactory();
		sessionFactory.getCurrentSession().delete(obj);
		executeFlushSession();
	}

	@Override
	public void executeUpdateQuerySqlNative(String g) throws Exception {
		validaSessionFactory();
		sessionFactory.getCurrentSession().createQuery(g).executeUpdate();
		executeFlushSession();
	}

	@Override
	public void executeUpdateSql(String g) throws Exception {
		validaSessionFactory();
		sessionFactory.getCurrentSession().createSQLQuery(g).executeUpdate();
		executeFlushSession();
	}

	@Override
	public void clearSession() throws Exception {
		sessionFactory.getCurrentSession().clear();
	}

	@Override
	public void evict(Object obj) throws Exception {
		validaSessionFactory();
		sessionFactory.getCurrentSession().evict(obj);
	}

	@Override
	public Long qtdRegistroTabelaBanco(String g) throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append(" select count(1) from ").append(g);
		return jdbcTemplateImpl.queryForLong(sql.toString());
	}

	@Override
	public G merge(G obj) throws Exception {
		validaSessionFactory();
		obj = (G) sessionFactory.getCurrentSession().merge(obj);
		executeFlushSession();
		return obj;
	}

	@Override
	public List<G> findList(Class<G> objs) throws Exception {
		validaSessionFactory();
		StringBuilder query = new StringBuilder();
		query.append(" select distinct(entity) from").append(objs.getSimpleName()).append(" entity ");
		
		List<G> lista = sessionFactory.getCurrentSession().createQuery(query.toString()).list();
		
		return lista;
	}

	@Override
	public G findByIdTo(Class<G> entidade, Long id) throws Exception {
		validaSessionFactory();
		G obj = (G) sessionFactory.getCurrentSession().load(getClass(), id);
		return null;
	}

	@Override
	public Object findById(Class<G> entidade, Long id) throws Exception {
		validaSessionFactory();
		Object obj = sessionFactory.getCurrentSession().load(getClass(), id);
		return obj;
	}

	@Override
	public List<G> findListQuerySqlNative(String g) throws Exception {
		validaSessionFactory();
		
		List<G> lista = new ArrayList<G>();
		lista = sessionFactory.getCurrentSession().createQuery(g).list();
		return lista;
	}

	@Override
	public List<?> getListSqlDinamica(String g) throws Exception {
		validaSessionFactory();
		List<?> lista = sessionFactory.getCurrentSession().createSQLQuery(g).list();
		return lista;
	}

	@Override
	public List<G> findListByQueryDinamica(String g, int numeroInicial, int numeroFinal) throws Exception {
		validaSessionFactory();
		
		List<G> lista = new ArrayList<G>();
		lista = sessionFactory.getCurrentSession().createQuery(g).setFirstResult(numeroInicial).setMaxResults(numeroFinal).list();
		return lista;
	}
	
	public List<Object[]> getListSqlDinamicaArray(String g) throws Exception{
		validaSessionFactory();
		
		List<Object[]> lista = (List<Object[]>) sessionFactory.getCurrentSession().createSQLQuery(g).list();
		return lista;
	}

	@Override
	public Query obterQuery(String g) throws Exception {
		validaSessionFactory();
		Query query = sessionFactory.getCurrentSession().createQuery(g.toString());
		return query;
	}

	@Override
	public Session getSession() throws Exception {
		validaSessionFactory();
		return sessionFactory.getCurrentSession();
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
