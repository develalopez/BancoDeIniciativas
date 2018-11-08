package edu.eci.pdsw.BancoDeIniciativas.sample.services;

import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import static com.google.inject.Guice.createInjector;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Injector;

import edu.eci.pdsw.BancoDeIniciativas.dao.SugerenciaDAO;
import edu.eci.pdsw.BancoDeIniciativas.dao.UsuarioDAO;
import edu.eci.pdsw.BancoDeIniciativas.dao.myBatis.MyBatisSugerenciaDAO;
import edu.eci.pdsw.BancoDeIniciativas.dao.myBatis.MyBatisUsuarioDAO;
import edu.eci.pdsw.BancoDeIniciativas.entities.Usuario;
import edu.eci.pdsw.BancoDeIniciativas.sample.services.impl.ServiceImpl;



public class ServicesFactory {

    private static ServicesFactory instance = new ServicesFactory();
    
    private static Injector injector;
    private static Injector testingInjector;
    
    private ServicesFactory(){
        injector = createInjector(new XMLMyBatisModule() {

                    @Override
                    protected void initialize() {
                        install(JdbcHelper.PostgreSQL);                        
                        setClassPathResource("mybatis-config.xml");         
                        bind(UsuarioDAO.class).to(MyBatisUsuarioDAO.class);
						bind(SugerenciaDAO.class).to(MyBatisSugerenciaDAO.class);
                        bind(Services.class).to(ServiceImpl.class);
                    }

                }
                
        );
        
        /*testingInjector = createInjector(new XMLMyBatisModule() {
                    @Override
                    protected void initialize() {
                        install(JdbcHelper.PostgreSQL);                        
                        setClassPathResource("mybatis-config-h2.xml");                        
                        bind(UserDAO.class).to(MyBatisUserDao.class);
                        bind(InitiativeServices.class).to(InitiativeServicesStub.class);
                    }
                }
                
        );*/
        
    }
    
    public Services getInitiativeServices(){
        return injector.getInstance(Services.class);   
    }

    public Services getServicesForTesting(){
        return testingInjector.getInstance(Services.class);   
    }
    
    public static ServicesFactory getInstance(){
        return instance;
    }
    
 
    
}