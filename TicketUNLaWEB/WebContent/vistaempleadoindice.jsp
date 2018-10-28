<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="datos.Usuario"%>
<!DOCTYPE html>
<html>
<head>
<title>vista administrador indice</title>
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
<script src="js/jquery-2.2.4.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#reservas').click(function() {
			var dni = $('#dni').val();
			$.ajax({
				method : "POST",
				url : "ajaxreservascliente",
				data : {
					dni : dni
				},
				async : false
			}).done(function(data) {
				$("#respuesta").html(data);
			})
		});
	});
</script>
<!-- botones  -->


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
			vista empleado indice <br>

			<FORM method="POST" action="/TicketUNLaWEB/ajaxreservascliente">
			<label>Ingrese DNI del cliente</label>
				<INPUT type="text" id="dni" name="dni" placeholder="ingrese dni" /> 
				<input type="button" id="reservas" value="Consultar">
			</FORM>
			
			<div id="respuesta"></div>
			
		</div>

		<div class="grid_4">
			<div class="left-1">
				<h2 class="top-1 p3">informacion:</h2>

				Bienvenido
				<%=u.getNombre()%>
				<%=u.getApellido()%>

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