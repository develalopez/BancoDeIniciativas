package edu.eci.pdsw.BancoDeIniciativas.ManageBean;

import java.io.IOException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import edu.eci.pdsw.BancoDeIniciativas.entities.Usuario;
import edu.eci.pdsw.BancoDeIniciativas.sample.services.Services;
import edu.eci.pdsw.BancoDeIniciativas.sample.services.ServicesException;

@SuppressWarnings("deprecation")
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean extends BasePageBean {
	
	private Usuario user;

	/**
	 * 
	 */
	private static final long serialVersionUID = 3594009161252782831L;

	@Inject
	Services service;

	public void validateUsernamePassword(String mail, String password) throws ServicesException, IOException {
		Usuario user = service.getUser(mail);
		FacesContext facesContext = FacesContext.getCurrentInstance();
		if (user != null) {
			HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
			session.setAttribute("id", user.getCorreo());
			session.setAttribute("name", user.getNombre());
			session.setAttribute("type", user.getTipo().ordinal());
			facesContext.getExternalContext().redirect("/faces/registroSugerencia.xhtml");
		} else {
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Usuario o clave invalido","Error"));
		}
	}
	
	public void showAllUsers() throws ServicesException {
		List<Usuario> usuarios = service.listUsers();
		usuarios.forEach(u -> System.out.println(u.getCorreo()));
	}
	

	
	public Usuario getUser() {
		return user;
	}
	
	public void setUser(Usuario user) {
		this.user = user;
	}

}
