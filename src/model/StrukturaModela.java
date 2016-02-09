package model;

public class StrukturaModela {

	public int id;

	public ModelZCSoftvera model;

	public Korak korak;

	public Korak prethodni_korak;

	public Korak sledeci_korak;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Korak getPrethodni_korak() {
		return prethodni_korak;
	}

	public void setPrethodni_korak(Korak prethodni_korak) {
		this.prethodni_korak = prethodni_korak;
	}

	public Korak getSledeci_korak() {
		return sledeci_korak;
	}

	public void setSledeci_korak(Korak sledeci_korak) {
		this.sledeci_korak = sledeci_korak;
	}

	public StrukturaModela() {
		super();
	}

	public StrukturaModela(int id) {
		super();
		this.id = id;
	}

	public StrukturaModela(int id, ModelZCSoftvera model, Korak korak,
			Korak prethodni_korak, Korak sledeci_korak) {
		super();
		this.id = id;
		this.model = model;
		this.korak = korak;
		this.prethodni_korak = prethodni_korak;
		this.sledeci_korak = sledeci_korak;
	}
	
	public StrukturaModela(int id, ModelZCSoftvera model, Korak korak) {
		super();
		this.id = id;
		this.model = model;
		this.korak = korak;
	}

}