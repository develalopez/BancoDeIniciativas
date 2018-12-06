package edu.eci.pdsw.BancoDeIniciativas.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.pdsw.BancoDeIniciativas.entities.Usuario;

public interface UsuarioDAO {

	List<Usuario> load() throws PersistenceException;

	Usuario load(String id) throws PersistenceException;

	Usuario likes(String id) throws PersistenceException;

	void save(Usuario id) throws PersistenceException;

	int getLikesUsuario(String id);

}
