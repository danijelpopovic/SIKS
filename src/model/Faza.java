package model;


public class Faza {

	public int id;

	public String nazivFaze;

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


}