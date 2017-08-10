package br.com.casadocodigo.livraria.dao;

import java.util.List;

import br.com.casadocodigo.livraria.modelo.Livro;

public interface LivroDAO {
	
	void adiciona(Livro livro );
	void popular();
	void exclui(String isbn);
	List<Livro> todos();
	Livro buscaPorIsbn(String isbn);

}
