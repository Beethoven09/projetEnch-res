package fr.eni.bll;

import java.time.LocalDateTime;

import fr.eni.bo.ArticleVendu;
import fr.eni.bo.EtatVente;
import fr.eni.bo.Utilisateur;

public class EnchereManager {

    private LocalDateTime dateEnchere;
    private int montantEnchere;
    private Utilisateur utilisateur;
    private ArticleVendu article;

    public EnchereManager(Utilisateur utilisateur, ArticleVendu article, int montantEnchere) {
        this.dateEnchere = LocalDateTime.now();
        this.utilisateur = utilisateur;
        this.article = article;
        this.montantEnchere = montantEnchere;
    }

    public void encherir(Utilisateur acheteur, int prix) throws BLLException {
        // Vérification que l'article est en vente
        if (article.getEtatVente() != EtatVente.EN_VENTE) {
            throw new BLLException("Cet article n'est pas en vente.");
        }

        // Vérification que le prix proposé est supérieur au prix de l'enchère actuelle
        if (montantEnchere > 0 && prix <= montantEnchere) {
            throw new BLLException("Le prix proposé est inférieur ou égal au prix de l'enchère actuelle.");
        }

        // Création de la nouvelle enchère
        EnchereManager nouvelleEnchere = new EnchereManager(acheteur, article, prix);

        // Mise à jour de l'article et de l'enchère associée
        article.setEtatVente(EtatVente.EN_COURS);
        this.montantEnchere = prix;
        this.dateEnchere = LocalDateTime.now();
        this.utilisateur = acheteur;
    }

	public LocalDateTime getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(LocalDateTime dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public int getMontantEnchere() {
		return montantEnchere;
	}

	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public ArticleVendu getArticle() {
		return article;
	}

	public void setArticle(ArticleVendu article) {
		this.article = article;
	}

   
}

