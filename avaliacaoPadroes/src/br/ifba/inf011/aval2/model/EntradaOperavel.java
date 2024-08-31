package br.ifba.inf011.aval2.model;

import br.ifba.inf011.aval2.model.state.ArquivoStateInterface;

public interface EntradaOperavel extends Entrada, Operavel {
	public ArquivoStateInterface getState();
	public void setState(ArquivoStateInterface state);

	public void liberar() throws IllegalAccessException ;
	public void restaurar() throws IllegalAccessException;
	public void bloquear() throws IllegalAccessException;
	public void somenteLeitura() throws IllegalAccessException;
	public void excluir() throws IllegalAccessException;
	public String desc();
	
}
