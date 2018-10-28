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

<% List<Reserva> lr = (List) request.getAttribute("lr"); %>

			<p>Reservas del usuario: </p>
					<FORM method="POST" action="/TicketUNLaWEB/reservapagada">
					<%for (Reserva r: lr){ %>
							
					<input type="radio" name="idreserva" value="<%= r.getIdReserva() %>" checked> Precio: <%= r.getPrecioTotal()%> <br>
					<br>
					<% }%>
					
					<input class="button" type="submit" value="venta/pagado">
								
					</FORM>

</body>
</html>