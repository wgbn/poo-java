<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Uso dos padrões de projeto - BEAN DAO DTO</title>
</head>
<body>
<h3>Pesquisa de um Nome no banco de dados BDAula.mdb na tabela tbPessoa</h3>
<form name="Formulario de pesquisa" action="resposta.jsp" method="GET">
  Nome para Busca: <input type="text" name="nome" value="" /> <br>
  <input type="submit" value="Pesquisar" name="btok" />
</form>
</body>
</html>
