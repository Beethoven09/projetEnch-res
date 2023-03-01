package fr.eni.bo;

public class Utilisateur {
    private String pseudo;
    private String nom;
    private String prenom;
	private String email;
    private int numeroTelephone;
	private String rue;
	private int cp;
	private String ville;
	private String password;
	private int credit;
	private String administrateur;

    public Utilisateur(String pseudo, String nom, String prenom, String email, int numeroTelephone, String rue, int cp, String ville, String password, int credit, String administrateur) {
        this.pseudo = pseudo;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.numeroTelephone = numeroTelephone;
        this.rue = rue;
        this.cp = cp;
        this.ville = ville;
        this.password = password;
        this.credit = credit;
        this.administrateur = administrateur;
       
        
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
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
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public int getnumeroTelephone() {
        return numeroTelephone;
    }

    public void setnumeroTelephone(int numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }
    public String rue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }
    public int getCP() {
        return cp;
    }

    public void setCP(int cp) {
        this.cp = cp;
    }
    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
    
    public String getAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(String administrateur) {
        this.administrateur = administrateur;
    }
 
}
//pseudo, nom, prenom, email, telephone, rue, cp, ville, password, credit, administrateur//


