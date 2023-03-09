package fr.eni.bll;

import java.util.List;

import fr.eni.bo.ArticleVendu;
import fr.eni.bo.Enchere;
import fr.eni.bo.Utilisateur;

public class RetirerArticle {
	// TODO : Le code suivant comporte est en cours, celui-ci peut comporter des erreurs
	
    public void retirerArticle(ArticleVendu article, Utilisateur vendeur) throws BLLException {
       
    	// Vérification que l'utilisateur est bien le vendeur de l'article
        if (!article.getVendeur().equals(vendeur)) {
            throw new BLLException("Cet utilisateur n'est pas le vendeur de cet article.");
        }

        // Vérification que l'article n'a pas déjà été retiré ou vendu
        if (article.getEtatVente() != EtatVente.EN_COURS) {
            throw new BLLException("Cet article ne peut pas être retiré car il n'est pas en cours de vente.");
        }

        try {
            // Récupération des enchères associées à l'article
            List<Enchere> encheres = enchereManager.getEncheresByArticle(article);

            // Suppression des enchères associées à l'article
            for (Enchere enchere : encheres) {
                enchereManager.removeEnchere(enchere);
            }

            // Changement de l'état de vente de l'article à "Retiré"
            article.setEtatVente(EtatVente.RETIRE);
            articleManager.updateArticle(article);

        } catch (DALException e) {
            throw new BLLException("Une erreur est survenue lors de la suppression des enchères associées à l'article.", e);
        }
    }
}