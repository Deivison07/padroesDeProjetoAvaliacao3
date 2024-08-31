package br.ifba.inf011.aval2.model.state;

import br.ifba.inf011.aval2.model.strategy.FormatoStrategyInterface;

public abstract class AbstractState implements ArquivoStateInterface {
	
	@Override
	public ArquivoStateInterface bloquear() throws IllegalAccessException {
		return this;
	}
	
	@Override
	public ArquivoStateInterface excluir() throws IllegalAccessException {
		return this;
	}
	
	@Override
	public ArquivoStateInterface liberar() throws IllegalAccessException {
		return this;
	}
	
	@Override
	public ArquivoStateInterface restaurar() throws IllegalAccessException {
		return this;
	}
	
	@Override
	public ArquivoStateInterface somenteLeitura() throws IllegalAccessException {
		return this;
	}
	
	@Override
	public String ler(FormatoStrategyInterface formato, String conteudo) throws IllegalAccessException {
		return formato.decodificar(conteudo);
	}
	
	@Override
	public String escrever(FormatoStrategyInterface formato, String escrever) throws IllegalAccessException {
		throw new IllegalAccessException();
	}
	
	@Override
	public Long getTamanho(String conteudo) throws IllegalAccessException {
		return Long.valueOf(conteudo.length());
	}
	
}
