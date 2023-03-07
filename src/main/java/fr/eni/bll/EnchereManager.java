package fr.eni.bll;

import java.util.List;

import fr.eni.bo.ArticleVendu;
import fr.eni.bo.Enchere;
import fr.eni.dal.DAOFactory;
import fr.eni.dal.EnchereDAO;
import fr.eni.utils.DALException;

public class EnchereManager {
    private EnchereDAO enchereDAO;
    
    public EnchereManager() {
        enchereDAO = DAOFactory.getEnchereDAO();
    }
    
    public Enchere addEnchere(Enchere enchere) throws BLLException {
        try {
            enchere = enchereDAO.insert(enchere);
        } catch (DALException e) {
            throw new BLLException("Une erreur est survenue lors de l'ajout de l'enchère.", e);
        }
        return enchere;
    }
    
    public void removeEnchere(Enchere enchere) throws BLLException {
        try {
            enchereDAO.delete(enchere);
        } catch (DALException e) {
            throw new BLLException("Une erreur est survenue lors de la suppression de l'enchère.", e);
        }
    }
    
    public List<Enchere> getEncheresByArticle(ArticleVendu article) throws BLLException {
        List<Enchere> encheres;
        try {
            encheres = enchereDAO.selectByArticle(article);
        } catch (DALException e) {
            throw new BLLException("Une erreur est survenue lors de la récupération des enchères associées à l'article.", e);
        }
        return encheres;
    }
    
    public Enchere getEnchereWithMaxMontant(ArticleVendu article) throws BLLException {
        Enchere enchere;
        try {
            enchere = enchereDAO.selectWithMaxMontant(article);
        } catch (DALException e) {
            throw new BLLException("Une erreur est survenue lors de la récupération de l'enchère avec le montant maximum.", e);
        }
        return enchere;
    }
}
