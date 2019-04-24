package com.infotel.dao;

import java.util.List;

import com.infotel.metier.Formation;
import com.infotel.metier.Promo;
import com.infotel.metier.Stagiaire;

public interface Idao {
	
	public int ajouterStagiaire (Stagiaire s); 
	int supprimerStagiaire (int idStagiaire); 
	public List<Stagiaire> findAll();
	
	public int ajouterPromo (Promo p); 
	int supprimerPromo (int idPromo); 
	public List<Promo> findAllPromo();
	
	public int ajouterFormation (Formation f); 
	int supprimerFormation (int idFormation); 
	public List<Formation> findAllFormation();
	void ajouterPromoFormation(Promo p, Formation f);
	void ajouterStagiairePromo(Stagiaire s, Promo p);

}
