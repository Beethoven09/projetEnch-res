package fr.eni.bll;

import fr.eni.bo.Enchere;
import fr.eni.bo.EtatVente;
import fr.eni.bo.Utilisateur;
import fr.eni.bo.ArticleVendu;

public class Acheter {

	private ArticleVendu articleEnVente;
	private Enchere enchereActuelle;

	public void acheter(Utilisateur acheteur, int prix) throws BLLException {
		// Vérification que l'article est en vente
		if (articleEnVente.getEtatVente() != EtatVente.EN_VENTE) {
			throw new BLLException("Cet article n'est pas en vente.");
		}

		// Vérification que le prix proposé est supérieur au prix de l'enchère actuelle
		if (enchereActuelle != null && prix <= enchereActuelle.getMontantEnchere()) {
			throw new BLLException("Le prix proposé est inférieur ou égal au prix de l'enchère actuelle.");
		}

		// Création de la nouvelle enchère
		Enchere nouvelleEnchere = new Enchere(acheteur, articleEnVente, prix);

		// Mise à jour de l'article et de l'enchère associée
		articleEnVente.setEtatVente(EtatVente.EN_COURS);
		enchereActuelle = nouvelleEnchere;
	}

	// Getters et Setters

	public ArticleVendu getArticleEnVente() {
		return articleEnVente;
	}

	public void setArticleEnVente(ArticleVendu articleEnVente) {
		this.articleEnVente = articleEnVente;
	}

	public Enchere getEnchereActuelle() {
		return enchereActuelle;
	}

	public void setEnchereActuelle(Enchere enchereActuelle) {
		this.enchereActuelle = enchereActuelle;
	}
}
