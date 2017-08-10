package br.com.casadocodigo.livraria.site.servico;

import java.util.List;

import com.thoughtworks.xstream.XStream;

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
		
		//Ver pg. 100 para explicação do funcionamento
		
		//sobre métodos http 
		/*
		 * A ideia é que, se usarmos cor- retamente as semânticas dos métodos, podemos
		 * aproveitar toda a infraestrutura da internet, como proxies, load balancers e
		 * outros intermediários entre o cliente e o servidor.
		 */
		
		String url = "http://localhost:8080/livraria-admin/integracao/listaLivros";
		String resposta = http.get(url);
		
		XStream xstream = new XStream();
		xstream.alias("livros", List.class);
		xstream.alias("livro", Livro.class);
		
		List<Livro> livros = (List<Livro>) xstream.fromXML(resposta);
		
		return livros;
	}

}
