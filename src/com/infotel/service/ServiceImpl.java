package com.infotel.service;

import java.util.List;

import com.infotel.dao.DaoImpl;
import com.infotel.dao.Idao;
import com.infotel.metier.Formation;
import com.infotel.metier.Promo;
import com.infotel.metier.Stagiaire;

public class ServiceImpl implements Iservice {
	private Idao dao = new DaoImpl();

	@Override
	public int ajouterStagiaire(Stagiaire s) {
		// TODO Auto-generated method stub
		return dao.ajouterStagiaire(s);
	}

	@Override
	public int supprimerStagiaire(int idStagiaire) {
		// TODO Auto-generated method stub
		return dao.supprimerStagiaire(idStagiaire);
	}

	@Override
	public List<Stagiaire> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public int ajouterPromo(Promo p) {
		// TODO Auto-generated method stub
		return dao.ajouterPromo(p);
	}

	@Override
	public int supprimerPromo(int idPromo) {
		// TODO Auto-generated method stub
		return dao.supprimerPromo(idPromo);
	}

	@Override
	public List<Promo> findAllPromo() {
		// TODO Auto-generated method stub
		return dao.findAllPromo();
	}

	@Override
	public int ajouterFormation(Formation f) {
		// TODO Auto-generated method stub
		return dao.ajouterFormation(f);
	}

	@Override
	public int supprimerFormation(int idFormation) {
		// TODO Auto-generated method stub
		return dao.supprimerFormation(idFormation);
	}


	@Override
	public List<Formation> findAllFormation() {
		// TODO Auto-generated method stub
		return dao.findAllFormation();
	}
	
	@Override
	public void ajouterPromoFormation(Promo p, Formation f) {
			
	}

	@Override
	public void ajouterStagiairePromo(Stagiaire s, Promo p) {
		// TODO Auto-generated method stub
		
	}

}
