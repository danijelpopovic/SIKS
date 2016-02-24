package actions;

import gui.MainFrame;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.AbstractAction;

import model.Korak;
import services.KorakService;

public class RemoveKorak extends AbstractAction{
	
	public RemoveKorak() {
		putValue(NAME, "Obrisi korak");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		KorakService ks = MainFrame.getInstance().getKorakService();
		
		Object o = MainFrame.getInstance().getTreeView().getLastSelectedPathComponent();
		
		List<Korak> koraci = (List<Korak>) ks.findAllKoraci();
		
		for (Korak k : koraci) {
			if (k.getId() == (((Korak)o)).getId()) {
				ks.removeKorak(k.getId());
			}
		}		
	}
}
