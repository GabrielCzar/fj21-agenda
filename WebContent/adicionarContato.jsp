<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="qualquernome" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Adicionar contato</title>
	
    <link href="jquery/jquery-ui.css" rel="stylesheet">
    <script src="jquery/external/jquery/jquery.js"></script>
    <script src="jquery/jquery-ui.js"></script>
  
</head>

<body>
	<c:import url="cabecalho.jsp" />
		
		<h1>Adicionar Contato</h1>
	    <hr />
	    
	    <form action="/adicionaContato" method="POST">
	      Nome: <input type="text" name="nome" /><br />
	      E-mail: <input type="text" name="email" /><br />
	      Endereço: <input type="text" name="endereco" /><br />
	      Data Nascimento: <qualquernome:campoData id="dataNascimento" /><br />
	      
	      <input type="submit" value="Gravar" />
	    </form>
			
	<c:import url="rodape.jsp" />
</body>
</html>