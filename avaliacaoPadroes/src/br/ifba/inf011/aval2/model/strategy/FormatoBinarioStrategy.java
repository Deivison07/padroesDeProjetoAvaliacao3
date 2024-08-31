package br.ifba.inf011.aval2.model.strategy;
import br.ifba.inf011.aval2.model.Conversor2Bin;
public class FormatoBinarioStrategy implements FormatoStrategyInterface {
	

	@Override
	public String codificar(String data) {
		String dados = new Conversor2Bin().toBinary(data);
		return  dados;
	}

	@Override
	public String decodificar(String data) {
		String dados = new Conversor2Bin().toASCII(data);
		return  dados;
	}

}



