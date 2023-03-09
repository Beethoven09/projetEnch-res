package fr.eni.bo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class Password {
<<<<<<< HEAD

	/**
	 * Méthode pour hasher un mot de passe avec un sel (salt).
	 * @param password le mot de passe à hasher
	 * @param salt le sel à utiliser pour le hash
	 * @return le mot de passe hashé
	 */
	private static String hashPassword(String password, String salt) {
		String generatedPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(salt.getBytes());
			byte[] bytes = md.digest(password.getBytes());
			StringBuilder sb = new StringBuilder();
			for (int i=0; i<bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return generatedPassword;
	}

	/**
	 * Permet de générer un mot de passer crypté.
	 * @param password
	 * @return password;hash
	 */
	public static String genererPassword(String password) {

		SecureRandom srnd = new SecureRandom();
		byte[] salt = new byte[16];
		srnd.nextBytes(salt);
		String base64salt = Base64.getEncoder().encodeToString(salt);
		String hashedPassword = hashPassword(password, base64salt);
		return hashedPassword + ";" + base64salt;
	}
}

