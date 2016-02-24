package actions;

import gui.MainFrame;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import view.FazaPropertiesDialog;
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

	}

	public KorakPropertiesDialog getDialog() {
		return dialog;
	}

	public void setDialog(KorakPropertiesDialog dialog) {
		this.dialog = dialog;
	}

}
