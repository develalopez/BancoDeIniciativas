package edu.eci.pdsw.BancoDeIniciativas.view;

import java.sql.Date;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import edu.eci.pdsw.BancoDeIniciativas.entities.EstadoSugerencia;
import edu.eci.pdsw.BancoDeIniciativas.entities.Sugerencia;
import edu.eci.pdsw.BancoDeIniciativas.entities.Tema;
import edu.eci.pdsw.BancoDeIniciativas.entities.Usuario;

@ManagedBean(name = "sugerenciaBean")
@RequestScoped
public class SugerenciaBean {
	@ManagedProperty(value = "#{param.usuario}")
	private String mensaje;
	private String palabrasClave;
	private String usuario;
	// private Tema tema;
	// desplebagle para escoger tema
	private Date fechaCreacion;
	private String titulo;
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
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void registrarSugerencia() {
		//cambiar usuario cuando este services terminado
		//tema, desplegable
		
		java.sql.Date fecha = new java.sql.Date(System.currentTimeMillis());
		Sugerencia s=new Sugerencia(1,mensaje,palabrasClave,new Usuario(),new Tema(),
				fecha,titulo,new ArrayList<Usuario>());
		
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	

}
