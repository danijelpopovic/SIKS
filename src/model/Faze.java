package model;

import java.util.*;

public class Faze {

	public int id;

	public int oznaka;

	public String nazivFaze;

	// public List<Koraci> koraci;

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

	public String getNazivFaze() {
		return nazivFaze;
	}

	public void setNazivFaze(String nazivFaze) {
		this.nazivFaze = nazivFaze;
	}

	public Faze(int id, short oznaka, String nazivFaze, List<Koraci> koraci) {
		super();
		this.id = id;
		this.oznaka = oznaka;
		this.nazivFaze = nazivFaze;
		// this.koraci = koraci;
	}

	public Faze(int id) {
		super();
		this.id = id;
	}

	public Faze() {
		super();
	}

	/*
	 * public List<Koraci> getKoraci() { return koraci; }
	 * 
	 * public void setKoraci(List<Koraci> koraci) { this.koraci = koraci; }
	 */

}