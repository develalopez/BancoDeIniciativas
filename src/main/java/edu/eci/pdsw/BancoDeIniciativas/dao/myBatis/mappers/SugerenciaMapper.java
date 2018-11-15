package edu.eci.pdsw.BancoDeIniciativas.dao.myBatis.mappers;

import java.sql.Date;
import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import edu.eci.pdsw.BancoDeIniciativas.entities.EstadoSugerencia;
import edu.eci.pdsw.BancoDeIniciativas.entities.Sugerencia;
import edu.eci.pdsw.BancoDeIniciativas.entities.Usuario;

public interface SugerenciaMapper {
	public void agregarSugerencia(@Param("sugerencia") Sugerencia sugerencia);

	public void eliminarSugerencia(@Param("id") int id);

	public Sugerencia verSugerencia(@Param("id") int id);

	public void actualizarSugerencia(@Param("id") int id, @Param("mensaje") String mensaje,
			@Param("palabras") String palabrasClave, @Param("fecha") Date fechaModificacion);

	public ArrayList<Sugerencia> verSugerencias();

	public void actualizarEstado(@Param("id") int id, @Param("estado") EstadoSugerencia estado);

	public ArrayList<Usuario> likesSugerencia(@Param("id") int id);

	public ArrayList<Sugerencia> verSugerenciasUsuario(@Param("correo") String id);

	public ArrayList<Sugerencia> searchClave(@Param("clave") String clave);
}
