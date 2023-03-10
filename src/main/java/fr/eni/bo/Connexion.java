package fr.eni.bo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
	private static final String URL = "jdbc:mysql://localhost:3306/eni?useSSL=false&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASSWORD = "motdepasse";
	private static Connection cnx;

	public static Connection getConnection() throws SQLException {
		if (cnx == null || cnx.isClosed()) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				cnx = DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return cnx;
	}

	public static void close() throws SQLException {
		if (cnx != null && !cnx.isClosed()) {
			cnx.close();
		}
	}
}
