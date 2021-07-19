package br.com.systemsgs.filter;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.filter.DelegatingFilterProxy;

import br.com.systemsgs.config.ContextLoaderSystemsGS;
import br.com.systemsgs.config.UtilFramework;
import br.com.systemsgs.connection.HibernateUtilConnection;
import br.com.systemsgs.model.ModelUsuario;

@WebFilter(filterName = "conexaoFilter")
public class FilterOpenSessionView extends DelegatingFilterProxy implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private static SessionFactory sessionFactory;
	
	@Override
	protected void initFilterBean() throws ServletException {
		sessionFactory = HibernateUtilConnection.getSessionFactory();
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		BasicDataSource dataSource = (BasicDataSource) ContextLoaderSystemsGS.getBean("springDataSource");
		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
		PlatformTransactionManager manager = new DataSourceTransactionManager(dataSource);
		TransactionStatus status = manager.getTransaction(definition);
		
		try {
			request.setCharacterEncoding("UTF-8");
			HttpServletRequest servletRequest = (HttpServletRequest) request;
			HttpSession sessao = servletRequest.getSession();
			
			ModelUsuario usuarioLogadoSessao = (ModelUsuario) sessao.getAttribute("usuarioLogadoSessao");
			
			if(usuarioLogadoSessao != null) {
				UtilFramework.getThreadLocal().set(usuarioLogadoSessao.getId());
			}
			
			sessionFactory.getCurrentSession().beginTransaction();
			filterChain.doFilter(request, response);
			
			manager.commit(status);
			
			if(sessionFactory.getCurrentSession().getTransaction().isActive()) {
				sessionFactory.getCurrentSession().flush();
				sessionFactory.getCurrentSession().getTransaction().commit();
			}
			
			if(sessionFactory.getCurrentSession().isOpen()) {
				sessionFactory.getCurrentSession().close();
			}
			
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
		}catch (Exception exception) {
			manager.rollback(status);
			exception.printStackTrace();
			
			if(sessionFactory.getCurrentSession().getTransaction().isActive()) {
				sessionFactory.getCurrentSession().getTransaction().rollback();
			}
			
			if(sessionFactory.getCurrentSession().isOpen()) {
				sessionFactory.getCurrentSession().close();
			}
			
		}finally {
			if(sessionFactory.getCurrentSession().isOpen()) {
				if(sessionFactory.getCurrentSession().beginTransaction().isActive()) {
					sessionFactory.getCurrentSession().flush();
					sessionFactory.getCurrentSession().clear();
				}
				if(sessionFactory.getCurrentSession().isOpen()) {
					sessionFactory.getCurrentSession().close();
				}
			}
		}
	}

}
