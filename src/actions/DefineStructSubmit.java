package actions;

import gui.MainFrame;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.SwingUtilities;

import services.StrukturaModelaService;
import model.Faza;
import model.Korak;
import model.ModelZCSoftvera;

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
		
		sms.createStrukturaModela(0, model, korak, sledeciKorak);
		MainFrame.getInstance().getDialogDefine().dispose();
		
		Faza f = new Faza(korak.getFaza().getId(),korak.getFaza().getNazivFaze());
		model.add(f);
		f.add(new Korak(korak.getId(), korak.getNaziv(), korak.getFaza()));
		f.add(new Korak(sledeciKorak.getId(), sledeciKorak.getNaziv(), sledeciKorak.getFaza()));
		
		
		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTreeView());
		
	}

}
