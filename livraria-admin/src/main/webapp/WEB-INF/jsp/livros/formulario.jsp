<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formulário</title>
</head>
<body>

	<!-- Podemos seguir com a criação do formulário. Precisamos criar um objeto livro a
partir dele, e para isso conseguimos usar mais uma convenção do VRaptor no nome
dos inputs. Para isso, precisamos de um nome de variável para o livro criado, por
exemplo, livro . Cada input deve ter seu atributo name começando com o nome
dessa variável, e cada propriedade acessível delimitada por pontos. Para popular o 
título do livro, usamos livro.titulo , para o preço, livro.preco e assim por
diante: -->

	<!-- Assim podemos criar o método do controller que vai receber o post desse formulário, 
no caso o método salva(Livro livro). Se quisermos o livro populado, o parâmetro desse método deve se chamar
livro , que é o prefixo dos inputs do formulário -->


	<%-- Sobre a action: se você não quer lembrar qual é a URI de um dos méto-
dos do controller, você pode usar o linkTo , com o qual você passa o con-
troller e o método e ele retorna a URI correspondente, já com o context-path.
Passamos o nome do controller entre colchetes e o nome do método após:
${linkTo[NomeDoController].nomeDoMetodo} --%>

<!-- Após executar o método salva , o VRaptor automaticamente
redireciona para a página WEB-INF/jsp/livros/salva.jsp , na qual podemos
indicar que o livro foi salvo. -->

	<form action="${linkTo[LivrosController].salva}" method="post">
		<input type="hidden" name="livro.id" value="${livro.id}" />

		<h2>Formulário de cadastro de livros</h2>
		<ul>
			<li>Titulo: <br /> <input type="text" name="livro.titulo"
				value="${livro.titulo}" /></li>
			<li>Descricao: <br /> <textarea name="livro.descricao"
					value="${livro.descricao}"></textarea></li>
			<li>ISBN: <br /> <input type="text" name="livro.isbn"
				value="${livro.isbn}" /></li>
			<li>Preco: <br /> <input type="text" name="livro.preco"
				value="${livro.preco}" /></li>
			<li>Data de publicacao: <br /> <input type="text"
				name="livro.dataPublicacao" value="${livro.dataPublicacao}" /></li>
		</ul>
		<input type="submit" value="Salvar" />
	</form>

</body>
</html>