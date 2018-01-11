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
	<div id="login-page">
		<div class="container">
			<form class="form-login" role="form" >

				<h2 class="form-login-heading">Registrati!</h2>
				<div class="login-wrap">
					<label for="nome" class="col-sm-3 control-label">Nome</label>
					<div class="col-sm-9">
						<input type="text" style="font-family: Ruda" id="nome" placeholder="Nome"
							class="form-control" autofocus >
					</div>
				</div>


				<div class="login-wrap">
					<label for="cognome" class="col-sm-3 control-label">Cognome</label>
					<div class="col-sm-9">
						<input type="text" id="cognome" placeholder="Cognome"
							class="form-control" autofocus>
					</div>
				</div>


				<div class="login-wrap">
					<label for="email" class="col-sm-3 control-label">Email</label>
					<div class="col-sm-9">
						<input type="email" id="email" placeholder="Email"
							class="form-control">
					</div>
				</div>


				<div class="login-wrap">
					<label for="cellulare" class="col-sm-3 control-label">Cellulare</label>
					<div class="col-sm-9">
						<input type="text" id="cellulare" class="form-control"
							placeholder="(+39)---|-------">
					</div>
				</div>


				<div class="login-wrap">
					<label for="dataN" class="col-sm-3 control-label">Data</label>
					<div class="col-sm-9">
						<input type="data" id="dataN" class="form-control"
							placeholder="**/**/****">
					</div>
				</div>


				<div class="login-wrap">
					<label for="matricola" class="col-sm-3 control-label">Matricola</label>
					<div class="col-sm-9">
						<input type="matricola" id="matricola" class="form-control"
							placeholder="Matricola">
					</div>
				</div>


				<div class="login-wrap">
					<label for="password" class="col-sm-3 control-label">Password</label>
					<div class="col-sm-9">
						<input type="password" id="password" placeholder="Password"
							class="form-control">
					</div>
				</div>






				<br></br>
				<!-- /.form-group -->
				<div class="form-group">
					<button class="btn btn-theme btn-block" type="submit" style="font-family: Ruda">Registrati</button>
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
		$.backstretch("image/unisalr.jpg", {
			speed : 500
		});
	</script>
</body>
</html>