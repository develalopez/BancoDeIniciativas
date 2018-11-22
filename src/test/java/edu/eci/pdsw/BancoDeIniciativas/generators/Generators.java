package edu.eci.pdsw.BancoDeIniciativas.generators;

public class Generators {
	
	public static UsuarioGenerator usuarios() {
		return new UsuarioGenerator();
	}
	
	public static SugerenciaGenerator sugerencias() {
		return new SugerenciaGenerator();
	}

}
