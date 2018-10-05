<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="datos.Usuario"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

					<%
					Usuario u = (Usuario) request.getAttribute("usuario");
					%>
					vista cliente indice <br>
					
					Bienvenido <%=u.getNombre()%> <%=u.getApellido()%>
                <FORM method="POST" action="/TicketUNLaWEB/reservar1">
                <INPUT type="hidden" id="idusuario" name="idusuario" value="<%= u.getIdUsuario() %>" />
				<input class="button" type="submit" value="reservar">
				</FORM>
</body>
</html>