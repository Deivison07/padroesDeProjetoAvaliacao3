package br.ifba.inf011.aval2.model;

import br.ifba.inf011.aval2.model.strategy.FormatoBinarioStrategy;
import br.ifba.inf011.aval2.model.strategy.FormatoStrategyInterface;
import br.ifba.inf011.aval2.model.strategy.FormatoTextoStrategy;

public enum Codificacao {
	BINARIO {
		@Override
		public FormatoStrategyInterface getStrategy() {
			return new FormatoBinarioStrategy();
		}
	},
	TEXTO {
		@Override
		public FormatoStrategyInterface getStrategy() {
			return new FormatoTextoStrategy();
		}
	};

	public abstract FormatoStrategyInterface getStrategy();
}