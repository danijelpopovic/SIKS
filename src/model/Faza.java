package model;

import java.util.HashSet;
import java.util.Set;

import javax.swing.tree.DefaultMutableTreeNode;


public class Faza extends DefaultMutableTreeNode{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7760744273006575193L;

	public int id;

	public String nazivFaze;
	
	public Set<Korak> koraci = new HashSet<Korak>(0);	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNazivFaze() {
		return nazivFaze;
	}

	public void setNazivFaze(String nazivFaze) {
		this.nazivFaze = nazivFaze;
	}
	
	public Set<Korak> getKoraci() {
		return koraci;
	}

	public void setKoraci(Set<Korak> koraci) {
		this.koraci = koraci;
	}	

	public Faza(int id, String nazivFaze) {
		super();
		this.id = id;
		this.nazivFaze = nazivFaze;
		
	}

	public Faza(int id) {
		super();
		this.id = id;
		
	}

	public Faza() {
		super();
		
	}

	@Override
	public String toString() {
		return nazivFaze;
	}

	

	
}