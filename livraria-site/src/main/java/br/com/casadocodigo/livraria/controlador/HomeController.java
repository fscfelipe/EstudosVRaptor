package br.com.casadocodigo.livraria.controlador;

import br.com.caelum.vraptor.Resource;

@Resource
public class HomeController {
	
	/*Precisamos mostrar na página dessa lógica uma lista de livros, que será con-
	sumida do serviço do livraria-admin. Devemos colocar o código que consome o
	serviço dentro do método inicio ? Precisaremos também de dados de livros na
	página que mostra o livro, na página do carrinho de compras, na página de finaliza-
	ção da compra e em várias outras, então não vale a pena repetir esse código por todo
	canto.
	Para evitar essa repetição, vamos criar um componente do sistema responsável
	por acessar os dados dos livros, como fizemos no livraria-admin, um repositório de
	livros. A diferença é que, agora, o acesso aos dados se dá pelo serviço disponibilizado
	pelo livraria-admin, e não pelo banco de dados. Podemos usar aqui, também, a
	Estante , nosso repositório de livros. Mas para não causar confusões, vamos usar
	outra abstração para um conjunto de livros: um Acervo, que nos dará acesso aos
	livros do sistema, que estão cadastrados no livraria-admin*/
	
	public void inicio() {
		
	}

}
