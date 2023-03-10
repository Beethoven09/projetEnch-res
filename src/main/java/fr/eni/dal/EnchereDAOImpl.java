package fr.eni.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import fr.eni.bo.ArticleVendu;
import fr.eni.bo.Connexion;
import fr.eni.bo.Enchere;
import fr.eni.bo.Utilisateur;
import fr.eni.dal.DALException;

public class EnchereDAOImpl implements EnchereDAO {

	private static final String SELECT_ALL_QUERY = "SELECT * FROM ENCHERES e INNER JOIN ARTICLES_VENDUS a ON e.no_article = a.no_article INNER JOIN UTILISATEURS u ON e.no_utilisateur = u.no_utilisateur";
	private static final String SELECT_BY_ID_QUERY = "SELECT * FROM ENCHERES e INNER JOIN ARTICLES_VENDUS a ON e.no_article = a.no_article INNER JOIN UTILISATEURS u ON e.no_utilisateur = u.no_utilisateur WHERE no_enchere = ?";
	private static final String INSERT_QUERY = "INSERT INTO ENCHERES (date_enchere, montant_enchere, no_utilisateur, no_article) VALUES (?, ?, ?, ?)";
	private static final String UPDATE_QUERY = "UPDATE ENCHERES SET date_enchere = ?, montant_enchere = ?, no_utilisateur = ?, no_article = ? WHERE no_enchere = ?";
	private static final String DELETE_QUERY = "DELETE FROM ENCHERES WHERE no_enchere = ?";

	private static final String SELECT_BY_ARTICLE_QUERY = "SELECT * FROM ENCHERES e INNER JOIN ARTICLES_VENDUS a ON e.no_article = a.no_article INNER JOIN UTILISATEURS u ON e.no_utilisateur = u.no_utilisateur WHERE a.no_article = ?";
	private static final String SELECT_BY_UTILISATEUR_QUERY = "SELECT * FROM ENCHERES e INNER JOIN ARTICLES_VENDUS a ON e.no_article = a.no_article INNER JOIN UTILISATEURS u ON e.no_utilisateur = u.no_utilisateur WHERE u.no_utilisateur = ?";

	public List<Enchere> selectAll() throws DALException {
		List<Enchere> encheres = new ArrayList<>();
		try (Connection conn = Connexion.getConnection()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL_QUERY);
			while (rs.next()) {
				Enchere enchere = resultSetToEnchere(rs);
				encheres.add(enchere);
			}
		} catch (SQLException e) {
			throw new DALException("Une erreur est survenue lors de la récupération de la liste des enchères", e);
		}
		return encheres;
	}

	public Enchere selectById(int id) throws DALException {
		Enchere enchere = null;
		try (Connection conn = Connexion.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_ID_QUERY);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				enchere = resultSetToEnchere(rs);
			}
		} catch (SQLException e) {
			throw new DALException("Une erreur est survenue lors de la récupération de l'enchère avec l'ID : " + id, e);
		}
		return enchere;
	}

	public void insert(Enchere enchere) throws DALException {
        try(Connection conn = Connexion.getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(INSERT_QUERY, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setTimestamp(1, Timestamp.valueOf(enchere.getDateEnchere()));
            pstmt.setInt(2, enchere.getMontantEnchere());
            pstmt.setInt(3, enchere.getUtilisateur().getNoUtilisateur());
            pstmt.setInt(4, enchere.getArticle().getNoArticle());
            int nbRows = pstmt.executeUpdate();
            if (nbRows == 1) {
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    enchere.setNoEnchere(id);
                }
            }
        } catch (SQLException e) {
            throw new DALException("Une erreur est survenue lors de la création de l'enchère : " + enchere, e);
        }
    }

public void update(Enchere enchere) throws DALException {
        try(Connection conn = Connexion.getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(UPDATE_QUERY);
            pstmt.setTimestamp(1, Timestamp.valueOf(enchere.getDateEnchere()));
            pstmt.setInt(2, enchere.getMontantEnchere());
            pstmt.setInt(3, enchere.getUtilisateur().getNoUtilisateur());
            pstmt.setInt(4, enchere
