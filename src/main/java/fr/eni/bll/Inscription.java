package fr.eni.bll;

public class Inscription {
	
	public Utilisateur inscription(String pseudo, String email, String password) throws UtilisateurDejaExistantException {
	    // Vérifier si l'utilisateur existe déjà avec le même pseudo ou email
	    if (utilisateurExisteParPseudo(pseudo)) {
	        throw new UtilisateurDejaExistantException("Le pseudo est déjà utilisé");
	    }
	    if (utilisateurExisteParEmail(email)) {
	        throw new UtilisateurDejaExistantException("L'email est déjà utilisé");
	    }
	    
	    // Vérifier si le pseudo contient uniquement des caractères alphanumériques
	    if (!pseudo.matches("^[a-zA-Z0-9]*$")) {
	        throw new IllegalArgumentException("Le pseudo ne doit contenir que des caractères alphanumériques");
	    }
	    
	    // Hasher le mot de passe avant de l'enregistrer
	    String salt = generateSalt();
	    String hashedPassword = hashPassword(password, salt);
	    
	    // Créer le nouvel utilisateur et l'ajouter à la base de données
	    Utilisateur nouvelUtilisateur = new Utilisateur(pseudo, email, hashedPassword, 0, salt);
	    ajouterUtilisateur(nouvelUtilisateur);
	    
	    return nouvelUtilisateur;
	}


}
