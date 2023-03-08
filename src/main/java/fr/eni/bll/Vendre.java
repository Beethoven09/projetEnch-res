package fr.eni.bll;

<<<<<<< HEAD

public void Vendre(Utilisateur vendeur, int prixInitial) throws BLLException {
    // Vérification que l'article n'est pas déjà en vente
    if (this.etatVente != EtatVente.RETIRE && this.etatVente != EtatVente.NON_DEBUTE) {
        throw new BLLException("Cet article est déjà en vente ou a été vendu.");
    }

    // Création de la nouvelle enchère associée à l'article
    Enchere nouvelleEnchere = new Enchere(vendeur, this, prixInitial);

    // Mise à jour de l'article et de l'enchère associée
    this.setEnchereActuelle(nouvelleEnchere);
    this.setEtatVente(EtatVente.EN_VENTE);
	}

}
=======
import fr.eni.bo.Enchere;

public class Vendre {
	// TODO : Le code suivant comporte est en cours, celui-ci peut comporter des erreurs
	
	public void Vendre(Utilisateur vendeur, int prixInitial) throws BLLException {
		// Vérification que l'article n'est pas déjà en vente
		if (this.etatVente != EtatVente.RETIRE && this.etatVente != EtatVente.NON_DEBUTE) {
			throw new BLLException("Cet article est déjà en vente ou a été vendu.");
		}

		// Création de la nouvelle enchère associée à l'article
		Enchere nouvelleEnchere = new Enchere(vendeur, this, prixInitial);

		// Mise à jour de l'article et de l'enchère associée
		this.setEnchereActuelle(nouvelleEnchere);
		this.setEtatVente(EtatVente.EN_VENTE);
	}
}
>>>>>>> refs/heads/master
