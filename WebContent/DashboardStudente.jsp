<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="javax.servlet.http.HttpServletRequest"
	import="storage.Studente" import="application.ListaRichieste"
	import="storage.Richiesta" import=" java.util.ArrayList"
	import="application.RifiutoRichiesta" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

<title>TIROCINIO SMART - Dashboard</title>

<!-- Bootstrap core CSS -->
<link href="assets/css/bootstrap.css" rel="stylesheet">
<!--external css-->
<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="assets/css/zabuto_calendar.css">
<link rel="stylesheet" type="text/css"
	href="assets/js/gritter/css/jquery.gritter.css" />
<link rel="stylesheet" type="text/css" href="assets/lineicons/style.css">

<!-- Custom styles for this template -->
<link href="assets/css/style.css" rel="stylesheet">
<link href="assets/css/style-responsive.css" rel="stylesheet">

<script src="assets/js/chart-master/Chart.js"></script>

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<section id="container">
		<!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
		<!--header start-->
		<header class="header black-bg">
			<div class="sidebar-toggle-box">
				<div class="fa fa-bars tooltips" data-placement="right"
					data-original-title="Toggle Navigation"></div>
			</div>
			<!--logo start-->
			<a href="index.html" class="logo"><b>TIROCINIO SMART</b></a>
			<!--logo end-->
			<div class="nav notify-row" id="top_menu">
				<!--  notification start -->
				<ul class="nav top-menu">
					<!-- settings start -->

					<!--  notification end -->
			</div>
			<div class="top-menu">
				<ul class="nav pull-right top-menu">
					<li><a class="logout" href="Logout">Logout</a></li>
				</ul>
			</div>
		</header>
		<!--header end-->

		<!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
		<!--sidebar start-->
		<aside>
			<div id="sidebar" class="nav-collapse ">
				<!-- sidebar menu start-->
				<ul class="sidebar-menu" id="nav-accordion">

					<p class="centered">
						<a href="Dashboard"><img
							src="image/Student-icon.png" class="img-circle" width="60"></a>
					</p>
					<h4 class="centered" style="font-family: Ruda; color: white"><%=session.getAttribute("Nome")%>
						<%=session.getAttribute("Cognome")%></h4>

					<li class="mt"><a class="active" href="Dashboard"> <i
							class="fa fa-dashboard"></i> <span>Dashboard</span>
					</a></li>



					<%
						ListaRichieste richieste = new ListaRichieste();
						ArrayList<Richiesta> r = new ArrayList<Richiesta>();
						r = richieste.doListaRichieste();
						int flag = 0;
						for (int i = 0; i < r.size(); i++) {

							if (r.get(i).getEmailS().equals(session.getAttribute("email")) && r.get(i).getStatoR() == true) {
								flag = 1;
								System.out.println("si è loggato chi ha fatto una richiesta ed è stato accettato");
							}
							if (r.get(i).getEmailS().equals(session.getAttribute("email")) && r.get(i).getStatoR() == false) {
								flag = 0;
								System.out.println("si è loggato chi ha fatto una richiesta e non è stato ancora accettato");
							}
						}
					%>

					<%
						if (flag == 0) {
					%>

					<li class="sub-menu"><a href="ListaAziende.jsp"> <i
							class="fa fa-desktop"></i> <span>Lista Aziende</span>
					</a></li>
					<%
						System.out.println("SE NON CI SONO RICHIESTE");

						}
					%>



				</ul>
				<!-- sidebar menu end-->
			</div>
		</aside>
		<!--sidebar end-->

		<!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper">
				<h5>In questa sezione potrai visualizzare le notifiche inerenti
					alle tue richieste, ed anche lo stato di una richiesta accettata o
					rifiutata da parte dei responsabili della richiesta.</h5>
				<div class="row">
					<div class="col-lg-9 main-chart"></div>
					<!-- /row -->

				</div>
				<!-- /col-lg-9 END SECTION MIDDLE -->


				<!-- **********************************************************************************************************************************************************
      RIGHT SIDEBAR CONTENT
      *********************************************************************************************************************************************************** -->

				<div class="col-md-3 ds">
					<!--COMPLETED ACTIONS DONUTS CHART-->
					<h3>NOTIFICHE</h3>

					<!-- First Action -->
					<div class="col-md-3 ds"></div>
					<%
						for (int i = 0; i < r.size(); i++) {
							if (r.get(i).getEmailS().equals(session.getAttribute("email")) && r.get(i).getStatoU() == true) {
					%>
					<div class="desc">
						<div class="thumb">
							<span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
						</div>
						<div class="details">
							<p>
								<a>L'Ufficio Stage</a> ha accettato la tua richiesta<br />
							</p>
						</div>
					</div>
					<%
						}
						}
					%>





					<%
						for (int i = 0; i < r.size(); i++) {
							if (r.get(i).getEmailS().equals(session.getAttribute("email")) && r.get(i).getStatoT() == true) {
					%>
					<div class="desc">
						<div class="thumb">
							<span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
						</div>
						<div class="details">
							<p>
								<a><%=r.get(i).getNomeT()%> <%=r.get(i).getCognomeT()%></a> ha
								accettato la tua richiesta<br />
							</p>
						</div>
					</div>
					<%
						}
						}
					%>
					<%
						for (int i = 0; i < r.size(); i++) {
							if (r.get(i).getEmailS().equals(session.getAttribute("email")) && r.get(i).getStatoR() == true) {
					%>
					<div class="desc">
						<div class="thumb">
							<span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
						</div>
						<div class="details">
							<p>
								<a><%=r.get(i).getNomeA()%></a> ha accettato la tua richiesta<br />
							</p>
						</div>
					</div>
					<%
						}
						}
					%>

					<%
						if (request.getAttribute("notifica") != null) {
					%><%=request.getAttribute("notifica")%>
					<%
						}
					%>

				</div>

				<!-- STATO PROGETTO FORMATIVO -->

				<div class="col-md-9">
					<div class="content-panel">
						<h5>
							<i class="fa fa-angle-right"></i>Stato Progetto Formativo
						</h5>

						<table class="table table-bordered table-striped table-condensed">
							<thead>

								<th>Responsabile</th>
								<th>Stato</th>


							</thead>
							<tbody>
								<tr>
									<td>Azienda</td>

									<td>
										<%
											for (int i = 0; i < r.size(); i++) {
												if (r.get(i).getEmailS().equals(session.getAttribute("email")) && r.get(i).getStatoR() == true) {
										%><img src="image/StatusVero.jpg" class="img-circle"
										width="18">
									</td>
								</tr>
								<%
									}
									}
								%>

								</tr>

								<tr>
									<td>Tutor</td>

									<td>
										<%
											for (int i = 0; i < r.size(); i++) {
												if (r.get(i).getEmailS().equals(session.getAttribute("email")) && r.get(i).getStatoT() == true) {
										%><img src="image/StatusVero.jpg" class="img-circle"
										width="18">
									</td>
								</tr>
								<%
									} else if (r.get(i).getEmailS().equals(session.getAttribute("email")) && r.get(i).getStatoT() == false
												&& r.get(i).getStatoR() == true) {
								%>
								<img src="image/StatusAttesa.jpg" class="img-circle" width="18">

								<%
									}
								%>
								<%
									}
								%>
								</tr>

								<tr>
									<td>Ufficio Stage</td>

									<td>
										<%
											for (int i = 0; i < r.size(); i++) {
												if (r.get(i).getEmailS().equals(session.getAttribute("email")) && r.get(i).getStatoU() == true) {
										%><img src="image/StatusVero.jpg" class="img-circle"
										width="18">
									</td>
								</tr>
								<%
									} else if (r.get(i).getEmailS().equals(session.getAttribute("email")) && r.get(i).getStatoU() == false
												&& r.get(i).getStatoR() == true) {
								%>
								<img src="image/StatusAttesa.jpg" class="img-circle" width="18">

								<%
									}
								%>
								<%
									}
								%>
								</tr>
							</tbody>
						</table>

					</div>
				</div>


				<!-- /col-lg-3 -->

				<!--/row -->
				<div class="col-md-3"></div>
				<div class="col-md-9" style="margin-top: 1.5%">
					<div class="content-panel">
						<h5>
							<i class="fa fa-angle-right"></i>Legenda
						</h5>
						<table class="table table-bordered table-striped table-condensed">

							<thead>

								<th>Stato</th>
								<th>Riferimento</th>


							</thead>
							<tbody>
								<tr>
									<td>Accettato</td>

									<td><img src="image/StatusVero.jpg" class="img-circle"
										width="18"></td>
								</tr>
								<tr>
									<td>In Attesa</td>

									<td><img src="image/StatusAttesa.jpg" class="img-circle"
										width="18"></td>
								</tr>
								<tr>
									<td>Rifiutato</td>

									<td><img src="image/StatusFalso.jpg" class="img-circle"
										width="18"></td>
								</tr>
							</tbody>
						</table>

					</div>
				</div>
			</section>


			<!-- <section id="unseen"> -->

			<!-- </section> -->
		</section>

		<!--main content end-->
		<!--footer start-->
		<footer class="site-footer">
			<div class="text-center">
				2018 - Tirocinio Smart <a href="principale.html#"> <i></i>
				</a>
			</div>
		</footer>
		<!--footer end-->
	</section>

	<!-- js placed at the end of the document so the pages load faster -->
	<script src="assets/js/jquery.js"></script>
	<script src="assets/js/jquery-1.8.3.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript"
		src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="assets/js/jquery.scrollTo.min.js"></script>
	<script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>
	<script src="assets/js/jquery.sparkline.js"></script>


	<!--common script for all pages-->
	<script src="assets/js/common-scripts.js"></script>

	<script type="text/javascript"
		src="assets/js/gritter/js/jquery.gritter.js"></script>
	<script type="text/javascript" src="assets/js/gritter-conf.js"></script>

	<!--script for this page-->
	<script src="assets/js/sparkline-chart.js"></script>
	<script src="assets/js/zabuto_calendar.js"></script>

	<script>
		function messaggio() {
			alert("non puoi inviare richieste");
		}
	</script>


</body>
</html>
