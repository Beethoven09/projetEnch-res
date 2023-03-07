package fr.eni.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import fr.eni.bo.Utilisateur;

public class UserDAO {

    protected static DataSource dataSource;

    /**
     * Initialise la connexion à la base de données
     * @throws NamingException
     */
    public UserDAO() throws NamingException {
        Context context = new InitialContext();
        dataSource = (DataSource) context.lookup("java:/comp/env/jdbc/pool_cnx");
    }
    
    /**
     * Récupère un ID en fonction d'un pseudo
     * @param pseudo
     * @return id
     */
    public int getUserIdByPseudo(String pseudo) {
    	final String REQUETE = "SELECT id FROM utilisateurs WHERE pseudo = ?";
    	int id = 0;
    	
    	try(Connection conn = dataSource.getConnection()) {
    		PreparedStatement stmt = conn.prepareStatement(REQUETE);
    		stmt.setString(1, pseudo);
    		stmt.executeUpdate();
    		ResultSet rs = stmt.getResultSet();
    		if(rs.next()) {
    			id = rs.getInt(1);
    		}
    	} catch (SQLException e) {
			e.printStackTrace();
		}
    	
		return id;
    }
    
    /**
     * Retourne le mot de passe hashé d'un utilisateur en fonction d'un id
     * @param id
     * @return password
     */
    public String getUserPasswordById(int id) {
    	final String REQUETE = "SELECT password FROM utilisateurs WHERE id = ?";
    	String password = null;
    	
    	try(Connection conn = dataSource.getConnection()) {
    		PreparedStatement stmt = conn.prepareStatement(REQUETE);
    		stmt.setInt(1, id);
    		stmt.executeUpdate();
    		ResultSet rs = stmt.getResultSet();
    		if(rs.next()) {
    			password = rs.getString(1);
    		}
    	} catch (SQLException e) {
			e.printStackTrace();
		}
    	
		return password;
    }

    /**
     * Insère un utilisateur dans la base de données
     * @param user
     * @return boolean
     * 
     */
    public boolean insertUtilisateur(Utilisateur user, String password, String salt) {
        final String REQUETE = "INSERT INTO utilisateurs (pseudo, nom, prenom, email, telephone, rue, cp, ville, password, salt, credit, administrateur) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = dataSource.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(REQUETE, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getPseudo());
            stmt.setString(2, user.getNom());
            stmt.setString(3, user.getPrenom());
            stmt.setString(4, user.getEmail());
            stmt.setString(5, user.getTelephone());
            stmt.setString(6, user.getRue());
            stmt.setInt(7, user.getCp());
            stmt.setString(8, user.getVille());
            stmt.setString(9, password);
            stmt.setString(10, salt);
            stmt.setInt(11, user.getCredit());
            stmt.setInt(12, user.getAdministrateur());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                user.setId(id);
                return true;
            } else {
                throw new IllegalArgumentException("Une erreur est survenue lors de l'ajout à la BDD.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Une erreur est survenue lors de l'ajout à la BDD : " + e);
        }
    }
    
    /**
     * Modifie un utilisateur. Pour modifier le mot de passe, utilisez la méthode {@code modifierPassword()}.
     * @param user
     * @return boolean
     */
    public boolean modifierUtilisateur(Utilisateur user) {
    	final String REQUETE = "UPDATE INTO utilisateurs SET pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue = ?, cp = ?, ville = ?, credit = ?, administrateur = ?";
    	
    	try (Connection conn = dataSource.getConnection()) {
    		PreparedStatement stmt = conn.prepareStatement(REQUETE);
    		stmt.setString(1, user.getPseudo());
    		stmt.setString(2, user.getNom());
    		stmt.setString(3, user.getPrenom());
    		stmt.setString(4, user.getEmail());
    		stmt.setString(5, user.getTelephone());
    		stmt.setString(6, user.getRue());
    		stmt.setInt(7, user.getCp());
    		stmt.setString(8, user.getVille());
    		stmt.setInt(9, user.getCredit());
    		stmt.setInt(10, user.getAdministrateur());
    		if(stmt.execute()) {
    			System.out.println(stmt.getResultSet());
    			return true;
    		} else {
    			System.out.println("Une erreur est survenue lors de la modification du compte. [USER ID: " + user.getId() + "]");
    			return false;
    		}
        } catch (SQLException e) {
        	e.printStackTrace();
        	return false;
        }
    }
    
    /**
     * Supprime un utilisateur.
     * @param user
     * @return boolean
     */
    public boolean supprimerUtilisateur(Utilisateur user) {
    	final String REQUETE = "DELETE FROM utilisateur WHERE id = ?";
    	
    	try (Connection conn = dataSource.getConnection()) {
    		PreparedStatement stmt = conn.prepareStatement(REQUETE);
    		stmt.setInt(1, user.getId());
    		if(stmt.execute()) {
    			System.out.println(stmt.getResultSet());
    			return true;
    		} else {
    			System.out.println("Une erreur est survenue lors de la suppression du compte. [USER ID: " + user.getId() + "]");
    			return false;
    		}
    	} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
    }
    
    /**
     * Vérifie si le pseudo est existant
     * @param email
     * @return boolean
     */
    public boolean ckeckIfPseudoExist(String pseudo) {
		final String REQUETE = "SELECT COUNT(*) AS nb FROM utilisateurs WHERE pseudo = ?";
		
		try (Connection conn = dataSource.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(REQUETE);
			stmt.setString(1, pseudo);
			stmt.executeQuery();
			ResultSet rs = stmt.getResultSet();
			if(rs.next()) {
				int nb = rs.getInt(1);
				if(nb > 0) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
    
    /**
     * Vérifie si l'adresse email est existante
     * @param email
     * @return boolean
     */
    public boolean ckeckIfEmailExist(String email) {
		final String REQUETE = "SELECT COUNT(*) AS nb FROM utilisateurs WHERE email = ?";
		
		try (Connection conn = dataSource.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(REQUETE);
			stmt.setString(1, email);
			stmt.executeQuery();
			ResultSet rs = stmt.getResultSet();
			if(rs.next()) {
				int nb = rs.getInt(1);
				if(nb > 0) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}