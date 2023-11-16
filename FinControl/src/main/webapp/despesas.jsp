<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Despesas</title>
<%@ include file="header.jsp" %>
</head>
<body>
    <%@ include file="menu.jsp" %>

    <div class="container">
    		<c:if test="${not empty msg }">
				<div class="alert alert-success">${msg}</div>
			</c:if>
			
			<c:if test="${not empty erro }">
				<div class="alert alert-danger">${erro}</div>
			</c:if>
			
        <form action="DespesasServlet" method="post" class="mt-5">
        <input type="hidden" name="acao" value="cadastrar"/>
		  <div class="mb-3">
		    <label for="id-nome" class="form-label">Nome:</label>
		    <input type="text" class="form-control" id="id-nome" name="nome">
		  </div>
		  <div class="mb-3">
		    <label for="id-valor" class="form-label">Valor:</label>
		    <input type="number" class="form-control" id="id-valor" name="valor">
		  </div>
		  <div class="mb-3">
		    <label for="id-data" class="form-label">Data de Pagamento:</label>
		    <input type="text" class="form-control" id="id-data" name="data">
		  </div>
			<input type="hidden" name="codigoUsuario" value="<c:out value="${codigoUsuario}"/>" />
		  
		  <input class="btn btn-success" type="submit" value="Cadastrar nova Receita">
		</form>
		
		<table class="table table-striped mt-5">
			<tr>
				<th>Nome</th>
				<th>Valor</th>
				<th>Data</th>
				<th></th>
			</tr>
			<c:forEach items="${despesas}" var="d">
				<tr>
					<td>${d.nome}</td>
					<td>${d.valor}</td>
					<td>
						<fmt:formatDate value="${d.dtPagamento.time}" pattern="dd/MM/yyyy"/>
					</td>
					<td>
						<c:url value="DespesasServlet" var="link">
							<c:param name="acao" value="abrir-form-edicao"/>
							<c:param name="codigo" value="${d.codigo}"/>
						</c:url>
						<a href="${link}">Editar</a>
						
						<button type="button" class="btn btn-danger btn-xs" data-toggle="modal" data-target="#excluirModal" 
						onclick="codigoExcluir.value = ${d.codigo}; codigoUsuario.value = ${d.cdUsuario}">Excluir</button>
					</td>
				</tr>
			</c:forEach>
		</table>
    </div>

    <%@ include file="footer.jsp" %>
    
<div class="modal fade" id="excluirModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Confirmação</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">$times;</span>
				</button>
			</div> 
			<div class="modal-body">
				Deseja realmente excluir a receita?
			</div>
			<div class="modal-footer">
				<form action="DespesasServlet" method="post">
					<input type="hidden" name="acao" value="excluir"/>
					<input type="hidden" name="codigo" id="codigoExcluir"/>
					<input type="hidden" name="codigoUsuario" id="codigoUsuario"/>
					<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
					<button type="submit" class="btn btn-danger">Excluir</button>
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>