package fr.eni.bo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connexion {
    private Utilisateur utilisateurConnecte;

    public boolean verifierLogin(String login, String motDePasse) {
        // Connexion à la base de données
        Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdd_encheres", "username", "password");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

        // Requête pour récupérer l'utilisateur correspondant au login et au mot de passe
        String requete = "SELECT * FROM utilisateurs WHERE login = ? AND mot_de_passe = ?";
        PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(requete);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
        try {
			statement.setString(1, login);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
        try {
			statement.setString(2, motDePasse);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
        ResultSet result = null;
		try {
			result = statement.executeQuery();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

        // Si un utilisateur est trouvé, on le connecte et on retourne true
        try {
			if (result.next()) {
			    utilisateurConnecte = new Utilisateur(result.getString("pseudo"), result.getString("nom"), result.getString("prenom"), result.getString("email"), result.getInt("numeroTelephone"), result.getString("rue"), result.getInt("cp"), result.getString("ville"), result.getString("password"), result.getInt("credit"), result.getString("administrateur"));
			    return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

        // Sinon, on retourne false
        return false;
    }

    public void connecter(Utilisateur utilisateur) {
        utilisateurConnecte = utilisateur;
    }

    public void deconnecter() {
        utilisateurConnecte = null;
    }

    public Utilisateur getUtilisateurConnecte() {
        return utilisateurConnecte;
    }
}
