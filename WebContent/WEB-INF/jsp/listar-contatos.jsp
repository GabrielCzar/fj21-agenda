<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Contatos taglib</title>
	</head>

	<body>
		<!-- Importando cabecalho de outra pagina -->
		<c:import url="cabecalho.jsp" />

		<table border="1">
		  <!-- percorre contatos montando as linhas da tabela -->
		  <c:forEach var="contato" items="${contatos}" varStatus="id">
		  	 <tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff' }" >
			      <td>${id.count}</td>
			      
			      <td>${contato.nome}</td>
			      
			      <td>
					<!--<c:if test="${not empty contato.email}"></c:if>-->
					<c:choose>
					  <c:when test="${not empty contato.email}">
					    <a href="mailto:${contato.email}">${contato.email}</a>
					  </c:when>
					  <c:otherwise>
					    E-mail não informado
					  </c:otherwise>
					</c:choose>
				  </td>
			      
			      <td>${contato.endereco}</td>
			      
			      <td><fmt:formatDate value="${contato.dataNascimento.time}" 
			      			pattern="dd/MM/yyyy" />
				  </td>
				  <td>
				      <a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Remover</a>
				  </td>
		    </tr>
		  </c:forEach>
		</table>
		
		<a href="mvc?logica=AdicionarContatoLogic">Adicionar Contato</a>
		
		<!-- importando rodape de outra pagina -->
		<c:import url="rodape.jsp" />
	</body>
</html>