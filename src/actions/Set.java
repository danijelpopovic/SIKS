package actions;

import gui.MainFrame;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.AbstractAction;

import model.Korak;
import model.ModelZCSoftvera;
import services.KorakService;
import services.ModelZCSoftveraService;
import view.SetView;

public class Set extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7112584226639671994L;
	public SetView sv;

	public Set() {
		putValue(NAME, "Set");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		sv = new SetView(MainFrame.getInstance());
		MainFrame.getInstance().setSetView(sv);
		KorakService ks = new KorakService(MainFrame.getInstance().getEm());

		List<Korak> koraci = (List<Korak>) ks.findAllKoraci();
		Collection koraciNazivi = new ArrayList<String>();

		for (Korak k : koraci) {
			if (k.getFaza() == null)
				koraciNazivi.add(k.getNaziv());
		}

		sv.addSourceElements(koraciNazivi.toArray());

		ModelZCSoftveraService mzcss = MainFrame.getInstance()
				.getModelZCSoftveraService();
		List<ModelZCSoftvera> modeli = (List<ModelZCSoftvera>) mzcss
				.findAllModelZcSoftvera();
		for (ModelZCSoftvera m : modeli) {
			sv.getCmbModel().addItem(m);
		}

	}

	public SetView getSv() {
		return sv;
	}

	public void setSv(SetView sv) {
		this.sv = sv;
	}

}