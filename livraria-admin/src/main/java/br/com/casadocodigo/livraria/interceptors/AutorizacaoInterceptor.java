package br.com.casadocodigo.livraria.interceptors;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.caelum.vraptor.view.Results;
import br.com.casadocodigo.livraria.controlador.LoginController;
import br.com.casadocodigo.livraria.modelo.UsuarioLogado;

@Intercepts(after = AutenticacaoInterceptor.class)
public class AutorizacaoInterceptor implements Interceptor {

	// Serve para verificar se o usuário tem a permissão
	// ver pag.135

	private UsuarioLogado usuario;
	private Result result;

	public AutorizacaoInterceptor(UsuarioLogado usuario, Result result) {
		this.usuario = usuario;
		this.result = result;
	}

	@Override
	public boolean accepts(ResourceMethod method) {
		return !method.getResource().getType().equals(LoginController.class);
	}

	@Override
	public void intercept(InterceptorStack stack, ResourceMethod method, Object controller)
			throws InterceptionException {

		if (podeAcessar(method)) {
			stack.next(method, controller);
		} else {
			result.use(Results.http()).sendError(401, "Você não está autorizado!");
		}

	}

	private boolean podeAcessar(ResourceMethod method) {
		return method.containsAnnotation(Get.class) || usuario.getUsuario().isAdmin();
	}

}
