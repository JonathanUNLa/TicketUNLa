<!DOCTYPE html>
<html lang="en">
<head>
<title>Main</title>
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
	<div class="main">
		<!--==============================header=================================-->
		<header>
			<div>
				<h1>
					<a href="index.html"><img src="images/logo.jpg" alt=""></a>
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
						<li class="current"><a href="index.html">Main</a></li>
						<li><a href="buying.html">Buying</a></li>
						<li><a href="selling.html">Selling</a></li>
						<li><a href="renting.html">Renting</a></li>
						<li><a href="finance.html">Finance</a></li>
						<li><a href="contacts.html">Contacts</a></li>
					</ul>
				</nav>
			</div>
		</header>
		<!--==============================content================================-->
		<section id="content">
			<div class="container_12">
				<div class="grid_8">
					<h2 class="top-1 p3">Welcome message!</h2>
					<p class="p2">
						Real Estate is one of <a
							href="http://blog.templatemonster.com/free-website-templates/"
							target="_blank" class="link">free website templates</a> created
						by TemplateMonster.com team. This website template is optimized
						for 1280X1024 screen resolution. It is also XHTML &amp; CSS valid.
					</p>
					<p class="line-1">
						Download the basic package of this <a class="link"
							href="http://blog.templatemonster.com/2012/04/09/free-website-template-real-estate-justslider/"
							target="_blank" rel="nofollow">Real Estate Template</a> (without
						PSD source) that is available for anyone without registration. If
						you need PSD source files, please go to the template download page
						at TemplateMonster to leave the e-mail address that you want the
						free template ZIP package to be delivered to.
					</p>
					<h2 class="p4">Buyers. Sellers. Proprietors. Agents.</h2>
					<div class="wrap block-1">
						<div>
							<img src="images/page1-img1.jpg" alt="" class="img-border">
							<h3>Selling</h3>
							<p>Nam liber tempor cum soluta no eleifend option congue
								nihil imperdiet doming iquod mazim placerat.</p>
							<a href="#" class="button">More</a>
						</div>
						<div>
							<img src="images/page1-img2.jpg" alt="" class="img-border">
							<h3>Investing</h3>
							<p>Nam liber tempor cum soluta no eleifend option congue
								nihil imperdiet doming iquod mazim placerat.</p>
							<a href="#" class="button">More</a>
						</div>
						<div class="last">
							<img src="images/page1-img3.jpg" alt="" class="img-border">
							<h3>Renting</h3>
							<p>Nam liber tempor cum soluta no eleifend option congue
								nihil imperdiet doming iquod mazim placerat.</p>
							<a href="#" class="button">More</a>
						</div>
					</div>
				</div>
				<div class="grid_4">
					<div class="left-1">
						<h2 class="top-1 p3">Login</h2>


						<FORM method="POST" action="/TicketUNLaWEB/vistapersonasindice"
							id="form-1" class="form-1 bot-1">
							<div class="select-1">
								<label>Usuario</label> 
								<input name="usuario" type="text" id="usuario"
									placeholder="Ingrese Usuario" required>
							</div>
							<div>
								<label>Contrase�a</label> 
								<input name="contrasenia" type="password" id="contrasenia"
									placeholder="Ingresa Contrase�a" required>
							</div>
							<INPUT  type="submit" value="ingresar" class="button"> 
						</form>

						
					</div>
				</div>
				<div class="clear"></div>
			</div>
		</section>
	</div>
	<!--==============================footer=================================-->
	<footer>
		<p>© 2012 Real Estate</p>
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