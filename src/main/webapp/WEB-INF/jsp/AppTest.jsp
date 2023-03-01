<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/main.css" />
    <title></title>
</head>
<body>
             <h1>Bienvenue</h1>
      <form method="post" action="register">
            <label>Nom d'utilisateur:</label>
            <input type="text" name="username"><br>
            <label>Mot de passe:</label>
            <input type="password" name="password"><br>
            <label>Email:</label>
            <input type="email" name="email"><br>
            <!-- autres informations utilisateur -->
            <input type="submit" value="S'inscrire">
      
      
  <label>Nom d'utilisateur:</label>
  <input type="text" name="username"><br>
  <label>Mot de passe:</label>
  <input type="password" name="password"><br>
  <input type="submit" value="Se connecter">
  <input type="checkbox" name="remember-me" 
  value="true">Se souvenir de moi<br>
 </form>

    <!-- afficher un message d'erreur si la connexion échoue -->
 <c:if test="${not empty error}">
  <p></p>
 </c:if>
 
<h2>inscription</h2><br><br>
     
     
     <p>Vous êtes connecté en tant que</p><br>
    
 <a href="logout">Se déconnecter</a>
 
 <p>Crédits disponibles: 0 </p>
 <a href="buy-credit">Acheter des crédits</a>
 <h3>Achat de crédits</h3>
 <p>Prix des crédits: 1 euro = 10 crédits</p>
 <form method="post" action="buy-credit">
  <label>Montant en euros:</label>
  <input type="number" name="amount"><br>
  <input type="submit" value="Acheter">
 </form>



        
</body>

</html>
