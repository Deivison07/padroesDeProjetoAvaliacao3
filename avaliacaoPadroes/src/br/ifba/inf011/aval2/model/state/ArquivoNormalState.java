package br.ifba.inf011.aval2.model.state;

import br.ifba.inf011.aval2.model.strategy.FormatoStrategyInterface;

public class ArquivoNormalState extends AbstractState implements ArquivoStateInterface {

	@Override
	public ArquivoStateInterface bloquear() throws IllegalAccessException {
		return new ArquivoBloqueadoState();
	}
	
	@Override
	public ArquivoStateInterface excluir() throws IllegalAccessException {
		return new ArquivoExcluidoState();
	}
	
	@Override
	public ArquivoStateInterface somenteLeitura() throws IllegalAccessException {
		return new ArquivoSomenteLeituraState();
	}

	@Override
	public String escrever(FormatoStrategyInterface formato, String escrever) throws IllegalAccessException {
		return formato.codificar(escrever);
	}
	@Override
	public String desc() {
		// TODO Auto-generated method stub
		return "NORMAL";
	}
	
}
