package br.com.casadocodigo.livraria.modelo;

import java.util.Calendar;

public class Arquivo {

	private String nome;
	private byte[] conteudo;
	private String contentType;
	private Calendar dataModificacao;

	public Arquivo(String nome, byte[] conteudo, String contentType, Calendar dataModificacao) {
		this.nome = nome;
		this.conteudo = conteudo;
		this.contentType = contentType;
		this.dataModificacao = dataModificacao;
	}

}
