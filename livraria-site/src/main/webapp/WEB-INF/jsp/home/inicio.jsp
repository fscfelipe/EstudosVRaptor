<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Acervo</title>
</head>
<body>

	<h3>Veja as últimas ofertas para você:</h3>
	<ul class="livros">
		<c:forEach items="${livros}" var="livro">
			<li class="livro">${livro.titulo}- R$ ${livro.preco}</li>
		</c:forEach>
	</ul>

</body>
</html>