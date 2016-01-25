package model;

import java.util.*;

public class Faze {
  
	public int id;
	
	public short oznaka;
   
	public String nazivFaze;
   
	public List<Koraci> koraci;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public short getOznaka() {
		return oznaka;
	}

	public void setOznaka(short oznaka) {
		this.oznaka = oznaka;
	}

	public String getNazivFaze() {
		return nazivFaze;
	}

	public void setNazivFaze(String nazivFaze) {
		this.nazivFaze = nazivFaze;
	}

	public List<Koraci> getKoraci() {
		return koraci;
	}

	public void setKoraci(List<Koraci> koraci) {
		this.koraci = koraci;
	} 

	
   
}