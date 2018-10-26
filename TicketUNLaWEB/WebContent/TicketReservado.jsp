<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="datos.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="datos.Funcion"%>
<%@page import="datos.Butaca"%>
<%@page import="funciones.Funciones"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<br>
	<%
		List<Butaca> butacas = (List) request.getAttribute("bt");
	%>

	<%
		if (butacas.isEmpty()) {
	%>
	<h2>No hay butacas</h2>
	<br>
	<br>
	<br>
	<%
		} else {
	%>
	<h2>Butacas:</h2>
	<br>

	<%
		for (Butaca butaca : butacas) {
	%>
	<p>
		Columna: <input type="checkbox" id="idbutaca" name="idbutaca"
			value="<%=butaca.getIdButaca()%>"><%=butaca.getColumna()%><br>
		<br> Fila
		<%=butaca.getFila()%>
		<br> Precio de la seccion
		<%=butaca.getSeccion().getPrecioSeccion()%><br>
		<br1><%=butaca.getSeccion().getNombreSeccion()%> <br1>
	</p>
	------------------------------------------------------------
	<%
		}
	%>
	<%
		}
	%>


	<p>Ticket con descuentos por tipo de cliente en un periodo</p>
	<input type="button" id="ticketxfuncion" value="Consultar">
	<div class="select-1">
		<label>Cliente</label> <input name="codigo" type="text" id="codigo"
			placeholder="ingrese Cliente"> <label>fecha 1</label> <input
			name="codigo" type="text" id="codigo" placeholder="ingrese fecha">
		<label>fecha 2</label> <input name="codigo" type="text" id="codigo"
			placeholder="ingrese fecha">
	</div>
</body>
</html>