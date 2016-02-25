package actions;

import gui.MainFrame;

import java.awt.event.ActionEvent;
import java.util.Collection;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import model.StrukturaModela;
import services.KorakService;
import services.StrukturaModelaService;
import view.DialogKorak;

public class RemoveKorak extends AbstractAction {

	public RemoveKorak() {
		putValue(NAME, "Obrisi korak");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		DialogKorak dk = MainFrame.getInstance().getDialogKorak();
		int select = dk.getTable().getSelectedRow();
		if (select > -1) {
			int id = Integer.parseInt(dk.getTable().getValueAt(select, 0)
					.toString());
			KorakService ks = MainFrame.getInstance().getKorakService();
			StrukturaModelaService ss = MainFrame.getInstance()
					.getStrukturaModelaService();

			Collection<StrukturaModela> strukture = ss.findAllStrukturaModela();

			for (StrukturaModela s : strukture) {
				if ((s.getKorak().getId() == id)
						|| (s.getSledeci_korak().getId() == id)) {
					JOptionPane
							.showMessageDialog(
									null,
									"Nije dozvoljeno brisanje koraka, jer se nalazi u modelu",
									"Upozorenje",
									JOptionPane.INFORMATION_MESSAGE);
					return;
				}
			}

			ks.removeKorak(id);

			dk.getTableModel().deleteRow(select);
		}

		else {
			JOptionPane.showMessageDialog(null, "Morate izabrati korak!",
					"Upozorenje", JOptionPane.INFORMATION_MESSAGE);
		}

	}
}
