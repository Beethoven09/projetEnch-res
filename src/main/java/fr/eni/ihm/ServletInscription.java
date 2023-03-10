package fr.eni.ihm;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
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
@WebServlet("/inscription")
public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		if (request.getParameter("pseudo") != null) {
			String pseudo = request.getParameter("pseudo");
			String name = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String email = request.getParameter("email");
			String telephone = request.getParameter("telephone");
			String rue = request.getParameter("rue");
			int cp = Integer.parseInt(request.getParameter("code_postal"));
			String ville = request.getParameter("ville");
			String password = request.getParameter("mot_de_passe");

			try {
				Utilisateur user = UtilisateurManager.insertUtilisateur(pseudo, name, prenom, email, telephone, rue, cp,
						ville, password);
				request.setAttribute("User", user);
				request.getRequestDispatcher("/WEB-INF/jsp/PageDeConnexion.jsp").forward(request, response);
			} catch (SQLException | NamingException e) {
				throw new ServletException("Erreur lors de la récupération des exemples", e);
			}
		} else {
			request.getRequestDispatcher("/WEB-INF/jsp/Inscription.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}