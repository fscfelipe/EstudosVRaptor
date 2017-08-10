package br.com.casadocodigo.livraria.modelo;

import java.util.Arrays;
import java.util.List;

public class UmaEstanteQualquer implements Estante {

	/*Classe utilizado somente para visualizar o funcionamento da
	estante, e para mostrar uma lista de livros exemplo.*/
	
	@Override
	public void guarda(Livro livro) {

	}

	@Override
	public List<Livro> todosOsLivros() {
		Livro vraptor = new Livro();
		vraptor.setIsbn("123-45");
		vraptor.setTitulo("VRaptor 3");
		vraptor.setDescricao("Um livro sobre VRaptor");
		
		Livro arquitetura = new Livro();
		arquitetura.setIsbn("5678-90");
		arquitetura.setTitulo("Arquitetura de Software");
		arquitetura.setDescricao("Uma abordagem prática");
		
		return Arrays.asList(vraptor, arquitetura);
	}

	@Override
	public Livro buscaPorIsbn(String isbn) {
		return null;
	}

	@Override
	public void exclui(String isbn) {
		// TODO Auto-generated method stub
		
	}


}