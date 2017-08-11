package br.com.casadocodigo.livraria.modelo;

import java.util.Calendar;

public class Arquivo {

	private String isbnLivro;
	private String nome;
	private byte[] conteudo;
	private String contentType;
	private Calendar dataModificacao;

	public Arquivo(String nome, byte[] conteudo, String contentType, Calendar dataModificacao, String isbnLivro) {
		this.nome = nome;
		this.conteudo = conteudo;
		this.contentType = contentType;
		this.dataModificacao = dataModificacao;
		this.isbnLivro = isbnLivro;
	}

	public String getIsbnLivro() {
		return isbnLivro;
	}

	public void setIsbnLivro(String isbnLivro) {
		this.isbnLivro = isbnLivro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public byte[] getConteudo() {
		return conteudo;
	}

	public void setConteudo(byte[] conteudo) {
		this.conteudo = conteudo;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Calendar getDataModificacao() {
		return dataModificacao;
	}

	public void setDataModificacao(Calendar dataModificacao) {
		this.dataModificacao = dataModificacao;
	}

}
