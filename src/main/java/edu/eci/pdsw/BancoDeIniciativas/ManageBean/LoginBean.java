package edu.eci.pdsw.BancoDeIniciativas.ManageBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import edu.eci.pdsw.BancoDeIniciativas.entities.Usuario;
import edu.eci.pdsw.BancoDeIniciativas.sample.services.Services;
import edu.eci.pdsw.BancoDeIniciativas.sample.services.ServicesException;

@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean extends BasePageBean {
	
	private String mail;
	private String password;
	private Usuario user;

	/**
	 * 
	 */
	private static final long serialVersionUID = 3594009161252782831L;

	@Inject
	Services service;

	public void validateUsernamePassword() throws ServicesException {
		setUser(service.getUser(mail));
		if (user != null) {
			System.out.println("In database.");
		} else {
			System.out.println("Not in database.");
		}
	}
	
	public void showAllUsers() throws ServicesException {
		List<Usuario> usuarios = service.listUsers();
		usuarios.forEach(u -> System.out.println(u.getCorreo()));
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Usuario getUser() {
		return user;
	}
	
	public void setUser(Usuario user) {
		this.user = user;
	}

}
