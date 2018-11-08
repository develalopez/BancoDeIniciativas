package edu.eci.pdsw.BancoDeIniciativas.ManageBean;

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
import edu.eci.pdsw.BancoDeIniciativas.entities.TipoTema;
import edu.eci.pdsw.BancoDeIniciativas.entities.Usuario;
import edu.eci.pdsw.BancoDeIniciativas.sample.services.Services;
import edu.eci.pdsw.BancoDeIniciativas.sample.services.ServicesException;

@ManagedBean(name = "sugerenciaBean")
@RequestScoped
public class SugerenciaBean extends BasePageBean{
	@Inject
	Services service;
	@ManagedProperty(value = "#{param.usuario}")
	private String usuario;
	private String mensaje;
	private String palabrasClave;
	
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
	public void registrarSugerencia() throws ServicesException {
		//cambiar usuario cuando este services terminado
		//tema, desplegable
		
		java.sql.Date fecha = new java.sql.Date(System.currentTimeMillis());
		Sugerencia s=new Sugerencia(1,mensaje,palabrasClave,service.getUser(usuario),new Tema(1,TipoTema.tema1),
				fecha,titulo,new ArrayList<Usuario>());
		System.out.println(s.getUsuario());
		System.out.println(s.getUsuario().getCorreo());
		service.createComment(s);
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public ArrayList<Sugerencia> getSugerenciasUsuario(){
		//revisar trace para error
		return service.getSugerenciasUsuario(usuario);
		
	}
	
	

}
