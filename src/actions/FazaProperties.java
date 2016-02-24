package actions;

import gui.MainFrame;

import java.awt.event.ActionEvent;
import java.util.HashSet;
import java.util.Set;

import javax.swing.AbstractAction;

import model.Faza;
import model.Korak;
import view.FazaPropertiesDialog;

public class FazaProperties extends AbstractAction {

	public FazaPropertiesDialog dialog;

	public FazaProperties() {
		putValue(NAME, "Osobine faze");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		dialog = new FazaPropertiesDialog(MainFrame.getInstance());
		MainFrame.getInstance().setFazaProperties(dialog);
		
		Object o = MainFrame.getInstance().getTreeView()
				.getLastSelectedPathComponent();
		
		Set<Korak> koraci = ((Faza)o).getKoraci();
		
		for (Korak k : koraci) {
			dialog.getKoraci().addItem(k.getNaziv());
		}
		
		String naziv = ((Faza)o).getNazivFaze();		
		
		dialog.getLblNazivFaze().setText(naziv);

	}

	public FazaPropertiesDialog getDialog() {
		return dialog;
	}

	public void setDialog(FazaPropertiesDialog dialog) {
		this.dialog = dialog;
	}

}
