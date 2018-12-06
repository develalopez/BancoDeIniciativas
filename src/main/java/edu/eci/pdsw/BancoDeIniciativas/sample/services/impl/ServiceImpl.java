package edu.eci.pdsw.BancoDeIniciativas.sample.services.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import edu.eci.pdsw.BancoDeIniciativas.ManageBean.BasePageBean;
import edu.eci.pdsw.BancoDeIniciativas.dao.ComentarioDAO;
import edu.eci.pdsw.BancoDeIniciativas.dao.SugerenciaDAO;
import edu.eci.pdsw.BancoDeIniciativas.dao.UsuarioDAO;
import edu.eci.pdsw.BancoDeIniciativas.entities.Comentario;
import edu.eci.pdsw.BancoDeIniciativas.entities.EstadoSugerencia;
import edu.eci.pdsw.BancoDeIniciativas.entities.Sugerencia;
import edu.eci.pdsw.BancoDeIniciativas.entities.Usuario;
import edu.eci.pdsw.BancoDeIniciativas.sample.services.Services;
import edu.eci.pdsw.BancoDeIniciativas.sample.services.ServicesException;

@ManagedBean(name = "serviceBean")
@SessionScoped
public class ServiceImpl extends BasePageBean implements Services {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioDAO userDAO;

	@Inject
	private SugerenciaDAO sugerenciaDAO;
	
	@Inject
	private ComentarioDAO comentarioDAO;

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
	public void createSugerencia(Sugerencia sugerencia) throws ServicesException {
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
		return userDAO.load(email);
	}
	
	public ArrayList<Sugerencia> getSugerenciasUsuario(String correo){
		return sugerenciaDAO.verSugerenciasUsuario(correo);
	}

	@Override
	public ArrayList<Usuario> likesSugerencia(int sugerencia) {
		return sugerenciaDAO.likesSugerencia(sugerencia);
	}

	@Override
	public ArrayList<Sugerencia> getSugerenciasPalabras(String clave) {
		return sugerenciaDAO.getClave(clave);
	}

	@Override
	public ArrayList<Sugerencia> getSugerenciasAll() {
		return sugerenciaDAO.verSugerencias();
	}

	@Override
	public ArrayList<Comentario> getComentariosSugerencia(int idSugerencia) {
		return comentarioDAO.verComentarios(idSugerencia);
	}

	@Override
	public void createComentario(Comentario comentario) {
		comentarioDAO.agregarComentario(comentario);
		
	}

	@Override
	public void darLike(int idSugerencia, String correo) {
		sugerenciaDAO.darLike(idSugerencia, correo);
	}

	@Override
	public void darDislike(int idSugerencia, String correo) {
		sugerenciaDAO.darDislike(idSugerencia, correo);
	}

	@Override
	public int numeroDeLikes(int idSugerencia) {
		return sugerenciaDAO.numeroDeLikes(idSugerencia);
	}

	@Override
	public void eliminarSugerencia(int idSugerencia) {
		sugerenciaDAO.eliminarSugerencia(idSugerencia);
	}

	@Override
	public int getLikesUsuario(String id) {
		
		return userDAO.getLikesUsuario(id);
	}

	@Override
	public int getnumComentariosUsuario(String id) {
		
		return comentarioDAO.getnumComentariosUsuario(id);
	}

	@Override
	public int getnumSugerenciassUsuario(String id) {
		
		return sugerenciaDAO.getnumSugerenciassUsuario(id);
	}

}