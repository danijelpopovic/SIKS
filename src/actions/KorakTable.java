package actions;

import gui.MainFrame;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.AbstractAction;

import model.Faza;
import services.FazaService;
import view.DialogKorak;

public class KorakTable extends AbstractAction{

	public DialogKorak dk;
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		dk = new DialogKorak(MainFrame.getInstance());
		MainFrame.getInstance().setDialogKorak(dk);
		FazaService fs = MainFrame.getInstance().getFazaService();
		
		List<Faza> faze = (List<Faza>) fs.findAllFaze();
		for(Faza f : faze){
			dk.getCmbFaza().addItem(f);
		}
	}

	public DialogKorak getDk() {
		return dk;
	}

	public void setDk(DialogKorak dk) {
		this.dk = dk;
	
	}
	
	

}
