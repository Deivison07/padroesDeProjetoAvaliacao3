package br.ifba.inf011.aval2.model.state;

import br.ifba.inf011.aval2.model.strategy.FormatoStrategyInterface;

public interface ArquivoStateInterface {
	
	public ArquivoStateInterface somenteLeitura() throws IllegalAccessException;
	public ArquivoStateInterface liberar() throws IllegalAccessException;
	public ArquivoStateInterface bloquear()throws IllegalAccessException;
	public ArquivoStateInterface excluir()throws IllegalAccessException;
	public ArquivoStateInterface restaurar()throws IllegalAccessException;
	public String ler(FormatoStrategyInterface formato, String conteudo) throws IllegalAccessException;
	public String escrever(FormatoStrategyInterface formato, String escrever) throws IllegalAccessException;
	public Long getTamanho(String conteudo) throws IllegalAccessException;
	public String desc();
}
