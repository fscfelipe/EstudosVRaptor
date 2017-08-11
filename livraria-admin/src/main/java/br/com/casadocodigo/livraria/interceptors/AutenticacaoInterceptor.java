package br.com.casadocodigo.livraria.interceptors;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.casadocodigo.livraria.controlador.LoginController;
import br.com.casadocodigo.livraria.modelo.UsuarioLogado;

@Intercepts
public class AutenticacaoInterceptor implements Interceptor {
	
	// Ver pag.134
	
	private UsuarioLogado usuario;
	private Result result;
	
	public AutenticacaoInterceptor(UsuarioLogado usuario, Result result) {
		this.usuario = usuario;
		this.result = result;
	}

	@Override
	public boolean accepts(ResourceMethod method) {
	
		return !method.getResource().getType().equals(LoginController.class);
	}

	@Override
	public void intercept(
			InterceptorStack stack, 
			ResourceMethod method, 
			Object controller) throws InterceptionException {
		
		if(usuario.isLogado()) {
			stack.next(method, controller);
		}else {
			result.redirectTo(LoginController.class).formulario();
		}
		

	}

}
