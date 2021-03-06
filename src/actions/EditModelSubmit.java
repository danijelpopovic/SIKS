package actions;

import gui.MainFrame;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import model.ModelZCSoftvera;
import services.ModelZCSoftveraService;

public class EditModelSubmit extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2111560131449301567L;

	public EditModelSubmit() {
		putValue(NAME, "Izmeni model");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String naziv = MainFrame.getInstance().getEditModelDialog()
				.getTxtNaziv().getText();
		String skraceni = MainFrame.getInstance().getEditModelDialog()
				.getTxtSkraceni().getText();
		String opis = MainFrame.getInstance().getEditModelDialog().getTxtOpis()
				.getText();

		if (naziv.equals("")) {
			JOptionPane.showMessageDialog(null, "Model mora imati naziv",
					"Upozorenje", JOptionPane.ERROR_MESSAGE);
			return;
		}

		Object o = MainFrame.getInstance().getTreeView()
				.getLastSelectedPathComponent();

		ModelZCSoftveraService ms = MainFrame.getInstance()
				.getModelZCSoftveraService();


		ms.updateModelZCSoftvera(
				((ModelZCSoftvera) o).getId(), naziv, skraceni, opis);
		MainFrame.getInstance().getEditModelDialog().dispose();

	}

}
