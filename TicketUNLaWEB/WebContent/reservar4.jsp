<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="datos.Butaca"%>
<%@page import="funciones.Funciones"%>
<%@page import="datos.Evento"%>
<%@page import="datos.Usuario"%>
<%@page import="datos.Auditorio"%>
<%@page import="datos.Funcion"%>

<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<title>vista cliente indice</title>
<meta charset="utf-8">
<!-- <link type="text/css" rel="stylesheet" href="css/materialize.min.css" -->
<!-- 	media="screen,projection" /> -->
<!-- <script type="text/javascript" src="js/materialize.min.js"></script> -->
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
<!--[if lt IE 8]>
       <div style=' clear: both; text-align:center; position: relative;'>
         <a href="http://windows.microsoft.com/en-US/internet-explorer/products/ie/home?ocid=ie6_countdown_bannercode">
           <img src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today." />
        </a>
      </div>
    <![endif]-->
<!--[if lt IE 9]>
   		<script type="text/javascript" src="js/html5.js"></script>
    	<link rel="stylesheet" type="text/css" media="screen" href="css/ie.css">
	<![endif]-->
</head>
<body>

<!--==============================header=================================-->
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
		<!--==============================content================================-->
		<section id="content">
				<div class="grid_8">
				
				<%
					Usuario u = (Usuario) request.getAttribute("usuario");
					%>
					<%
					Auditorio a = (Auditorio) request.getAttribute("auditorio");
					%>
					<%
					Evento e = (Evento) request.getAttribute("evento");
					%>
					<%
					Funcion f = (Funcion) request.getAttribute("funcion");
					%>
		
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
					
					vista reservar4 <br>
					
					 
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
					<input type="checkbox" id="idbutaca" name="idbutaca" value="<%= butaca.getIdButaca() %>" ><%= butaca.getColumna() %><br>
					<br>
					Fila <%= butaca.getFila() %>
				<br>	Precio de la seccion <%= butaca.getSeccion().getPrecioSeccion() %><br>
				<br1><%= butaca.getSeccion().getNombreSeccion() %> <br1>
					</p>
					------------------------------------------------------------
					<%} %>
					<%} %>
					<br>
					<div class="select-1">
								<label>Codigo</label> 
								<input name="codigo" type="text" id="codigo"
									placeholder="ingrese codigo">
					</div>
					<br>
					<INPUT type="hidden" id="idfuncion" name="idfuncion" value="<%= idf %>" />
					<INPUT type="hidden" id="idevento" name="idevento" value="<%= ide %>" />
					<INPUT type="hidden" id="idauditorio" name="idauditorio" value="<%= ida %>" />
					<INPUT type="hidden" id="idusuario" name="idusuario" value="<%= idu %>" />
					<input class="button" type="submit" value="reservar" id="siguiente">
					</FORM>
				</div>
					
			<div class="grid_4">
					<div class="left-1">
						<h2 class="top-1 p3">informacion:</h2>

						Nombre: <%=u.getNombre()%> <%=u.getApellido()%> <br>
						Auditorio: <%=a.getNombre()%><br>
						Evento: <%=e.getNombre()%><br>
						Funcion: <%=Funciones.traerFechaCorta(f.getDiaHora())%><br>
						
						<img src="images/plano1.jpg" alt="" /> <br>
						<img src="images/plano2.jpg" alt="" /> <br>
						<img src="images/plano3.jpg" alt="" /> <br>
					</div>
			</div>		
		
					
					</section>
				
<!--==============================footer=================================-->
	<footer>
		<p>UNLa Ticket 2018</p>
		<p>
			Website Template by <a href="http://www.templatemonster.com/"
				target="_blank" rel="nofollow">www.templatemonster</a>
		</p>
	</footer>
	<script>
		Cufon.now();
	</script>
					
</body>
</html>