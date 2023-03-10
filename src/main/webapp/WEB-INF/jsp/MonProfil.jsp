<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mon profil</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"> 
<link rel="stylesheet" href="css/main.css">
</head>
<body>

<h2>Mon profil</h2>
<form method="post" action="ModifProfil" class="pt-5 pr-4">
<div>
  <p>Pseudo : ${User.pseudo}</p>
</div>

<div id="formulaire" style="display:block;">
  <label for="nom" class="col-sm-2 col-form-label">Nom : ${User.nom}</label><br>
<label for="prenom" class="col-sm-2 col-form-label">Prénom : ${User.prenom}</label><br>
<label for="email" class="col-sm-2 col-form-label">Email : ${User.email}</label><br>
 <label for="telephone" class="col-sm-2 col-form-label">Téléphone : ${User.telephone}</label><br>
<label for="rue" class="col-sm-2 col-form-label">Rue : ${User.rue}</label><br>
<label for="postal" class="col-sm-2 col-form-label">Code postal : ${User.cp}</label><br>
<label for="ville" class="col-sm-2 col-form-label">Ville : ${User.ville}</label><br>

</div>
<button id="modifier" class="col-sm-2 col-form-label">Modifier</button>
</form>
<a href="ListeEncheres" class="btn btn-primary">Aller aux enchères</a>


</body>
</html>