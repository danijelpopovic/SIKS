package actions;

import gui.MainFrame;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.SwingUtilities;

import model.Faza;
import model.Korak;
import model.ModelZCSoftvera;
import model.StrukturaModela;
import services.ModelZCSoftveraService;
import services.StrukturaModelaService;

public class DefineStructSubmit extends AbstractAction{

	public DefineStructSubmit(){
		putValue(NAME, "Snimi");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		StrukturaModelaService sms = MainFrame.getInstance().getStrukturaModelaService();
		ModelZCSoftvera model = (ModelZCSoftvera) MainFrame.getInstance().getDialogDefine().getCmbModel().getSelectedItem();
		Korak korak = (Korak) MainFrame.getInstance().getDialogDefine().getCmbKorak().getSelectedItem();
		Korak sledeciKorak = (Korak) MainFrame.getInstance().getDialogDefine().getCmbSledeciKorak().getSelectedItem();
		
		StrukturaModela str = sms.createStrukturaModela(0, model, korak, sledeciKorak);
		MainFrame.getInstance().getDialogDefine().dispose();
		
		/*Faza f = new Faza(korak.getFaza().getId(),korak.getFaza().getNazivFaze());
		model.add(korak.getFaza());*/
		
		ModelZCSoftvera modelZC = MainFrame.getInstance().getModelZCSoftveraService().findModelZcSoftvera(model.getId());
		
		model.removeAllChildren();
		
		List<Faza> faze2 = new ArrayList<Faza>();
		List<Korak> koraci = new ArrayList<Korak>();
		
		List<StrukturaModela> strukture = new ArrayList<StrukturaModela>();
		strukture.add(str);
		for(StrukturaModela struktura : modelZC.getStrukturaModela()){
			strukture.add(struktura);
		}
		
		System.out.println("--------->"+strukture.size());
		for (StrukturaModela struktura : strukture) {

			Faza f = struktura.getKorak().getFaza();
			Faza f2 = struktura.getSledeci_korak().getFaza();
			//modelZCSoftvera.add(fn);
			
			if(!faze2.contains(f))
				faze2.add(f);
			
			if(!faze2.contains(f2))
				faze2.add(f2);
			
			if(!koraci.contains(struktura.getKorak()))
				koraci.add(struktura.getKorak());
			if(!koraci.contains(struktura.getSledeci_korak()))
				koraci.add(struktura.getSledeci_korak());		

		}
		

		for(Faza f : faze2){
			Faza fn = new Faza(f.getId(), f.getNazivFaze());
			model.add(fn);
			for(Korak k : koraci){
				if(fn.getId() == k.getFaza().getId())
					fn.add(new Korak(k.getId(), k.getNaziv(), null));
			}			
		}
		
		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTreeView());
		
		
	}

}
