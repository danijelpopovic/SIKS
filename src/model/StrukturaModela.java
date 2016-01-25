package model;

import java.util.*;

public class StrukturaModela {

   public double nivo;

   public double polozajUNivou;
      
   public List<StrukturaModela> strukturaModelaB;
   
   public List<StrukturaModela> strukturaModelaA;

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
   
   

}