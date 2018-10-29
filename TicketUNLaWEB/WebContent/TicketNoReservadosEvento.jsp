<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="datos.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="datos.Funcion"%>
<%@page import="datos.Butaca"%>
<%@page import="funciones.Funciones"%>
<!DOCTYPE html>
<html>
<head><title>vista cliente indice</title>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" media="screen"
	href="css/reset.css">
<link rel="stylesheet" type="text/css" media="screen"
	href="css/style.css">
<link rel="stylesheet" type="text/css" media="screen"
	href="css/grid_12.css">
<link rel="stylesheet" type="text/css" media="screen"
	href="css/slider.css">
<link rel="stylesheet" type="text/css" media="screen"
	href="css/jqtransform.css">
<script src="js/jquery-1.7.min.js"></script>
<script src="js/jquery.easing.1.3.js"></script>
<script src="js/cufon-yui.js"></script>
<script src="js/vegur_400.font.js"></script>
<script src="js/Vegur_bold_700.font.js"></script>
<script src="js/cufon-replace.js"></script>
<script src="js/tms-0.4.x.js"></script>
<script src="js/jquery.jqtransform.js"></script>
<script src="js/FF-cash.js"></script>
<script>
	$(document).ready(function() {
		$('.form-1').jqTransform();
		$('.slider')._TMS({
			show : 0,
			pauseOnHover : true,
			prevBu : '.prev',
			nextBu : '.next',
			playBu : false,
			duration : 1000,
			preset : 'fade',
			pagination : true,
			pagNums : false,
			slideshow : 7000,
			numStatus : false,
			banners : false,
			waitBannerAnimation : false,
			progressBar : false
		})
	});
</script>
</head>
<body>
	<header>
			<div>
				<h1>
					<a href=""><img src="images/logo.jpg" alt=""></a>
				</h1>
				<div class="social-icons">
					<span>Follow Us:</span> <a href="#" class="icon-3"></a> <a href="#"
						class="icon-2"></a> <a href="#" class="icon-1"></a>
				</div>
				<div id="slide">
					<div class="slider">
						<ul class="items">
							<li><img src="images/slider-1.jpg" alt="" /></li>
							<li><img src="images/slider-2.jpg" alt="" /></li>
							<li><img src="images/slider-3.jpg" alt="" /></li>
						</ul>
					</div>
					<a href="#" class="prev"></a><a href="#" class="next"></a>
				</div>
				<nav>
					<ul class="menu">
						<li class="current"><a href="">Main</a></li>
						<li><a href="contacto.html">Contacts</a></li>
					</ul>
				</nav>
			</div>
		</header>

	<br>
		<section id="content">
				<div class="grid_8">
				<%
					List<Butaca> butacas = (List) request.getAttribute("butacasDevolver");
				%>
				
				<%
					String evento = (String) request.getAttribute("evento");
				%>
			
				<%
					if (butacas.isEmpty()) {
				%>
				<h2>No hay butacas en el evento <%= evento %></h2>
				<br>
				<br>
				<br>
				<%
					} else {
				%>
				<h2>Butacas del evento: <%= evento %>:</h2>
				<br>
			
				<%
					for (Butaca butaca : butacas) {
				%>
				<p>
					Columna:  <%=butaca.getColumna()%><br>
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
	
			</div>
			
		
					
</section>

</body>
</html>