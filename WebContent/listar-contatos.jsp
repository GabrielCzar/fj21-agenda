<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Contatos taglib</title>
	</head>

	<body>

		<!-- cria o DAO -->
		<jsp:useBean id="dao" class="br.com.caelum.jdbc.dao.ContatoDao"/>

		<table border="1">
		  <!-- percorre contatos montando as linhas da tabela -->
		  <c:forEach var="contato" items="${dao.lista}" varStatus="id">
		  	 <tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff' }" >
		      <td>${id.count}</td><td>${contato.nome}</td>
		      <td>${contato.email}</td>
		      <td>${contato.endereco}</td>
		      <td>${contato.dataNascimento.time}</td>
		    </tr>
		  </c:forEach>
		</table>

	</body>
</html>