package actions;

import gui.MainFrame;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.AbstractAction;

import model.Korak;
import services.KorakService;
import view.SetView;

public class Set extends AbstractAction{

	public Set(){
		putValue(NAME, "Set");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		SetView sv = new SetView(MainFrame.getInstance());
		KorakService ks = new KorakService(MainFrame.getInstance().getEm());
		
		List<Korak> koraci = (List<Korak>) ks.findAllKoraci();
		Collection koraciNazivi = new ArrayList<String>();
		
		for(Korak k: koraci){
			koraciNazivi.add(k.getNaziv());
		}
		//new String[] { "One", "Two", "Three" }
		sv.addSourceElements(koraciNazivi.toArray());
	
	}

}