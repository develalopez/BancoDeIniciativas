package edu.eci.pdsw.BancoDeIniciativas.entities;


public class Tema {
	
	private Integer id;
	private TipoTema tipoTema;
	
	
	public Tema() {
		
	}

	public Tema(Integer id, TipoTema tipoTema) {
		this.id = id;
		this.tipoTema = tipoTema;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoTema getTipoTema() {
		return tipoTema;
	}

	public void setTipoTema(TipoTema tipoTema) {
		this.tipoTema = tipoTema;
	}
	
	

	

}
