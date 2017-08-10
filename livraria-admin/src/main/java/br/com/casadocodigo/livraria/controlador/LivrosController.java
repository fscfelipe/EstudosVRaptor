package br.com.casadocodigo.livraria.controlador;

import java.math.BigDecimal;
import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.caelum.vraptor.view.Results;
import br.com.casadocodigo.livraria.dao.controlador.Estante;
import br.com.casadocodigo.livraria.modelo.Livro;

/* Para que o VRaptor passe a gerenciar essa classe como um controlador, preci-
samos anotá-la com @Resource . Isso significa que essa classe controla um dos
recursos da aplicação, no caso os livros. Chamamos de recursos os dados que a apli-
cação produz e/ou gerencia e, ao colocarmos o @Resouce em uma classe dizemos
ao VRaptor que essa classe será o ponto de acesso via Web de algum dos recursos do
sistema.*/

@Resource
public class LivrosController {

	private Estante estante;
	private Result result;
	private Validator validator;

	// Preferir receber interfaces como dependências
	// principalmente quando a implementação depende de uma biblioteca externa.
	// Prática: Inversão de controle - Técnica: Injeção de dependências

	/*
	 * Nessa técnica, evitamos que a classe controle a criação e o gerenciamento das
	 * suas dependências. Em vez disso, declaramos quais são os componentes
	 * necessários para o funcionamento de cada classe e confiamos que instâncias
	 * funcionais dos componentes serão injetados antes que a classe seja usada.
	 * Assim, a responsabilidade de criar e gerenciar os componentes do sistema vai
	 * sendo empurrada para camadas inferiores até que a centralizamos num
	 * componente especializado que coordenará a injeção das dependências nos
	 * lugares certos.
	 * 
	 * Esse componente especializado é chamado de container ou provedor (provi- der)
	 * de dependências. Dessa forma, cada componente declara quais são as suas de-
	 * pendências, se possível como interfaces para ficarmos livres para usar
	 * qualquer im- plementação, e registramos esse componente como uma
	 * implementação disponível para a injeção no container.
	 * 
	 * Ao tentar instanciar o componente, o container buscará cada dependência e, se
	 * necessário, criará uma nova instância dessa dependência, que também tem suas
	 * pró- prias dependências e esse processo segue até que todas as dependências
	 * sejam resol- vidas e, então, o componente requisitado estará criado e pronto
	 * para usar.
	 * 
	 * Ao recebermos uma Estante no construtor, estamos declarando que o
	 * LivrosController não pode ser criado sem antes receber uma Estante preen-
	 * chida e funcionando, ou seja, declaramos que Estante é uma dependência. Como
	 * o controller é uma classe gerenciada pelo VRaptor (por causa do @Resource ),
	 * o VRaptor tentará buscar uma implementação de Estante candidata a ser
	 * injetada. Como Estante é uma interface, precisamos indicar qual é a
	 * implementação dessa interface que desejamos usar no sistema. Fazemos isso
	 * escolhendo a classe que im- plementa Estante mais apropriada e anotando-a
	 * com @Component
	 * 
	 * 
	 */

	// Sobre o validator
	/*
	 * Poderíamos controlar tudo isso manualmente, somente usando o result para
	 * mudar o fluxo, mas como essa tarefa de validar se o objeto a ser salvo é bem
	 * comum, existe um componente do VRaptor especializado em executar essas
	 * validações: o Validator . Nele, podemos adicionar mensagens de erro de
	 * validação e, se houver erros, redirecionar a requisição de volta para o
	 * formulário, ou seja, exatamente o que a gente queria. Para ter acesso a esse
	 * componente, recebemo-lo no construtor. pag.69
	 */

	public LivrosController(Estante estante, Result result, Validator validator) {
		this.estante = estante;
		this.result = result;
		this.validator = validator;
	}

