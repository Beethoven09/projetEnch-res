package fr.eni.bo;

import java.time.LocalDateTime;

public class Article {
    private int id;
    private String nom;
    private String description;
    private String categorie;
    private int prixDepart;
    private LocalDateTime dateDebutEnchere;
    private LocalDateTime dateFinEnchere;
    private String adresseRetrait;
    private Utilisateur vendeur;
    
    // Constructeurs
    
    public Article(int id, String nom, String description, String categorie, int prixDepart,
                   LocalDateTime dateDebutEnchere, LocalDateTime dateFinEnchere, String adresseRetrait,
                   Utilisateur vendeur) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.categorie = categorie;
        this.prixDepart = prixDepart;
        this.dateDebutEnchere = dateDebutEnchere;
        this.dateFinEnchere = dateFinEnchere;
        this.adresseRetrait = adresseRetrait;
        this.vendeur = vendeur;
    }
    public Article(String nom, String description, String categorie, int prixDepart,
            LocalDateTime dateDebutEnchere, LocalDateTime dateFinEnchere, String adresseRetrait,
            Utilisateur vendeur) {
    	this.nom = nom;
    	this.description = description;
    	this.categorie = categorie;
    	this.prixDepart = prixDepart;
    	this.dateDebutEnchere = dateDebutEnchere;
    	this.dateFinEnchere = dateFinEnchere;
    	this.adresseRetrait = adresseRetrait;
    	this.vendeur = vendeur;
    }
    
    // Getters et setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getCategorie() {
        return categorie;
    }
    
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
    
    public int getPrixDepart() {
        return prixDepart;
    }
    
    public void setPrixDepart(int prixDepart) {
        this.prixDepart = prixDepart;
    }
    
    public LocalDateTime getDateDebutEnchere() {
        return dateDebutEnchere;
    }
    
    public void setDateDebutEnchere(LocalDateTime dateDebutEnchere) {
        this.dateDebutEnchere = dateDebutEnchere;
    }
    
    public LocalDateTime getDateFinEnchere() {
        return dateFinEnchere;
    }
    
    public void setDateFinEnchere(LocalDateTime dateFinEnchere) {
        this.dateFinEnchere = dateFinEnchere;
    }
    
    public String getAdresseRetrait() {
        return adresseRetrait;
    }
    
    public void setAdresseRetrait(String adresseRetrait) {
        this.adresseRetrait = adresseRetrait;
    }
    
    public Utilisateur getVendeur() {
        return vendeur;
    }
    
    public void setVendeur(Utilisateur vendeur) {
        this.vendeur = vendeur;
    }
}

