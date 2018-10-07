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
					
					<%
					String idb[] = (String[]) request.getAttribute("idbutaca");
					%>
					
					vista reservar4 <br>
					id de usuario: <%=idu%>
					id de auditorio: <%=ida%>
					id de evento: <%=ide%>
					id de funcion: <%=idf%>
					 
					id de butacas: 
					<% if (idb != null && idb.length != 0) { %>
						seleccionaste:
						<%for (int i = 0; i < idb.length; i++) {%>
							<%=idb[i] %>
						<%}%>
					<%}%>
					
					<h1>reserva realizada</h1>
					<h2>Total de la reserva </h2>
					
</body>
</html>