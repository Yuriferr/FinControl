<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro Usuario</title>
<%@ include file="header.jsp" %>
</head>
<body>
<%@ include file="menuLogout.jsp" %>

<div class="container mt-5">
	<h1>Cadastro de Usuario</h1>
	
	<c:if test="${not empty msg }">
		<div class="alert alert-success">${msg}</div>
	</c:if>
	
	<c:if test="${not empty erro }">
		<div class="alert alert-danger">${erro}</div>
	</c:if>
	
	
	<form action="UsuariosServlet" method="post">
		<input type="hidden" name="acao" value="cadastrar"/>
	  <div class="mb-3">
	    <label for="id-nome" class="form-label">Nome:</label>
	    <input type="text" class="form-control" id="id-nome" name="nome">
	  </div>
	  <div class="mb-3">
	    <label for="id-email" class="form-label">Email:</label>
	    <input type="email" class="form-control" id="id-email" name="email">
	  </div>
	  <div class="mb-3">
	    <label for="id-senha" class="form-label">Senha:</label>
	    <input type="password" class="form-control" id="id-senha" name="senha">
	  </div>
	  <div class="mb-3">
	    <label for="id-cpf" class="form-label">Cpf:</label>
	    <input type="number" class="form-control" id="id-cpf" name="cpf">
	  </div>
	  <div class="mb-3">
	    <label for="id-data" class="form-label">Data de nascimento:</label>
	    <input type="text" class="form-control" id="id-data" name="data">
	  </div>
	 <input type="submit" value="Cadastrar" class="btn btn-success">
	</form>
</div>

<%@ include file="footer.jsp" %>
</body>
</html>