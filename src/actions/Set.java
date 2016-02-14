package actions;

import gui.MainFrame;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.AbstractAction;

import model.Korak;
import model.ModelZCSoftvera;
import services.FazaService;
import services.KorakService;
import services.ModelZCSoftveraService;
import view.SetView;

public class Set extends AbstractAction{

	public Set(){
		putValue(NAME, "Set");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		SetView sv = new SetView(MainFrame.getInstance());
		MainFrame.getInstance().setSetView(sv);
		KorakService ks = new KorakService(MainFrame.getInstance().getEm());
		
		List<Korak> koraci = (List<Korak>) ks.findAllKoraci();
		Collection koraciNazivi = new ArrayList<String>();
		
		for(Korak k: koraci){
			if(k.getFaza()==null)
				koraciNazivi.add(k.getNaziv());
		}
		//new String[] { "One", "Two", "Three" }
		sv.addSourceElements(koraciNazivi.toArray());
		
		ModelZCSoftveraService mzcss = MainFrame.getInstance().getModelZCSoftveraService();
	    List<ModelZCSoftvera> modeli = (List<ModelZCSoftvera>) mzcss.findAllModelZcSoftvera();
	    for(ModelZCSoftvera m: modeli){
	    	sv.getCmbModel().addItem(m);
	    }	
		
	}

}