package fr.eni.bo;

public class Utilisateur {
    private String login;
    private String motDePasse;
    private String nom;
    private String prenom;
    private int numeroTelephone;

    public Utilisateur(String login, String motDePasse, String nom, String prenom, int numeroTelephone) {
        this.login = login;
        this.motDePasse = motDePasse;
        this.nom = nom;
        this.prenom = prenom;
        this.numeroTelephone = numeroTelephone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public int getNumeroTelephone() {
    	return numeroTelephone;
    }
    
    public void setNumeroTelephone(int numeroTelephone) {
    	this.numeroTelephone = numeroTelephone;
    }
}



