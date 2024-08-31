package br.ifba.inf011.aval2.model;

import java.time.LocalDate;
import java.util.List;

import br.ifba.inf011.aval2.model.composite.AbstractEntrada;
import br.ifba.inf011.aval2.model.state.ArquivoNormalState;
import br.ifba.inf011.aval2.model.state.ArquivoStateInterface;
import br.ifba.inf011.aval2.model.strategy.FormatoStrategyInterface;

public class Arquivo extends AbstractEntrada implements EntradaOperavel{
	
	private String conteudo;
	private FormatoStrategyInterface formato;
	private ArquivoStateInterface state;
	
	public Arquivo(String nome, LocalDate dataCriacao, String conteudo, Codificacao tipo) {
		super(nome, dataCriacao);
		this.formato = tipo.getStrategy();
		this.state = new ArquivoNormalState();
		this.conteudo = tipo.getStrategy().codificar(conteudo);
	}
	
	@Override
	public List<Entrada> getFilhos() throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}

	@Override
	public void addFilho(Entrada entrada) throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}

	@Override
	public void removeFilho(Entrada entrada) throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}

	@Override
	public Long getTamanho() throws IllegalAccessException{
		return this.state.getTamanho(conteudo);
	}
	
	@Override
	public String ler(Credencial credencial) throws IllegalAccessException{
		return this.state.ler(this.formato, this.conteudo);
	}

	@Override
	public void escrever(Credencial credencial, String conteudo) throws IllegalAccessException {
		this.conteudo = this.state.escrever(this.formato, conteudo);
		
	}

	@Override
	public String dump(){
		return this.conteudo;
	};	

	public void setConteudo(String conteudo){
		this.conteudo = conteudo;
	}
	
	@Override
	public void liberar() throws IllegalAccessException {
		this.state = this.state.liberar();
	}

	@Override
	public void restaurar() throws IllegalAccessException {
		this.state = this.state.restaurar();
	}

	@Override
	public void bloquear() throws IllegalAccessException {
		this.state = this.state.bloquear();
	}

	@Override
	public void somenteLeitura() throws IllegalAccessException {
		this.state = this.state.somenteLeitura();
	}

	@Override
	public void excluir() throws IllegalAccessException {
		this.state = this.state.excluir();  
	}
	
	@Override
	public String desc() {
		return this.state.desc();
	}

	@Override
	public ArquivoStateInterface getState() {
		return this.state;
	}

	@Override
	public void setState(ArquivoStateInterface state) {
		this.state = state;
	}
	
}
