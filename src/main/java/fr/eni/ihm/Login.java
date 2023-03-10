package fr.eni.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.result.Row;

import fr.eni.bll.ConnexionManager;
import fr.eni.bll.UtilisateurManager;
import fr.eni.bo.Utilisateur;

/**
 * Servlet implementation class Connexion
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	// méthode doPost pour gérer les requêtes POST
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");

		try {
			if(login != null && password != null) {
				Utilisateur user = ConnexionManager.connecterUtilisateur(login, password);
				request.setAttribute("User", user);
				request.getRequestDispatcher("/WEB-INF/jsp/ListeEncheres.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
			}
		} catch(Exception e) {
			e.printStackTrace();
			throw new ServletException("Une erreur est survenue dans la servlet.");

		}
	}
}












