package edu.eci.pdsw.BancoDeIniciativas.generators;

import static org.quicktheories.generators.SourceDSL.strings;

import org.quicktheories.core.Gen;
import org.quicktheories.generators.Generate;

import edu.eci.pdsw.BancoDeIniciativas.entities.TipoUsuario;
import edu.eci.pdsw.BancoDeIniciativas.entities.Usuario;

public class UsuarioGenerator {

	public Gen<Usuario> any() {
		return nombres().zip(correos(), tipos(), (nombre, correo, tipo) -> new Usuario(nombre, correo, tipo));
	}

	public Gen<String> nombres() {
		return strings().basicLatinAlphabet().ofLengthBetween(7, 15);
	}

	public Gen<String> correos() {
		return strings().basicLatinAlphabet().ofLengthBetween(6, 10).zip(strings().basicLatinAlphabet().ofLength(7), (user, domain) -> (user+"@"+domain+".com"));
	}

	public Gen<TipoUsuario> tipos() {
		return Generate.enumValues(TipoUsuario.class);
	}

}