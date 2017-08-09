package br.com.casadocodigo.livraria.modelo;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/*No nosso sistema, acessaremos o banco de dados com a ajuda da JPA, a espe-
cificação do Java para persistência de objetos. Esses objetos persistidos no banco
recebem o nome de entidade, então, para indicar que um Livro tem esse papel,
anotamos a classe com @Entity*/

/*Como o Livro é uma entidade, a JPA disponibiliza o gerenciador de en-
tidades para realizar as operações de persistência. Esse gerenciador se chama
EntityManager , e será necessário para que o LivroDAO , baseado na JPA, realize
o seu trabalho. Ou seja, uma dependência que também será recebida no construtor.*/

@Entity
public class Livro {
	
	@Id @GeneratedValue
	private Long id;
	
	@Column(unique=true)
	private String isbn;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	private String titulo;
	private String descricao;
	private BigDecimal preco;
	private Calendar dataPublicacao;
	
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
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public Calendar getDataPublicacao() {
		return dataPublicacao;
	}
	public void setDataPublicacao(Calendar dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

}
