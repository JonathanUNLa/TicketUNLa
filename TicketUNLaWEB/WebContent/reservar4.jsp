<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="datos.Butaca"%>
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
					
					<%
					int idf = (int) request.getAttribute("idfuncion");
					%>
					
					vista reservar3 <br>
					id de usuario: <%=idu%>
					id de auditorio: <%=ida%>
					id de evento: <%=ide%>
					id de funcion: <%=idf%>
					 
					 <br>
					<% List<Butaca> butacas = (List) request.getAttribute("bl"); %>
					
					<%if(butacas.isEmpty()){ %>
					<h2>No hay butacas</h2>
					<br><br><br>
					<%}else{%>
					<h2>Butacas:</h2>
					<br>
					<FORM method="POST" action="/TicketUNLaWEB/reservar5">
					
					<% for (Butaca butaca : butacas) { %>
					<p>
					Columna:
					<input type="radio" id="idfuncion" name="idfuncion" value="<%= butaca.getIdButaca() %>" checked><%= butaca.getColumna() %><br>
					<br>
					Fila <%= butaca.getFila() %>
					</p>
					------------------------------------------------------------
					<%} %>
					<%} %>
					<br>
					<br>
					<INPUT type="hidden" id="idfuncion" name="idfuncion" value="<%= idf %>" />
					<INPUT type="hidden" id="idauditorio" name="idauditorio" value="<%= ida %>" />
					<INPUT type="hidden" id="idusuario" name="idusuario" value="<%= idu %>" />
					<input class="button" type="submit" value="siguiente" id="siguiente">
					</FORM>
</body>
</html>