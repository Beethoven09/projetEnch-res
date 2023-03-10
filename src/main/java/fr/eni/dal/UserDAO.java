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
	 * 
	 * @throws NamingException
	 */
	public UserDAO() throws NamingException {
		Context context = new InitialContext();
		dataSource = (DataSource) context.lookup("java:/comp/env/jdbc/pool_cnx");
	}

	/**
	 * Récupère les informations d'un utilisateur dans la base de données
	 * 
	 * @param id
	 * @return Utilisateur
	 */
	public String getUser(int idUser) {
		final String REQUETE = "SELECT id, pseudo, nom, prenom, email, telephone, rue, cp, ville, credit, administrateur FROM utilisateurs WHERE id = ?";
		String user = null;

		try (Connection conn = dataSource.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(REQUETE);
			stmt.setInt(1, idUser);
			stmt.executeUpdate();
			ResultSet rs = stmt.getResultSet();
			if (rs.next()) {
				int id = rs.getInt(1);
				String pseudo = rs.getString(2);
				String nom = rs.getString(3);
				String prenom = rs.getString(4);
				String email = rs.getString(5);
				String tel = rs.getString(6);
				String rue = rs.getString(7);
				int cp = rs.getInt(8);
				String ville = rs.getString(9);
				int credit = rs.getInt(10);
				int administrateur = rs.getInt(11);

				user = id + "," + pseudo + "," + nom + "," + prenom + "," + email + "," + tel + "," + rue + "," + cp
						+ "," + ville + "," + credit + "," + administrateur;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IllegalArgumentException(
					"Une erreur est survenue lors de la récupération de l'utilisateur dans la BDD : " + e);
		}
		return user;
	}

	/**
	 * Retourne l'ID du compte
	 * 
	 * @param pseudo
	 * @return id
	 */

	public int getId(String login) {
		final String REQUETE = "SELECT id FROM utilisateurs WHERE pseudo = ? OR email = ?";

		try (Connection conn = dataSource.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(REQUETE);
			stmt.setString(1, login);
			stmt.setString(2, login);
			stmt.executeUpdate();
			ResultSet rs = stmt.getResultSet();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	/**
	 * Retourne le salt du compte
	 * 
	 * @param id
	 * @return
	 */
	public String getSalt(int id) {
		final String REQUETE = "SELECT salt FROM utilisateurs WHERE id = ?";
		String salt = null;

		try (Connection conn = dataSource.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(REQUETE);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			ResultSet rs = stmt.getResultSet();
			if (rs.next()) {
				salt = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return salt;
	}

	/**
	 * Retourne le mot de passe hashé d'un utilisateur en fonction d'un id
	 * 
	 * @param id
	 * @return password
	 */
	public String getPassword(int id) {
		final String REQUETE = "SELECT password FROM utilisateurs WHERE id = ?";
		String password = null;

		try (Connection conn = dataSource.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(REQUETE);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			ResultSet rs = stmt.getResultSet();
			if (rs.next()) {
				password = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return password;
	}

	/**
	 * Insère un utilisateur dans la base de données
	 * 
	 * @param user
	 * @return boolean
	 * 
	 */
	public boolean add(Utilisateur user, String password, String salt) {
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
	 * Modifie un utilisateur. Pour modifier le mot de passe, utilisez la méthode
	 * {@code modifierPassword()}.
	 * 
	 * @param user
	 * @return boolean
	 */
	public boolean update(Utilisateur user) {
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
			if (stmt.execute()) {
				System.out.println(stmt.getResultSet());
				return true;
			} else {
				System.out.println(
						"Une erreur est survenue lors de la modification du compte. [USER ID: " + user.getId() + "]");
				throw new IllegalArgumentException(
						"Une erreur est survenue lors de la modification de l'utilisateur dans la BDD.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IllegalArgumentException(
					"Une erreur est survenue lors de la modification de l'utilisateur dans la BDD : " + e);
		}
	}

	public boolean update(Utilisateur user, String password) {
		final String REQUETE = "UPDATE utilisateurs SET password = ? WHERE id = ?";

		try (Connection conn = dataSource.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(REQUETE);
			stmt.setString(1, password);
			stmt.setInt(2, user.getId());
			if (stmt.execute()) {
				return true;
			} else {
				throw new IllegalArgumentException(
						"Une erreur est survenue lors de la modification du mot de passe dans la BDD.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new IllegalArgumentException(
					"Une erreur est survenue lors de la modification du mot de passe dans la BDD : " + e);
		}
	}

	/**
	 * Supprime un utilisateur.
	 * 
	 * @param user
	 * @return boolean
	 */
	public boolean delete(Utilisateur user) {
		final String REQUETE = "DELETE FROM utilisateur WHERE id = ?";

		try (Connection conn = dataSource.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(REQUETE);
			stmt.setInt(1, user.getId());
			if (stmt.execute()) {
				System.out.println(stmt.getResultSet());
				return true;
			} else {
				throw new IllegalArgumentException(
						"Une erreur est survenue lors de la suppression de l'utilisateur dans la BDD.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Vérifie si le pseudo est existant
	 * 
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
			if (rs.next()) {
				int nb = rs.getInt(1);
				if (nb > 0) {
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
	 * 
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
			if (rs.next()) {
				int nb = rs.getInt(1);
				if (nb > 0) {
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