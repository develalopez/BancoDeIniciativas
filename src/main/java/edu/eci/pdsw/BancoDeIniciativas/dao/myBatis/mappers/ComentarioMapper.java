package edu.eci.pdsw.BancoDeIniciativas.dao.myBatis.mappers;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import edu.eci.pdsw.BancoDeIniciativas.entities.Comentario;

public interface ComentarioMapper {

	public ArrayList<Comentario> verComentarios(@Param("idSugerencia") int idSugerencia);

	public void agregarComentario(@Param("comentario") Comentario comentario);

}
