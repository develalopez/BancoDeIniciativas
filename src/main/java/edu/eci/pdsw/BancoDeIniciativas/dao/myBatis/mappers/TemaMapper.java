package edu.eci.pdsw.BancoDeIniciativas.dao.myBatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.pdsw.BancoDeIniciativas.entities.Sugerencia;

public interface TemaMapper {

	List<Sugerencia> consultarSugerencia (@Param("idtema") int id);
	
}
