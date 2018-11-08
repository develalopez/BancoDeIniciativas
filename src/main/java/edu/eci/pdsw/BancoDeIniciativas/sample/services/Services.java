package edu.eci.pdsw.BancoDeIniciativas.sample.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import edu.eci.pdsw.BancoDeIniciativas.entities.EstadoSugerencia;
import edu.eci.pdsw.BancoDeIniciativas.entities.Sugerencia;
import edu.eci.pdsw.BancoDeIniciativas.entities.Usuario;

public interface Services {

	/**
	 * Crea un usuario
	 * 
	 * @param user
	 * @throws ServicesException
	 */
	public void createUser(Usuario user) throws ServicesException;

	/**
	 * 
	 * @return lista de usuarios
	 * @throws ServicesException
	 */
	public List<Usuario> listUsers() throws ServicesException;

	public void modifyUser(String email, int rol) throws ServicesException;

	/**
	 * 
	 * @param idUser
	 * @param idSuge
	 * @param comment
	 * @param tema
	 * @throws ServicesException
	 */
	public void createComment(Sugerencia sugerencia) throws ServicesException;

	/**
	 * public List<Sugerencia> searchCommentsBySugenrencia (int id) throws
	 * ServicesException;
	 * 
	 * 
	 * 
	 * @param idIni
	 * @return
	 * @throws ServicesException
	 */
	public Sugerencia searchSugerencia(int idSuge) throws ServicesException;

	/**
	 * 
	 * @param id
	 * @return
	 * @throws ServicesException
	 */
	public Usuario getUser(String email) throws ServicesException;

	public void modifySugerencia(int id, String mensaje, String palabrasClave, Date fechaModificacion)
			throws ServicesException;
	
	public void modifyEstado(int id,EstadoSugerencia estado)
			throws ServicesException;

	/**
	 * 
	 * @param keywords
	 * @return
	 * @throws ServicesException
	 *             public List<Sugerencia> searchInitiativeByKeywords(List<String>
	 *             keywords) throws ServicesException;
	 * 
	 */
	public ArrayList<Sugerencia> getSugerenciasUsuario(String correo);

	public ArrayList<Usuario> likesSugerencia(int sugerencia);

}