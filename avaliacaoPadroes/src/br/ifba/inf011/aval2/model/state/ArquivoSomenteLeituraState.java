package br.ifba.inf011.aval2.model.state;

public class ArquivoSomenteLeituraState extends AbstractState implements ArquivoStateInterface {

	
	@Override
	public ArquivoStateInterface liberar() {
		return new ArquivoNormalState();
	}

	@Override
	public ArquivoStateInterface bloquear() {		
		return new ArquivoBloqueadoState();
	}
	
	// eu posso bloquear um arquivo que está somente leitura?
	@Override
	public ArquivoStateInterface excluir() {
		return new ArquivoExcluidoState();
	}
	
	@Override
	public String desc() {
		// TODO Auto-generated method stub
		return "SOMENTE LEITURA";
	}

}
