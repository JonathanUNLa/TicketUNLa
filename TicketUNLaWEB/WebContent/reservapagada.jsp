<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="datos.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="datos.Funcion"%>
<%@page import="datos.Evento"%>
<%@page import="datos.Reserva"%>
<%@page import="datos.TipoBeneficio"%>
<%@page import="funciones.Funciones"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
				Reserva r = (Reserva) request.getAttribute("r");
			%>
reserva pagada! <br>
total pagado: <%= r.getPrecioTotal() %>

</body>
</html>