package model;

import javax.swing.tree.DefaultMutableTreeNode;


public class Korak extends DefaultMutableTreeNode {

	public int id;

	public String naziv;

	public Faza faza;

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

	public Faza getFaza() {
		return faza;
	}

	public void setFaza(Faza faza) {
		this.faza = faza;
	}

	public Korak(int id, String naziv, Faza faza) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.faza = faza;
	}

	public Korak(int id) {
		super();
		this.id = id;
	}

	public Korak() {
		super();
	}

	@Override
	public String toString() {
		return naziv;
	}

	
}