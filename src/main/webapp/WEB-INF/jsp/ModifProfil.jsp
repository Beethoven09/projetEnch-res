<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modification du profil</title>
<link rel="stylesheet" href="css/Sign.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
</head>
<body>
	<h1>ENI-Enchères</h1>
	<h2>Mon profil</h2>

	<!-- Table pour mettre les infos en colonne -->

	<div class="form-group">
		<label for="pseudo" class="col-sm-2 col-form-label">Pseudo :</label> <input
			type="text" id="pseudo" name="pseudo" class="form-control col-sm-4"
			required> <label for="nom" class="col-sm-2 col-form-label">Nom
			:</label> <input type="text" id="nom" name="nom"
			class="form-control col-sm-4" required>
	</div>
	<div class="form-group">
		<label for="prenom" class="col-sm-2 col-form-label">Prénom :</label> <input
			type="text" id="prenom" name="prenom" class="form-control col-sm-4"
			required> <label for="email" class="col-sm-2 col-form-label">Email
			:</label> <input type="text" id="email" name="email"
			class="form-control col-sm-4" required>
	</div>
	<div class="form-group">
		<label for="telephone" class="col-sm-2 col-form-label">Téléphone
			:</label> <input type="text" id="telephone" name="telephone"
			class="form-control col-sm-4"> <label for="rue"
			class="col-sm-2 col-form-label">Rue :</label> <input type="text"
			id="rue" name="rue" class="form-control col-sm-4" required>
	</div>
	<div class="form-group">
		<label for="code_postal" class="col-sm-2 col-form-label">Code
			postal :</label> <input type="text" id="code_postal" name="code_postal"
			class="form-control col-sm-4" required> <label for="ville"
			class="col-sm-2 col-from-label">Ville :</label> <input type="text"
			id="ville" name="ville" class="form-control col-sm-4" required>
	</div>
	<div class="form-group">
		<label for="mot_de_passe" class="col-sm-2 col-form-label">Mot
			de passe actuel :</label> <input type="password" id="mot_de_passe"
			name="mot_de_passe" class="form-control col-sm-4" required> <label
			for="confirmation" class="col-sm-2 col-form-label">Confirmation
			:</label> <input type="password" id="confirmation" name="confirmation"
			class="form-control col-sm-4" required><br>
	</div>
	<div>
		<label for="mot_de_passe" class="col-sm-2 col-form-label">Nouveau
			mot de passe :</label> <input type="password" id="mot_de_passe"
			name="mot_de_passe" class="form-control col-sm-4 " required>
	</div>

	<label for="Crédits" class="col-sm-2 col-form-label">Crédits
		640  </label> 
	<div class="p-5">
		<button class="btn btn-primary mr-5" type="submit">Enregitrer</button>
		<a class="btn btn-light" href="">Supprimer mon compte</a>
	</div>

</body>
</html>