package fr.eni.bll;

import java.sql.SQLException;

import javax.naming.NamingException;

import fr.eni.bo.Utilisateur;
import fr.eni.dal.SQLController;

public class UtilisateurManager {

	/*private SQLController sqlController;

	public UtilisateurManager() {
		try {
			this.sqlController = new SQLController();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	public static boolean insertUtilisateur(Utilisateur user) throws SQLException, NamingException {
    	
        // Vérification de la validité des données
    	
    	// Vérification du pseudo
    	if (user.getPseudo() == null || user.getPseudo().trim().isEmpty()) {
	        throw new IllegalArgumentException("Le pseudo est obligatoire.");
	    } else if (!user.getPseudo().matches("^[a-zA-Z0-9]*$")) {
	        throw new IllegalArgumentException("Le pseudo ne doit contenir que des caractères alphanumériques.");
	    }
    	
    	// Vérification de l'email
    	if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
	        throw new IllegalArgumentException("L'adresse email est obligatoire.");
	    } else if (!user.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
	        throw new IllegalArgumentException("L'adresse email est invalide.");
	    }
    	
    	// Vérification du mot de passe
	    if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
	        throw new IllegalArgumentException("Le mot de passe est obligatoire.");
	    } else if (user.getPassword().length() < 8) {
	        throw new IllegalArgumentException("Le mot de passe doit contenir au moins 8 caractères.");
	    }
    	
    	// Initialisation de la connexion à la base de données
	    SQLController sqlController = new SQLController();
	    
	    // Si le pseudo existe
	    if (sqlController.ckeckIfPseudoExist(user.getPseudo())) {
	        throw new IllegalArgumentException("Ce pseudo est déjà utilisé.");
	    }
	    
	    // Si le mail existe
	    if (sqlController.ckeckIfEmailExist(user.getEmail())) {
	        throw new IllegalArgumentException("Cette adresse email est déjà utilisée.");
	    }
	    
	    // Insertion de l'utilisateur en base de données
	    if(sqlController.insertUtilisateur(user)) {
	    	return true;
	    } else {
	    	System.out.println("Une erreur est survenue lors de l'ajout à la BDD.");
	    	return false;
	    }
	    
	}

	public boolean modifierUtilisateur(Utilisateur user, String pseudo, String nom, String prenom, String email, String telephone, String rue, int cp, String ville, String password, int administrateur) throws SQLException, NamingException {
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
	    // Modification de l'utilisateur en mémoire
	    user.setPseudo(pseudo);
	    user.setNom(nom);
	    user.setPrenom(prenom);
	    user.setEmail(email);
	    user.setTelephone(telephone);
	    user.setRue(rue);
	    user.setCp(cp);
	    user.setVille(ville);
	    user.setAdministrateur(administrateur);
	    SQLController sql = new SQLController();
	    return sql.modifierUtilisateur(user);
		}

	public boolean supprimerUtilisateur(Utilisateur user) throws BLLException, NamingException{
	    // Vérification de l'existence de l'utilisateur
	    Utilisateur utilisateurBdd = UtilisateurManager.getUtilisateurById(user.getId());
	    if (utilisateurBdd == null) {
	        throw new BLLException("L'utilisateur n'existe pas.");
	    }
	    
	    // Vérification de la suppression des clés étrangères
	    /*if (!ArticleManager.articlesEnVenteParUtilisateur(user).isEmpty()) {
	        throw new BLLException("L'utilisateur a des articles en vente et ne peut pas être supprimé.");
	    }*/
	    
	    // BDD suppression stp
	    SQLController sql = new SQLController();
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
