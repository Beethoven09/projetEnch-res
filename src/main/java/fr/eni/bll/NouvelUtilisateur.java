package fr.eni.bll;

import fr.eni.bo.Password;
import fr.eni.bo.Utilisateur;

public class NouvelUtilisateur extends Utilisateur {
    // Ajouter les nouveaux attributs et/ou méthodes spécifiques à NouvelUtilisateur
}
	
	public boolean createNewUser(String pseudo, String nom, String prenom, String email, String telephone, String rue,
            String codePostal, String ville, String motDePasse) throws BLLException {
boolean isUserCreated = false;

// Vérification si le pseudo et l'email sont déjà utilisés
if (utilisateurDAO.getByPseudo(pseudo) != null || utilisateurDAO.getByEmail(email) != null) {
throw new BLLException("Le pseudo ou l'email est déjà utilisé");
}

// Vérification que le pseudo ne contient que des caractères alphanumériques
if (!pseudo.matches("^[a-zA-Z0-9]+$")) {
throw new BLLException("Le pseudo ne doit contenir que des caractères alphanumériques");
}

// Hashage du mot de passe avant de l'enregistrer en base de données
String salt = Password.generateSalt(16);
String hashedPassword = Password.hashPassword(motDePasse, salt);

// Création de l'utilisateur
Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, hashedPassword, salt, 0);

try {
// Ajout de l'utilisateur en base de données
utilisateurDAO.insert(utilisateur);
isUserCreated = true;
} catch (DAOException e) {
throw new BLLException("Erreur lors de la création de l'utilisateur", e);
}

return isUserCreated;
}


}
