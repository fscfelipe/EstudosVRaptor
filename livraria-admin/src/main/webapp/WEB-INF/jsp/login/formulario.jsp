<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="decorator" content="main" />
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
	
	<div class="container">
		<fieldset class="form-group">
			<legend>Login</legend>
			<hr>
			<form action="${ linkTo[LoginController].login }" method="post">	
				<div class="form-group row">
					<label for="login" class="col-2 col-form-label">Usuário:</label>
					<div class="col-10">
						<input class="form-control" type="text" name="login" id="login">
					</div>
				</div>
				
				<div class="form-group row">
					<label for="login" class="col-2 col-form-label">Senha:</label>
					<div class="col-10">
						<input class="form-control" type="text" name="senha" id="senha">
					</div>
				</div>
				
				<div class="form-group row justify-content-around">
					<div class="col-8">
						<input class="btn btn-primary" type="submit" value="Login" id="btnLogin"/>
					</div>
				</div>	
			</form>
		</fieldset>
	</div>
		
</body>
</html>