<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mostra Conta</title>
</head>
<body>

	<h3>Alterar Conta</h3>

	<form action="alteraConta" method="post">
		<label>ID</label> 
		<input value="${conta.id}" name="id" /> 
		<br /> <br />
		
		<label>Descrição:</label>
		<textarea rows="2" cols="50" name="descricao">${conta.descricao}</textarea>
		<br /><br /> 
		
		<label>Valor</label> 
		<input value="${conta.valor}" name="valor" /> 
		<br /><br /> 

		<label>Tipo</label> 
		<select name="tipo">
			<option value="ENTRADA" ${conta.tipo eq 'ENTRADA' ? 'selected' : '' }>Entrada</option>
			<option value="SAIDA" ${conta.tipo eq 'SAIDA' ? 'selected' : '' }>Saida</option>
		</select> 
		<br /><br />
		 
		<label>Pago?</label> 
		<input type="checkbox" name="paga" ${conta.paga ? 'checked' : ''}/>
		<br /> 
		
		<label>Data de Pagamento</label> 
		<input name="dataPagamento" value='<fmt:formatDate value="${conta.dataPagamento.time}" pattern="dd/MM/yyyy"/>' />
		<br />
		
		<br /> <input type="submit" value="Alterar" /> <a href="<c:url value="/lista" />">Voltar</a>
	</form>

</body>
</html>