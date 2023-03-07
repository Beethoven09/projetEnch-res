package fr.eni.bll;

public void acheter(Utilisateur acheteur, int prix) throws BLLException {
    // Vérification que l'article est en vente
    if (this.etatVente != EtatVente.EN_VENTE) {
        throw new BLLException("Cet article n'est pas en vente.");
    }

    // Vérification que le prix proposé est supérieur au prix de l'enchère actuelle
    if (this.enchereActuelle != null && prix <= this.enchereActuelle.getMontantEnchere()) {
        throw new BLLException("Le prix proposé est inférieur ou égal au prix de l'enchère actuelle.");
    }

    // Création de la nouvelle enchère
    Enchere nouvelleEnchere = new Enchere(acheteur, this, prix);

    // Mise à jour de l'article et de l'enchère associée
    this.setEnchereActuelle(nouvelleEnchere);
    this.setEtatVente(EtatVente.EN_COURS);
	}

}

