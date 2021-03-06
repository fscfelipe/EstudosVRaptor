package br.com.casadocodigo.livraria.modelo;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.validation.constraints.Past;

public class Livro {
	
private Long id;
	
	
	private String isbn;
	private String titulo;
	private String descricao;
	private Dinheiro preco;
	private Calendar dataPublicacao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Dinheiro getPreco() {
		return preco;
	}
	public void setPreco(Dinheiro preco) {
		this.preco = preco;
	}
	
	@Past
	public Calendar getDataPublicacao() {
		return dataPublicacao;
	}
	public void setDataPublicacao(Calendar dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

}
