package fr.eni.bll;

import java.sql.SQLException;

import javax.naming.NamingException;

import fr.eni.bo.Utilisateur;
import fr.eni.dal.SQLController;

public class UtilisateurManager {

	private SQLController sqlController;

	public UtilisateurManager() {
		try {
			this.sqlController = new SQLController();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Utilisateur insertUtilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue, int cp, String ville, String password, int credit, int administrateur) throws SQLException, NamingException {
    	SQLController sqlController = new SQLController();
        // Vérification de la validité des données
    	

    	    // Vérification du pseudo
    	    if (pseudo == null || pseudo.trim().isEmpty()) {
    	        throw new IllegalArgumentException("Le pseudo est obligatoire.");
    	    } else if (!pseudo.matches("^[a-zA-Z0-9]*$")) {
    	        throw new IllegalArgumentException("Le pseudo ne doit contenir que des caractères alphanumériques.");
    	    } else if (sqlController.getUtilisateurByPseudo(pseudo) != null) {
    	        throw new IllegalArgumentException("Ce pseudo est déjà utilisé.");
    	    }

    	    // Vérification de l'email
    	    if (email == null || email.trim().isEmpty()) {
    	        throw new IllegalArgumentException("L'adresse email est obligatoire.");
    	    } else if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
    	        throw new IllegalArgumentException("L'adresse email est invalide.");
    	    } else if (sqlController.getUtilisateurByEmail(email) != null) {
    	        throw new IllegalArgumentException("Cette adresse email est déjà utilisée.");
    	    }

    	    // Vérification du mot de passe
    	    if (password == null || password.trim().isEmpty()) {
    	        throw new IllegalArgumentException("Le mot de passe est obligatoire.");
    	    } else if (password.length() < 8) {
    	        throw new IllegalArgumentException("Le mot de passe doit contenir au moins 8 caractères.");
    	    }

    	    // Insertion de l'utilisateur en base de données
    	    Utilisateur utilisateur = sqlController.insertUtilisateur(pseudo, nom, prenom, email, telephone, rue, cp, ville, password, 0, administrateur);
    	    
    	    return utilisateur;
    	

	// Insertion de l'utilisateur en base de données
	return sqlController.insertUtilisateur(pseudo,nom,prenom,email,telephone,rue,cp,ville,password,credit,administrateur);

	}

	public void modifierUtilisateur(Utilisateur utilisateur) throws SQLException {
    	SQLController sqlController = new SQLController();
        // Vérification de la validité des données
        
        // Modification de l'utilisateur en base de données
        sqlController.modifierUtilisateur(utilisateur);
    }

	public void supprimerUtilisateur(Utilisateur utilisateur) throws SQLException {
		SQLController sqlController = new SQLController();

		// Suppression de l'utilisateur en base de données
		sqlController.supprimerUtilisateur(utilisateur);
	}
	// Ajouter ici d'autres méthodes si besoin
}
