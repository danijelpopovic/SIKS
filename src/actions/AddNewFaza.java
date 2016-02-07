package actions;

import gui.MainFrame;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import view.FazaView;

public class AddNewFaza extends AbstractAction{

	public FazaView fv;
	
	public AddNewFaza(){
		putValue(NAME, "Dodaj novu fazu");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		fv = new FazaView(MainFrame.getInstance(), "Nova faza");
		
	}

	public  FazaView getFazaView() {
		return fv;
	}

	public  void setFazaView(FazaView fv) {
		this.fv = fv;
	}

	
}
