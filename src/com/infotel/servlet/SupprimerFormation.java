package com.infotel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infotel.service.Iservice;
import com.infotel.service.ServiceImpl;

/**
 * Servlet implementation class SupprimerFormation
 */
@WebServlet("/SupprimerFormation")
public class SupprimerFormation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Iservice service = new ServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerFormation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//FORMATION
		//1-recuperation des informations 
		int idFormation = Integer.parseInt(request.getParameter("id"));
		
		//2-supprimer en base de données
		service.supprimerFormation(idFormation);
		
		// 3- preparation à l'envoi 
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
