package actions;

import gui.MainFrame;

import java.awt.event.ActionEvent;
import java.util.Collection;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import model.ModelZCSoftvera;
import services.ModelZCSoftveraService;

public class AddNewModelSubmit extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5934910250924432221L;

	public AddNewModelSubmit() {
		putValue(NAME, "Sačuvaj model");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String naziv = MainFrame.getInstance().getNewModelDialog().getTxtNaziv().getText();
		String skraceni = MainFrame.getInstance().getNewModelDialog().getTxtSkraceni().getText();
		String opis = MainFrame.getInstance().getNewModelDialog().getTxtOpis().getText();
		
		if (naziv.equals("")) {
			JOptionPane.showMessageDialog(null, "Model mora imati naziv", "Upozorenje", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		ModelZCSoftveraService ms = MainFrame.getInstance().getModelZCSoftveraService();
				
		Collection<ModelZCSoftvera> modeli = ms.findAllModelZcSoftvera();
		
		for (ModelZCSoftvera m : modeli) {
			if (m.getNaziv().equals(naziv)) {
				JOptionPane.showMessageDialog(null, "Već postoji model sa zadatim nazivom", "Upozorenje", JOptionPane.ERROR_MESSAGE);
				return;
			}				
		}
		
		ModelZCSoftvera model = ms.createModelZcSoftvera(0, naziv, skraceni, opis);		
		MainFrame.getInstance().getTreeView().AddModelZC(model);
		MainFrame.getInstance().getNewModelDialog().dispose();
		
	}

}
