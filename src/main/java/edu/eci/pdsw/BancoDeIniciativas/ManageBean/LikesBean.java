package edu.eci.pdsw.BancoDeIniciativas.ManageBean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.google.inject.Inject;

import edu.eci.pdsw.BancoDeIniciativas.entities.Usuario;
import edu.eci.pdsw.BancoDeIniciativas.sample.services.Services;

@ManagedBean(name = "likesBean")
@RequestScoped
public class LikesBean extends BasePageBean {
	
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
	public ArrayList<Usuario> getLikes(){
		return service.likesSugerencia(sugerencia);
	}
	
}
