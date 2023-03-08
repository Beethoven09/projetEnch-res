<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mot de passe oublié</title>
<link rel="stylesheet" href="css/Sign.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<h1>Mot de passe oublié</h1>
<form method="post" action="ReinitialisationMotDePasse">
<label for="email">Adresse email :</label>
<input type="email" name="email" id="email" required>
<button type="submit">Envoyer</button>
</form>
</body>
</html>