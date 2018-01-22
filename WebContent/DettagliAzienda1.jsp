<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="storage.Azienda" import="application.ListaAziende"
	import="storage.Richiesta" import="storage.RichiestaDao"
	import="java.util.ArrayList" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

<title>Lista Aziende</title>


<!-- Bootstrap core CSS -->
<link href="assets/css/bootstrap.css" rel="stylesheet">
<!--external css-->
<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />

<!-- Custom styles for this template -->
<link href="assets/css/style.css" rel="stylesheet">
<link href="assets/css/style-responsive.css" rel="stylesheet">

<link href="assets/css/table-responsive.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<section id="container"> <!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
	<!--header start--> <header class="header black-bg">
	<div class="sidebar-toggle-box">
		<div class="fa fa-bars tooltips" data-placement="right"
			data-original-title="Toggle Navigation"></div>
	</div>
	<!--logo start--> <a href="index.html" class="logo"><b>
			TIROCINIO SMART </b> </a> <!--logo end-->
	<div class="nav notify-row" id="top_menu">
		<!--  notification start -->

		</li>
		<!-- inbox dropdown end -->
		</ul>
		<!--  notification end -->
	</div>
	<div class="top-menu">
		<ul class="nav pull-right top-menu">
			<li><a class="logout" href="Logout">Logout</a></li>
		</ul>
	</div>
	</header> <!--header end--> <!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
	<!--sidebar start--> <aside>
	<div id="sidebar" class="nav-collapse ">
		<!-- sidebar menu start-->
		<ul class="sidebar-menu" id="nav-accordion">

			<p class="centered">
				<a href="DashboardStudente.jsp"><img
					src="image/Student-icon.png" class="img-circle" width="60"></a>
			</p>
			<h4 class="centered" style="font-family: Ruda; color: white"><%=session.getAttribute("Nome")%>
				<%=session.getAttribute("Cognome")%></h4>

			<li class="mt"><a href="DashboardStudente.jsp"> <i
					class="fa fa-dashboard"></i> <span>Dashboard</span>
			</a></li>

			<li class="sub-menu"><a href="ListaAziende.jsp"> <i
					class="fa fa-desktop"></i> <span>Lista Aziende</span>
			</a>
	</div>
	</aside> <!--sidebar end--> <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
	<!--main content start--> <section id="main-content"> <section
		class="wrapper">
	<h5>In questa sezione potrai inviare una richiesta se interessato
		al progetto formativo offerto dall'azienda.</h5>
	<div class="row mt">
		<div class="col-lg-12">
			<div class="content-panel">

				<section id="unseen">
				<table class="table table-bordered table-striped table-condensed">
					<thead>

						<th>Nome Azienda</th>
						<th>Locazione</th>
						<th>Ambito</th>


					</thead>
					<tbody>
						<tr>
							<td id="nomeAzienda">AF Soluzioni srl</td>
							<td> Via San Leonardo, 120 - 84131 Salerno</td>
							<td>AF Soluzioni è un punto di riferimento sulle tematiche che <br>
							riguardano la gestione degli approvvigionamenti per via telematica <br>
							e la collaborazione con fornitori e clienti via Web. 
							</td>

						</tr>



					</tbody>
				</table>
				<table>
					<h4 align="center">DETTAGLI AZIENDA</h4>
					</section>
				</table>
				<h5>AF Soluzioni è un azienda di produzione di soluzioni software gestionali multicanali per 
							l'SCM. La elevata flessibilità delle soluzioni ed il continuo adeguamento alle nuove 
							esigenze del mercato sono i temi che indirizzano le strategie di sviluppo.<br>
						<a href="https://www.afsoluzioni.it/index.html"> Clicca qui per vedere la pagina ufficiale dell'azienda</a></h5>
				<br>
				<div align="center">
					<form action="InviaRichiesta" method="post">

						<input type="hidden" name="emailAz"
							value="aziendaAFSoluzioni@gmail.it"> <input type="submit"
							class="btn btn-theme" value="Invia Richiesta"
							style="margin-right: 30%"> <a href="ListaAziende.jsp"
							class="btn btn-theme" style="margin-right: 4%" value="Indietro">Indietro</a>
					</form>


				</div>
			</div>
			<!-- /content-panel -->
		</div>
		<!-- /col-lg-4 -->
	</div>
	<!-- /row -->


	</div>
	<!-- /content-panel -->
	</div>
	<!-- /col-lg-12 -->
	</div>
	<!-- /row --> </section> <! --/wrapper --> </section><!-- /MAIN CONTENT --> <!--main content end-->
	<!--footer start--> <footer class="site-footer">
	<div class="text-center">
		2018 - Tirocinio Smart <a href="responsive_table.html#"> <i></i>
		</a>
	</div>
	</footer> <!--footer end--> </section>

	<!-- js placed at the end of the document so the pages load faster -->
	<script src="assets/js/jquery.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript"
		src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="assets/js/jquery.scrollTo.min.js"></script>
	<script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>


	<!--common script for all pages-->
	<script src="assets/js/common-scripts.js"></script>

	<!--script for this page-->
</body>
</html>