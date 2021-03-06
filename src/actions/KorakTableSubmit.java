package actions;

import gui.MainFrame;

import java.awt.event.ActionEvent;
import java.util.Collection;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import model.Faza;
import model.Korak;
import services.FazaService;
import services.KorakService;
import view.DialogKorak;

public class KorakTableSubmit extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6739601732455147085L;
	public DialogKorak dk;

	public KorakTableSubmit() {
		putValue(NAME, "Sačuvaj korak");
	}

	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String nazivKoraka = MainFrame.getInstance().getDialogKorak()
				.getTxtNaziv().getText();
		KorakService ks = MainFrame.getInstance().getKorakService();
		FazaService fs = MainFrame.getInstance().getFazaService();
		int type = MainFrame.getInstance().getDialogKorak().getCmbFazaAkcija()
				.getSelectedIndex();

		if (nazivKoraka.equals("")) {
			JOptionPane.showMessageDialog(null, "Korak mora imati naziv",
					"Upozorenje", JOptionPane.ERROR_MESSAGE);
			return;
		}

		Collection<Korak> koraci = ks.findAllKoraci();
		Collection<Faza> fazeProvera = fs.findAllFaze();

		for (Korak k : koraci) {
			if (k.getNaziv().equals(nazivKoraka)) {
				JOptionPane.showMessageDialog(null,
						"Vec postoji korak sa zadatim nazivom", "Upozorenje",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
		}

		Faza faza = null;

		if (type == 0) {
			Faza selektovanaFaza = (Faza) MainFrame.getInstance()
					.getDialogKorak().getCmbFaza().getSelectedItem();
			if (selektovanaFaza != null) {
				faza = fs.findFaza(selektovanaFaza.getId());
			} else {
				JOptionPane.showMessageDialog(null, "Morate izabrati fazu",
						"Upozorenje", JOptionPane.ERROR_MESSAGE);
				return;
			}

		} else if (type == 1) {
			String nazivFaza = MainFrame.getInstance().getDialogKorak()
					.getTextFaza().getText();
			if (nazivFaza.equals("")) {
				JOptionPane.showMessageDialog(null, "Faza mora imati naziv",
						"Upozorenje", JOptionPane.ERROR_MESSAGE);
				return;
			}
			for (Faza f : fazeProvera) {
				if (f.getNazivFaze().equals(nazivFaza)) {
					JOptionPane.showMessageDialog(null,
							"Već postoji faza sa zadatim nazivom",
							"Upozorenje", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			faza = fs.createFaza(0, nazivFaza);
		}

		ks.createKorak(0, nazivKoraka, faza);

		MainFrame.getInstance().getDialogKorak().dispose();
		dk = new DialogKorak(MainFrame.getInstance());
		dk.setVisible(true);
		MainFrame.getInstance().setDialogKorak(dk);
		List<Faza> faze = (List<Faza>) fs.findAllFaze();
		for (Faza f : faze) {
			dk.getCmbFaza().addItem(f);
		}

	}

}
