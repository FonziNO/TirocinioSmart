<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

<title>Accedi</title>

<!-- Bootstrap core CSS -->
<link href="assets/css/bootstrap.css" rel="stylesheet">
<!--external css-->
<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />

<!-- Custom styles for this template -->
<link href="assets/css/style.css" rel="stylesheet">
<link href="assets/css/style-responsive.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
	<%
		String errore = (String) request.getAttribute("ErroreLogin");
		if (errore == null) {
			errore = "";
		}
		if (!errore.equals("")) {
			
			
	%>
		<script>
		alert("E-mail o Password non corretti!");
		</script>
	
	<%
		}
	%>
	<div id="login-page">
		<div class="container">

			<form class="form-login" action="Login" method="post">
				<h2 class="form-login-heading">Effettua l'accesso</h2>
				<div class="login-wrap">
					<input type="email" name="email" class="form-control"
						placeholder="E-mail" autofocus value="" required
						style="font-family: Ruda"> <br> <input
						type="password" name="password" class="form-control"
						placeholder="Password" value="" required> <label
						class="checkbox"> <span class="pull-right"> </span>
					</label>
					<button class="btn btn-theme btn-block" type="submit"
						value="Accedi" style="font-family: Ruda">
						<i class="fa fa-lock"></i> ACCEDI
					</button>
					<br>
					<form>
					
					<a href="index.jsp"
							class="btn btn-theme btn-block" type="submit"
						value="Indietro" style="font-family: Ruda">Indietro</a>
					</form>
					


				</div>

				<!-- Modal -->
				<!--
				<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog"
					tabindex="-1" id="myModal" class="modal fade">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title">Forgot Password ?</h4>
							</div>
							<div class="modal-body">
								<p>Enter your e-mail address below to reset your password.</p>
								<input type="text" name="email" placeholder="Email"
									autocomplete="off" class="form-control placeholder-no-fix">

							</div>
							<div class="modal-footer">
								<button data-dismiss="modal" class="btn btn-default"
									type="button">Cancel</button>
								<button class="btn btn-theme" type="button">Submit</button>
							</div>
						</div>
					</div>
				</div>
				-->
				<!-- modal -->

			</form>

		</div>
	</div>


	<script src="assets/js/jquery.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="assets/js/jquery.backstretch.min.js">
		
	</script>
	<script>
		$.backstretch("image/unisalr2.jpg", {
			speed : 500
		});
	</script>

	<!--
	<script>
		function controlloLogin(form) {
			var email = form.elements.namedItem("email").value.trim();
			var pass = form.elements.namedItem("password").value.trim();
			if (email !== null && email !== "" && pass !== null && pass !== "") {
	
				return true;
			} else {
				document.getElementById("alert").style.display = "block";
				return false;
			}
		}
	</script>
  -->

</body>
</html>
