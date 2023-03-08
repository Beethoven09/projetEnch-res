package fr.eni.dal;

import fr.eni.bo.Connexion;
import fr.eni.dal.ArticleVenduDAOImpl;

public class DAOFactory {

    public static ArticleVenduDAO getArticleVenduDAO() {
        return new ArticleVenduDAOImpl(Connexion.getConnection());
    }

    public static UserDAO getUtilisateurDAO() {
        return new UtilisateurDAOImpl(Connexion.getConnection());
    }

    public static EnchereDAO getEnchereDAO() {
        return new EnchereDAOImpl(Connexion.getConnection());
    }
    
    public static RetraitDAO getRetraitDAO() {
        return new RetraitDAOImpl(Connexion.getConnection());
    }

}

