package edu.eci.pdsw.BancoDeIniciativas.generators;

import static org.quicktheories.generators.SourceDSL.integers;


import org.quicktheories.core.Gen;
import org.quicktheories.generators.Generate;

import edu.eci.pdsw.BancoDeIniciativas.entities.Tema;
import edu.eci.pdsw.BancoDeIniciativas.entities.TipoTema;

public class TemaGenerator {
	
	public static Gen<Tema> any() {
		return ids().zip(tiposTemas(), (id, nombre) -> new Tema(id, nombre));
	}
	
	public static Gen<Integer> ids() {
		return integers().allPositive();
	}
	
	public static Gen<TipoTema> tiposTemas() {
		return Generate.enumValues(TipoTema.class);
	}

}
