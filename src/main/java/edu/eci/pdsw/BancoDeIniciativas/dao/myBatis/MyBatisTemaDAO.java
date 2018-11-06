package edu.eci.pdsw.BancoDeIniciativas.dao.myBatis;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;

import edu.eci.pdsw.BancoDeIniciativas.dao.TemaDAO;
import edu.eci.pdsw.BancoDeIniciativas.dao.myBatis.mappers.TemaMapper;
import edu.eci.pdsw.BancoDeIniciativas.entities.Sugerencia;

public class MyBatisTemaDAO implements TemaDAO {

	@Inject
	private TemaMapper temaMapper;

	@Override
	public List<Sugerencia> load(int idTema) throws PersistenceException {
		try {
			return temaMapper.consultarSugerencia(idTema);
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al consultar las sugerencias con id de  tema " + idTema, e);
		}
	}

}
