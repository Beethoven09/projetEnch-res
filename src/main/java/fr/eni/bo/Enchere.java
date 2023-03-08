package fr.eni.bo;

import java.time.LocalDateTime;

public class Enchere {

	
    private int id;
    private Utilisateur acheteur;
    private ArticleVendu article;
    private LocalDateTime dateEnchere;
    private int montantEnchere;


    public Enchere(ArticleVendu article, Utilisateur utilisateur, LocalDateTime dateEnchere, int montant) {
        this.article = article;
        this.acheteur = utilisateur;
        this.dateEnchere = dateEnchere;
        this.montantEnchere = montant;
    }




    public Enchere(Utilisateur acheteur, ArticleVendu article, int montantEnchere) {
        this.acheteur = acheteur;
        this.article = article;
        this.dateEnchere = LocalDateTime.now();
        this.montantEnchere = montantEnchere;
    }




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public Utilisateur getAcheteur() {
		return acheteur;
	}




	public void setAcheteur(Utilisateur acheteur) {
		this.acheteur = acheteur;
	}




	public ArticleVendu getArticle() {
		return article;
	}




	public void setArticle(ArticleVendu article) {
		this.article = article;
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




}
