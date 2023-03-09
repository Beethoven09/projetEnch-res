package fr.eni.bll;

import java.time.LocalDateTime;

import fr.eni.bo.ArticleVendu;
import fr.eni.bo.Utilisateur;
import fr.eni.dal.DALException;
import fr.eni.dal.SQLController;
import fr.eni.dal.UserDAO;

public class ArticleManager {

	public ArticleVendu ajouterArticle(String nom, String description, String categorie, int prixDepart, LocalDateTime dateOuverture, LocalDateTime dateFin, String adresseRetrait, Utilisateur vendeur) throws BLLException {
	    // Vérification de la validité des données
	    if (nom == null || nom.trim().isEmpty()) {
	        throw new BLLException("Le nom de l'article ne peut pas être vide");
	    }
	    if (description == null || description.trim().isEmpty()) {
	        throw new BLLException("La description de l'article ne peut pas être vide");
	    }
	    if (categorie == null || categorie.trim().isEmpty()) {
	        throw new BLLException("La catégorie de l'article ne peut pas être vide");
	    }
	    if (prixDepart <= 0) {
	        throw new BLLException("Le prix de départ doit être supérieur à zéro");
	    }
	    if (dateOuverture == null || dateFin == null || dateOuverture.isAfter(dateFin)) {
	        throw new BLLException("La date d'ouverture doit être antérieure à la date de fin");
	    }
	    if (adresseRetrait == null || adresseRetrait.trim().isEmpty()) {
	        throw new BLLException("L'adresse de retrait ne peut pas être vide");
	    }
	    if (vendeur == null) {
	        throw new BLLException("Le vendeur ne peut pas être null");
	    }

	    // Insertion de l'article en base de données
	    ArticleVendu article = new ArticleVendu();
	    try {
	        UserDAO.getInstance().insertArticle(article);
	    } catch (DALException e) {
	        throw new BLLException("Erreur lors de l'insertion de l'article en base de données", e);
	    }
	    return article;
	}

	public static String articlesEnVenteParUtilisateur(Utilisateur utilisateur) {
		return null;
	}
}
