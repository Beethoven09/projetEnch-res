<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ListeEncheres</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"> 
<link rel="stylesheet" href="css/main.css">
</head>
<body>
<div id="body" class="mx-auto mt-5 ">

	<header id="header-connexion">
	<div class="text-right mr-2 mb-4 mt-1">
			<!-- options utilisateur -->
	          <a href="NouvelleVente">Enchères</a>|	<a href="NouvelleVente" >Vendre un article</a>	| <a href="inscription">Mon profil</a> | <a href="Accueil">Déconnexion</a> | 
			
		</div>

		<h1>Liste des enchères</h1>
		<br><br>
		</header>
	<main>
		<!-- création de la liste des enchères -->
	</main>
	<br><br>
	<h5>Liste des enchères :</h5>
	<br>
	
	<div class="container">
		<div class="row mx-auto" id="row-categories">
			<div
				class="d-flex align-items-end mb-5 bd-highlight text-center w-100">
				<div class="flex-fill bd-highlight mx-1">
					<div class="form-group mb-0">
						<label for="category-select">Catégorie :</label> <select
							class="form-control" id="category-select">
							<option>Toutes</option>
							<option>Informatique</option>
							<option>Ameublement</option>
							<option>Vêtement</option>
							<option>Sport&Loisirs</option>
						</select>
					</div>
				
				</div>
				<aside>
   <h2>Achats et ventes</h2>
   <!-- Liste des achats et des ventes -->
   <ul>
    <li>
     <label for="achats">Achats:</label>
     <select id="achats" name="achats">
      <option value="article1">enchères ouvertes</option>
      <option value="article2">mes enchères ouvertes</option>
      <option value="article3">mes enchères remportées</option>
     
     </select>
    </li>
    <li>
     <label for="ventes">Ventes:</label>
     <select id="ventes" name="ventes">
      <option value="article1">mes ventes en cours</option>
      <option value="article2">ventes non débutées</option>
      <option value="article3">ventes terminées</option>
     </select>
    </li>
   </ul>
  </aside>
				
				<!-- Création de la barre de recherche avec bootstrap -->
				<div class="flex-fill bd-highlight mx-1">
					<div class="form-group mb-0">
						<label for="search-input">Rechercher :</label> <input type="text"
							class="form-control" id="search-input"
							placeholder="Le nom de l'article contient...">
					</div>
				</div>
				<div class="flex-fill bd-highlight mx-1">
					<button type="button" class="btn btn-primary btn-block">Rechercher</button>
				</div>
			</div>
		</div>

		<div class="d-flex justify-content-between">
			<!-- Insertion des images -->
			<div class="d-flex">
				<img src="images/pc.jpg" alt="Pc gamer pour travailler"
					width="150px">
				<p class="ml-2">
					<a href="#">Pc gamer pour travailler</a><br> Prix : 210 points<br>
					Fin de l'enchère : 10/08/2018<br> Vendeur : Jojo44
				</p>

			</div>
			<div class="d-flex">
				<img src="images/rocket.jpg" alt="Rocket stove pour riz et pâtes"
					width="150px">
				<p class="ml-2">
					<a href="#">Rocket stove pour riz et pâtes</a><br> Prix : 185
					points<br> Fin de l'enchère : 10/08/2018<br> Vendeur :
					Jiji56
				</p>
			</div>
		</div>
	</div>
	</div>

</body>
</html>