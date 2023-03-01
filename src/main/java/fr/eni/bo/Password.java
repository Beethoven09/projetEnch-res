package fr.eni.bo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Password {
    
    /**
     * Méthode pour hasher un mot de passe avec un sel (salt).
     * 
     * @param password le mot de passe à hasher
     * @param salt le sel à utiliser pour le hash
     * @return le mot de passe hashé
     */
    public static String hashPassword(String password, String salt) {
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
}

