<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<%@ include file="header.jsp" %>
</head>
<body>
<%@ include file="menuLogout.jsp" %>

<div class="container mt-5">
	<h1>Login Usuario</h1>

	<form action="UsuariosServlet" method="post">
		<input type="hidden" name="acao" value="logar"/>
	  <div class="mb-3">
	    <label for="id-email" class="form-label">Email:</label>
	    <input type="email" class="form-control" id="id-email" name="email">
	  </div>
	  <div class="mb-3">
	    <label for="id-senha" class="form-label">Senha:</label>
	    <input type="password" class="form-control" id="id-senha" name="senha">
	  </div>
	  <input class="btn btn-success" type="submit" value="Logar">
	</form>
</div>
	
	
<%@ include file="footer.jsp" %>
</body>
</html>