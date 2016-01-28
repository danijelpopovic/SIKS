package model;

import java.util.*;

public class StrukturaModela {

	public int id;

	public int nivo;

	public int polozajUNivou;

	public ModelZCSoftvera model;

	public Korak korak;
	
	public Set<StrukturaModela> struktureModela;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNivo() {
		return nivo;
	}

	public void setNivo(int nivo) {
		this.nivo = nivo;
	}

	public int getPolozajUNivou() {
		return polozajUNivou;
	}

	public void setPolozajUNivou(int polozajUNivou) {
		this.polozajUNivou = polozajUNivou;
	}

	public Set<StrukturaModela> getStruktureModela() {
		return struktureModela;
	}

	public void setStruktureModela(Set<StrukturaModela> struktureModela) {
		this.struktureModela = struktureModela;
	}

	public ModelZCSoftvera getModel() {
		return model;
	}

	public void setModel(ModelZCSoftvera model) {
		this.model = model;
	}

	public Korak getKorak() {
		return korak;
	}

	public void setKorak(Korak korak) {
		this.korak = korak;
	}

	public StrukturaModela(int id, int nivo, int polozajUNivou,
			ModelZCSoftvera model, Korak korak) {
		super();
		this.id = id;
		this.nivo = nivo;
		this.polozajUNivou = polozajUNivou;
		this.korak = korak;
		this.model = model;
	}
	
	public StrukturaModela(int id, int nivo, int polozajUNivou,
			ModelZCSoftvera model, Korak korak, Set<StrukturaModela> struktureModela) {
		super();
		this.id = id;
		this.nivo = nivo;
		this.polozajUNivou = polozajUNivou;
		this.korak = korak;
		this.model = model;
		this.struktureModela = struktureModela;
	}

	public StrukturaModela() {
		super();
	}

	public StrukturaModela(int id) {
		super();
		this.id = id;
	}

}