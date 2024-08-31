package br.ifba.inf011.aval2.model.state;

import br.ifba.inf011.aval2.model.strategy.FormatoStrategyInterface;

public class ArquivoBloqueadoState  extends AbstractState implements ArquivoStateInterface {

	
	@Override
	public ArquivoStateInterface liberar() {
		return new ArquivoNormalState();
	}
	
	@Override
	public String ler(FormatoStrategyInterface formato, String conteudo)
			throws IllegalAccessException {
		// TODO Auto-generated method stub
		throw new IllegalAccessException();
	}
	
	@Override
	public String desc() {
		// TODO Auto-generated method stub
		return "BLOQUEADO";
	}

}
