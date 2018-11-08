package edu.eci.pdsw.BancoDeIniciativas.ManageBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.eci.pdsw.BancoDeIniciativas.entities.Tema;
import edu.eci.pdsw.BancoDeIniciativas.entities.Usuario;
import edu.eci.pdsw.BancoDeIniciativas.sample.services.Services;
import edu.eci.pdsw.BancoDeIniciativas.sample.services.ServicesException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;




@SuppressWarnings("deprecation")
@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean extends BasePageBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3594009161252782831L;
	
	
	@Inject
	Services service;
	
	public void logIn(String email, String password) throws ServicesException, IOException {
		Usuario user = service.getUser(email);
		FacesContext facesContext = FacesContext.getCurrentInstance();
		if(user != null) {
			HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
			session.setAttribute("correo", user.getCorreo());
			session.setAttribute("name", user.getNombre());
			facesContext.getExternalContext().redirect("/faces/initiativeKeyword.xhtml");
		}
		else {
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Usuario o clave invalido","Error"));
		}
	}
	
	public boolean islogged() {
		return ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute("id") != null;
	}
	
	public String getName() {
		return ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute("name").toString();
	}
		
	public List<Usuario> getUsers() throws Exception{
		try {
			return service.listUsers();
		}
		catch(ServicesException ex) {
			throw ex;
		}
	}
	
	public List<Tema> getTypes (){
		return Arrays.asList(Tema.class.getEnumConstants() );
		
	}
	
	public void modifyUser(String email, int rol) {
		try {
			System.out.println(email+" "+rol);
			service.modifyUser(email, rol);
		} catch (ServicesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
