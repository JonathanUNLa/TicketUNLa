<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="datos.Auditorio"%>
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
					vista reservar1 <br>
					id de usuario: <%=idu%>
					
					 <br>
					<% List<Auditorio> auditorios = (List) request.getAttribute("la"); %>
					
					<%if(auditorios.isEmpty()){ %>
					<h2>No hay auditorios</h2>
					<br><br><br>
					<%}else{%>
					<h2>Auditorios:</h2>
					<br>
					<FORM method="POST" action="/TicketUNLaWEB/reservar2">
					
					<% for (Auditorio auditorio : auditorios) { %>
					<p>
					<input type="radio" id="idauditorio" name="idauditorio" value="<%= auditorio.getIdAuditorio() %>" checked> <%=auditorio.getNombre()%><br>
					<br>
					</p>
					------------------------------------------------------------
					<%} %>
					<%} %>
					<br>
					<br>
					<INPUT type="hidden" id="idusuario" name="idusuario" value="<%= idu %>" />
					<input class="button" type="submit" value="siguiente" id="siguiente">
					</FORM>
					
</body>
</html>