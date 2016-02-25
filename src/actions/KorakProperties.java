package actions;

import gui.MainFrame;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import model.Korak;
import view.KorakPropertiesDialog;

public class KorakProperties extends AbstractAction {

	public KorakPropertiesDialog dialog;

	public KorakProperties() {
		putValue(NAME, "Osobine koraka");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		dialog = new KorakPropertiesDialog(MainFrame.getInstance());
		MainFrame.getInstance().setKorakProperties(dialog);
		
		Object o = MainFrame.getInstance().getTreeView()
				.getLastSelectedPathComponent();
		
		System.out.println(((Korak)o).getFaza());
		
		String naziv = ((Korak)o).getNaziv();
		String faza = ((Korak)o).getFaza().getNazivFaze();
		
		System.out.println(faza);
		
		dialog.getLblNazivKoraka().setText(naziv);
		dialog.getLblFazaKoraka().setText(faza);

	}

	public KorakPropertiesDialog getDialog() {
		return dialog;
	}

	public void setDialog(KorakPropertiesDialog dialog) {
		this.dialog = dialog;
	}

}
