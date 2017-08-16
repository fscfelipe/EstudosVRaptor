package br.com.casadocodigo.livraria.controlador;

import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.casadocodigo.livraria.anotacoes.Integracao;
import br.com.casadocodigo.livraria.dao.controlador.Estante;
import br.com.casadocodigo.livraria.modelo.Livro;
import br.com.casadocodigo.livraria.modelo.Usuario;
import br.com.casadocodigo.livraria.modelo.UsuarioLogado;

@Resource
public class IntegracaoController {

	private Estante estante;
	private Result result;
	private UsuarioLogado usuario;
	private Usuario u = new Usuario(); 

	public IntegracaoController(UsuarioLogado usuario, Estante estante, Result result) {
		this.estante = estante;
		this.result = result;
		this.usuario = usuario;
		this.usuario.loga(u);
	}

	@Get
	@Integracao
	public void listaLivros() {
		
		List<Livro> livros = estante.todosOsLivros();
		result.use(Results.xml()).from(livros, "livros").serialize();
	}
}
