package br.com.systemsgs.connection;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.SessionFactoryImplementor;

import br.com.systemsgs.config.VarConnectionUtil;

public class HibernateUtilConnection implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public static String JAVA_COMP_ENV_JDBC_DATA_SOURCE = "java:/comp/env/jdbc/datasource";

	private static SessionFactory sessionFactory = buildSessionFactory();
	
	
	private static SessionFactory buildSessionFactory() {
		try {
			if(sessionFactory == null) {
				sessionFactory = new Configuration().configure().buildSessionFactory();
			}
			
			return sessionFactory;
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError("Ops! Conexão Falhou com o SessionFactory: " + sessionFactory);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static Session getCurrentSession() {
		return getSessionFactory().getCurrentSession();
	}
	
	public static Session openSession() {
		if(sessionFactory == null) {
			buildSessionFactory();
		}
		
		return sessionFactory.openSession();
	}
	
	public static Connection getConnection() throws Exception {
		InitialContext context = new InitialContext();
		DataSource dataSource = (DataSource) context.lookup(JAVA_COMP_ENV_JDBC_DATA_SOURCE);
		
		return dataSource.getConnection();
	}
	
	public static Connection getConnectionProvider() throws SQLException{
		return ((SessionFactoryImplementor) sessionFactory).getConnectionProvider().getConnection();
	}
	
	public DataSource getDatSource() throws NamingException{
		InitialContext context = new InitialContext();
		return (DataSource) context.lookup(VarConnectionUtil.JAVA_COMP_ENV_JDBC_DATA_SOURCE);
	}
	
}
