package fr.eni.dal;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import fr.eni.bo.ArticleVendu;

public class ArticleVenduDAO {

	protected static DataSource dataSource;

	public ArticleVenduDAO() throws NamingException {
		Context context = new InitialContext();
		dataSource = (DataSource) context.lookup("java:/comp/env/jdbc/pool_cnx");
	}

	List<ArticleVendu> selectAll() throws DALException;

	ArticleVendu selectById(int id) throws DALException;

	ArticleVendu insert(ArticleVendu article) throws DALException;

	void update(ArticleVendu article) throws DALException;

	void delete(int id) throws DALException;

	List<ArticleVendu> selectByCategorie(int noCategorie) throws DALException;

	List<ArticleVendu> selectByNom(String nomArticle) throws DALException;

}
