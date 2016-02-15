package actions;

import gui.MainFrame;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import services.KorakService;
import view.DialogKorak;

public class KorakTableSubmit extends AbstractAction{

	public DialogKorak dk;
	
	public KorakTableSubmit(){
		putValue(NAME, "Snimi");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	String nazivKoraka = MainFrame.getInstance().getDialogKorak().getTxtNaziv().getText();
	KorakService ks = MainFrame.getInstance().getKorakService();
	
	ks.createKorak(0, nazivKoraka, null);
	
	
	MainFrame.getInstance().getDialogKorak().dispose();
	dk = new DialogKorak(MainFrame.getInstance());
	dk.setVisible(true);
	MainFrame.getInstance().setDialogKorak(dk);
	
	}

}
