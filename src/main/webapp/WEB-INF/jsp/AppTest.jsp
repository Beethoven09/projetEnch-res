<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<title>ENI ENCHERES</title>
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>

<body>
	<header>
		<h1>ENI-ENCHERES</h1>

		<div id="header-user-account">
			<!-- options utilisateur -->
			<a href="#">S'inscrire</a> | <a href="#">Se connecter</a>
		</div>

	</header>
	<main>
		<h2>Bienvenue sur notre site d'enchères en ligne !</h2>
		<h5>Connectez-vous ou inscrivez-vous pour commencer à enchérir
			sur vos articles préférés.</h5>
	</main>
	<h5>Liste des enchères</h5>
	<p>Filtres:</p>
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<div class="form-group">
					<label for="category-select">Catégorie :</label> <select
						class="form-control" id="category-select">
						<option>Toutes</option>
						<option>Informatique</option>
						<option>Ameublement</option>
						<option>Vêtement</option>
						<option>Sport&Loisir</option>
					</select>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group">
					<label for="search-input">Rechercher :</label> <input type="text"
						class="form-control" id="search-input"
						placeholder="Le nom de l'article contient...">
				</div>
			</div>
			<div class="col-md-4">
				<button type="button" class="btn btn-primary btn-block">Rechercher</button>
			</div>
		</div>
		<div>
			<div class="d-flex">
				<img src="images/pc.jpg" alt="Pc gamer pour travailler"
					width="120px">
				<p class="ml-2">
					<a href="#">Pc gamer pour travailler</a><br> Prix : 210 points<br>
					Fin de l'enchère : 10/08/2018<br> Vendeur : Jojo44
				</p>

			</div>
			<div class="d-flex">
				<img src="images/rocket.jpg" alt="Rocket stove pour riz et pâtes"
					width="120px">
				<p class="ml-2">
					Prix : 185 points<br> Fin de l'enchère : 10/08/2018<br>
					Vendeur : Jojo44
				</p>
			</div>
		</div>
	</div>
</body>
</html>