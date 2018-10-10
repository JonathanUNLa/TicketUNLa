<!DOCTYPE html>
<html lang="en">
<head>
<title>Main</title>
<meta charset="utf-8">
<link type="text/css" rel="stylesheet" href="css/materialize.min.css"
	media="screen,projection" />
<script type="text/javascript" src="js/materialize.min.js"></script>
<link rel="stylesheet" type="text/css" media="screen"
	href="css/reset.css">
<link rel="stylesheet" type="text/css" media="screen"
	href="css/style.css">
<link type="text/css" rel="stylesheet" href="css/materialize.min.css"
	media="screen,projection" />
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
	<div class="main">
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
			<div class="container_12">
				<div class="grid_8">
					<h2 class="top-1 p3">BIENVENIDO</h2>
					<p class="p2">algo escrito</p>
					<p class="line-1">algo escrito2</p>
					<h2 class="p4">titulo2</h2>
					<div class="wrap block-1">nada (?)</div>
				</div>
				<div class="grid_4">
					<div class="left-1">
						<h2 class="top-1 p3">Login</h2>


						<FORM method="POST" action="/TicketUNLaWEB/vistapersonasindice"
							id="form-1" class="form-1 bot-1">
							<div class="select-1">
								<label>Usuario</label> <input name="usuario" type="text"
									id="usuario" placeholder="Ingrese Usuario" required>
							</div>
							<div>
								<label>Contraseña</label> <input name="contrasenia"
									type="password" id="contrasenia"
									placeholder="Ingresa Contraseña" required>
							</div>
							<input type="submit" value="ingresar"
								class="waves-effect waves-light btn-large">
						</form>


					</div>
				</div>
				<div class="clear"></div>
			</div>
		</section>
	</div>
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