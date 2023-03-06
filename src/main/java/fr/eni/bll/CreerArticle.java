package fr.eni.bll;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.bo.Article;
import fr.eni.bo.Enchere;
import fr.eni.dal.SQLController;

public class CreerArticle {

	public List<Article> getEncheresEnCours(String categorie, String nomArticle) throws SQLException {
	    List<Article> articles = new ArrayList<>();
	    List<Enchere> encheres = SQLController.getEncheresEnCours(categorie, nomArticle);
	    for (Enchere enchere : encheres) {
	        Article article = new Article();
	        article.setNom(enchere.getNomArticle());
	        article.setDescription(enchere.getDescription());
	        article.setCategorie(enchere.getCategorie());
	        article.setPrixDepart(enchere.getPrixDepart());
	        article.setDateOuverture(enchere.getDateOuverture());
	        article.setDateFin(enchere.getDateFin());
	        article.setRetrait(enchere.getRetrait());
	        articles.add(article);
	    }
	    return articles;
	}
	

}

