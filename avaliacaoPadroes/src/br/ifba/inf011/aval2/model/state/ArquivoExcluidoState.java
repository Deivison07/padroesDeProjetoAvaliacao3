package br.ifba.inf011.aval2.model.state;

import br.ifba.inf011.aval2.model.strategy.FormatoStrategyInterface;

public class ArquivoExcluidoState extends AbstractState implements ArquivoStateInterface {

	@Override
	public String ler(FormatoStrategyInterface formato, String conteudo)
			throws IllegalAccessException {
		// TODO Auto-generated method stub
		throw new IllegalAccessException();
	}
	
	@Override
	public ArquivoStateInterface restaurar() {
		return new ArquivoNormalState();
	}
	
	@Override
	public Long getTamanho(String conteudo) throws IllegalAccessException {
		return (long) 0;
	}

	@Override
	public String desc() {
		return "EXCLUIDO";
	}
}
