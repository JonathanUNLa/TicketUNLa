<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="datos.Usuario"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% Usuario u = (Usuario) request.getAttribute("usuario"); %>

<% List<String> lista = (List) request.getAttribute("lista"); %>

bienvenido usuario: <%= u.getApellido() %>

<%if(lista.isEmpty()){ %>
					<h2>No hay nada en la lista</h2>
					<br><br><br>
					<%}else{%>
					<h2>Lista:</h2>
					<br>
					
					<% for (String l : lista) { %>
					<p>
					<%= l %>
					<br>
					</p>
					------------------------------------------------------------
					<%} %>
					<%} %>
					<br>
</body>
</html>