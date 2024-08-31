package br.ifba.inf011.aval2.model;

import java.time.LocalDate;

import br.ifba.inf011.aval2.model.memento.SistemaOperacional;
import br.ifba.inf011.aval2.model.state.ArquivoStateInterface;

public class ArquivoHistorico extends Arquivo implements SistemaOperacional{


	public ArquivoHistorico(String nome, LocalDate dataCriacao, String conteudo, Codificacao tipo) {
		super(nome, dataCriacao, conteudo, tipo);
	}
	
	public class Memento{
		
		String conteudo;
		ArquivoStateInterface state;	
		private Memento(String conteudo, ArquivoStateInterface state) {
			this.conteudo = conteudo;
			this.state = state;
		}

		private String getConteudo() {
			return conteudo;
		}

		private ArquivoStateInterface getState() {
			return state;
		}

	}
	
	@Override
	public ArquivoHistorico.Memento save() {
		
		return new ArquivoHistorico.Memento(
										this.dump(), 
										this.getState()
										);
	}
	
	@Override
	public void back(ArquivoHistorico.Memento memento){
		this.setState(memento.getState());
		this.setConteudo(memento.getConteudo());
	}


}
