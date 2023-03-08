package fr.eni.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.bo.ArticleVendu;
import fr.eni.bo.Connexion;
import fr.eni.dal.DALException;
import fr.eni.dal.UserDAO;
import fr.eni.bo.Categorie;



	public abstract class ArticleVenduDAOImpl implements ArticleVenduDAO {

	    private static final String SELECT_ALL_QUERY = "SELECT * FROM ARTICLES_VENDUS a INNER JOIN UTILISATEURS u ON a.no_utilisateur = u.no_utilisateur";
	    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM ARTICLES_VENDUS a INNER JOIN UTILISATEURS u ON a.no_utilisateur = u.no_utilisateur WHERE no_article = ?";
	    private static final String INSERT_QUERY = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, no_utilisateur, no_categorie) VALUES (?, ?, ?, ?, ?, ?, ?)";
	    private static final String UPDATE_QUERY = "UPDATE ARTICLES_VENDUS SET nom_article = ?, description = ?, date_debut_encheres = ?, date_fin_encheres = ?, prix_initial = ?, prix_vente = ?, no_categorie = ? WHERE no_article = ?";
	    private static final String DELETE_QUERY = "DELETE FROM ARTICLES_VENDUS WHERE no_article = ?";

	    private static final String SELECT_BY_CATEGORIE_QUERY = "SELECT * FROM ARTICLES_VENDUS a INNER JOIN UTILISATEURS u ON a.no_utilisateur = u.no_utilisateur WHERE no_categorie = ?";
	    private static final String SELECT_BY_NOM_QUERY = "SELECT * FROM ARTICLES_VENDUS a INNER JOIN UTILISATEURS u ON a.no_utilisateur = u.no_utilisateur WHERE nom_article LIKE ?";

	    public List<ArticleVendu> selectAll() throws DALException {
	        List<ArticleVendu> articles = new ArrayList<>();
	        try(Connection conn = Connexion.getConnection()) {
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery(SELECT_ALL_QUERY);
	            while (rs.next()) {
	                ArticleVendu article = resultSetToArticle(rs);
	                articles.add(article);
	            }
	        } catch (SQLException e) {
	            throw new DALException("Une erreur est survenue lors de la récupération de la liste des articles", e);
	        }
	        return articles;
	    }

	    public ArticleVendu selectById(int id) throws DALException {
	        try(Connection conn = Connexion.getConnection()) {
	            PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID_QUERY);
	            stmt.setInt(1, id);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                return resultSetToArticle(rs);
	            } else {
	                throw new DALException("Aucun article trouvé pour l'identifiant : " + id);
	            }
	        } catch (SQLException e) {
	            throw new DALException("Une erreur est survenue lors de la récupération de l'article avec l'identifiant : " + id, e);
	        }
	    }

	    public ArticleVendu insert(ArticleVendu article) throws DALException {
	        try(Connection conn = Connexion.getConnection()) {
	            PreparedStatement stmt = conn.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
	            stmt.setString(1, article.getNomArticle());
	            stmt.setString(2, article.getDescription());
	            stmt.setDate(3, Date.valueOf(article.getDateDebutEncheres()));
	            stmt.setDate(4, Date.valueOf(article.getDateFinEncheres()));
	            stmt.setInt(5, article.getMiseAPrix());
	            stmt.setInt(6, article.getVendeur().getId());
	            stmt.setInt(7, article.getNoCategorie().getNoCategorie());
	            stmt.executeUpdate();

	            ResultSet rs = stmt.getGeneratedKeys();
	            if (rs.next()) {
	                article.setNoArticle(rs.getInt(1));
	            }

	        } catch (SQLException e) {
	            throw new DALException("Une erreur est survenue lors de la création de l'article : " + article, e);
	        }
	        return article;
	    }
	            	
	    public void update(ArticleVendu article) throws DALException {
	        try(Connection conn = Connexion.getConnection()) {
	            PreparedStatement stmt = conn.prepareStatement(UPDATE_QUERY);
	            stmt.setString(1, article.getNomArticle());
	            stmt.setString(2, article.getDescription());
	            stmt.setDate(3, Date.valueOf(article.getDateDebutEncheres()));
	            stmt.setDate(4, Date.valueOf(article.getDateFinEncheres()));
	            stmt.setInt(5, article.getMiseAPrix());
	            stmt.setInt(6, article.getPrixVente());
	            stmt.setInt(7, article.getNoCategorie().getNoCategorie());
	            stmt.setInt(8, article.getNoArticle());
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            throw new DALException("Une erreur est survenue lors de la mise à jour de l'article : " + article, e);
	        }
	    }

	    public void delete(ArticleVendu article) throws DALException {
	        try(Connection conn = Connexion.getConnection()) {
	            PreparedStatement stmt = conn.prepareStatement(DELETE_QUERY);
	            stmt.setInt(1, article.getNoArticle());
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            throw new DALException("Une erreur est survenue lors de la suppression de l'article : " + article, e);
	        }
	    }

	    public List<ArticleVendu> selectByCategorie(int noCategorie) throws DALException {
	        List<ArticleVendu> articles = new ArrayList<>();
	        try(Connection conn = Connexion.getConnection()) {
	            PreparedStatement stmt = conn.prepareStatement(SELECT_BY_CATEGORIE_QUERY);
	            stmt.setInt(1, noCategorie);
	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {
	                ArticleVendu article = resultSetToArticle(rs);
	                articles.add(article);
	            }
	        } catch (SQLException e) {
	            throw new DALException("Une erreur est survenue lors de la récupération des articles de la catégorie : " + noCategorie, e);
	        }
	        return articles;
	    }

	    public List<ArticleVendu> selectByNom(String nomArticle) throws DALException {
	        List<ArticleVendu> articles = new ArrayList<>();
	        try(Connection conn = Connexion.getConnection()) {
	            PreparedStatement stmt = conn.prepareStatement(SELECT_BY_NOM_QUERY);
	            stmt.setString(1, "%" + nomArticle + "%");
	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {
	                ArticleVendu article = resultSetToArticle(rs);
	                articles.add(article);
	            }
	        } catch (SQLException e) {
	            throw new DALException("Une erreur est survenue lors de la récupération des articles contenant le nom : " + nomArticle, e);
	        }
	        return articles;
	    }

	    private ArticleVendu resultSetToArticle(ResultSet rs) throws SQLException {
	        ArticleVendu article = new ArticleVendu();
	        article.setNoArticle(rs.getInt("no_article"));
	        article.setNomArticle(rs.getString("nom_article"));
	        article.setDescription(rs.getString("description"));
	        article.setDateDebutEncheres(rs.getDate("date_debut_encheres").toLocalDate());
	        article.setDateFinEncheres(rs.getDate("date_fin_encheres").toLocalDate());
	        article.setMiseAPrix(rs.getInt("prix_initial"));
	        article.setPrixVente(rs.getInt("prix_vente"));
	        article.setVendeur(UserDAO.resultSetToUtilisateur(rs));
	        article.setNoCategorie(Categorie.resultSetToCategorie(rs));
	        return article;
	    }
	}

	    

}
