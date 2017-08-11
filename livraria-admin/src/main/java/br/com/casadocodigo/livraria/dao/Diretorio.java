package br.com.casadocodigo.livraria.dao;

import java.net.URI;

import br.com.casadocodigo.livraria.modelo.Arquivo;

public interface Diretorio {
	
	void grava(Arquivo arquivo);
	Arquivo recupera(String isbnLivro);

}
