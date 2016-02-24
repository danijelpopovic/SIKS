package actions;

import gui.MainFrame;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import services.ModelZCSoftveraService;
import view.NewModelDialog;

public class AddNewModelSubmit extends AbstractAction {

	public NewModelDialog md;

	public AddNewModelSubmit() {
		putValue(NAME, "Snimi");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String naziv = MainFrame.getInstance().getNewModelDialog().getTxtNaziv().getText();
		String skraceni = MainFrame.getInstance().getNewModelDialog().getTxtSkraceni().getText();
		String opis = MainFrame.getInstance().getNewModelDialog().getTxtOpis().getText();
		
		ModelZCSoftveraService ms = MainFrame.getInstance().getModelZCSoftveraService();
		
		ms.createModelZcSoftvera(0, naziv, skraceni, opis);		
		
		MainFrame.getInstance().getNewModelDialog().dispose();
		/*md = new DialogKorak(MainFrame.getInstance());
		dk.setVisible(true);
		MainFrame.getInstance().setDialogKorak(dk);*/
		

	}

}
