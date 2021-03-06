package br.com.casadocodigo.livraria.modelo;

import java.math.BigDecimal;
import java.net.URI;
import java.util.Calendar;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.casadocodigo.livraria.utils.Moeda;

/*No nosso sistema, acessaremos o banco de dados com a ajuda da JPA, a espe-
cificação do Java para persistência de objetos. Esses objetos persistidos no banco
recebem o nome de entidade, então, para indicar que um Livro tem esse papel,
anotamos a classe com @Entity*/

/*Como o Livro é uma entidade, a JPA disponibiliza o gerenciador de en-
tidades para realizar as operações de persistência. Esse gerenciador se chama
EntityManager , e será necessário para que o LivroDAO , baseado na JPA, realize
o seu trabalho. Ou seja, uma dependência que também será recebida no construtor.*/

public class Livro {
	
	//Retire o uso do 'Dinheiro'

	private Long id;
	//private BigDecimal preco;
	private Dinheiro preco;
	
	public Dinheiro getPreco() {
		return this.preco;
	}

	@NotNull @DecimalMin("0.0")
	public void setPreco(Dinheiro preco) {
		this.preco = preco;
	}

	@NotEmpty(message = "Título deve ser preenchido!")
	private String isbn;

	// Essa chave precisa estar no ValidationMessages.properties
	@NotNull(message = "{campo.obrigatorio}")
	private String titulo;
	private String descricao;

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

	@Past
	public Calendar getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Calendar dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

}
