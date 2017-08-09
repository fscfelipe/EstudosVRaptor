package br.com.casadocodigo.livraria.modelo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.caelum.vraptor.ioc.Component;

/*Esta classe é uma dependência do LivrosController, por ela iremos
utilizar um EntityManager*/

/*O livro diz que precisamos de uma *implementação de um EntityManager
caso contrário, a aplicação iria dar erro, mas nesse caso
funcionou corretamente.

pag.48[...] Precisamos agora de uma implementação de EntityManager , para que o
VRaptor consiga injetar essa dependência. Mas essa implementação será feita pela
nossa aplicação? Não! Usaremos o Hibernate como implementação da JPA, dessa
forma, o VRaptor teria que instanciar uma classe do Hibernate. Podemos colocar
@Component numa classe do Hibernate?

*/

@Component
public class JPALivroDAO implements LivroDAO {

	private final EntityManager manager;
	
	/*O VRaptor injeta dependências via construtor, a maneira escolhida por exigir o mí-
	nimo de configuração: não é possível criar o objeto sem passar todos os argumentos
	do construtor, logo tudo que está no construtor já é uma dependência da classe. Mas
	existem outras maneiras de fazer injeção de dependências que são usadas por outras
	bibliotecas[...] pg.56*/
	
	/*O VRaptor não suporta oficialmente esses outros tipos de injeção, mas como ele
	usa outra biblioteca (Spring, Guice ou Pico Container) para implementar a injeção
	de dependências, você pode usar a forma da biblioteca escolhida para usar outros
	tipos de injeção. A anotação @javax.inject.Inject funciona em todas essas
	bibliotecas, pois faz parte da especificação do java para injeção de dependências —
	basta colocá-la no setter, atributo ou método de inicialização desejado.*/

	public JPALivroDAO(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public void adiciona(Livro livro) {
		this.manager.getTransaction().begin();
		this.manager.persist(livro);
		this.manager.getTransaction().commit();
	}

	@Override
	public List<Livro> todos() {
		return this.manager.createQuery("select l from Livro l", Livro.class).getResultList();
	}

	@Override
	public Livro buscaPorIsbn(String isbn) {
		try {
			return this.manager.createQuery("select l from Livro l where l.isbn = :isbn", Livro.class)
					.setParameter("isbn", isbn).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
