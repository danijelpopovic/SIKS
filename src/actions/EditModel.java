package actions;

import gui.MainFrame;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import model.ModelZCSoftvera;
import view.EditModelDialog;

public class EditModel extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6873997553756011640L;

	public EditModel() {
		putValue(NAME, "Izmena modela");
	}

	private EditModelDialog ed;

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		ed = new EditModelDialog(MainFrame.getInstance());
		MainFrame.getInstance().setEditModelDialog(ed);

		Object o = MainFrame.getInstance().getTreeView()
				.getLastSelectedPathComponent();

		String naziv = ((ModelZCSoftvera) o).getNaziv();
		String skraceni = ((ModelZCSoftvera) o).getSkraceniNaziv();
		String opis = ((ModelZCSoftvera) o).getOpis();

		ed.getTxtNaziv().setText(naziv);
		ed.getTxtSkraceni().setText(skraceni);
		ed.getTxtOpis().setText(opis);
	}

}
