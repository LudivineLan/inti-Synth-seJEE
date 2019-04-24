package com.infotel.metier;

public class Promo {
	private int idPromo;
	private String nomPromo;
	private int effectif;
	
	public int getIdPromo() {
		return idPromo;
	}

	public void setIdPromo(int idPromo) {
		this.idPromo = idPromo;
	}

	public String getNomPromo() {
		return nomPromo;
	}

	public void setNomPromo(String nomPromo) {
		this.nomPromo = nomPromo;
	}

	public int getEffectif() {
		return effectif;
	}

	public void setEffectif(int effectif) {
		this.effectif = effectif;
	}




	@Override
	public String toString() {
		return "Promo [idPromo=" + idPromo + ", nomPromo=" + nomPromo + ", effectif=" + effectif + "]";
	}
	
}
