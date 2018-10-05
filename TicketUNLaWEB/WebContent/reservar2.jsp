<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="datos.Evento"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
					<%
					int idu = (int) request.getAttribute("idusuario");
					%>
					
					<%
					int ida = (int) request.getAttribute("idauditorio");
					%>
					
					vista reservar2 <br>
					id de usuario: <%=idu%>
					id de auditorio: <%=ida%>
					
					 <br>
					<% List<Evento> eventos = (List) request.getAttribute("el"); %>
					
					<%if(eventos.isEmpty()){ %>
					<h2>No hay eventos</h2>
					<br><br><br>
					<%}else{%>
					<h2>Eventos:</h2>
					<br>
					<FORM method="POST" action="/TicketUNLaWEB/reservar3">
					
					<% for (Evento evento : eventos) { %>
					<p>
					<input type="radio" id="idevento" name="idevento" value="<%= evento.getIdEvento() %>" checked> <%=evento.getNombre()%><br>
					<br>
					</p>
					------------------------------------------------------------
					<%} %>
					<%} %>
					<br>
					<br>
					<INPUT type="hidden" id="idauditorio" name="idauditorio" value="<%= ida %>" />
					<INPUT type="hidden" id="idusuario" name="idusuario" value="<%= idu %>" />
					<input class="button" type="submit" value="siguiente" id="siguiente">
					</FORM>
					
</body>
</html>