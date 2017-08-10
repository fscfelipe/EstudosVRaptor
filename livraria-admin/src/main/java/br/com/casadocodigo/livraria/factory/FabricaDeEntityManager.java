package br.com.casadocodigo.livraria.factory;

import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

/*Quando estamos em um ambiente de injeção de dependências, temos que indicar
como os componentes serão criados, para que o nosso container possa fazer isso
quando necessário. Entretanto, não é só o como que importa, precisamos saber
também quando os componentes serão criados e quando eles não serão mais ne-
cessários, ou seja, o momento de serem destruídos.*/

/*Durante um escopo, todas as classes que dependerem de um componente re-
ceberão a mesma instância deste componente. Como estamos num ambiente Web,
toda interação com o usuário, como cliques em links ou submissões de formulários,
se dá através de requisições. Logo um escopo natural é o de requisição: todo objeto
que precisar ser criado durante uma requisição será destruído ao final dela, ou seja,
após a resposta ser devolvida para o usuário. 

Sendo assim, toda classe gerenciada pelo VRaptor, como as anotadas com
@Resource ou @Component , é por padrão de escopo de requisição, [...] pg.50*/

/*Como alguns escopos são maiores que outros, temos uma restrição
importante: um componente não pode ser dependência de um outro de
escopo maior.*/


/*Existe outra particularidade quando estamos trabalhando com uma
ComponentFactory . O escopo é dado à fábrica e não ao objeto fabricado.
O método getInstance será chamado sempre, independente do escopo da
ComponentFactory . Na FabricaDeEntityManager movemos o código de
criação do EntityManager para o construtor justamente por esse motivo.*/


/*Instâncias dessa fábrica serão criadas a cada requisição, e cada instância vai
criar seu próprio EntityManager . Só que cada instância também cria uma
EntityManagerFactory , que é um objeto de criação cara, que deveria ser único
na aplicação inteira, ou seja, seu escopo deveria ser o de aplicação. Para aproveitar
a mesma factory em todos os requests da aplicação, precisamos gerenciá-la de
forma separada. Vamos começar recebendo a factory como dependência [...]*/


/*A regra de ouro para recursos que precisam ser fechados/liberados, como co-
nexões, é a seguinte: se uma classe abriu/adquiriu esse recurso, ela é a responsável
por fechá-lo/liberá-lo. Por esse motivo, se a FabricaDeEntityManager criou o
EntityManager , ela deveria fechá-lo. Vamos criar um método para isso.*/ 


@Component
public class FabricaDeEntityManager implements ComponentFactory<EntityManager> {

	//O EntityManager é criado fora do construtor para ser usado sempre
	//a mesma instância.
	private final EntityManager manager;

	public FabricaDeEntityManager(EntityManagerFactory factory) {
		this.manager = factory.createEntityManager();
	}

	@Override
	public EntityManager getInstance() {
		return this.manager;
	}
	
	/*O método está criado, mas quando ele deve ser chamado? Ele deve ser cha-
	mado quando acabarmos de usar o manager , ou seja, ao final do escopo da fábrica.
	Conseguimos fazer isso com o callback @PreDestroy . Um método de qualquer
	componente que estiver anotado com @PreDestroy será chamado logo antes do
	objeto ser destruído, muito útil para liberar os recursos abertos. Esse método precisa
	retornar void e não ter argumentos. No nosso caso, queremos chamar o método
	fechaManager ao final do escopo da fábrica, então vamos anotá-lo.*/
	
	@PreDestroy
	public void fechaManager() {
		this.manager.close();
	}

}
