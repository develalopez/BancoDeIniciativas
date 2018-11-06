package edu.eci.pdsw.BancoDeIniciativas.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.pdsw.BancoDeIniciativas.entities.Sugerencia;

public interface TemaDAO {
	
	List<Sugerencia> load(int idTema) throws PersistenceException;
	
}
