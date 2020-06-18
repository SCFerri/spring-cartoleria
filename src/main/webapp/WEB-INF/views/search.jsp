<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trova</title>
</head>
<body>
<div align="center">
	<h2>Risultati</h2>
	<table border="1" cellpadding="5">
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>Quantita</th>
			<th>Categoria</th>
		</tr>
		<c:forEach items="${result}" var="prodotti">
		<tr>
			<td>${prodotti.id}</td>
			<td>${prodotti.name}</td>
			<td>${prodotti.quantity}</td>
			<td>${prodotti.category}</td>
		</tr>
		</c:forEach>
	</table>
</div>	
</body>
</html>