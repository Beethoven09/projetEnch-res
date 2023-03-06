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

	public boolean insertUtilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue, int cp, String ville, String password, int credit, int administrateur) throws SQLException, NamingException {
    	SQLController sqlController = new SQLController();
        // Vérification de la validité des données
    	

    	    // Vérification du pseudo
    	    if (pseudo == null || pseudo.trim().isEmpty()) {
    	        throw new IllegalArgumentException("Le pseudo est obligatoire.");
    	    } else if (!pseudo.matches("^[a-zA-Z0-9]*$")) {
    	        throw new IllegalArgumentException("Le pseudo ne doit contenir que des caractères alphanumériques.");
    	    } else if (sqlController.ckeckIfEmailExist(email)) {
    	        throw new IllegalArgumentException("Ce pseudo est déjà utilisé.");
    	    }

    	    // Vérification de l'email
    	    if (email == null || email.trim().isEmpty()) {
    	        throw new IllegalArgumentException("L'adresse email est obligatoire.");
    	    } else if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
    	        throw new IllegalArgumentException("L'adresse email est invalide.");
    	    } else if (sqlController.ckeckIfEmailExist(email)) {
    	        throw new IllegalArgumentException("Cette adresse email est déjà utilisée.");
    	    }


    	    // Vérification du mot de passe
    	    if (password == null || password.trim().isEmpty()) {
    	        throw new IllegalArgumentException("Le mot de passe est obligatoire.");
    	    } else if (password.length() < 8) {
    	        throw new IllegalArgumentException("Le mot de passe doit contenir au moins 8 caractères.");
    	    }

    	    // Insertion de l'utilisateur en base de données
    	    Utilisateur user = new Utilisateur (pseudo, nom, prenom, email, telephone, rue, cp, ville, password, credit, administrateur);
    	    SQLController sql = new SQLController();
    	    
    	    return sql.insertUtilisateur(user);

	}

	public boolean modifierUtilisateur(Utilisateur utilisateur, String pseudo, String nom, String prenom, String email, String telephone, String rue, int cp, String ville, String password, Utilisateur user) throws SQLException {
	    // Vérification de la validité des données
	    if (!isValidPseudo(pseudo)) {
	        throw new IllegalArgumentException("Le pseudo doit contenir uniquement des caractères alphanumériques.");
	    }
	    if (!isValidEmail(email)) {
	        throw new IllegalArgumentException("L'adresse email est invalide.");
	    }
	    if (!isValidPhoneNumber(telephone)) {
	        throw new IllegalArgumentException("Le numéro de téléphone est invalide.");
	    }
	    if (!isValidPostalCode(cp)) {
	        throw new IllegalArgumentException("Le code postal doit être composé de 5 chiffres.");
	    }
	    // Modification de l'utilisateur en base de données
	    utilisateur.setPseudo(pseudo);
	    utilisateur.setNom(nom);
	    utilisateur.setPrenom(prenom);
	    utilisateur.setEmail(email);
	    utilisateur.setTelephone(telephone);
	    utilisateur.setRue(rue);
	    utilisateur.setCp(cp);
	    utilisateur.setVille(ville);
	    SQLController sql = null;
		try {
			sql = new SQLController();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return sql.modifierUtilisateur(user);
	}

	public boolean supprimerUtilisateur(Utilisateur user) throws BLLException {
	    // Vérification de l'existence de l'utilisateur
	    Utilisateur utilisateurBdd = UtilisateurManager.getUtilisateurById(user.getId());
	    if (utilisateurBdd == null) {
	        throw new BLLException("L'utilisateur n'existe pas.");
	    }
	    
	    // Vérification de la suppression des clés étrangères
	    if (!ArticleManager.articlesEnVenteParUtilisateur(user).isEmpty()) {
	        throw new BLLException("L'utilisateur a des articles en vente et ne peut pas être supprimé.");
	    }
	    
	    SQLController sql = null;
		try {
			sql = new SQLController();
		} catch (NamingException e) {
			e.printStackTrace();
		};
		sql.supprimerUtilisateur(user);
		return true;
	}

	
	//methodes

		private static Utilisateur getUtilisateurById(int id) {
		return null;
		}

		private boolean isValidPseudo(String pseudo) {
			return false;
		}

		private boolean isValidEmail(String email) {
			return false;
		}

		private boolean isValidPhoneNumber(String telephone) {
			return false;
		}

		private boolean isValidPostalCode(int cp) {
			return false;
		}
	// Ajouter ici d'autres méthodes si besoin
}
