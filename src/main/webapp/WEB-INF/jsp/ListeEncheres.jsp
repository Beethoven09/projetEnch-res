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
	          <a href="NouvelleVente">Enchères</a>|	<a href="NouvelleVente" >Vendre un article</a>	| <a href="MonProfil">Mon profil</a> | <a href="Accueil">Déconnexion</a> | 
			
		</div>

		<h1>ENI-Enchères</h1>
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
				
   <div>
  <h3>Achats</h3>
  <ul>
    <li>
      <input type="checkbox" id="ench-open" name="ench-ouverte">
      <label for="ench-ouverte">Enchères ouvertes</label>
    </li>
    <li>
      <input type="checkbox" id="ench-cours" name="ench-cours">
      <label for="ench-cours">Mes enchères en cours</label>
    </li>
    <li>
      <input type="checkbox" id="ench-remporte" name="ench-remporte">
      <label for="ench-remporte">Mes enchères remportées</label>
    </li>
  </ul>
</div>

<div>
  <h3>Mes ventes</h3>
  <ul>
    <li>
      <input type="checkbox" id="ventes-cours" name="ventes-cours">
      <label for="ventes-cours">Mes ventes en cours</label>
    </li>
    <li>
      <input type="checkbox" id="ventes-non-debutees" name="ventes-non-debutees">
      <label for="ventes-non-debutees">Ventes non débutées</label>
    </li>
    <li>
      <input type="checkbox" id="ventes-terminees" name="ventes-terminees">
      <label for="ventes-terminees">Ventes terminées</label>
    </li>
  </ul>
</div>
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
					Fin de l'enchère : 10/08/2018<br> vendeur: <a href="MonProfil"> Jojo44</a>
				</p>

			</div>
			<div class="d-flex">
				<img src="images/rocket.jpg" alt="Rocket stove pour riz et pâtes"
					width="150px">
				<p class="ml-2">
					<a href="MesVentes">Rocket stove pour riz et pâtes</a><br> Prix : 185
					points<br> Fin de l'enchère : 09/08/2018<br> vendeur: <a href="MonProfil"> Jiji56</a>
				</p>
			</div>
		</div>
	</div>
	</div>

</body>
</html>