package br.com.casadocodigo.livraria.interceptors;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;

@Intercepts
public class TransacoesInterceptor implements Interceptor {

	public TransacoesInterceptor() {
		
	}
	
	@Override
	public boolean accepts(ResourceMethod method) {
		return true;
	}

	@Override
	public void intercept(
			InterceptorStack stack, 
			ResourceMethod method, 
			Object controller) throws InterceptionException {
		
		// O livro utiliza JPA para inplementar a interceptação da transação
		// ver pag. 124

	}

}
