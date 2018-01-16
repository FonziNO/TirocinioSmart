<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    import="java.util.ArrayList" import="storage.Azienda" import="application.ListaAziende" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

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

  <section id="container" >
      <!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
      <!--header start-->
      <header class="header black-bg">
              <div class="sidebar-toggle-box">
                  <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
              </div>
            <!--logo start-->
            <a href="index.html" class="logo"><b> TIROCINIO SMART </b> </a>
            <!--logo end-->
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
        </header>
      <!--header end-->
      
      <!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
      <!--sidebar start-->
      <aside>
          <div id="sidebar"  class="nav-collapse ">
              <!-- sidebar menu start-->
              <ul class="sidebar-menu" id="nav-accordion">
              
              	  <p class="centered"><a href="profile.html"><img src="assets/img/ui-sam.jpg" class="img-circle" width="60"></a></p>
              	  <h4 class="centered" style="font-family: Ruda; color: white" ><%= session.getAttribute("Nome") %> <%= session.getAttribute("Cognome") %></h4>

              	  	
                  <li class="mt">
                      <a href="DashboardStudente.jsp">
                          <i class="fa fa-dashboard" ></i>
                          <span>Dashboard</span>
                      </a>
                  </li>

                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-desktop" href="ListaAziende.jsp"></i>
                          <span>Lista Aziende</span>
                      </a>
                
          </div>
      </aside>
      <!--sidebar end-->
      
      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
      <!--main content start-->
      <section id="main-content">
          <section class="wrapper">
          	<p> In questa sezione puoi scegliere l'Azienda</p>
		  		<div class="row mt">
			  		<div class="col-lg-12">
                      <div class="content-panel">
                      <h5><i class="fa fa-angle-right"></i> Lista Aziende </h5>
                          <section id="unseen" action="ListaAziende.jsp">
                          <%ArrayList<Azienda> lista = new ArrayList<Azienda>();
                          ListaAziende azienda = new ListaAziende();
                          lista=azienda.doListaAziende();%>
                         
                           <%if(request.getAttribute("errore")!= null){
                            	%>
                            	<p><font color="red"><%=request.getAttribute("errore")%></font></p>
                            	<%}else if(request.getAttribute("inserisci")!=null){%>
                            	 <p><font color="green"><%=request.getAttribute("inserisci")%></font></p>
                            	 <%} %>
                            <table class="table table-bordered table-striped table-condensed">
                              <thead>
                              
                                  <th>Nome Aziende</th>
                                  <th> Visualizza dettagli dell'azienda</th>
                                 
                              </thead>
                              <tbody>
                              <tr>
                                  <td><%=lista.get(0).getNomeA()%></td>
                                  <td> <a href="DettagliAzienda1.jsp" class="btn btn-theme" style="margin-right: 20%"
			value="Dettagli">Dettagli</a> </td>
                              </tr>
                                <tr>
                                  <td><%=lista.get(1).getNomeA()%></td>
                                  <td> <a href="DettagliAzienda2.jsp" class="btn btn-theme" style="margin-right: 20%"
			value="Dettagli">Dettagli</a> </td>
                              </tr>
                                <tr>
                                  <td><%=lista.get(2).getNomeA()%></td>
                                  <td> <a href="DettagliAzienda3.jsp" class="btn btn-theme" style="margin-right: 20%"
			value="Dettagli">Dettagli</a> </td>
                              </tr>
                              </tbody>
                          </table>
                          </section>
                  </div><!-- /content-panel -->
               </div><!-- /col-lg-4 -->			
		  	</div><!-- /row -->
		 
                        
                      </div><!-- /content-panel -->
                  </div><!-- /col-lg-12 -->
              </div><!-- /row -->

		</section><! --/wrapper -->
      </section><!-- /MAIN CONTENT -->

      <!--main content end-->
      <!--footer start-->
      <footer class="site-footer">
          <div class="text-center">
              2018 - Tirocinio Smart
              <a href="responsive_table.html#" class="go-top">
                  <i class="fa fa-angle-up"></i>
              </a>
          </div>
      </footer>
      <!--footer end-->
  </section>

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="assets/js/jquery.scrollTo.min.js"></script>
    <script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>


    <!--common script for all pages-->
    <script src="assets/js/common-scripts.js"></script>

    <!--script for this page-->
    

  </body>
</html>
