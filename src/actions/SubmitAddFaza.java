package actions;

import gui.MainFrame;

import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Set;

import javax.swing.AbstractAction;
import javax.swing.SwingUtilities;

import model.Faza;
import model.Korak;
import model.ModelZCSoftvera;
import services.FazaService;
import services.KorakService;

public class SubmitAddFaza extends AbstractAction{

	
	
	public SubmitAddFaza(){
		putValue(NAME, "Ok");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String nazivFaze = MainFrame.getInstance().getActionManager().getAddNewFaza().getFazaView().getNazivFaze().getText();
		FazaService fs = new FazaService(MainFrame.getInstance().getEm());
		KorakService korakService = new KorakService(MainFrame.getInstance().getEm());
		Object o = MainFrame.getInstance().getTreeView().getLastSelectedPathComponent();
		if(o instanceof ModelZCSoftvera){
			
			ModelZCSoftvera modelZc = (ModelZCSoftvera)o;
			
			Faza faza = fs.createFaza(0, nazivFaze,modelZc.getId());
			//((ModelZCSoftvera)o).a
			modelZc.add(faza);		
			
			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTreeView());	
			
		}
		
		
		MainFrame.getInstance().getActionManager().getAddNewFaza().getFazaView().dispose();
		 
		
	}
}
