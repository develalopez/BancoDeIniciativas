package edu.eci.pdsw.BancoDeIniciativas.sample.services.impl;

import java.sql.Date;
import java.util.List;

import javax.inject.Inject;

import edu.eci.pdsw.BancoDeIniciativas.dao.SugerenciaDAO;
import edu.eci.pdsw.BancoDeIniciativas.dao.UsuarioDAO;
import edu.eci.pdsw.BancoDeIniciativas.entities.EstadoSugerencia;
import edu.eci.pdsw.BancoDeIniciativas.entities.Sugerencia;
import edu.eci.pdsw.BancoDeIniciativas.entities.Usuario;
import edu.eci.pdsw.BancoDeIniciativas.sample.services.Services;
import edu.eci.pdsw.BancoDeIniciativas.sample.services.ServicesException;

public class ServiceImpl implements Services {

	@Inject
	private UsuarioDAO userDAO;

	@Inject
	private SugerenciaDAO sugerenciaDAO;

	@Override
	public void createUser(Usuario user) throws ServicesException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Usuario> listUsers() throws ServicesException {
		return userDAO.load();
	}

	@Override
	public void modifyUser(String email, int rol) throws ServicesException {
		// TODO Auto-generated method stub

	}

	@Override
	public void createComment(Sugerencia sugerencia) throws ServicesException {
		//como hacer la exception
				sugerenciaDAO.agregarSugerencia(sugerencia);	
	}

	@Override
	public Sugerencia searchSugerencia(int idSuge) throws ServicesException {
		return sugerenciaDAO.verSugerencia(idSuge);
	
	}

	@Override
	public void modifySugerencia(int id, String mensaje, String palabrasClave, Date fechaModificacion)
			throws ServicesException {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifyEstado(int id, EstadoSugerencia estado) throws ServicesException {
		// TODO Auto-generated method stub

	}

	@Override
	public Usuario getUser(String email) throws ServicesException {
		// TODO Auto-generated method stub
		return null;
	}

}