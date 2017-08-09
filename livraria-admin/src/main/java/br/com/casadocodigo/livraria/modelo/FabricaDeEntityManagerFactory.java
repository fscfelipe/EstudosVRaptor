package br.com.casadocodigo.livraria.modelo;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

/*[...]Reforçando: mesmo que a fábrica seja
@ApplicationScoped , o método getInstance() será chamado sempre
que o VRaptor precisar de um EntityManagerFactory.*/

/*Algun links sobre o erro da EntityManager
 - http://www.guj.com.br/t/duplicidade-de-entitymanager-no-vraptor-resolvido/299017
 - http://www.guj.com.br/t/resolvido-vraptor-erro-na-criacao-dos-controller/298882/5
*/

/*[...] quando estamos trabalhando com bancos de dados só é
possível realizar modificações aos dados dentro de uma transação.*/

@Component
@ApplicationScoped
public class FabricaDeEntityManagerFactory implements ComponentFactory<EntityManagerFactory> {

	private final EntityManagerFactory factory;

	public FabricaDeEntityManagerFactory() {
		this.factory = Persistence.createEntityManagerFactory("default");
	}

	@Override
	public EntityManagerFactory getInstance() {
		return this.factory;
	}

}
