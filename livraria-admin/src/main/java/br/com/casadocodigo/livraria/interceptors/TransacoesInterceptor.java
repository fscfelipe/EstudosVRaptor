package br.com.casadocodigo.livraria.interceptors;

import javax.servlet.http.HttpServletRequest;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.resource.ResourceMethod;

@Intercepts
@RequestScoped
public class TransacoesInterceptor implements Interceptor {
	
	//O exemplo a seguir é somente para teste e ilustração.
	//Ele faz um log dos métodos que forem chamados pela requisição
	
	private final HttpServletRequest request;

	public TransacoesInterceptor(HttpServletRequest request) {
		this.request = request;
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
		
		System.out.println("Interceptando " + request.getRequestURI());
        // código a ser executado antes da lógica

        stack.next(method, controller); // continua a execução

        // código a ser executádo depois da lógica

	}

}
