package actions;

import gui.MainFrame;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.AbstractAction;

import model.Korak;
import model.ModelZCSoftvera;
import services.ModelZCSoftveraService;

public class RemoveModel extends AbstractAction {

	public RemoveModel() {
		putValue(NAME, "Obrisi model");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		ModelZCSoftveraService ms = MainFrame.getInstance().getModelZCSoftveraService();

		Object o = MainFrame.getInstance().getTreeView()
				.getLastSelectedPathComponent();

		List<ModelZCSoftvera> modeli = (List<ModelZCSoftvera>) ms.findAllModelZcSoftvera();

		for (ModelZCSoftvera m : modeli) {
			if (m.getId() == (((ModelZCSoftvera) o)).getId()) {
				ms.removeModelZCSoftvera(m.getId());
			}
		}

	}

}
