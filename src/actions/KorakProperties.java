package actions;

import gui.MainFrame;

import java.awt.event.ActionEvent;
import java.util.Collection;

import javax.swing.AbstractAction;

import model.Korak;
import services.KorakService;
import view.KorakPropertiesDialog;

public class KorakProperties extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4786684352866735480L;
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
		
		KorakService ks = MainFrame.getInstance().getKorakService();
		Collection<Korak> koraci = ks.findAllKoraci();
		
		String faza = "";
		
		for (Korak k : koraci) {
			if (k.getNaziv() ==((Korak)o).getNaziv())
				faza = k.getFaza().getNazivFaze();			
		}
		
		String naziv = ((Korak)o).getNaziv();
		
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
