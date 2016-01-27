package model;

import java.util.*;

public class StrukturaModela {
	
	public int id;	

	public double nivo;

	public double polozajUNivou;

	public List<StrukturaModela> strukturaModelaB;

	public List<StrukturaModela> strukturaModelaA;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getNivo() {
		return nivo;
	}

	public void setNivo(double nivo) {
		this.nivo = nivo;
	}

	public double getPolozajUNivou() {
		return polozajUNivou;
	}

	public void setPolozajUNivou(double polozajUNivou) {
		this.polozajUNivou = polozajUNivou;
	}

	public List<StrukturaModela> getStrukturaModelaB() {
		return strukturaModelaB;
	}

	public void setStrukturaModelaB(List<StrukturaModela> strukturaModelaB) {
		this.strukturaModelaB = strukturaModelaB;
	}

	public List<StrukturaModela> getStrukturaModelaA() {
		return strukturaModelaA;
	}

	public void setStrukturaModelaA(List<StrukturaModela> strukturaModelaA) {
		this.strukturaModelaA = strukturaModelaA;
	}

	public StrukturaModela(int id, double nivo, double polozajUNivou,
			List<StrukturaModela> strukturaModelaB,
			List<StrukturaModela> strukturaModelaA) {
		super();
		this.id = id;
		this.nivo = nivo;
		this.polozajUNivou = polozajUNivou;
		// this.strukturaModelaB = strukturaModelaB;
		// this.strukturaModelaA = strukturaModelaA;
	}

	public StrukturaModela() {
		super();
	}
	
	public StrukturaModela(int id) {
		super();
		this.id = id;
	}

}