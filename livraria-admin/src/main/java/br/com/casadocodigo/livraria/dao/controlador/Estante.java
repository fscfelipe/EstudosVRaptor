package br.com.casadocodigo.livraria.dao.controlador;

import java.util.List;

import br.com.casadocodigo.livraria.modelo.Livro;

public interface Estante {
	
	void guarda(Livro livro);
	List<Livro> todosOsLivros();
	Livro buscaPorIsbn(String isbn);
	void exclui(String isbn);

}
