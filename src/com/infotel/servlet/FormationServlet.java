package com.infotel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infotel.metier.Formation;
import com.infotel.metier.Stagiaire;
import com.infotel.service.Iservice;
import com.infotel.service.ServiceImpl;

/**
 * Servlet implementation class FormationServlet
 */
@WebServlet("/FormationServlet")
public class FormationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Iservice service = new ServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1-recuperation des informations
		String nomFormation = null;
		int idFormation = 0;
		if(request.getParameter("nomFormation")!=null) {
			nomFormation = request.getParameter("nomFormation");
		}
			
		//2-envoyer à la couche service
		Formation f = new Formation();
		f.setNomFormation(nomFormation);
		
		//ajout en base de données et modifier une personne si l'id est different de zero
		
		if(request.getParameter("ajouter")!=null) {
			service.ajouterFormation(f);
		}
	
			
		// 3- preparation à l'envoi 
		//on ajoute la personne entree dans le formulaire dans le tableau grace à la methode findAll()
		request.setAttribute("formations", service.findAllFormation());
				
		//4- appel de la jsp
		request.getRequestDispatcher("formation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
