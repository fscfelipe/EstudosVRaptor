package br.com.casadocodigo.livraria.dao.controlador;

import java.util.Arrays;
import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.casadocodigo.livraria.dao.LivroDAO;
import br.com.casadocodigo.livraria.modelo.Livro;

/*Ao anotar a EstanteNoBancoDeDados com @Component ela passa a ser
gerenciada pelo VRaptor, que tentará procurar algum componente gerenciado que
seja um LivroDAO , ou seja, que implemente essa interface.*/


public class EstanteNoBancoDeDados implements Estante {
	
	private final LivroDAO dao;
	
	public EstanteNoBancoDeDados(LivroDAO dao) {
		this.dao = dao;
	}

	@Override
	public void guarda(Livro livro) {
		this.dao.adiciona(livro);

	}

	@Override
	public List<Livro> todosOsLivros() {
		/*Livro vraptor = new Livro();
		vraptor.setIsbn("123-45");
		vraptor.setTitulo("VRaptor 3");
		vraptor.setDescricao("Um livro sobre VRaptor");
		
		Livro arquitetura = new Livro();
		arquitetura.setIsbn("5678-90");
		arquitetura.setTitulo("Arquitetura de Software");
		arquitetura.setDescricao("Uma abordagem prática");
		
		return Arrays.asList(vraptor, arquitetura);*/
		return this.dao.todos();
	}

	@Override
	public Livro buscaPorIsbn(String isbn) {
		// TODO Auto-generated method stub
		return dao.buscaPorIsbn(isbn);
	}

	@Override
	public void exclui(String isbn) {
		// TODO Auto-generated method stub
		
	}

}
