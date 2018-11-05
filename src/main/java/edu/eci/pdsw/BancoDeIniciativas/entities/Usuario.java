package edu.eci.pdsw.BancoDeIniciativas.entities;

public class Usuario {
	private String nombre;

	private String correo;
	private long users_type_id;

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Usuario(String correo, String nombre, Long users_type_id) {
		this.correo=correo;
		this.nombre=nombre;
		this.users_type_id=users_type_id;
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

	public long getUsers_type_id() {
		return users_type_id;
	}

	public void setUsers_type_id(long users_type_id) {
		this.users_type_id = users_type_id;
	}

}
