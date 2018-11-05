package edu.eci.pdsw.BancoDeIniciativas.generators;

import static org.quicktheories.generators.SourceDSL.integers;
import static org.quicktheories.generators.SourceDSL.strings;

import org.quicktheories.core.Gen;

import edu.eci.pdsw.BancoDeIniciativas.entities.Tema;

public class TemaGenerator {
	
	public Gen<Tema> any() {
		return ids().zip(nombres(), (id, nombre) -> new Tema(id, nombre));
	}
	
	public Gen<Integer> ids() {
		return integers().allPositive();
	}
	
	public Gen<String> nombres() {
		return strings().basicLatinAlphabet().ofLengthBetween(6, 12);
	}

}
