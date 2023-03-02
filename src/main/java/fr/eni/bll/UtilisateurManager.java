package fr.eni.bll;

import java.sql.SQLException;
import fr.eni.bo.Utilisateur;
import fr.eni.dal.SQLController;

public class UtilisateurManager {
    
    private SQLController sqlController;
    
    public UtilisateurManager() {
        try {
            this.sqlController = new SQLController();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Utilisateur insertUtilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue, int cp, String ville, String password, int credit, int administrateur) throws SQLException {
        // Vérification de la validité des données
        
        // Insertion de l'utilisateur en base de données
        return sqlController.insertUtilisateur(pseudo, nom, prenom, email, telephone, rue, cp, ville, password, credit, administrateur);
    }
    
    public void modifierUtilisateur(int id, String pseudo, String nom, String prenom, String email, String telephone, String rue, int cp, String ville, String password, int credit, int administrateur) throws SQLException {
        // Vérification de la validité des données
        
        // Modification de l'utilisateur en base de données
        sqlController.modifierUtilisateur(id, pseudo, nom, prenom, email, telephone, rue, cp, ville, password, credit, administrateur);
    }
    
    public void supprimerUtilisateur(int id) throws SQLException {
        // Suppression de l'utilisateur en base de données
        sqlController.supprimerUtilisateur(id);
    }
    	// Ajouter ici d'autres méthodes si besoin
}

