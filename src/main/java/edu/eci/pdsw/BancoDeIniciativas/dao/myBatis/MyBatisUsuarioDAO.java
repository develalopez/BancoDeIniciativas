package edu.eci.pdsw.BancoDeIniciativas.dao.myBatis;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;

import edu.eci.pdsw.BancoDeIniciativas.dao.UsuarioDAO;
import edu.eci.pdsw.BancoDeIniciativas.dao.myBatis.mappers.UsuarioMapper;
import edu.eci.pdsw.BancoDeIniciativas.entities.Usuario;

public class MyBatisUsuarioDAO implements UsuarioDAO {
	@Inject
	private UsuarioMapper usuarioMapper;

	@Override
	public Usuario load(String id) throws PersistenceException {
		try {
			return usuarioMapper.consultarUsuario(id);
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al consultar el usuario " + id, e);
		}

	}

	@Override
	public List<Usuario> load() throws PersistenceException {
		try {
			return usuarioMapper.consultarUsuarios();
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al consultar los usuarios " + e);
		}
	}

	@Override
	public Usuario likes(String id) throws PersistenceException {
		try {
			return usuarioMapper.consultarUsuarioLikes(id);
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al consultar el like del usuario " + id, e);
		}

	}

	@Override
	public void save(Usuario id) throws PersistenceException {
		try {
			usuarioMapper.registrarUsuario(id);
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al registrar el usuaio " + id.toString(), e);
		}

	}

	@Override
	public int getLikesUsuario(String id) {
		
		return usuarioMapper.getLikesUsuario(id);
	}

}
