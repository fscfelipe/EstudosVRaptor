<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de livros</title>
</head>

<body>

	<!-- Aqui verificamos se a variável mensagem existe, caso tenha sido um request repassado
	do método salva. -->

	<c:if test="${not empty mensagem}">
		<p class="mensagem">${mensagem}</p>
	</c:if>


	<h3>Lista de livros</h3>

	<ul>
		<c:forEach items="${livros}" var="livro">
			<li>
			
			${livro.titulo} - ${livro.descricao} - 
			<a href="${linkTo[LivrosController].edita[livro.isbn]}">Modificar</a> - 
			<a href="${linkTo[LivrosController].exclui[livro.isbn]}">Excluir</a> - 
			<a href="${linkTo[LivrosController].serialize[livro.isbn]}">Serializar</a>
			
			</li>
		</c:forEach>
	</ul>

</body>
</html>