package br.com.casadocodigo.livraria.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.casadocodigo.livraria.modelo.Livro;

@ApplicationScoped
@Component
public class MemoriaLivroDAO implements LivroDAO {

	List<Livro> lista = new ArrayList<Livro>();

	public MemoriaLivroDAO() {
	}

	@Override
	public void adiciona(Livro livro) {

		Livro livroEncontrado = buscaPorIsbn(livro.getIsbn());

		if (lista.contains(livroEncontrado))
			lista.remove(livroEncontrado);

		this.lista.add(livro);

	}

	@Override
	public List<Livro> todos() {
		return this.lista;
	}

	@Override
	public Livro buscaPorIsbn(String isbn) {

		for (Livro el : lista) {
			if (el.getIsbn().equals(isbn)) {
				return el;
			}
		}

		return null;
	}

	public void exclui(String isbn) {
		Livro livro = buscaPorIsbn(isbn);
		lista.remove(livro);
	}

	public void popular() {

		Livro vraptor = new Livro();
		vraptor.setIsbn("123-45");
		vraptor.setTitulo("VRaptor 3");
		vraptor.setDescricao("Um livro sobre VRaptor");
		lista.add(vraptor);

		Livro arquitetura = new Livro();
		arquitetura.setIsbn("5678-90");
		arquitetura.setTitulo("Arquitetura de Software");
		arquitetura.setDescricao("Uma abordagem prática");
		lista.add(arquitetura);

		Livro ruby = new Livro();
		ruby.setIsbn("433-90");
		ruby.setTitulo("Ruby");
		ruby.setDescricao("uma linguagem show");
		lista.add(ruby);

		Livro javascript = new Livro();
		javascript.setIsbn("764-76");
		javascript.setTitulo("JavaScript");
		javascript.setDescricao("uma belezura");
		lista.add(javascript);

		Livro jquery = new Livro();
		jquery.setIsbn("234-91");
		jquery.setTitulo("JQuery");
		jquery.setDescricao("mais beleza ainda");
		lista.add(jquery);

	}

}