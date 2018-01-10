<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> TirocinioSmart </title>
</head>
<body>
	<div class="container">
		<form class="form-horizontal" role="form">
			<h2>Registrati!</h2>
			<div class="form-group">
				<label for="nome" class="col-sm-3 control-label">Nome</label>
				<div class="col-sm-9">
					<input type="text" id="nome" placeholder="Nome"
						class="form-control" autofocus>
				</div>
			</div>
			<div class="form-group">
				<label for="cognome" class="col-sm-3 control-label">Cognome</label>
				<div class="col-sm-9">
					<input type="text" id="cognome" placeholder="Cognome"
						class="form-control" autofocus>
				</div>
			</div>
			<div class="form-group">
				<label for="email" class="col-sm-3 control-label">Email</label>
				<div class="col-sm-9">
					<input type="email" id="email" placeholder="Email"
						class="form-control">
				</div>
			</div>
			<div class="form-group">
				<label for="cellulare" class="col-sm-3 control-label">Cellulare</label>
				<div class="col-sm-9">
					<input type="number" id="cellulare" class="form-control">
				</div>
			</div>
			<div class="form-group">
				<label for="dataN" class="col-sm-3 control-label">Data
					di Nascita</label>
				<div class="col-sm-9">
					<input type="data" id="dataN" class="form-control">
				</div>
			</div>
			<div class="form-group">
				<label for="matricola" class="col-sm-3 control-label">Matricola</label>
				<div class="col-sm-9">
					<input type="matricola" id="matricola" class="form-control">
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-3 control-label">Password</label>
				<div class="col-sm-9">
					<input type="password" id="password" placeholder="Password"
						class="form-control">
				</div>
			</div>
			
	</div>
	<!-- /.form-group -->
	<div class="form-group">
		<div class="col-sm-9 col-sm-offset-3">
			<button type="submit" class="btn btn-primary btn-block">Register</button>
		</div>
	</div>
	<!-- ./container -->
</body>
</html>