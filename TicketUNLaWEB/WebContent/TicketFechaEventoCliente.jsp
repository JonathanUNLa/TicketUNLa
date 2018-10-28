<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="datos.Seccion"%>
<%@page import="datos.Usuario"%>
<%@page import="datos.Auditorio"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<title>vista cliente indice</title>
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
				
					<%List<Usuario> usuario = (List) request.getAttribute("usuario");%>
					<%int id= (int) request.getAttribute("idevento"); %>
					
						<FORM method="POST" action="/TicketUNLaWEB/TicketFechaEventoClienteResultado">
						<p>Lista de Usuarios </p>
						<%for (Usuario u: usuario){ %>
						<input type="radio" id="idusuario" name="idusuario" value="<%= u.getIdUsuario() %>" checked> Apelido: <%= u.getNombre() %> Nombre: <%= u.getApellido() %> Dni: <%= u.getDni() %>
						
						<% if( u.getTipoBeneficio()!=null ){ %>
						Tipo del beneficio: <%= u.getTipoBeneficio().getBeneficio() %>						
						<%} %>
						
						
						<br>
						<% }%>
					
						<p>Fecha inicial: </p> 
												<input name="fecha1" type="text" id="fecha1" placeholder="dd/mm/aaaa">
                         <p>Fecha final: </p>  <input name="fecha2" type="text" id="fecha2" placeholder="dd/mm/aaaa">
                                				   <br> 
						
						<INPUT type="hidden" id="idevento" name="idevento" value="<%= id %>" />
						<input class="button" type="submit" value="Consultar" id="siguiente">
						</FORM>
						<br> <br> <br>
				
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