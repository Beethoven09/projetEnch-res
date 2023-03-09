<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nouvelle vente</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="css/main.css">
</head>
<body>
	<h1>Nouvelle vente</h1>

	<form method="post" action="Inscription" class="pt-5 pr-4">
		<label for="article">Article :</label> <input type="text" id="article"
			name="article" required><br> <label for="description">Description
			:</label>
		<textarea id="description" name="description" rows="5" cols="50"
			required></textarea>
		<br> <label for="categorie">Catégorie :</label> <select
			id="categorie" name="categorie">
			<option></option>
			<option value="informatique">Informatique</option>
			<option value="ameublement">Ameublement</option>
			<option value="vêtements">Vêtements</option>
			<option value="sport&loisirs">Sport&loisirs</option>
		</select><br>

		<div class="form-group">
			<label for="photo">Photo :</label> <input type="file" id="photo"
				name="photo" accept="image/*" required><br> <label
				for="miseaprix" class="col-sm-2 col-form-label ">Mise à prix
				:</label> <input type="number" id="miseaprix" name="miseaprix" required><br>

			<label for="datedebut" class="col-sm-2 col-form-label">Début
				de l'enchère :</label> <input type="datetime-local" id="datedebut"
				name="datedebut" required><br> <label for="datefin"
				class="col-sm-2 col-form-label">Fin de l'enchère :</label> <input
				type="datetime-local" id="datefin" name="datefin" required><br>

			<label for="rue" class="col-sm-2 col-form-label">Rue :</label> <input
				type="text" id="rue" name="rue" value="Rue des mouettes" required><br>

			<label for="codepostal" class="col-sm-2 col-form-label">Code
				postal :</label> <input type="text" id="codepostal" name="codepostal"
				value="44800" required><br> <label for="ville"
				class="col-sm-2 col-form-label">Ville :</label> <input type="text"
				id="ville" name="ville" value="Saint-Herblain" required><br>
		</div>
		<div class="p-5">
			<button class="btn btn-primary mr-5" type="submit">Enregistrer</button>
			<a class="btn btn-light" href="ListeEncheres">Annuler</a>
			<a class="btn btn-light" href="ListeEncheres">Annuler la vente </a>

		</div>

	</form>

</body>
</html>