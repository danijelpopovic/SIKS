package actions;

import gui.MainFrame;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.SwingUtilities;

import model.Faza;
import model.Korak;
import model.ModelZCSoftvera;
import model.StrukturaModela;
import services.FazaService;
import services.KorakService;
import services.ModelZCSoftveraService;
import services.StrukturaModelaService;
import view.SetView;
import view.SortedListModel;

import java.util.Set;

public class SetSubmit extends AbstractAction{	
	
	public SetSubmit(){
		putValue(NAME, "Ok");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Set<Korak> koraciFaze = new HashSet<Korak>(0);
		SortedListModel model = MainFrame.getInstance().getSetView().getDestListModel();
		
		KorakService ks = MainFrame.getInstance().getKorakService();//new KorakService(MainFrame.getInstance().getEm());
		FazaService fs = MainFrame.getInstance().getFazaService();//new FazaService(MainFrame.getInstance().getEm());
		StrukturaModelaService sms = MainFrame.getInstance().getStrukturaModelaService();//new StrukturaModelaService(MainFrame.getInstance().getEm());
		ModelZCSoftveraService mss = MainFrame.getInstance().getModelZCSoftveraService();//new ModelZCSoftveraService(MainFrame.getInstance().getEm());
		ModelZCSoftvera ms = null;
		
		String nazivFaze = MainFrame.getInstance().getSetView().getTxtFaza().getText();
		Faza f = fs.createFaza(0, nazivFaze);
		
		Object o = MainFrame.getInstance().getSetView().getCmbModel().getSelectedItem();
	
		int positon=0;
		if(o instanceof ModelZCSoftvera){
			ms = mss.findModelZcSoftvera(((ModelZCSoftvera)o).getId());
			if(ms!=null){
				int counter=0;
				List<Korak> koraci = (List<Korak>) ks.findAllKoraci();
				for(int i=0; i<model.getModel().size(); i++){
					System.out.println("------->  "+model.getElementAt(i));
					for(Korak k : koraci){
						if(model.getElementAt(i).equals(k.getNaziv())){
							positon++;
							ks.updateKorak(k.id, k.getNaziv(), f);
							
							if(i==model.getModel().size()-1)
								sms.createStrukturaModela(0, ms, k, null);
							else{
								
								Korak sledeciKorak =ks.findKorakByNaziv(model.getElementAt(counter+1).toString());
								
								sms.createStrukturaModela(0, ms, k, sledeciKorak);
							}
								
							f.add(k);
							break;
						}
						
					}
					counter++;
				}
				
				ms.add(f);
			}
			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTreeView());
		}
		
		MainFrame.getInstance().getSetView().dispose();
		
		SetView sv = new SetView(MainFrame.getInstance());
		MainFrame.getInstance().setSetView(sv);
				
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
	    
	    MainFrame.getInstance().setSetView(sv);
	}
}
