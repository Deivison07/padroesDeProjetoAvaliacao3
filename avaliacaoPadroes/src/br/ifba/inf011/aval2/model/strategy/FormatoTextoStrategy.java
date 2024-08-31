package br.ifba.inf011.aval2.model.strategy;

public class FormatoTextoStrategy implements FormatoStrategyInterface{
	
	@Override
	public String codificar(String data) {
		return data;
	}

	@Override
	public String decodificar(String data) {
		return data;
	}

}
