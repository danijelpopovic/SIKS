package actions;

import gui.MainFrame;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.swing.AbstractAction;

import model.Korak;
import model.ModelZCSoftvera;
import model.StrukturaModela;
import services.KorakService;
import services.ModelZCSoftveraService;
import services.StrukturaModelaService;
import view.DefineStructView;

public class DefineStructGet extends AbstractAction{

	public DefineStructView dsv;
	
	public DefineStructGet(){
		putValue(NAME, "Definisi model");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		dsv = new DefineStructView(MainFrame.getInstance());
		KorakService ks = MainFrame.getInstance().getKorakService();
		ModelZCSoftveraService mzcss = MainFrame.getInstance().getModelZCSoftveraService();
		MainFrame.getInstance().setDialogDefine(dsv);
		
		Object o = MainFrame.getInstance().getTreeView().getLastSelectedPathComponent();
		
		List<Korak> koraci = (List<Korak>) ks.findAllKoraci();
		List<ModelZCSoftvera> modeli = (List<ModelZCSoftvera>) mzcss.findAllModelZcSoftvera();
		
		for(ModelZCSoftvera m : modeli){
			dsv.getCmbModel().addItem(m);
		}
		
		for (int i = 0; i < dsv.getCmbModel().getItemCount(); i++)
        {
	        ModelZCSoftvera item = (ModelZCSoftvera)dsv.getCmbModel().getItemAt(i);
	        //System.out.println(item);
            if (item.getId() == ((ModelZCSoftvera)o).getId())
            {
            	dsv.getCmbModel().setSelectedIndex(i);
                break;
            }
        }
		
		List<Korak> koraciList = new ArrayList<Korak>();
		List<Korak> zauzetiList = new ArrayList<Korak>();
		StrukturaModelaService sms = MainFrame.getInstance().getStrukturaModelaService();
		
		for(Korak k: koraci){
			dsv.getCmbKorak().addItem(k);
	    	dsv.getCmbSledeciKorak().addItem(k);
		}
		
	/*	int modelId = ((ModelZCSoftvera)o).getId();
		int counter = 0;
		
		for(StrukturaModela sm : sms.findAllStrukturaModela()){
			if(!zauzetiList.contains(sm.getKorak()) )
				zauzetiList.add(sm.getKorak());
			if(!zauzetiList.contains(sm.getSledeci_korak())){
				zauzetiList.add(sm.getSledeci_korak());
			}
		}
		
			for(ModelZCSoftvera mzc : modeli){		
				
				for(StrukturaModela sm : mzc.getStrukturaModela()){
					if(sm.getModel().getId() == modelId){	
					    if(!koraciList.contains(sm.getKorak())){
							koraciList.add(sm.getKorak());	
							//zauzetiList.add(sm.getKorak());
							counter++;
						}
						if(!koraciList.contains(sm.getSledeci_korak())){
							koraciList.add(sm.getSledeci_korak());	
							//zauzetiList.add(sm.getKorak());
							counter++;
						}
					}
				}
			
			}
			for(Korak k : koraci){
				if(!zauzetiList.contains(k))
					koraciList.add(k);
			}
			
			
			dsv.getCmbKorak().addItem(k);
	    	dsv.getCmbSledeciKorak().addItem(k);
	    	
	   // }
			
			
			
		
		for(Korak k: koraciList){
			dsv.getCmbKorak().addItem(k);
	    	dsv.getCmbSledeciKorak().addItem(k);
		}
		*/
		dsv.getTableModel().open(((ModelZCSoftvera)o).getId());
		
		dsv.setVisible(true);
		
	}

}
