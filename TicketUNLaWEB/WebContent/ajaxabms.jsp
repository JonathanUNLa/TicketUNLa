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

	<%
		Usuario u = (Usuario) request.getAttribute("usuario");
	%>

	bienvenido usuario:
	<%=u.getApellido()%>
	<br>
	
	<FORM method="POST" action="/TicketUNLaWEB/abmclientes">
				<INPUT type="hidden" id="idusuario" name="idusuario"
					value="<%=u.getIdUsuario()%>" /> <input type="submit"
					value="ABM clientes">
	</FORM>
	
	<FORM method="POST" action="/TicketUNLaWEB/abmauditorios">
				<INPUT type="hidden" id="idusuario" name="idusuario"
					value="<%=u.getIdUsuario()%>" /> <input type="submit"
					value="ABM auditorios">
	</FORM>
	
	<FORM method="POST" action="/TicketUNLaWEB/abmeventos">
				<INPUT type="hidden" id="idusuario" name="idusuario"
					value="<%=u.getIdUsuario()%>" /> <input type="submit"
					value="ABM eventos">
	</FORM>
	
	<FORM method="POST" action="/TicketUNLaWEB/abmfunciones">
				<INPUT type="hidden" id="idusuario" name="idusuario"
					value="<%=u.getIdUsuario()%>" /> <input type="submit"
					 value="ABM funciones">
	</FORM>
	
	<FORM method="POST" action="/TicketUNLaWEB/abmdescuentos">
				<INPUT type="hidden" id="idusuario" name="idusuario"
					value="<%=u.getIdUsuario()%>" /> <input type="submit"
					value="ABM descuentos">
	</FORM>
		
</body>
</html>