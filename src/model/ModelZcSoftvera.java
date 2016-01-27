package model;

import java.util.List;


public class ModelZcSoftvera {

	public int id;

	public int oznaka;
	
	public String naziv;

	public String skraceniNaziv;

	public String opis;

	//public List<StrukturaModela> strukturaModela;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOznaka() {
		return oznaka;
	}

	public void setOznaka(int oznaka) {
		this.oznaka = oznaka;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getSkraceniNaziv() {
		return skraceniNaziv;
	}

	public void setSkraceniNaziv(String skraceniNaziv) {
		this.skraceniNaziv = skraceniNaziv;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	/*public List<StrukturaModela> getStrukturaModela() {
		return strukturaModela;
	}

	public void setStrukturaModela(List<StrukturaModela> strukturaModela) {
		this.strukturaModela = strukturaModela;
	}*/

	public ModelZcSoftvera(int id, int oznaka, String naziv,
			String skraceniNaziv, String opis,
			List<StrukturaModela> strukturaModela) {
		super();
		this.id = id;
		this.oznaka = oznaka;
		this.naziv = naziv;
		this.skraceniNaziv = skraceniNaziv;
		this.opis = opis;
		//this.strukturaModela = strukturaModela;
	}

	public ModelZcSoftvera(int id) {
		super();
		this.id = id;
	}

	public ModelZcSoftvera() {
		super();
	}
	
	

}