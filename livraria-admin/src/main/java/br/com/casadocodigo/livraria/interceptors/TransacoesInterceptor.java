package br.com.casadocodigo.livraria.interceptors;

import javax.servlet.http.HttpServletRequest;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Lazy;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.casadocodigo.livraria.anotacoes.Transacional;

@Intercepts
@RequestScoped
@Lazy
public class TransacoesInterceptor implements Interceptor {
	
	/*
	 * Sobre lazy, pag.128. [..] Para resolver esse problema, podemos usar a
	 * anotação @Lazy . Com ela, o VRap- tor guarda uma instância não funcional do
	 * interceptor só para invocar o método accepts . Assim, ele só instancia o
	 * interceptor caso o accepts retorne true .
	 */
	
	//O exemplo a seguir é somente para teste e ilustração.
	//Ele faz um log dos métodos que forem chamados pela requisição
	
	private final HttpServletRequest request;

	public TransacoesInterceptor(HttpServletRequest request) {
		this.request = request;
	}
	
	@Override
	public boolean accepts(ResourceMethod method) {
		
		/*
		 * Quando criamos o TransacoesInterceptor , implementamos o método accepts
		 * retornando true . Isso significa que ele vai interceptar todos os métodos de
		 * controller, ou seja, todas as requisições web. Mas nem sempre isso é o
		 * desejável. Embora essa solução seja suficiente para um sistema pouco
		 * acessado, para um sis- tema com muitos acessos, criar transações a cada
		 * requisição pode ser um problema e deixar o sistema mais lento do que deveria.
		 */
		
		//return true;
		
		//Nesse caso o interceptador irá executar somente com os métodos que estiverem com 
		//a anotação @Transacional
		return method.containsAnnotation(Transacional.class);
		
		//Podemos também usar a condição de não executar métodos
		//que utilizam uma anotação HTTP específica
		//return !method.containsAnnotation(Get.class);
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
        
        //Podemos usar interceptors para redirecionar a requisição
        //ver pag.129
        
        //Podemos determinar a ordem de execução dos interceptor
        //ver pag.130

	}

}
