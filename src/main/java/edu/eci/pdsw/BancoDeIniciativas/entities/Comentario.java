package edu.eci.pdsw.BancoDeIniciativas.entities;

import java.sql.Date;

public class Comentario {

	private int id;
	private String sugerencias_id;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String mensaje;
	private Usuario usuario;

	public Comentario(int id, String sugerencias_id, Date fechaCreacion, Date fechaModificacion, String mensaje,
			Usuario usuario) {
		this.id = id;
		this.sugerencias_id = sugerencias_id;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.mensaje = mensaje;
		this.usuario = usuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSugerencias_id() {
		return sugerencias_id;
	}

	public void setSugerencias_id(String sugerencias_id) {
		this.sugerencias_id = sugerencias_id;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
