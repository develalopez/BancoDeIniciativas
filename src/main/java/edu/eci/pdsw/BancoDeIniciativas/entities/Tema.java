package edu.eci.pdsw.BancoDeIniciativas.entities;

public class Tema {
	
	private Integer id;
	private String nombre;
	
	public Tema() {
		
	}
	
	public Tema(int id, String nombre) {
		this.setId(id);
		this.setNombre(nombre);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
