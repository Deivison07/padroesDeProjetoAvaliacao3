package br.ifba.inf011.aval2.model.memento;

import br.ifba.inf011.aval2.model.ArquivoHistorico;
import br.ifba.inf011.aval2.model.EntradaOperavel;

public interface SistemaOperacional extends EntradaOperavel{
	
	public ArquivoHistorico.Memento save();
	public void back(ArquivoHistorico.Memento memento);
}
