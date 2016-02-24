package actions;

import gui.MainFrame;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.AbstractAction;

import model.Korak;
import model.ModelZCSoftvera;
import services.KorakService;
import services.ModelZCSoftveraService;
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
		
		for(Korak k: koraci){
	    	dsv.getCmbKorak().addItem(k);
	    	dsv.getCmbSledeciKorak().addItem(k);
	    }
		
		dsv.getTableModel().open(((ModelZCSoftvera)o).getId());
		
		dsv.setVisible(true);
		
	}

}
