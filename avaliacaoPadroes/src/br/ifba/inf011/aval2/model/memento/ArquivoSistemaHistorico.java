package br.ifba.inf011.aval2.model.memento;

import java.util.Stack;

import br.ifba.inf011.aval2.model.ArquivoHistorico;

public class ArquivoSistemaHistorico {
	
	private ArquivoHistorico arquivo;
	private Stack<ArquivoHistorico.Memento> pilha = new Stack<ArquivoHistorico.Memento>();
	
	public ArquivoSistemaHistorico(ArquivoHistorico arquivo) {
		this.arquivo = arquivo;
	}
	
	public void save(){
		ArquivoHistorico.Memento print = this.arquivo.save();
		this.pilha.push(print);
	}
	
	public void restore() {
		if (this.pilha.isEmpty())
			return;
		ArquivoHistorico.Memento print = this.pilha.pop();
		this.arquivo.back(print);
	}
	
	

}
