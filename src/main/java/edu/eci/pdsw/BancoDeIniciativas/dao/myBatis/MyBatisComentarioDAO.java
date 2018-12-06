package edu.eci.pdsw.BancoDeIniciativas.dao.myBatis;

import java.util.ArrayList;

import com.google.inject.Inject;

import edu.eci.pdsw.BancoDeIniciativas.dao.ComentarioDAO;
import edu.eci.pdsw.BancoDeIniciativas.dao.myBatis.mappers.ComentarioMapper;
import edu.eci.pdsw.BancoDeIniciativas.dao.myBatis.mappers.SugerenciaMapper;
import edu.eci.pdsw.BancoDeIniciativas.entities.Comentario;

public class MyBatisComentarioDAO implements ComentarioDAO{
	
	@Inject
	ComentarioMapper comentarioMapper;
	
	@Override
	public ArrayList<Comentario> verComentarios(int idSugerencia) {
		return comentarioMapper.verComentarios(idSugerencia);
	}

	@Override
	public void agregarComentario(Comentario comentario) {
		comentarioMapper.agregarComentario(comentario);
	}

	@Override
	public int getnumComentariosUsuario(String id) {
		return comentarioMapper.getnumComentariosUsuario(id);
	}

}
