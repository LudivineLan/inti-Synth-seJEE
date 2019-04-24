package com.infotel.dao;

import java.sql.Connection;
import java.sql.DriverManager;

//on  cree cette classe pour avoir un seul pont de connexion
public class GestionConnexion {
		
		private String url="jdbc:postgresql://localhost:5432/SyntheseJee";
		private String user="postgres";
		private String password="inmp030";
		
		//Objet Connection
		private static Connection connect;
		
		// creation d'un constrcucteur prive 
		//permet de creer une connexion à la BDD
		private GestionConnexion() {
			try {
				//1- charger le pilote
				Class.forName("org.postgresql.Driver");
				 connect = DriverManager.getConnection(url, user, password);
			} catch (Exception e) {
				System.out.println("Erreur de connexion");
			}
		}
		
		//creation d'une methode d'attribution de connexion
		//permet de s'assurer l'unicité de la connexion 
		public static Connection getInstance() {
			if(connect == null) {
				new GestionConnexion();
			}
			return connect;
		}
	     
}
