package fr.eni.bll;

import java.util.List;
import java.util.stream.Collectors;
import fr.eni.bo.Article;

public class EnchereNonConnecte {
	
	public List<Article> listerEncheresEnCours(String nomArticle, String categorie) {
	    ArticleManager articleManager = new ArticleManager();
	    List<Article> articles = articleManager.getArticlesEnCours();

	    // Filtrage par nom d'article
	    if (nomArticle != null && !nomArticle.isEmpty()) {
	        articles = articles.stream()
	            .filter(a -> a.getNom().toLowerCase().contains(nomArticle.toLowerCase()))
	            .collect(Collectors.toList());
	    }

	    // Filtrage par catégorie
	    if (categorie != null && !categorie.isEmpty()) {
	        articles = articles.stream()
	            .filter(a -> a.getCategorie().toLowerCase().equals(categorie.toLowerCase()))
	            .collect(Collectors.toList());
	    }

	    return articles;
	}


}
