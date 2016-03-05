package actions;

import gui.MainFrame;

import java.awt.event.ActionEvent;
import java.util.Collection;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import model.Faza;
import model.Korak;
import model.StrukturaModela;
import services.FazaService;
import services.KorakService;
import services.StrukturaModelaService;
import view.DialogKorak;

public class RemoveKorak extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8188055411411217136L;

	public RemoveKorak() {
		putValue(NAME, "Obriši korak");
	}

	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		DialogKorak dk = MainFrame.getInstance().getDialogKorak();
		int select = dk.getTable().getSelectedRow();
		if (select > -1) {
			int id = Integer.parseInt(dk.getTable().getValueAt(select, 0)
					.toString());
			KorakService ks = MainFrame.getInstance().getKorakService();
			FazaService fs = MainFrame.getInstance().getFazaService();
			StrukturaModelaService ss = MainFrame.getInstance()
					.getStrukturaModelaService();

			Collection<StrukturaModela> strukture = ss.findAllStrukturaModela();

			for (StrukturaModela s : strukture) {
				if ((s.getKorak().getId() == id)
						|| (s.getSledeci_korak().getId() == id)) {
					JOptionPane
							.showMessageDialog(
									null,
									"Nije dozvoljeno brisanje koraka jer se nalazi u modelu",
									"Upozorenje",
									JOptionPane.INFORMATION_MESSAGE);
					return;
				}
			}
			
			Collection<Korak> koraci = ks.findAllKoraci();
			Korak kk = new Korak();
			int faza = 0;
			
			for (Korak k : koraci) {
				if (k.getId() == id)
					kk = k;
			}
			
			for (Korak k : koraci) {
				if (kk.getFaza().getId() == k.getFaza().getId()) {
					faza++;					
				}
			}
			
			if (faza == 1) {
				fs.removeFaza(kk.getFaza().getId());
			}
			

			ks.removeKorak(id);

			dk.getTableModel().deleteRow(select);
			List<Faza> faze = (List<Faza>) fs.findAllFaze();
			dk.getCmbFaza().removeAllItems();
			for (Faza f : faze) {
				dk.getCmbFaza().addItem(f);
			}
		}

		else {
			JOptionPane.showMessageDialog(null, "Morate izabrati korak!",
					"Upozorenje", JOptionPane.INFORMATION_MESSAGE);
		}

	}
}
