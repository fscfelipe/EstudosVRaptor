<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<ul class="errors">
			<c:forEach items="${errors}" var="error">
				<li>
					<!-- o campo em que ocorreu o erro, ou o tipo do erro -->
					${error.category}: <!-- a mensagem de erro de validação -->
					${error.message}
				</li>
			</c:forEach>
	</ul>
	
	<form action="${ linkTo[LoginController].login }" method="post">
	<h2>Formulário de login</h2>
	
		<ul>
			<li>
				Login: <input type="text" name="login">
			</li>
			<li>
				Senha: <input type="text" name="senha">
			</li>
		
		</ul>
			<input type="submit" value="Login"/>
	</form>
		
</body>
</html>