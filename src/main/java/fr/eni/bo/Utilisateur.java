package fr.eni.bo;

public class Utilisateur {
<<<<<<< HEAD
    private int id;
    private String pseudo;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String rue;
    private int cp;
    private String ville;
    private String password;
    private int credit;
    private int administrateur;

    

    public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue, int cp,
			String ville, int credit, int administrateur) {
		super();
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.cp = cp;
		this.ville = ville;
		this.credit = credit;
		this.administrateur = administrateur;
	}

	public Utilisateur(int id, String pseudo, String nom, String prenom, String email, String telephone, String rue, int cp, String ville, int credit, int administrateur) {
        this.id = id;
        this.pseudo = pseudo;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.rue = rue;
        this.cp = cp;
        this.ville = ville;
        this.credit = credit;
        this.administrateur = administrateur;
    }

    // Getters et Setters 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(int administrateur) {
        this.administrateur = administrateur;
    }

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}


=======
	private int id;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String rue;
	private int cp;
	private String ville;
	private int credit;
	private int administrateur;

	/**
	 * @param pseudo
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param telephone
	 * @param rue
	 * @param cp
	 * @param ville
	 * @param credit
	 * @param administrateur
	 */
	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue, int cp, String ville, int credit, int administrateur) {
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.cp = cp;
		this.ville = ville;
		this.credit = credit;
		this.administrateur = administrateur;
	}

	public Utilisateur(int id, String pseudo, String nom, String prenom, String email, String telephone, String rue, int cp, String ville, int credit, int administrateur) {
		this.id = id;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.cp = cp;
		this.ville = ville;
		this.credit = credit;
		this.administrateur = administrateur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public int getAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(int administrateur) {
		this.administrateur = administrateur;
	}
}
>>>>>>> refs/heads/master
