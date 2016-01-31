package model;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import javax.swing.tree.DefaultMutableTreeNode;




public class ModelZCSoftvera extends DefaultMutableTreeNode{

	public int id;	
	
	public String naziv;

	public String skraceniNaziv;

	public String opis;

	public Set<StrukturaModela> strukturaModela = new HashSet<StrukturaModela>(0);

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

	

	public Set<StrukturaModela> getStrukturaModela() {
		return strukturaModela;
	}

	public void setStrukturaModela(Set<StrukturaModela> strukturaModela) {
		this.strukturaModela = strukturaModela;
	}

	public ModelZCSoftvera(int id, String naziv,
			String skraceniNaziv, String opis,
			List<StrukturaModela> strukturaModela) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.skraceniNaziv = skraceniNaziv;
		this.opis = opis;
		//this.strukturaModela = strukturaModela;
	}

	public ModelZCSoftvera(int id) {
		super();
		this.id = id;
	}

	public ModelZCSoftvera() {
		
	}

	@Override
	public String toString() {
		return naziv;
	}
	
	public Enumeration<Faza> children() {
		// TODO Auto-generated method stub
		Enumeration<Faza> en;
		Vector<Faza> d = new Vector<Faza>();
		
		List<Faza> fs = new ArrayList<Faza>();
		Faza f1 = new Faza();
		f1.setNazivFaze("faza 2");
		fs.add(f1);
		for(int i = 0; i < fs.size(); i++){
			d.add(fs.get(i));
		}
		en = d.elements();
		return en;
	}

}