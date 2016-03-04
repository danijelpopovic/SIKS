package actions;

import gui.MainFrame;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.SwingUtilities;

import model.Faza;
import model.ModelZCSoftvera;
import services.FazaService;
import services.KorakService;

public class SubmitAddFaza extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3123348726088238426L;

	public SubmitAddFaza() {
		putValue(NAME, "Ok");
	}

	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {

		String nazivFaze = MainFrame.getInstance().getActionManager()
				.getAddNewFaza().getFazaView().getNazivFaze().getText();
		FazaService fs = new FazaService(MainFrame.getInstance().getEm());
		KorakService korakService = new KorakService(MainFrame.getInstance()
				.getEm());
		Object o = MainFrame.getInstance().getTreeView()
				.getLastSelectedPathComponent();
		if (o instanceof ModelZCSoftvera) {

			ModelZCSoftvera modelZc = (ModelZCSoftvera) o;

			Faza faza = fs.createFaza(0, nazivFaze, modelZc.getId());
			// ((ModelZCSoftvera)o).a
			modelZc.add(faza);

			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance()
					.getTreeView());

		}

		MainFrame.getInstance().getActionManager().getAddNewFaza()
				.getFazaView().dispose();

	}
}
