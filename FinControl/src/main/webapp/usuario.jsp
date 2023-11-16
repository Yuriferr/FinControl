<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Usuario</title>
<%@ include file="header.jsp" %>
</head>
<body>
<%@ include file="menu.jsp" %>

<div class="container mt-5">
	<h1 class="mx-auto" style="width: fit-content;"><c:out value=" ${usuario.nome}" /></h1>
	<p class="mx-auto" style="width: fit-content;">Cpf: <c:out value=" ${usuario.cpf}" /></p>
	<p class="mx-auto" style="width: fit-content;">Data de nascimento: <fmt:formatDate value="${usuario.dtNascimento.time}" pattern="dd/MM/yyyy"/></p>
	
	<div class="container-fluid mt-5">
	  <div class="row">
		 <div class="col">
	      <a class="bg-success p-4 rounded text-light" href="ReceitasServlet?acao=listar&codigoUsuario=${usuario.codigo}" class="btn">Receitas</a>
	    </div>
	    <div class="col">
	      <a class="bg-success p-4 rounded text-light" href="DespesasServlet?acao=listar&codigoUsuario=${usuario.codigo}" class="btn">Despesas</a>
	    </div>
	    <div class="col">
	     <a class="bg-success p-4 rounded text-light" href="MetasServlet?acao=listar&codigoUsuario=${usuario.codigo}" class="btn">Metas</a>
	    </div>
	    <div class="col">
	     <a class="bg-success p-4 rounded text-light" href="InvestimentosServlet?acao=listar&codigoUsuario=${usuario.codigo}" class="btn">Investimentos</a>
	    </div>
	  </div>
	</div>
</form>

</div>

<%@ include file="footer.jsp" %>
</body>
</html>