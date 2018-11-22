package edu.eci.pdsw.BancoDeIniciativas.entities;

import java.sql.Date;
import java.util.ArrayList;

public class Sugerencia {

	private int id;
	private String mensaje;
	private String palabrasClave;	// Ver si se quedara como string o sera una lista
	private Usuario usuario;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String titulo;
	private ArrayList<Usuario> likes;
	private EstadoSugerencia estado;

	public Sugerencia() {

	}

	public Sugerencia(int id, String mensaje, String palabrasClave, Usuario usuario, Date fechaCreacion,
			String titulo, ArrayList<Usuario> likes) {
		this.id = id;
		this.mensaje = mensaje;
		this.palabrasClave = palabrasClave;
		this.usuario = usuario;
		this.fechaCreacion = fechaCreacion;
		this.titulo = titulo;
		this.likes = likes;
		fechaModificacion = null;
		estado = EstadoSugerencia.EN_ESPERA_DE_REVISION;
	}

	public EstadoSugerencia getEstado() {
		return estado;
	}

	public void setEstado(EstadoSugerencia estado) {
		this.estado = estado;
	}

	public ArrayList<Usuario> getLikes() {
		return likes;
	}

	public void setLikes(ArrayList<Usuario> likes) {
		this.likes = likes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getPalabrasClave() {
		return palabrasClave;
	}

	public void setPalabrasClave(String palabrasClave) {
		this.palabrasClave = palabrasClave;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

	public void setFechaModificacion(Date fechamodificacion) {
		this.fechaModificacion = fechamodificacion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String toString() {

		return "[Comentario: id: " + id + ", description: " + mensaje + ", CreationDate: "
				+ fechaCreacion + ", ModifyDate: " + fechaModificacion + ", user: " + usuario + ", status: " + estado + ", likes: "
				+ likes + "]";
	}

}
