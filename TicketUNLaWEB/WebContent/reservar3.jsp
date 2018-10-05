<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="datos.Funcion"%>
<%@page import="funciones.Funciones"%>
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
					
					<%
					int ide = (int) request.getAttribute("idevento");
					%>
					
					vista reservar3 <br>
					id de usuario: <%=idu%>
					id de auditorio: <%=ida%>
					id de evento: <%=ide%>
					
					 <br>
					<% List<Funcion> funciones = (List) request.getAttribute("fl"); %>
					
					<%if(funciones.isEmpty()){ %>
					<h2>No hay funciones</h2>
					<br><br><br>
					<%}else{%>
					<h2>Funciones:</h2>
					<br>
					<FORM method="POST" action="/TicketUNLaWEB/reservar4">
					
					<% for (Funcion funcion : funciones) { %>
					<p>
					Día:
					<input type="radio" id="idfuncion" name="idfuncion" value="<%= funcion.getIdFuncion() %>" checked><%=Funciones.traerFechaCorta(funcion.getDiaHora())%><br>
					<br>
					Precio base: <%= funcion.getPrecioBase() %>
					</p>
					------------------------------------------------------------
					<%} %>
					<%} %>
					<br>
					<br>
					<INPUT type="hidden" id="idevento" name="idevento" value="<%= ide %>" />
					<INPUT type="hidden" id="idauditorio" name="idauditorio" value="<%= ida %>" />
					<INPUT type="hidden" id="idusuario" name="idusuario" value="<%= idu %>" />
					<input class="button" type="submit" value="siguiente" id="siguiente">
					</FORM>
</body>
</html>