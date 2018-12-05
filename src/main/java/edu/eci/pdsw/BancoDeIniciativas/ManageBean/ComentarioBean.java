package edu.eci.pdsw.BancoDeIniciativas.ManageBean;

import java.io.IOException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.google.inject.Inject;

import edu.eci.pdsw.BancoDeIniciativas.*;

import edu.eci.pdsw.BancoDeIniciativas.entities.Comentario;
import edu.eci.pdsw.BancoDeIniciativas.entities.Sugerencia;
import edu.eci.pdsw.BancoDeIniciativas.entities.Usuario;
import edu.eci.pdsw.BancoDeIniciativas.sample.services.Services;
import edu.eci.pdsw.BancoDeIniciativas.sample.services.ServicesException;

@ManagedBean(name = "comentariosBean")
@RequestScoped
public class ComentarioBean extends BasePageBean {
	
	@Inject
	Services service;
	
	@ManagedProperty(value = "#{param.sugerencia}")
	private int sugerencia;
	
	public int getSugerencia() {
		return sugerencia;
	}
	public void setSugerencia(int sugerencia) {
		this.sugerencia = sugerencia;
	}
	public ArrayList<Comentario> getComentarios(){
		return service.getComentariosSugerencia(sugerencia);
	}
	
	public void registrarComentario(int idSugerencia) throws ServicesException, IOException {

		java.sql.Date fecha = new java.sql.Date(System.currentTimeMillis());
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
		Sugerencia sugerencia = service.searchSugerencia(idSugerencia);
		try {
			Comentario comentario = new Comentario(1, sugerencia, fecha,
					"monda", service.getUser((String) session.getAttribute("id")));
			service.createComentario(comentario);
			facesContext.getExternalContext().redirect("/faces/registroSugerencia.xhtml");
		} catch (ServicesException ex) {
			throw ex;
		}
	}

}
