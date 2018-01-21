<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.util.ArrayList" import="storage.Studente"
	import="storage.Richiesta" import="application.ListaStudentiUfficio"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

	<section id="container"> <!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
	<!--header start--> <header class="header black-bg">
	<div class="sidebar-toggle-box">
		<div class="fa fa-bars tooltips" data-placement="right"
			data-original-title="Toggle Navigation"></div>
	</div>
	<!--logo start--> <a href="index.html" class="logo"><b>TIROCINIO
			SMART</b></a> <!--logo end-->
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
	</header> <!--header end--> <!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
	<!--sidebar start--> <aside>
	<div id="sidebar" class="nav-collapse ">
		<!-- sidebar menu start-->
		<ul class="sidebar-menu" id="nav-accordion">

			<p class="centered">
				<a href="DashboardStage.jsp"><img src="image/UfficioS-icon.png"
					class="img-circle" width="60"></a>
			</p>
			<h4 class="centered" style="font-family: Ruda; color: white"><%=session.getAttribute("email")%></h5>

				<li class="mt"><a href="DashboardStage.jsp"> <i
						class="fa fa-dashboard"></i> <span>Dashboard</span>
				</a></li>

				<li class="sub-menu"><a class="active"
					href="ListaStudentiUfficio.jsp"> <i class="fa fa-desktop"></i>
						<span>Lista Studenti</span>
				</a></li>
		</ul>
		<!-- sidebar menu end-->
	</div>
	</aside> <!--sidebar end--> <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
	<!--main content start--> <section id="main-content"> <section
		class="wrapper">

	<div class="row mt">
		<div class="col-lg-12">
			<div class="content-panel">
				<h5>
					<i class="fa fa-angle-right"></i> Lista Studenti
				</h5>

				<section id="unseen" action="ListaStudentiUfficio.jsp"> <%
 	ListaStudentiUfficio richieste = new ListaStudentiUfficio(); //creazione dell'oggetto richieste
 	//ArrayList<Studente> stud = richieste.doListaStudenti(); //query per gli studenti
 	ArrayList<Richiesta> ric = richieste.doListaStudenteUfficio(); //query per le richieste
 %>
				<table class="table table-bordered table-striped table-condensed">
					<thead>

						<th>Nome Studente</th>
						<th>Cognome Studente</th>
						<th>Matricola Studente</th>
						<th>Operazioni</th>



					</thead>
					<tbody>
						<%
							System.out.println(ric.size());
							System.out.println(session.getAttribute("email"));

							for (int i = 0; i < ric.size(); i++) {

								if (ric.get(i).getEmailU().equals(session.getAttribute("email"))) {
									if(ric.get(i).getStatoU()==false){
						%>
						<tr>
							<td><%=ric.get(i).getNomeS()%></td>
							<td><%=ric.get(i).getCognomeS()%></td>
							<td><%=ric.get(i).getMatricolaS()%></td>
							<td>
								<form action="AccettazioneUfficio" method="post">
									<input type="hidden" name="emailSt"
										value=<%=ric.get(i).getEmailS()%>> <input
										type="submit" class="btn btn-theme" value="Accetta"
										style="margin-right: 20%">
								</form>
							</td>


						</tr>

						<%
									}
								}
						}
						%>
					</tbody>
				</table>
				<!-- /row -->
			</div>
			<!-- /col-lg-9 END SECTION MIDDLE -->
			<!-- **********************************************************************************************************************************************************
      RIGHT SIDEBAR CONTENT
      *********************************************************************************************************************************************************** -->




		</div>
		<!-- /col-lg-3 -->
	</div>
	<! --/row --> </section> </section> <!--main content end--> <!--footer start--> <footer
		class="site-footer">
	<div class="text-center">
		2018 - Tirocinio Smart <a href="DashboardStage.jsp#"> <i></i>
		</a>
	</div>
	</footer> <!--footer end--> </section>

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




</body>

</html>