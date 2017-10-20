<%@ page import="java.lang.annotation.Target"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listando as contas</title>

<script type="text/javascript" src="resources/js/jquery.js"></script>

<script type="text/javascript">

	function deuCerto(id){
		$('#conta'+id).html("Paga");
		$('#acaoPago'+id).remove();
	}

	function pagaAgora(id){
		$.get("<c:url value='pagaConta'></c:url>?id="+id,deuCerto(id));
	}

</script>

</head>
<body>

	<table border="1">
		<tr>
			<th>Código</th>
			<th>Descrição</th>
			<th>Valor</th>
			<th>Tipo</th>
			<th>Paga?</th>
			<th>Data de Pagamento</th>
			<th colspan="3">Ação</th>
		</tr>
		<c:forEach items="${contas}" var="conta">
			<tr>
				<td>${conta.id }</td>
				<td>${conta.descricao }</td>
				<td>${conta.valor }</td>
				<td>${conta.tipo.descricao }</td>
				<td id="conta${conta.id}">${conta.paga eq false ? "Não paga" : "Paga" }</td>
				<td><fmt:formatDate value="${conta.dataPagamento.time}" pattern="dd/MM/yyyy"></fmt:formatDate></td>
				<td><a href="<c:url value="/removeConta?id=${conta.id}"></c:url>">Excluir</a>
				<td><a href="<c:url value="/mostraConta?id=${conta.id}"></c:url>">Editar Conta </a></td>
				<td>
					<c:if test="${!conta.paga }">
						<a id="acaoPago${conta.id}" href="#" onclick="pagaAgora(${conta.id})">Pagar Conta</a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
<br>
<a href="<c:url value="/form"></c:url>">Adicionar Conta</a>
<a href='<c:url value="/logout"></c:url>'>logout</a>
</body>
</html>