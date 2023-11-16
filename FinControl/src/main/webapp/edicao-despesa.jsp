<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Atualizar Despesa</title>
<%@ include file="header.jsp" %>
</head>
<body>
<%@ include file="menu.jsp" %>

<div class="container">
	<h1>Edição de Despesa</h1>
	
	<form action="DespesasServlet" method="post">
		<input type="hidden" value="editar" name="acao"/>
		
		<input type="hidden" value="${despesa.codigo}" name="codigo"/>
		<div class="form-group">
			<label for="id-nome">Nome</label>
			<input type="text" name="nome" id="id-nome" class="form-control" value="${despesa.nome}" />
		</div>
		<div class="form-group">
			<label for="id-valor">Valor</label>
			<input type="number" name="valor" id="id-valor" class="form-control" value="${despesa.valor}" />
		</div>
		<div class="form-group">
			<label for="id-data">Data de Recebimento</label>
			<input type="text" name="data" id="id-data" class="form-control"  
			value='<fmt:formatDate value="${despesa.dtPagamento.time}" pattern="dd/MM/yyyy"/>'/>
		</div>
		<input type="hidden" value="${despesa.cdUsuario}" name="codigoUsuario"/>
		
		<input type="submit" value="Salvar" class="btn btn-success"/>
		<a class="text-danger" href="DespesasServlet?acao=listar&codigoUsuario=${despesa.cdUsuario}">Cancelar</a>
	</form>
</div>

<%@ include file="footer.jsp" %>
</body>
</html>