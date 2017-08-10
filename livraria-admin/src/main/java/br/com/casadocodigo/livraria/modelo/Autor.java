package br.com.casadocodigo.livraria.modelo;

import java.util.Calendar;
import java.util.List;

enum Pais { BRASIL, ESTADOS_UNIDOS, REINO_UNIDO }
public class Autor {
	
	private String nome;
	private Calendar dataNascimento;
	private Integer numeroDeLivros;
	private Pais nacionalidade;
	
	private List<Livro> livros;
	private Livro ultimoLivro;

}
