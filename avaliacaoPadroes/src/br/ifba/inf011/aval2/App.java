package br.ifba.inf011.aval2;

import java.time.LocalDate;

import br.ifba.inf011.aval2.model.Arquivo;
import br.ifba.inf011.aval2.model.ArquivoHistorico;
import br.ifba.inf011.aval2.model.Codificacao;
import br.ifba.inf011.aval2.model.Credencial;
import br.ifba.inf011.aval2.model.Entrada;
import br.ifba.inf011.aval2.model.EntradaOperavel;
import br.ifba.inf011.aval2.model.Pasta;
import br.ifba.inf011.aval2.model.memento.ArquivoSistemaHistorico;

public class App {
	
	public void runQ2() throws IllegalAccessException{
		/* 
		 * crio a credencial, a pasta, o arquivoHistorico
		 * adiciono o arquivo historico dentro da pasta
		 * crio o arquivo que vai manter os checkpoints
		 * crio o arquivo comum
		 * imprimo o dump
		 * leio
		 * salvo
		 * escrevo
		 * leio
		 * salvo
		 * escrevo novamente
		 * leio
		 * restauro
		 * leio
		 * restauro novamente
		 * leio
		 * mudo o estado para excluido
		 * imprimo o tamanho da pasta
		 * escrevo no arquivo comum
		 * mudo para o estado de * somente leitura *
		 * leio
		 * bloqueio o arquivo
		 * libero o arquivo
		 * escrevo no arquivo
		 * excluo o arquivo
		 * tento bloquear resultando em erro.
		 * */
		
		//criando usuario
		Credencial user01 = new Credencial("user01");
		
		Entrada raiz = new Pasta("/", LocalDate.now());

		EntradaOperavel a1 = new Arquivo("Arquivo teste", LocalDate.now(), "ARQUIVO DE TESTE PARA A AVALIAÇÃO", Codificacao.TEXTO);
		
		//criando arquivo
		ArquivoHistorico s1 = new ArquivoHistorico("S1", LocalDate.now(), "DICIPLINA PADROES DE PROJETO", Codificacao.BINARIO);
		
		raiz.addFilho(s1);
		raiz.addFilho(a1);
		
		ArquivoSistemaHistorico historico = new ArquivoSistemaHistorico(s1);

		// Retornando o dump
		System.out.println(s1.dump());

		// Lendo o conteúdo
		System.out.println(s1.ler(user01));
		
		historico.save();
		s1.escrever(user01, "ARQUIVO SENDO MODIFICADO");
		System.out.println(s1.ler(user01));
		
		historico.save();
		s1.escrever(user01, "ARQUIVO SENDO MODIFICADO NOVAMENTE");
		
		System.out.println(s1.ler(user01));
		
		System.out.println("----------------- RESTAURANDO --------------------");
		historico.restore();
		
		System.out.println(s1.ler(user01));
		
		historico.restore();
		System.out.println(s1.ler(user01));
		
		s1.excluir();

		a1.escrever(user01, "NOVO TESTE");

		a1.somenteLeitura();
		System.out.println(a1.desc());

		System.out.println(a1.ler(user01));

		a1.bloquear();
		System.out.println(a1.desc());

		a1.liberar();
		System.out.println(a1.desc());


		a1.escrever(user01, "MAIS TESTES");

		//tanto ler, quanto escrever resultam em IllegalAccessException, só permite Restaurar
		a1.excluir();
		System.out.println(a1.desc());

		a1.bloquear();
		
		try {
			System.out.println("A1: " + a1.ler(user01));
		} catch (IllegalAccessException e) {
			System.out.println("NÃO FOI POSSIVEL LER DE A1");
		}
	
		System.out.println(raiz.getNome() + ": " + raiz.getTamanho() + "K");
	}
	
	
	public void runQ1() throws IllegalAccessException  {
		
		Credencial user01 = new Credencial("user01");
		// MODIFIQUEI O CONSTRUTOR DO ARQUIVO PARA QUE ELE PODESSE ADICIONAR O FORMATO INTERNO 
		EntradaOperavel a1 = new Arquivo("A1", LocalDate.now(), "01000011010010010100111001000011010011110010101100110010", Codificacao.BINARIO);
		EntradaOperavel b1 = new Arquivo("B1", LocalDate.now(), "UM ARQUIVO TAMANHO GRANDE", Codificacao.TEXTO);
		EntradaOperavel c1 = new Arquivo("C1", LocalDate.now(), "UM ARQUIVO TAMANHO MUITO MUITO GRANDE", Codificacao.TEXTO);
		
		Entrada a = new Pasta("A", LocalDate.now());
		Entrada b = new Pasta("B", LocalDate.now());
		Entrada c = new Pasta("C", LocalDate.now());
		Entrada raiz = new Pasta("/", LocalDate.now());
		
		raiz.addFilho(a);
		raiz.addFilho(b);
		
		a.addFilho(a1);
		
		b.addFilho(c);
		b.addFilho(b1);
		
		c.addFilho(c1);

		try {
			b1.escrever(user01, "CINCO");
		}catch(IllegalAccessException ex) {
			System.out.println("NÃO FOI POSSIVEL ESCREVER EM A1");
		}
			
		System.out.println(raiz.getNome() + ": " + raiz.getTamanho() + "K");

		try {
			b1.escrever(user01, "CINCO+2");
		}catch(IllegalAccessException ex) {
			System.out.println("NÃO FOI POSSIVEL ESCREVER EM A1");
		}
		
		try {
			System.out.println("B1: " + b1.ler(user01));
		} catch (IllegalAccessException e) {
			System.out.println("NÃO FOI POSSIVEL LER DE A1");
		}			
		
		System.out.println(raiz.getNome() + ": " + raiz.getTamanho() + "K");
	}
	
	public static void main(String[] args) throws IllegalAccessException {
		App app = new App();
		app.runQ2();
	}

}
