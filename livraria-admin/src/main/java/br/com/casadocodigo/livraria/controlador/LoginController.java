package br.com.casadocodigo.livraria.controlador;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.casadocodigo.livraria.modelo.RegistroDeUsuarios;
import br.com.casadocodigo.livraria.modelo.Usuario;
import br.com.casadocodigo.livraria.modelo.UsuarioLogado;

@Resource
public class LoginController {

	private RegistroDeUsuarios usuarios;
	private UsuarioLogado logado;
	private Result result;
	private Validator validator;

	public LoginController(RegistroDeUsuarios usuarios, UsuarioLogado logado, Result result, Validator validator) {
		this.usuarios = usuarios;
		this.logado = logado;
		this.result = result;
		this.validator = validator;
		this.usuarios.usuarioPadrao();

	}

	@Get("/login")
	public void formulario() {
	}

	@Post("/login")
	public void login(String login, String senha) {
		Usuario usuario = usuarios.comLoginESenha(login, senha);
		if (usuario == null) {
			validator.add(new I18nMessage("usuario", "login.ou.senha.invalidos"));
		}
		validator.onErrorRedirectTo(this).formulario();
		logado.loga(usuario);
		// ou a página inicial
		result.redirectTo(LivrosController.class).lista();
	}

	@Get("/logout")
	public void logout() {
		logado.desloga();
		result.redirectTo(this).formulario();
	}
}
