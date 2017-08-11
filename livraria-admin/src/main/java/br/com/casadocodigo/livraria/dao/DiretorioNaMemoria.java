package br.com.casadocodigo.livraria.dao;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.casadocodigo.livraria.modelo.Arquivo;
import br.com.casadocodigo.livraria.modelo.Livro;

@ApplicationScoped
@Component
public class DiretorioNaMemoria implements Diretorio {

	List<Arquivo> lista = new ArrayList<Arquivo>();
	
	@Override
	public void grava(Arquivo arquivo) {
		lista.add(arquivo);
	}

	@Override
	public Arquivo recupera(String isbnLivro) {
		// TODO Auto-generated method stub
		return null;
	}

}
