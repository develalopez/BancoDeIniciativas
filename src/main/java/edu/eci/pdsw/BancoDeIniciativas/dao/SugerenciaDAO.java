package edu.eci.pdsw.BancoDeIniciativas.dao;

import java.sql.Date;
import java.util.ArrayList;

import edu.eci.pdsw.BancoDeIniciativas.entities.EstadoSugerencia;
import edu.eci.pdsw.BancoDeIniciativas.entities.Sugerencia;
import edu.eci.pdsw.BancoDeIniciativas.entities.Usuario;

public interface SugerenciaDAO {
	public void agregarSugerencia(Sugerencia sugerencia);

	public void eliminarSugerencia(int id);

	public Sugerencia verSugerencia(int id);

	public void actualizarSugerencia(int id, String mensaje, String palabrasClave, Date fechaModificacion);

	public ArrayList<Sugerencia> verSugerencias();

	public void actualizarEstado(int id, EstadoSugerencia estado);

	public ArrayList<Usuario> likesSugerencia(int id);

	public ArrayList<Sugerencia> verSugerenciasUsuario(String id);

	public ArrayList<Sugerencia> getClave(String clave) ;

	public void darLike(int idSugerencia, String correo);

	public void darDislike(int idSugerencia, String correo);

	public int numeroDeLikes(int idSugerencia);


}
