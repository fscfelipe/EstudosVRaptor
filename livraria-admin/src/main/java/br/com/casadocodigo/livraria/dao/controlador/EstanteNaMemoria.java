package br.com.casadocodigo.livraria.dao.controlador;

import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.com.casadocodigo.livraria.dao.LivroDAO;
import br.com.casadocodigo.livraria.modelo.Livro;

/*Foi necessário definir como escopo de sessão, pois cada requisição para o ../lista
era instanciado um objeto dessa classe, zerando a lista de livros.*/

@SessionScoped
@Component
public class EstanteNaMemoria implements Estante {

	private final LivroDAO dao;

	public EstanteNaMemoria(LivroDAO dao) {
		this.dao = dao;
		this.dao.popular();
	}

	@Override
	public void guarda(Livro livro) {
		this.dao.adiciona(livro);

	}

	@Override
	public List<Livro> todosOsLivros() {
		return this.dao.todos();
	}

	@Override
	public Livro buscaPorIsbn(String isbn) {
		// TODO Auto-generated method stub
		return dao.buscaPorIsbn(isbn);
	}

	@Override
	public void exclui(String isbn) {
		this.dao.exclui(isbn);
		
	}
}