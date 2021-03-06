<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrati</title>



<link href="assets/css/style.css" rel="stylesheet">
<link href="assets/css/style-responsive.css" rel="stylesheet">
<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link href="assets/css/bootstrap.css" rel="stylesheet">


</head>
<body>
	<%
		String errore = (String) request.getAttribute("ErroreRegistrazione");
		if (errore == null) {
			errore = "";
		}
		if (!errore.equals("")) {
	%>
	<script>
		alert("Email gi� esistente!");
	</script>

	<%
		}
	%>
	<div id="login-page">
		<div class="container">
			<form class="form-login" role="form" onsubmit="return Control()"
				action="Registra" method="post">

				<h2 class="form-login-heading">Registrati!</h2>
				<div class="login-wrap">
					<label for="nome" class="col-sm-3 control-label">Nome</label>
					<div class="col-sm-9">
						<input type="text" style="font-family: Ruda" required id="nome"
							placeholder="Nome" class="form-control" autofocus name="nome"
							pattern="[A-za-z\s]{3,20}">
					</div>
				</div>


				<div class="login-wrap">
					<label for="cognome" class="col-sm-3 control-label">Cognome</label>
					<div class="col-sm-9">
						<input type="text" id="cognome" required placeholder="Cognome"
							class="form-control" autofocus name="cognome"
							pattern="[A-za-z\s]{3,20}">
					</div>
				</div>


				<div class="login-wrap">
					<label for="email" class="col-sm-3 control-label">Email</label>
					<div class="col-sm-9">
						<input type="email" id="email" required placeholder="Email"
							class="form-control" name="email">
					</div>
				</div>

				<div class="login-wrap">
					<label for="dataN" class="col-sm-3 control-label">Data </label>

					<div class="col-sm-9">
						<input type="data" id="dataN" required
							title="Rispetta il formato!" class="form-control"
							placeholder="dd/mm/yyyy" maxlength="10" name="datanascita">
					</div>
				</div>



				<div class="login-wrap">
					<label for="cellulare" class="col-sm-3 control-label">Cellulare</label>
					<div class="col-sm-9">
						<input pattern=".{10,}" required title="10 caratteri richiesti!"
							type="text" id="cellulare" class="form-control"
							placeholder="Cellulare" onkeypress='validate(event)'
							maxlength="10" name="cellulare">
					</div>
				</div>


				<div class="login-wrap">
					<label for="matricola" class="col-sm-3 control-label">Matricola</label>
					<div class="col-sm-9">
						<input pattern=".{10,}" required title="10 caratteri richiesti!"
							type="matricola" id="matricola" class="form-control"
							placeholder="0512100000" onkeypress='validate(event)'
							maxlength="10" name="matricola">
					</div>
				</div>


				<div class="login-wrap">
					<label for="password" class="col-sm-3 control-label">Password</label>
					<div class="col-sm-9">
						<input pattern=".{8,16}" required title="Minimo 8 caratteri!"
							type="password" id="password" placeholder="Password"
							class="form-control" maxlength="16" name="password">
					</div>
				</div>

				<div class="login-wrap">
					<label for="ripetipassword" class="col-sm-3 control-label">Ripeti
						Password</label>
					<div class="col-sm-9">
						<input type="password" id="ripetipassword"
							placeholder="RipetiPassword" class="form-control" maxlength="16"
							name="ripetipassword">

					</div>

					<div class="login-wrap">
						<label class="checkbox"><span class="pull-right"> </span>
						</label>

					</div>

					<div class="form-group">

						<button class="btn btn-theme btn-block" type="submit"
							style="font-family: Ruda" onclick="Control()">
							<i class="fa fa-lock"></i> REGISTRATI
						</button>
						<form>

							<a href="Index" class="btn btn-theme btn-block" type="submit"
								value="Indietro" style="font-family: Ruda">INDIETRO</a>
						</form>

					</div>
				</div>
			</form>
		</div>
	</div>
	<!-- ./container -->
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
	<script>
		function validate(evt) {
			var theEvent = evt || window.event;
			var key = theEvent.keyCode || theEvent.which;
			key = String.fromCharCode(key);
			var regex = /[0-9]|\./;
			if (!regex.test(key)) {
				theEvent.returnValue = false;
				if (theEvent.preventDefault)
					theEvent.preventDefault();
			}
		}
	</script>
	<script type="text/javascript">
		function Control() {
			var pass1 = document.getElementById("password").value;
			var pass2 = document.getElementById("ripetipassword").value;
			var email = document.getElementById("email").value;
			var data = document.getElementById("dataN").value;
			var matricola = document.getElementById("matricola").value;
			
			var espressione =  /^[0-9]{2}\/[0-9]{2}\/[0-9]{4}$/;
			
			var ok = true;
			
			
			
			if (email.indexOf('studenti.unisa.it') == -1) {
				alert("E-MAIL NON VALIDA: L'accesso � consentito unicamente ai domini (@studenti.unisa.it)");
				return false;
			}
			if(!espressione.test(data)){
				return false;
			}else{
				anno = parseInt(data.substr(6), 10);
				mese = parseInt(data.substr(3, 2), 10);
				giorno = parseInt(data.substr(0, 2), 10);
				var dataNascita = new Date(anno, mese - 1, giorno);
				if (dataNascita.getFullYear() == anno
						&& dataNascita.getMonth() + 1 == mese
						&& dataNascita.getDate() == giorno) {
					return true;
				} else {
					return false;
				}
				if (matricola.indexOf('05121') == -1) {
					alert("Prefisso matricola errato! '05121' � il prefisso da utilizzare");
					return false;
				} else if (pass1 != pass2) { //alert("Passwords Do not match");
					alert("Le password immesse non coincidono!");
					document.getElementById("password").style.borderColor = "#E34234";
					document.getElementById("ripetipassword").style.borderColor = "#E34234";
					ok = false;
				} else {

				}
				return ok;
			}
		}

		/* if (data.indexOf('/', 1) == -1) {
		alert("Separa il giorno nella data di nascita con il carattere '/'");
		return false;
		} */
		//else{
		//il campo diventa verde come CORRETTO
		//}
		/* if (data.indexOf('/', 3) == -1) {
		alert("Separa il mese nella data di nascita con il carattere '/'");
		return false;
		} */
		//else{
		//il campo diventa verde come CORRETTO
		//}

		/*  if (data.length < 10) {
		 alert("La lunghezza della data non � corretta!");
		 return false;
		 } */
		//else{
		//il campo diventa verde come CORRETTO
		//} */
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