	/*
	 * Essa classe Result é o componente do VRaptor responsável pela personaliza-
	 * ção do resultado final da execução do método do controller. Além de receber
	 * no método, podemos recebê-lo no construtor da classe, principalmente se
	 * formos usar o Result na maioria dos métodos. Mais sobre redirecionamento
	 * pg.60 Diferenças entre o redirectTo e o forwardTo pag.61 Praticar o uso do
	 * método use do Result pag.64
	 */

	@Get("/livros/{isbn}")
	public void formulario() {
		// WEB-INF/jsp/livros/formulario.jsp
	}

	// public List<Livro> lista()
	@Get @Path("/livros") // ou @Get("/livros")
	public void lista() {
		// WEB-INF/jsp/livros/lista.jsp

		/*
		 * Vamos mostrar a lista de todos os livros, que iremos buscar de algum lugar
		 * nesse caso, de uma estante, e queremos deixar essa lista disponível para usar
		 * na jsp.
		 */

		this.result.include("livros", this.estante.todosOsLivros());

		/*
		 * Por padrão, o VRaptor deixa o retorno dos métodos do controller disponível na
		 * JSP, seguindo outra convenção. Se o retorno do método é um objeto do tipo
		 * Livro , ele será colocado numa variável chamada ${livro} , ou seja, nome da
		 * classe com a primeira letra em minúsculo. No caso do retorno ser uma
		 * List<Livro> , o nome da variável no JSP será ${livroList} , ou seja, o nome
		 * da classe dos elementos da lista com a primeira minúscula, seguido de List.
		 */

	}

	@Post("/livros")
	public void salva(Livro livro) {
		// WEB-INF/jsp/livros/salva.jsp

		// Infelizmente para a validação precisamos do if's
		// Pelo que parece o Validator é utilizado para repassar mensagens para
		// a view caso aconteçam erros.

		validator.validate(livro);

		validator.onErrorRedirectTo(this).formulario();

		estante.guarda(livro);

		/*
		 * Precisamos redirecionar o método para lista() pois precisamos da variável da
		 * estante para mostrar os livros novamente, e também iremos adicionar uma
		 * mensagem de notificação no redirecionamento.
		 */

		// o include é utilizado para adicionar multiploes objetos. pg.59

		result.include("mensagem", "Livro salvo com sucesso!");
		result.redirectTo(this).lista();
	}

	@Get
	@Path(value="/livros/{isbn}", priority=Path.LOWEST)
	public void edita(String isbn) {
		/*
		 * Este método recebe o Result com parâmetro será utilizado para redirecionar a
		 * página ao invés de utilizar edita.jsp, utilizaremos outra
		 */

		/*
		 * Recebe pelo link de 'Modificar' do formulário um parâmetro com o valor do
		 * ISBN do livro Este método irá utilizar a página de formulário.jsp para fazer
		 * a edição, uma vez que oe métodos salva e adiciona posuem funçẽso parecidas.
		 */

		// Apesar do nome da variável ser livroEncontrado
		// ele será passado para o jsp como 'livro'
		Livro livroEncontrado = estante.buscaPorIsbn(isbn);

		/*
		 * Traduzindo, queremos o resultado ( result ) desse controller ( of(this) ) no
		 * método formulário ( .formulario() ).
		 */

		if (livroEncontrado == null) {
			result.notFound();
		} else {
			result.include(livroEncontrado);
			result.of(this).formulario();
		}

	}
	
	// Após executar esse método, a pagina de lista será chamada
	@Get("/livros/exclui/{isbn}")
	public void exclui(String isbn) {
		this.estante.exclui(isbn);

		result.include("mensagem", "Livro excluido com sucesso!");
		result.redirectTo(this).lista();

	}

	@Get("/livros/serialize/{isbn}")
	public void serialize(String isbn) {
		Livro livroEncontrado = estante.buscaPorIsbn(isbn);

		result.use(Results.json()).from(livroEncontrado).serialize();

	}

}
