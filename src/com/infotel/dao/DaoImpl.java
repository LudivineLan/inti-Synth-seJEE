package com.infotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.infotel.metier.Formation;
import com.infotel.metier.Promo;
import com.infotel.metier.Stagiaire;

public class DaoImpl implements Idao {
	
	private Connection connect;
	private PreparedStatement st;
	private ResultSet rs;
	
	@Override
	public int ajouterStagiaire(Stagiaire s) {
		try {
			//1- se connecter à la base de données
			connect = GestionConnexion.getInstance();
			
			//2- préparer et effectuer la requête
			st = connect.prepareStatement("INSERT INTO Stagiaire (nom, prenom, age,)"
					+ " VALUES(?,?,?)");
			st.setString(1, s.getNom());
			st.setString(2, s.getPrenom());
			st.setInt(3, s.getAge());
			//st.setInt(4, s.getfidPromo());
			
			st.executeUpdate();
			
			//3- recuperer le résultat en cas de besoin
			
		} catch (Exception e) {
			System.out.println("Erreur");
			e.printStackTrace();
		}
		
		return s.getIdStagiaire();
	}

	@Override
	public int supprimerStagiaire(int idStagiaire) {
		try {
			//1- se connecter à la base de données
			connect = GestionConnexion.getInstance();
			
			//2- préparer et effectuer la requête
			st = connect.prepareStatement("DELETE FROM Stagiaire"
					+ " where (idStagiaire= ?)");
			st.setInt(1,idStagiaire);
			
			st.executeUpdate();
			
			//3- recuperer le résultat en cas de besoin
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return idStagiaire;
	}

	@Override
	public List<Stagiaire> findAll() {
		//initialisation de la liste qui va recupérer les résultats
		List<Stagiaire> list = new ArrayList<Stagiaire>();
		try {
			//1- se connecter à la base de données
			connect = GestionConnexion.getInstance();
	
			//2- préparer et effectuer la requête
			st = connect.prepareStatement("SELECT * FROM Stagiaire");
	
			rs = st.executeQuery();
	
			//3- on recupere les resultats des colonnes SQL que l'on met dans un objet personne que l'on ajoute dans une liste
			while(rs.next()) { //tant que la ligne est remplie je remplie la liste
				Stagiaire s = new Stagiaire();
				s.setIdStagiaire(rs.getInt("idStagiaire"));
				s.setNom(rs.getString("nom"));
				s.setPrenom(rs.getString("prenom"));
				s.setAge(rs.getInt("age"));
				
				list.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public int ajouterPromo(Promo p) {
		try {
			//1- se connecter à la base de données
			connect = GestionConnexion.getInstance();
			
			//2- préparer et effectuer la requête
			st = connect.prepareStatement("INSERT INTO Promo (nomPromo, effectif)"
					+ " VALUES(?,?)");
			st.setString(1, p.getNomPromo());
			st.setInt(2, p.getEffectif());
			
			st.executeUpdate();
			
			//3- recuperer le résultat en cas de besoin
			
		} catch (Exception e) {
			System.out.println("Erreur");
			e.printStackTrace();
		}
		
		return p.getIdPromo();
	}

	@Override
	public int supprimerPromo(int idPromo) {
		try {
			//1- se connecter à la base de données
			connect = GestionConnexion.getInstance();
			
			//2- préparer et effectuer la requête
			st = connect.prepareStatement("DELETE FROM Promo"
					+ " where (idPromo= ?)");
			st.setInt(1,idPromo);
			
			st.executeUpdate();
			
			//3- recuperer le résultat en cas de besoin
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return idPromo;
	}


	@Override
	public List<Promo> findAllPromo() {
		
		//initialisation de la liste qui va recupérer les résultats
		List<Promo> list = new ArrayList<Promo>();
		
		try {
			//1- se connecter à la base de données
			connect = GestionConnexion.getInstance();
			
			//2- préparer et effectuer la requête
			st = connect.prepareStatement("SELECT * FROM Promo");
			
			rs = st.executeQuery();
			
			//3- on recupere les resultats des colonnes SQL que l'on met dans un objet personne que l'on ajoute dans une liste
			while(rs.next()) { //tant que la ligne est remplie je remplie la liste
				Promo p = new Promo();
				p.setIdPromo(rs.getInt("idPromo"));
				p.setNomPromo(rs.getString("nomPromo"));
				p.setEffectif(rs.getInt("effectif"));
				
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int ajouterFormation(Formation f) {
		try {
			//1- se connecter à la base de données
			connect = GestionConnexion.getInstance();
			
			//2- préparer et effectuer la requête
			st = connect.prepareStatement("INSERT INTO Formation (nomFormation)"
					+ " VALUES(?)");
			st.setString(1, f.getNomFormation());
			
			st.executeUpdate();
			
			//3- recuperer le résultat en cas de besoin
			
		} catch (Exception e) {
			System.out.println("Erreur");
			e.printStackTrace();
		}
		
		return f.getIdFormation();
	}

	@Override
	public int supprimerFormation(int idFormation) {
		try {
			//1- se connecter à la base de données
			connect = GestionConnexion.getInstance();
			
			//2- préparer et effectuer la requête
			st = connect.prepareStatement("DELETE FROM Formation"
					+ " where (idFormation= ?)");
			st.setInt(1,idFormation);
			
			st.executeUpdate();
			
			//3- recuperer le résultat en cas de besoin
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return idFormation;
	}


	@Override
	public List<Formation> findAllFormation() {
		//initialisation de la liste qui va recupérer les résultats
				List<Formation> list = new ArrayList<Formation>();
		try {
			//1- se connecter à la base de données
			connect = GestionConnexion.getInstance();
			
			//2- préparer et effectuer la requête
			st = connect.prepareStatement("SELECT * FROM Formation");
			
			rs = st.executeQuery();
			
			//3- on recupere les resultats des colonnes SQL que l'on met dans un objet personne que l'on ajoute dans une liste
			while(rs.next()) { //tant que la ligne est remplie je remplie la liste
				Formation f = new Formation();
				f.setIdFormation(rs.getInt("idFormation"));
				f.setNomFormation(rs.getString("nomFormation"));
				
				list.add(f);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	@Override
	public void ajouterPromoFormation(Promo p, Formation f) {
		try {
			//1- se connecter à la base de données
			connect = GestionConnexion.getInstance();
			
			//2- préparer et effectuer la requête
			st = connect.prepareStatement("UPDATE Promo set fidFormation =? where idPromo=?");
			
			st.setInt(1,f.getIdFormation());
			st.setInt(2,f.getIdFormation());
			
			
			st.executeUpdate();
			
			//3- recuperer le résultat en cas de besoin
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
	@Override
	public void ajouterStagiairePromo(Stagiaire s, Promo p) {
		try {
			//1- se connecter à la base de données
			connect = GestionConnexion.getInstance();
			
			//2- préparer et effectuer la requête
			st = connect.prepareStatement("UPDATE Promo set fidPromo =? where idStagiaire=?");
			
			st.setInt(1,s.getIdStagiaire());
			st.setInt(1,s.getIdStagiaire());
			
			
			st.executeUpdate();
			
			//3- recuperer le résultat en cas de besoin
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
}
