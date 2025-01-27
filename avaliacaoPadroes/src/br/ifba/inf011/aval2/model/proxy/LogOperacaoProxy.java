package br.ifba.inf011.aval2.model.proxy;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.ifba.inf011.aval2.model.Arquivo;
import br.ifba.inf011.aval2.model.Credencial;
import br.ifba.inf011.aval2.model.Entrada;
import br.ifba.inf011.aval2.model.EntradaOperavel;
import br.ifba.inf011.aval2.model.state.ArquivoStateInterface;

public class LogOperacaoProxy implements EntradaOperavel{

	private Arquivo arquivo;
	private Map<Credencial, Integer> log;
	
	public LogOperacaoProxy(Arquivo arquivo) {
		this.arquivo = arquivo;
		this.log = new HashMap<Credencial, Integer>();
	}
	
	@Override
	public String getNome() {
		return this.arquivo.getNome();
	}

	@Override
	public LocalDate getDataCriacao() {
		return this.arquivo.getDataCriacao();
	}

	@Override
	public Long getTamanho() throws IllegalAccessException{
		return this.arquivo.getTamanho();
	}

	@Override
	public List<Entrada> getFilhos() throws UnsupportedOperationException {
		return this.arquivo.getFilhos();
	}

	@Override
	public void addFilho(Entrada entrada) throws UnsupportedOperationException {
		this.arquivo.addFilho(entrada);
	}

	@Override
	public void removeFilho(Entrada entrada) throws UnsupportedOperationException {
		this.arquivo.removeFilho(entrada);
	}

	@Override
	public String ler(Credencial credencial) throws IllegalAccessException {
		String conteudo = this.arquivo.ler(credencial); 
		Integer acessado = (this.log.get(credencial) == null) ? 0 : this.log.get(credencial);
		acessado++;
		this.log.put(credencial, acessado);
		return conteudo;
	}
	
	
	public String doLog() {
		StringBuffer str = new StringBuffer("LOG DE ACESSO ARQUIVO " + this.arquivo.getNome() + "\n");
		for(Credencial c : this.log.keySet())
			str.append(c.getId() + ": " + this.log.get(c).longValue() + " acessos\n");
		return str.toString();
	}

	@Override
	public void escrever(Credencial credencial, String escrever) throws IllegalAccessException {
		this.arquivo.escrever(credencial, escrever);
		Integer acessado = (this.log.get(credencial) == null) ? 0 : this.log.get(credencial);
		acessado++;
		this.log.put(credencial, acessado);
	}

	@Override
	public String dump(){
		return this.arquivo.dump();
	}

	
	@Override
	public void liberar() throws IllegalAccessException{
		this.arquivo.liberar();
	}

	@Override
	public void restaurar() throws IllegalAccessException{
		this.arquivo.restaurar();
	}

	@Override
	public void bloquear() throws IllegalAccessException{
		this.arquivo.bloquear();
		
	}

	@Override
	public void somenteLeitura() throws IllegalAccessException{
		this.arquivo.somenteLeitura();
	}

	@Override
	public void excluir() throws IllegalAccessException{
		this.arquivo.excluir();
	}
	
	@Override
	public String desc() {
		return this.desc();
	}

	
	@Override
	public ArquivoStateInterface getState() {
		return this.arquivo.getState();
	}

	@Override
	public void setState(ArquivoStateInterface state) {
		this.arquivo.setState(state);
	}

}
