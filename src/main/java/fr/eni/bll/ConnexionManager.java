package fr.eni.bll;

import javax.naming.NamingException;

import fr.eni.bo.Password;
import fr.eni.bo.Utilisateur;
import fr.eni.dal.UserDAO;

public class ConnexionManager {

	public static Utilisateur connecterUtilisateur(String pseudo, String motDePasse) throws BLLException, NamingException {

		// On récupère l'utilisateur correspondant au pseudo
		UserDAO userDAO = new UserDAO();
		int userId = userDAO.getId(pseudo);

		if (userId > 0) {
			String hashedPassword = userDAO.getPassword(userId);
			String salt = userDAO.getSalt(userId);
			String password = Password.hashPassword(motDePasse, salt);
			if (password.equals(hashedPassword)) {
				String[] array = userDAO.getUser(userId).split(",");
				Utilisateur user = new Utilisateur(Integer.parseInt(array[0]), array[1], array[2], array[3], array[4], array[5], array[6], Integer.parseInt(array[7]), array[8], Integer.parseInt(array[9]), Integer.parseInt(array[10]));

				return user;
			} else {
				throw new BLLException("Le mot de passe est incorrect");
			}
		} else {
			throw new BLLException("Le compte n'existe pas.");
		} 

	}

}

