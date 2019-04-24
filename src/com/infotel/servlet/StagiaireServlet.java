package com.infotel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infotel.metier.Stagiaire;
import com.infotel.service.Iservice;
import com.infotel.service.ServiceImpl;

/**
 * Servlet implementation class StagiaireServlet
 */
@WebServlet("/StagiaireServlet")
public class StagiaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private Iservice service = new ServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StagiaireServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1-recuperation des informations
				String nom = null;
				String prenom = null;
				int age = 0;
				int id = 0;
				if(request.getParameter("nom")!=null) {
					age = Integer.parseInt(request.getParameter("age"));
					nom = request.getParameter("nom");
					prenom = request.getParameter("prenom");
				}
					
				//2-envoyer à la couche service
				Stagiaire s = new Stagiaire();
				s.setNom(nom);
				s.setPrenom(prenom);
				s.setAge(age);
				
				//ajout en base de données et modifier une personne si l'id est different de zero
				
				if(request.getParameter("ajouter")!=null) {
					service.ajouterStagiaire(s);
				}
			
					
				// 3- preparation à l'envoi 
				//on ajoute la personne entree dans le formulaire dans le tableau grace à la methode findAll()
				request.setAttribute("stagiaires", service.findAll());
						
				//4- appel de la jsp
				request.getRequestDispatcher("stagiaire.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
