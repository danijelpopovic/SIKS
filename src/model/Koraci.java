package model;

import java.util.List;

public class Koraci {
   
   public int id;
   
   public String naziv;
   
   //public List<StrukturaModela> strukturaModela;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNaziv() {
		return naziv;
	}
	
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	/*public List<StrukturaModela> getStrukturaModela() {
		return strukturaModela;
	}
	
	public void setStrukturaModela(List<StrukturaModela> strukturaModela) {
		this.strukturaModela = strukturaModela;
	}*/

	public Koraci(int id, String naziv, List<StrukturaModela> strukturaModela) {
		super();
		this.id = id;
		this.naziv = naziv;
		//this.strukturaModela = strukturaModela;
	}

	public Koraci(int id) {
		super();
		this.id = id;
	}

	public Koraci() {
		super();
	}
	
	
   
   
   
}