package actions;

import gui.MainFrame;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

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

	}

	public FazaPropertiesDialog getDialog() {
		return dialog;
	}

	public void setDialog(FazaPropertiesDialog dialog) {
		this.dialog = dialog;
	}

}
