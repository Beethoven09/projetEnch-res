package fr.eni.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.bll.UtilisateurManager;
import fr.eni.bo.Utilisateur;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/Inscription.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	// méthode doPost pour gérer les requêtes POST
	  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	    throws ServletException, IOException {

	    // Récupérer les informations d'inscription entrées par l'utilisateur
	    String pseudo = request.getParameter("pseudo");
	    String nom = request.getParameter("nom");
	    String prenom = request.getParameter("prenom");
	    String email = request.getParameter("email");
	    String telephone = request.getParameter("telephone");
	    String rue = request.getParameter("rue");
	    int code_postal = Integer.parseInt(request.getParameter("code_postal"));
	    String ville = request.getParameter("ville");
	    String password = request.getParameter("mot_de_passe");
	    String confirmation = request.getParameter("confirmation");
	    
	    Utilisateur user = UtilisateurManager.insertUtilisateur(pseudo, prenom, nom, email, telephone, rue, code_postal, ville, password);
	    

	  

	   
	   

	    // Créer le profil de l'utilisateur avec un crédit initial de 0
	    createUserProfile(username, email, password, 0);

	    // Rediriger l'utilisateur vers la page d'accueil de la plateforme
	    response.sendRedirect("ListeEncheres.jsp");
	  }
	}


