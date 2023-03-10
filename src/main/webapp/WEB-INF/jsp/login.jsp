<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion</title>
<link rel="stylesheet"
	 href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"> 
<link rel="stylesheet" href="css/login.css">


</head>
<body>
   <div class="container">
		<form method="post" action="Login">
			<h1>ENI-Enchères</h1>
            <input type="text" id="login" name="login" placeholder="identifiant" required><br>
			<input type="password" name="password" placeholder="Mot de passe" required><br>
			<input type="submit" value="connexion">
			<input type="checkbox" id="rememberMe" name="rememberMe">
			<label for="remeberMe"> Se souvenir</label><br>
			<a href="MotDePasseOublie">Mot de passe oublié</a>
		</form>
		<div>
		<a href="Inscription" class="btn btn-outline-primary btn-block w-75 ml-5 mt-2 btn-xl">Créer un compte</a>
		
		</div>

		<div class="drop drop-1"></div>
		<div class="drop drop-2"></div>
		<div class="drop drop-3"></div>
		<div class="drop drop-4"></div>
		<div class="drop drop-5"></div>
	</div>
</body>
</html>






