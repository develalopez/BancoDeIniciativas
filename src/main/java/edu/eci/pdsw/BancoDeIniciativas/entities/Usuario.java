package edu.eci.pdsw.BancoDeIniciativas.entities;

public class Usuario {
	private String nombre;
	private String correo;
	private TipoUsuario tipo;

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Usuario(String correo, String nombre, TipoUsuario tipo) {
		this.correo = correo;
		this.nombre = nombre;
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}

}
