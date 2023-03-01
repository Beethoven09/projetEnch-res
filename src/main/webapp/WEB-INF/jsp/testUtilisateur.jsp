<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Exemple pour un utilisateur</title>
</head>
<body>
    <h1>Exemple pour un utilisateur</h1>
        <p>
        	ID: ${User.id} <br>
        	pseudo: ${User.pseudo} <br>
        	nom: ${User.nom} <br>
        	prénom: ${User.prenom} <br>
        	email: ${User.email} <br>
        	téléphone: ${User.telephone} <br>
        	rue: ${User.rue} <br>
        	code postal: ${User.cp} <br>
        	ville: ${User.ville} <br>
        	credit: ${User.credit} <br>
        	admin: ${User.administrateur}
        </p>
</body>
</html>