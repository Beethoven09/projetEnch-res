package fr.eni.bo;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.eni.bll.UtilisateurManager;
import fr.eni.dal.SQLController;


/**
 * Servlet implementation class ServletTestUser
 */
@WebServlet("/ServletTestUser")
public class ServletTestUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			Utilisateur user = UtilisateurManager.insertUtilisateur("Sebsineat", "Rouillon", "Sébastien", "srouillon@icloud.com", "+33674611693", "1 rue de xxx", 12345, "Nantes", "Motdepasse");
            request.setAttribute("User", user);

            request.getRequestDispatcher("/WEB-INF/jsp/testUtilisateur.jsp").forward(request, response);
        } catch (SQLException | NamingException e) {
            throw new ServletException("Erreur lors de la récupération des exemples", e);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
