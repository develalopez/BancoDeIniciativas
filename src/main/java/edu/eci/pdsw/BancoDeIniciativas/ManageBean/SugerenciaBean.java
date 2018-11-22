package edu.eci.pdsw.BancoDeIniciativas.ManageBean;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import edu.eci.pdsw.BancoDeIniciativas.entities.Sugerencia;
import edu.eci.pdsw.BancoDeIniciativas.entities.Usuario;
import edu.eci.pdsw.BancoDeIniciativas.sample.services.Services;
import edu.eci.pdsw.BancoDeIniciativas.sample.services.ServicesException;

@SuppressWarnings("deprecation")
@ManagedBean(name = "sugerenciaBean")
@SessionScoped
public class SugerenciaBean extends BasePageBean {
	
	@Inject
	Services service;

	private static final long serialVersionUID = 3594009161252782831L;

	private String usuario;
	private String mensaje;
	private String palabrasClave;
	private String Clave;

	public String getClave() {
		return Clave;
	}

	public void setClave(String clave) {
		Clave = clave;
	}

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

	public void registrarSugerencia() throws ServicesException, IOException {
		// cambiar usuario cuando este services terminado
		// tema, desplegable

		java.sql.Date fecha = new java.sql.Date(System.currentTimeMillis());
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);

		try {
			Sugerencia s = new Sugerencia(1, mensaje, palabrasClave,
					service.getUser((String) session.getAttribute("id")), fecha, titulo,
					new ArrayList<Usuario>());
			service.createComment(s);
			facesContext.getExternalContext().redirect("/faces/registroSugerencia.xhtml");
		} catch (ServicesException ex) {
			throw ex;
		}
	}
	
	public void eliminarSugerencia(int idSugerencia) throws IOException {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
		service.eliminarSugerencia(idSugerencia);
		facesContext.getExternalContext().redirect("/faces/registroSugerencia.xhtml");
	}

	public ArrayList<Sugerencia> getPalabraClave() throws ServicesException {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
		try {
			return service.getSugerenciasPalabras(Clave);
		} catch (Exception e) {
			throw e;
			// TODO: handle exception
		}
	}
	
	public void darLike(int idSugerencia) throws IOException {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
		service.darLike(idSugerencia, (String) session.getAttribute("id"));
		facesContext.getExternalContext().redirect("/faces/registroSugerencia.xhtml");
	}
	
	public void darDislike(int idSugerencia) throws IOException {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
		service.darDislike(idSugerencia, (String) session.getAttribute("id"));
		facesContext.getExternalContext().redirect("/faces/registroSugerencia.xhtml");
	}
	
	public int getNumeroLikes(int idSugerencia) {
		return service.numeroDeLikes(idSugerencia);
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public ArrayList<Sugerencia> getSugerenciasUsuario() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);

		return service.getSugerenciasUsuario((String) session.getAttribute("id"));

	}

	public ArrayList<Sugerencia> getSugerencias() {

		return service.getSugerenciasAll();

	}

	public String getName() {
		return ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true))
				.getAttribute("name").toString();
	}

}
