package fr.eni.bo;

import java.time.LocalDateTime;

public class Enchere {
    private Article article;
    private Utilisateur utilisateur;
    private LocalDateTime dateEnchere;
    private int montant;

    public Enchere(Article article, Utilisateur utilisateur, LocalDateTime dateEnchere, int montant) {
        this.article = article;
        this.utilisateur = utilisateur;
        this.dateEnchere = dateEnchere;
        this.montant = montant;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public LocalDateTime getDateEnchere() {
        return dateEnchere;
    }

    public void setDateEnchere(LocalDateTime dateEnchere) {
        this.dateEnchere = dateEnchere;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

}
