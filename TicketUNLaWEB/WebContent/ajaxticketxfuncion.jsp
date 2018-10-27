<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="datos.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="datos.Funcion"%>
<%@page import="datos.Evento"%>
<%@page import="datos.Seccion"%>
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
<% List<Evento> eventos = (List) request.getAttribute("evento"); %>
bienvenido usuario: <%= u.getApellido() %>
						<br> <br> <br>
						
							<p>7. Tickets reservados por funcion </p>
							<FORM method="POST" action="/TicketUNLaWEB/TicketReservado">
							<%for (Funcion f: lista){ %>
							
							<input type="radio" id="codigo" name="codigo" value="<%= f.getIdFuncion() %>" checked> Fecha: <%= Funciones.traerFechaCortaHora(f.getDiaHora())%> Evento:  <%= f.getEvento().getNombre() %><br>
							<br>
							<% }%>
							
								
								<input class="button" type="submit" value="Consultar" id="siguiente">
								
							</FORM>
						<br><br> <br>
						
						<p> 8.Tickets reservados con descuentos </p> 
						<FORM method="POST" action="/TicketUNLaWEB/TicketConDescuento">
						<input class="button" type="submit" value="Consultar" id="siguiente">
						</FORM>
						<br> <br> <br>
						
						<FORM method="POST" action="/TicketUNLaWEB/TicketNoReservado">
							<p>9. Ubicaciones no ocupadas en una función </p> 
							<%for (Funcion f: lista){ %>
							<input type="radio" id="funcion" name="funcion" value="<%= f.getIdFuncion() %>" checked>Fecha: <%= Funciones.traerFechaCortaHora(f.getDiaHora())%> Evento:  <%= f.getEvento().getNombre() %><br>
							<br>
							<% }%>
								<input class="button" type="submit" value="Consultar" id="siguiente">
							</FORM>
						<br> <br> <br>
					

						<p> 10. ubicaciones no ocupadas de un evento para un auditorio. </p> 
						<FORM method="POST" action="/TicketUNLaWEB/TicketConDescuento">
						<input class="button" type="submit" value="Consultar" id="siguiente">
						</FORM>
						<br> <br> <br>
						
						
						<p> 11.ticket con descuentos por tipo de cliente en un periodo </p> 
						<FORM method="POST" action="/TicketUNLaWEB/TicketConDescuento">
						<input class="button" type="submit" value="Consultar" id="siguiente">
						</FORM>
						<br> <br> <br>
							
						<p> 12.ticket reservados con precio del ticket entre fechas por evento </p> 
						<FORM method="POST" action="/TicketUNLaWEB/TicketFechaEvento">
						<%for (Evento e: eventos){ %>
							<input type="radio" id="codigo" name="codigo" value="<%= e.getIdEvento() %>" checked> Nombre evento: <%= e.getNombre() %> Auditorio <%= e.getAuditorio().getNombre() %><br>					
							<% }%>
							<p>Fecha inicial: </p> <input type="date" name="fecha1" min="2018-03-25"
                                  				   max="2018-05-25" step="2" placeholder="dd/mm/aaaa"> 
                            <p>Fecha final: </p>  <input type="date" name="fecha2" min="2018-03-25"
                                				   max="2018-05-25" step="2" placeholder="dd/mm/aaaa">
                                				   <br> 
						<input class="button" type="submit" value="Consultar" id="siguiente">
						</FORM>
						<br> <br> <br>
						
						
						<p> 12. ticket reservados por función y sector </p> 
						<FORM method="POST" action="/TicketUNLaWEB/TicketFuncionSeccion">
						<p>Funcion </p>
						<%for (Funcion f: lista){ %>
						<input type="radio" id="funcion" name="funcion" value="<%= f.getIdFuncion() %>" checked>Fecha: <%= Funciones.traerFechaCortaHora(f.getDiaHora())%> Evento:  <%= f.getEvento().getNombre() %><br>
						<% }%>
						<input class="button" type="submit" value="Consultar" id="siguiente">
						</FORM>
						<br> <br> <br>
						
						
</body>
</html>