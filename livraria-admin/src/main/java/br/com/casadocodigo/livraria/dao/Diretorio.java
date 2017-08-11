package br.com.casadocodigo.livraria.dao;

import java.net.URI;

import br.com.casadocodigo.livraria.modelo.Arquivo;

public interface Diretorio {
	
	URI grava(Arquivo arquivo);
	Arquivo recupera(URI chave);

}
