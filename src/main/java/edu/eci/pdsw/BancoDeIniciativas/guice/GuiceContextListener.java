
package edu.eci.pdsw.BancoDeIniciativas.guice;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import com.google.inject.Guice;
import com.google.inject.Injector;

import edu.eci.pdsw.BancoDeIniciativas.dao.SugerenciaDAO;
import edu.eci.pdsw.BancoDeIniciativas.dao.TemaDAO;
import edu.eci.pdsw.BancoDeIniciativas.dao.UsuarioDAO;
import edu.eci.pdsw.BancoDeIniciativas.dao.myBatis.MyBatisSugerenciaDAO;
import edu.eci.pdsw.BancoDeIniciativas.dao.myBatis.MyBatisTemaDAO;
import edu.eci.pdsw.BancoDeIniciativas.dao.myBatis.MyBatisUsuarioDAO;
import edu.eci.pdsw.BancoDeIniciativas.sample.services.Services;
import edu.eci.pdsw.BancoDeIniciativas.sample.services.impl.ServiceImpl;

public class GuiceContextListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		ServletContext servletContext = servletContextEvent.getServletContext();
		servletContext.removeAttribute(Injector.class.getName());
	}

	public void contextInitialized(ServletContextEvent servletContextEvent) {
		Injector injector = Guice.createInjector(new XMLMyBatisModule() {
			@Override
			protected void initialize() {
				install(JdbcHelper.PostgreSQL);
				setEnvironmentId("development");
				setClassPathResource("mybatis-config.xml");

				bind(UsuarioDAO.class).to(MyBatisUsuarioDAO.class);
				bind(SugerenciaDAO.class).to(MyBatisSugerenciaDAO.class);
				bind(TemaDAO.class).to(MyBatisTemaDAO.class);
				bind(Services.class).to(ServiceImpl.class);
			}
		});

		servletContextEvent.getServletContext().setAttribute(Injector.class.getName(), injector);
	}
}
