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
    
    // Ajoutez ici d'autres méthodes de gestion des utilisateurs si besoin
}
