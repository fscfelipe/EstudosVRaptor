package br.com.casadocodigo.livraria.interceptors;

import javax.servlet.http.HttpServletRequest;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Lazy;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.casadocodigo.livraria.anotacoes.Integracao;


@Intercepts(before=AutenticacaoInterceptor.class)
public class IntegracaoInterceptor implements Interceptor {

	private final HttpServletRequest request;

	public IntegracaoInterceptor(HttpServletRequest request) {
		this.request = request;
	}
	
	@Override
	public boolean accepts(ResourceMethod method) {
		
		return method.containsAnnotation(Integracao.class);
	}

	@Override
	public void intercept(InterceptorStack stack, ResourceMethod method, Object controller) throws InterceptionException {
		//System.out.println("Interceptando " + request.getRequestURI());
        stack.next(method, controller); // continua a execução
		
	}

}
