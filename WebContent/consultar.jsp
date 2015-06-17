<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html ">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Consulta dos Dados</h2>
	<p/>
	<form method="post" action="Controle?cmd=consultar">
		<input type="submit" value="Consultar"/>
	</form>
	<form method="post" action="Controle?cmd=excluir">
	<table border="1">
		<tr>
			<th>Excluir</th>
			<th>IdProduto</th>
			<th>Nome Produto</th>
			<th>Preco</th>
			<th>Quantidade</th>
		</tr>
		<c:forEach items="${registro}" var="linha">
		<tr>
			<td><input type="checkbox" value="${linha.idProduto} " name="codigo"></td>
			<td>${linha.idProduto }</td>
			<td>${linha.nome }</td>
			<td>${linha.preco }</td>
			<td>${linha.quantidade}</td>
		</tr>
		</c:forEach>		
	</table>
	<input type="submit" value="Excluir" />
	</form>
	<p/>
	${produto}
	<p/>
	<a href="cadastrar.jsp">Novo Cadastro</a>
	${msg}
</body>
</html>