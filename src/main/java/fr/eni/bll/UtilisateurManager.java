package fr.eni.bll;

import java.sql.SQLException;

import javax.naming.NamingException;

import fr.eni.bo.Password;
import fr.eni.bo.Utilisateur;
import fr.eni.dal.UserDAO;

public class UtilisateurManager {

	public static Utilisateur insertUtilisateur(String pseudo, String prenom, String nom, String email,
			String telephone, String rue, int cp, String ville, String password) throws SQLException, NamingException {

		// Vérification de la validité des données

		// Vérification du pseudo
		if (pseudo == null || pseudo.trim().isEmpty()) {
			throw new IllegalArgumentException("Le pseudo est obligatoire.");
		} else if (!pseudo.matches("^[a-zA-Z0-9]*$")) {
			throw new IllegalArgumentException("Le pseudo ne doit contenir que des caractères alphanumériques.");
		}

		// Vérification de l'email
		if (email == null || email.trim().isEmpty()) {
			throw new IllegalArgumentException("L'adresse email est obligatoire.");
		} else if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
			throw new IllegalArgumentException("L'adresse email est invalide.");
		}

		// Vérification du mot de passe
		if (password == null || password.trim().isEmpty()) {
			throw new IllegalArgumentException("Le mot de passe est obligatoire.");
		} else if (password.length() < 8) {
			throw new IllegalArgumentException("Le mot de passe doit contenir au moins 8 caractères.");
		}

		// Initialisation de la connexion à la base de données
		UserDAO sql = new UserDAO();

		// Si le pseudo existe
		if (sql.ckeckIfPseudoExist(pseudo)) {
			throw new IllegalArgumentException("Ce pseudo est déjà utilisé.");
		}

		// Si le mail existe
		if (sql.ckeckIfEmailExist(email)) {
			throw new IllegalArgumentException("Cette adresse email est déjà utilisée.");
		}

		// On génère le mot de passe + on récupère le salt
		String passwordBuilder = Password.genererPassword(password);
		String pass = passwordBuilder.split(";")[0];
		String salt = passwordBuilder.split(";")[1];

		// On construit l'utilisateur
		Utilisateur user = new Utilisateur(pseudo, prenom, nom, email, telephone, rue, cp, ville, 0, 0);

		// Insertion de l'utilisateur en BDD
		if (sql.add(user, pass, salt)) {
			return user;
		} else {
			throw new IllegalArgumentException("Une erreur est survenue lors de l'ajout à la BDD.");
		}

	}

	public boolean modifierUtilisateur(Utilisateur user, String pseudo, String nom, String prenom, String email,
			String telephone, String rue, int cp, String ville, String password, int administrateur)
			throws SQLException, NamingException {
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
		UserDAO sql = new UserDAO();
		if (sql.update(user)) {
			user.setPseudo(pseudo);
			user.setNom(nom);
			user.setPrenom(prenom);
			user.setEmail(email);
			user.setTelephone(telephone);
			user.setRue(rue);
			user.setCp(cp);
			user.setVille(ville);
			user.setAdministrateur(administrateur);

			return true;
		} else {
			throw new IllegalArgumentException(
					"Une erreur est survenue lors de la modification de l'utilisateur dans la base de données.");
		}

	}

	public boolean supprimerUtilisateur(Utilisateur user) throws BLLException, NamingException {
		// Vérification de l'existence de l'utilisateur
		Utilisateur utilisateurBdd = UtilisateurManager.getUtilisateurById(user.getId());
		if (utilisateurBdd == null) {
			throw new BLLException("L'utilisateur n'existe pas.");
		}

		if (!ArticleVenduManager.articlesEnVenteParUtilisateur(user).isEmpty()) {
			throw new BLLException("L'utilisateur a des articles en vente et ne peut pas être supprimé.");
		}

		// BDD suppression stp
		UserDAO sql = new UserDAO();

		sql.delete(user);
		return true;
	}

	// methodes

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