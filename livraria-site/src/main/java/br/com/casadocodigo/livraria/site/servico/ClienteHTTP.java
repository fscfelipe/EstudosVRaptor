package br.com.casadocodigo.livraria.site.servico;

import br.com.casadocodigo.livraria.site.excecoes.ServidorIndisponivelException;

public interface ClienteHTTP {
	
	String get(String url) throws ServidorIndisponivelException;

}
