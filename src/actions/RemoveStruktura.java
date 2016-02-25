package actions;

import gui.MainFrame;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import model.Faza;
import model.Korak;
import model.ModelZCSoftvera;
import model.StrukturaModela;
import services.StrukturaModelaService;
import view.DefineStructView;

public class RemoveStruktura extends AbstractAction {

	public RemoveStruktura(){
		putValue(NAME, "Obrisi");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		DefineStructView dsv = MainFrame.getInstance().getDialogDefine();
		int select = dsv.getTable().getSelectedRow();
		if(select>-1){
		
			int id = Integer.parseInt(dsv.getTable().getValueAt(select, 0).toString());
			
		
		List<ModelZCSoftvera> modelZCSoftveras = (List<ModelZCSoftvera>)MainFrame.getInstance().getModelZCSoftveraService()
				.findAllModelZcSoftvera();
		
		StrukturaModelaService sms = MainFrame.getInstance().getStrukturaModelaService();
		
		for (ModelZCSoftvera model : modelZCSoftveras){
			
			model.removeAllChildren();
			List<Faza> faze2 = new ArrayList<Faza>();
			List<Korak> koraci = new ArrayList<Korak>();
			
			List<StrukturaModela> strukture1 = new ArrayList<StrukturaModela>();
			
			for(StrukturaModela struktura : model.getStrukturaModela()){
				strukture1.add(struktura);
			}
			strukture1.remove(sms.findStrukturaModela(id));
			
			System.out.println("--------->"+strukture1.size());
			for (StrukturaModela struktura : strukture1) {

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
			}
			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTreeView());
		
			
			sms.removeStrukturaModela(id);
			
			dsv.getTableModel().deleteRow(select);
		}
		
		if(select==-1){
			JOptionPane.showMessageDialog(null, "Morate prvo selektovati strukturu!", "", JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
