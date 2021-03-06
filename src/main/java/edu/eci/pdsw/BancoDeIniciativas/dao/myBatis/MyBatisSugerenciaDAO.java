package edu.eci.pdsw.BancoDeIniciativas.dao.myBatis;

import java.sql.Date;
import java.util.ArrayList;

import com.google.inject.Inject;

import edu.eci.pdsw.BancoDeIniciativas.dao.SugerenciaDAO;
import edu.eci.pdsw.BancoDeIniciativas.dao.myBatis.mappers.SugerenciaMapper;
import edu.eci.pdsw.BancoDeIniciativas.entities.EstadoSugerencia;
import edu.eci.pdsw.BancoDeIniciativas.entities.Sugerencia;
import edu.eci.pdsw.BancoDeIniciativas.entities.Usuario;

public class MyBatisSugerenciaDAO implements SugerenciaDAO {
	@Inject
	SugerenciaMapper sugerenciaMapper;

	@Override
	public void agregarSugerencia(Sugerencia sugerencia) {
		sugerenciaMapper.agregarSugerencia(sugerencia);
		
	}

	@Override
	public void eliminarSugerencia(int id) {
		sugerenciaMapper.eliminarSugerencia(id);
		
	}

	@Override
	public Sugerencia verSugerencia(int id) {
		return sugerenciaMapper.verSugerencia(id);
	}

	@Override
	public void actualizarSugerencia(int id, String mensaje, String palabrasClave, Date fechaModificacion) {
		sugerenciaMapper.actualizarSugerencia(id, mensaje, palabrasClave, fechaModificacion);
		
	}

	@Override
	public ArrayList<Sugerencia> verSugerencias() {
		return sugerenciaMapper.verSugerencias();
	}

	@Override
	public void actualizarEstado(int id, EstadoSugerencia estado) {
		sugerenciaMapper.actualizarEstado(id, estado);
		
	}

	@Override
	public ArrayList<Usuario> likesSugerencia(int id) {
		return sugerenciaMapper.likesSugerencia(id);
	}

	@Override
	public ArrayList<Sugerencia> verSugerenciasUsuario(String id) {
		return sugerenciaMapper.verSugerenciasUsuario(id);
	}

	@Override
	public ArrayList<Sugerencia> getClave(String clave) {
		return sugerenciaMapper.searchClave(clave);
	}

	@Override
	public void darLike(int idSugerencia, String correo) {
		sugerenciaMapper.darLike(idSugerencia, correo);
	}

	@Override
	public void darDislike(int idSugerencia, String correo) {
		sugerenciaMapper.darDislike(idSugerencia, correo);
	}

	@Override
	public int numeroDeLikes(int idSugerencia) {
		return sugerenciaMapper.numeroDeLikes(idSugerencia);
	}

	@Override
	public int getnumSugerenciassUsuario(String id) {
		
		return sugerenciaMapper.getnumSugerenciassUsuario(id);
	}

	
}
