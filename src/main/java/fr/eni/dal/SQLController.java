package fr.eni.dal;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import fr.eni.bo.Utilisateur;

public class SQLController {

    private static DataSource dataSource;

    public SQLController() throws NamingException {
        Context context = new InitialContext();
        dataSource = (DataSource) context.lookup("java:/comp/env/jdbc/pool_cnx");
    }

    /**
     * Insère un utilisateur dans la base de données
     * @param pseudo
     * @param nom
     * @param prenom
     * @param email
     * @param telephone
     * @param rue
     * @param cp
     * @param ville
     * @param password
     * @param credit
     * @param administrateur
     * @return
     * @throws SQLException
     */
    
    public boolean insertUtilisateur(Utilisateur user) {
    	final String INSERT = "INSERT INTO utilisateurs (pseudo, nom, prenom, email, telephone, rue, cp, ville, password, credit, administrateur) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    	
    	try (Connection conn = dataSource.getConnection()) {
    		PreparedStatement stmt = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
    		stmt.setString(1, user.getPseudo());
    		stmt.setString(2, user.getNom());
    		stmt.setString(3, user.getPrenom());
    		stmt.setString(4, user.getEmail());
    		stmt.setString(5, user.getTelephone());
    		stmt.setString(6, user.getRue());
    		stmt.setInt(7, user.getCp());
    		stmt.setString(8, user.getVille());
    		stmt.setString(9, user.getPassword());
    		stmt.setInt(10, user.getCredit());
    		stmt.setInt(11, user.getAdministrateur());
    		stmt.executeUpdate();
    		ResultSet rs = stmt.getGeneratedKeys();
    		if (rs.next()) {
				int id = rs.getInt(1);
				user.setId(id);
				user.setPassword(null);
			}
        } catch (SQLException e) {
        	e.printStackTrace();
        	return false;
        }
    	
        return true;
    }
    
	public Utilisateur insertUtilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue, int cp, String ville, String password, int credit, int administrateur) throws SQLException {
		
    	
    	Utilisateur user = null;
    	SecureRandom srnd = new SecureRandom();
    	byte[] salt = new byte[16];
    	srnd.nextBytes(salt);
    	String base64salt = Base64.getEncoder().encodeToString(salt);
    	String hashedPassword = hashPassword(password, base64salt);
    	
    	try (Connection conn = dataSource.getConnection()) {
    		PreparedStatement stmt = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
    		stmt.setString(1, pseudo);
    		stmt.setString(2, nom);
    		stmt.setString(3, prenom);
    		stmt.setString(4, email);
    		stmt.setString(5, telephone);
    		stmt.setString(6, rue);
    		stmt.setInt(7, cp);
    		stmt.setString(8, ville);
    		stmt.setString(9, hashedPassword);
    		stmt.setInt(10, credit);
    		stmt.setInt(11, administrateur);
    		stmt.executeUpdate();
    		ResultSet rs = stmt.getGeneratedKeys();
    		if (rs.next()) {
				int id = rs.getInt(1);
				user = new Utilisateur(id, pseudo, nom, prenom, email, telephone, rue, cp, ville, credit, administrateur);
			}
        }
        return user;
    }
}