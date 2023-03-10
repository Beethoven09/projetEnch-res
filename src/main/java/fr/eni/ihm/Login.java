package fr.eni.ihm;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class Connexion
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 // La source de données (data source) pour la base de données
	 private DataSource dataSource;

	 @Override
	 public void init() throws ServletException {
	  super.init();
	  dataSource = (DataSource) getServletContext().getAttribute("dataSource");
	 }


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
			  String rememberMe = request.getParameter("rememberMe");
			  boolean remember = rememberMe != null && rememberMe.equals("on");

		  }
		
	}


