package edu.eci.pdsw.BancoDeIniciativas.dao.myBatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.pdsw.BancoDeIniciativas.entities.Usuario;

public interface UsuarioMapper {

	Usuario consultarUsuario(@Param("iduser") String id);

	List<Usuario> consultarUsuarios();

	Usuario consultarUsuarioLikes(@Param("iduser") String id);

	Usuario registrarUsuario(@Param("user") Usuario user);

	int getLikesUsuario(@Param("id") String id);
}
