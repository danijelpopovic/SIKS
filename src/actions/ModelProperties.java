package actions;

import gui.MainFrame;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JLabel;

import model.ModelZCSoftvera;
import services.ModelZCSoftveraService;
import view.ModelPropertiesDialog;

public class ModelProperties extends AbstractAction {

	public ModelPropertiesDialog dialog;

	public ModelProperties() {
		putValue(NAME, "Osobine modela");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		dialog = new ModelPropertiesDialog(MainFrame.getInstance());
		MainFrame.getInstance().setModelProperties(dialog);

		Object o = MainFrame.getInstance().getTreeView()
				.getLastSelectedPathComponent();
		
		String naziv = ((ModelZCSoftvera)o).getNaziv();
		String skraceni = ((ModelZCSoftvera)o).getSkraceniNaziv();
		String opis = ((ModelZCSoftvera)o).getOpis();
		
		dialog.getTxtNaziv().setText(naziv);
		
		if (skraceni.equals(""))
			dialog.getTxtSkraceni().setText("-");
		else
			dialog.getTxtSkraceni().setText(skraceni);
		
		if (opis.equals(""))
			dialog.getTxtOpis().setText("-");
		else
			dialog.getTxtOpis().setText(opis);
	}

	public ModelPropertiesDialog getDialog() {
		return dialog;
	}

	public void setDialog(ModelPropertiesDialog dialog) {
		this.dialog = dialog;
	}

}
