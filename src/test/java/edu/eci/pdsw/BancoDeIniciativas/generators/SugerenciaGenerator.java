package edu.eci.pdsw.BancoDeIniciativas.generators;

import static org.quicktheories.generators.SourceDSL.longs;
import static org.quicktheories.generators.SourceDSL.strings;
import static org.quicktheories.generators.SourceDSL.integers;

import static edu.eci.pdsw.BancoDeIniciativas.generators.Generators.usuarios;

import org.quicktheories.core.Gen;

import edu.eci.pdsw.BancoDeIniciativas.entities.Sugerencia;

public class SugerenciaGenerator {
	
	public Gen<Sugerencia> any() {
		return ids().zip(titulos(), mensajes(), fechas(), usuarios().any(), (id, titulo, mensaje, fecha_creacion, correo_usuario) -> new Sugerencia(id, titulo, mensaje, fecha_creacion, correo_usuario));
	}
	
	public Gen<Integer> ids() {
		return integers().allPositive();
	}
	
	public Gen<String> titulos() {
		return strings().basicLatinAlphabet().ofLengthBetween(10, 20);
	}
	
	public Gen<String> mensajes() {
		return strings().basicLatinAlphabet().ofLengthBetween(100, 200);
	}
	
	@SuppressWarnings("deprecation")
	public Gen<java.sql.Date> fechas() {
		return integers().between(1, 31).zip(integers().between(1, 12), integers().between(2016, 2018), (dia, mes, año) -> new java.sql.Date(año, mes, dia));
	}

}
