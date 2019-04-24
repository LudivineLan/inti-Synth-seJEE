package com.infotel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infotel.metier.Promo;
import com.infotel.metier.Stagiaire;
import com.infotel.service.Iservice;
import com.infotel.service.ServiceImpl;

/**
 * Servlet implementation class PromoServlet
 */
@WebServlet("/PromoServlet")
public class PromoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private Iservice service = new ServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PromoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1-recuperation des informations
		String nomPromo = null;
		int effectif = 0;
		int idpromo = 0;
		if(request.getParameter("nomPromo")!=null) {
			effectif = Integer.parseInt(request.getParameter("effectif"));
			nomPromo = request.getParameter("nomPromo");
		}
			
		//2-envoyer à la couche service
		Promo p = new Promo();
		p.setNomPromo(nomPromo);
		p.setEffectif(effectif);
		
		
		//ajout en base de données et modifier une personne si l'id est different de zero
		
		if(request.getParameter("ajouter")!=null) {
			service.ajouterPromo(p);
		}
	
			
		// 3- preparation à l'envoi 
		//on ajoute la personne entree dans le formulaire dans le tableau grace à la methode findAll()
		request.setAttribute("promos", service.findAllPromo());
				
		//4- appel de la jsp
		request.getRequestDispatcher("promo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
