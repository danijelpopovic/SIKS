package tree.model;

import javax.swing.tree.DefaultTreeModel;

import model.Faza;
import model.Korak;
import model.ModelZCSoftvera;

public class RootTreeModel extends DefaultTreeModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7562560951623448322L;

	public RootTreeModel() {
		super(new RootTree());

	}

	public void addModelZCSoftvera(ModelZCSoftvera modelZCSoftvera) {
		((RootTree) getRoot()).addModelZCSoftvera(modelZCSoftvera);
	}

	public void addFaza(Faza faza) {
		((ModelZcTree) getRoot()).addFaza(faza);
	}

	public void removeFaza(Faza faza) {
		((ModelZcTree) getRoot()).removeFaza(faza);
	}

	public void addKorak(Korak korak) {
		((FazaTree) getRoot()).addKorak(korak);
	}

	public void removeModelZCSoftvera(ModelZCSoftvera modelZCSoftvera) {
		((RootTree) getRoot()).removeModelZCSoftvera(modelZCSoftvera);
	}

}
