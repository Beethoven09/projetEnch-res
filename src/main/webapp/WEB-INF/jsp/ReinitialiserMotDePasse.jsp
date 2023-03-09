<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Réinitialisation</title>
<link rel="stylesheet" href="css/Sign.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<h1>Réinitialisation mot de passe</h1>
	<form action="update-password" method="post">
		<label for="password">Nouveau mot de passe:</label> <input
			type="password" id="password" name="password" required> <label
			for="confirm-password">Confirmer le nouveau mot de passe:</label> <input
			type="password" id="confirm-password" name="confirm-password"
			required>
		<button type="submit">Enregistrer le nouveau mot de passe</button>
	</form>

</body>
</html>