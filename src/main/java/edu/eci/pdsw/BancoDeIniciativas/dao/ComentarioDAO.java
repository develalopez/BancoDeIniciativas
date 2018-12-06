package edu.eci.pdsw.BancoDeIniciativas.dao;

import java.util.ArrayList;

import edu.eci.pdsw.BancoDeIniciativas.entities.*;

public interface ComentarioDAO {
	
	public ArrayList<Comentario> verComentarios(int idSugerencia);
	
	public void agregarComentario(Comentario comentario);

	public int getnumComentariosUsuario(String id);
	
}
