<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="datos.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="datos.Funcion"%>
<%@page import="funciones.Funciones"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% Usuario u = (Usuario) request.getAttribute("usuario"); %>

<% List<Funcion> lista = (List) request.getAttribute("lista"); %>

bienvenido usuario: <%= u.getApellido() %>
						<br> <br> <br>
						
							<p> Tickets reservados por funcion </p>
							<FORM method="POST" action="/TicketUNLaWEB/TicketReservado">
							<%for (Funcion f: lista){ %>
							
							<input type="radio" id="codigo" name="codigo" value="<%= f.getIdFuncion() %>" checked> Fecha: <%= Funciones.traerFechaCortaHora(f.getDiaHora())%> Evento:  <%= f.getEvento().getNombre() %><br>
							<br>
							<% }%>
							
								
								<input class="button" type="submit" value="Consultar" id="siguiente">
								
							</FORM>
						<br><br> <br>
						
						<p> Tickets reservados con descuentos </p> 
						<FORM method="POST" action="/TicketUNLaWEB/TicketConDescuento">
						<input class="button" type="submit" value="Consultar" id="siguiente">
						</FORM>
						<br> <br> <br>
						
						<FORM method="POST" action="/TicketUNLaWEB/TicketNoReservado">
							<p> Ubicaciones no ocupadas en una función </p> 
							<%for (Funcion f: lista){ %>
							<input type="radio" id="funcion" name="funcion" value="<%= f.getIdFuncion() %>" checked>Fecha: <%= Funciones.traerFechaCortaHora(f.getDiaHora())%> Evento:  <%= f.getEvento().getNombre() %><br>
							<br>
							<% }%>
								<input class="button" type="submit" value="Consultar" id="siguiente">
							</FORM>
						<br> <br> <br>
						
							<p> Ubicaciones no ocupadas de un evento para un auditorio </p> 
							<input type="button" id="ticketxfuncion" value="Consultar">
							<div class="select-1">
										<label>Auditorio</label> 
										<input name="codigo" type="text" id="codigo" placeholder="ingrese codigo">
							</div>
						<br> <br> <br>
						
						<p> Ticket con descuentos por tipo de cliente en un periodo </p> 
						<input type="button" id="ticketxfuncion" value="Consultar">
						<div class="select-1">
									<label>Cliente</label> 
									<input name="codigo" type="text" id="codigo" placeholder="ingrese Cliente">
									<label>fecha 1</label> 
									<input name="codigo" type="text" id="codigo" placeholder="ingrese fecha">
									<label>fecha 2</label> 
									<input name="codigo" type="text" id="codigo" placeholder="ingrese fecha">
						</div>
						
						
</body>
</html>