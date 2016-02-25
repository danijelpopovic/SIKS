package actions;

import gui.MainFrame;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.AbstractAction;
import javax.swing.SwingUtilities;

import model.Faza;
import model.Korak;
import model.ModelZCSoftvera;
import model.StrukturaModela;
import services.ModelZCSoftveraService;
import services.StrukturaModelaService;

public class RemoveModel extends AbstractAction {

	public RemoveModel() {
		putValue(NAME, "Obrisi model");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		ModelZCSoftveraService ms = MainFrame.getInstance().getModelZCSoftveraService();
		StrukturaModelaService ss = MainFrame.getInstance().getStrukturaModelaService();

		Object o = MainFrame.getInstance().getTreeView()
				.getLastSelectedPathComponent();

		List<ModelZCSoftvera> modeli = (List<ModelZCSoftvera>) ms.findAllModelZcSoftvera();
		Set<StrukturaModela> strukture = new HashSet<StrukturaModela>(0);

		
		
		
		for (ModelZCSoftvera m : modeli) {
			if (m.getId() == (((ModelZCSoftvera) o)).getId()) {
				strukture = m.getStrukturaModela();
				for (StrukturaModela s : strukture) {
					ss.removeStrukturaModela(s.getId());
				}
				m.strukturaModela.clear();
				MainFrame.getInstance().getTreeView().RemoveModelZC(m);
				ms.removeModelZCSoftvera(m.getId());
			
			}
		}
		
		
		
		

	}

}
