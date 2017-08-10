package br.com.casadocodigo.livraria.site.servico;

import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.casadocodigo.livraria.dao.controlador.Acervo;
import br.com.casadocodigo.livraria.modelo.Livro;

@Component
public class AcervoNoAdmin implements Acervo {

	@Override
	public List<Livro> todosOsLivros() {
		// TODO Auto-generated method stub
		return null;
	}

}
