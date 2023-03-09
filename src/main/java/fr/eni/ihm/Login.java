package fr.eni.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		    // Récupérer les informations de connexion entrées par l'utilisateur
		    String login = request.getParameter("login");
		    String password = request.getParameter("password");

		    // Vérifier si les informations de connexion sont valides
		    if (isValidLogin(login, password)) {
		      // Rediriger l'utilisateur vers la page d'accueil de la plateforme
		      response.sendRedirect("ListeEncheres.jsp");
		    } else {
		      // Afficher un message d'erreur si les informations de connexion sont incorrectes
		      request.setAttribute("errorMessage", "login ou mot de passe incorrect.");
		      request.getRequestDispatcher("login.jsp").forward(request, response);
		    }
		  }

		  // Méthode pour vérifier si les informations de connexion sont valides
		  private boolean isValidLogin(String login, String password) {
		    // Vérifier si l'utilisateur existe dans la base de données
		    // Vérifier si le mot de passe correspond à celui enregistré pour l'utilisateur
		    // Retourner true si les informations sont valides, false sinon
		    return true;
		  }
		

		
	}


