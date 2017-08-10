package br.com.casadocodigo.livraria.modelo;

import java.util.List;

public interface LivroDAO {
	
	void adiciona(Livro livro );
	void popular();
	void exclui(String isbn);
	List<Livro> todos();
	Livro buscaPorIsbn(String isbn);

}
