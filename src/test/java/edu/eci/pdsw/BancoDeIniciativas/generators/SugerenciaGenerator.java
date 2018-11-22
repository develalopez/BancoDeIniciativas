package edu.eci.pdsw.BancoDeIniciativas.generators;

import static org.quicktheories.generators.SourceDSL.*;

import java.util.List;
import java.util.ArrayList;

import org.quicktheories.core.Gen;

import edu.eci.pdsw.BancoDeIniciativas.entities.Sugerencia;
import edu.eci.pdsw.BancoDeIniciativas.entities.Usuario;

public class SugerenciaGenerator {

	public Gen<Sugerencia> any() {
		return ids().zip(titulos(), mensajes(), fechas(), usuarios(), (id, titulo, mensaje, fechaCreacion, usuario) -> {
			return (Sugerencia) palabrasClave().zip(likes(), (palabrasClave, likes) -> new Sugerencia(id,
					mensaje, palabrasClave, usuario, fechaCreacion, titulo, (ArrayList<Usuario>) likes));
		});
	}

	public static Gen<Integer> ids() {
		return integers().allPositive();
	}

	public static Gen<List<Usuario>> likes() {
		return lists().of(UsuarioGenerator.any()).ofSizeBetween(0, 20);
	}

	public static Gen<Usuario> usuarios() {
		return UsuarioGenerator.any();
	}

	public static Gen<String> titulos() {
		return strings().basicLatinAlphabet().ofLengthBetween(10, 20);
	}

	public static Gen<String> mensajes() {
		return strings().basicLatinAlphabet().ofLengthBetween(100, 200);
	}

	public static Gen<String> palabrasClave() {
		return strings().basicLatinAlphabet().ofLengthBetween(10, 20);
	}

	@SuppressWarnings("deprecation")
	public static Gen<java.sql.Date> fechas() {
		return integers().between(1, 31).zip(integers().between(1, 12), integers().between(2016, 2018),
				(dia, mes, año) -> new java.sql.Date(año, mes, dia));
	}

}
