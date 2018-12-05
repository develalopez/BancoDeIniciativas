package edu.eci.pdsw.BancoDeIniciativas.entities;

import java.sql.Date;

public class Comentario {

	private int id;
	private Sugerencia sugerencia;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String mensaje;
	private Usuario usuario;

	public Comentario(int id, Sugerencia sugerencia, Date fechaCreacion, String mensaje,
			Usuario usuario) {
		this.id = id;
		this.sugerencia = sugerencia;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = null;
		this.mensaje = mensaje;
		this.usuario = usuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Sugerencia getSugerencia() {
		return sugerencia;
	}

	public void setSugerencia(Sugerencia sugerencia) {
		this.sugerencia = sugerencia;
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
