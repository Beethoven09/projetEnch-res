package fr.eni.dal;

import java.util.List;
import fr.eni.bo.ArticleVendu;

	public interface ArticleVenduDAO {

	    List<ArticleVendu> selectAll() throws DALException;
	
	    ArticleVendu selectById(int id) throws DALException;
	
	    ArticleVendu insert(ArticleVendu article) throws DALException;
	
	    void update(ArticleVendu article) throws DALException;
	
	    void delete(int id) throws DALException;
	
	    List<ArticleVendu> selectByCategorie(int noCategorie) throws DALException;
	
	    List<ArticleVendu> selectByNom(String nomArticle) throws DALException;
	    
}


