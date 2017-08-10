package br.com.casadocodigo.livraria.site.servico;

import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.casadocodigo.livraria.dao.controlador.Acervo;
import br.com.casadocodigo.livraria.modelo.Livro;

@Component
public class AcervoNoAdmin implements Acervo {

	private ClienteHTTP http;

	public AcervoNoAdmin(ClienteHTTP http) {
		this.http = http;
	}

	@Override
	public List<Livro> todosOsLivros() {
		String url = "http://localhost:8080/livraria-admin" + "/integracao/listaLivros";
		String resposta = http.get(url);
		return null;
	}

}
