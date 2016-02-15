package actions;

import gui.MainFrame;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import view.DialogKorak;

public class KorakTable extends AbstractAction{

	public DialogKorak dk;
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		dk = new DialogKorak(MainFrame.getInstance());
		MainFrame.getInstance().setDialogKorak(dk);
	}

	public DialogKorak getDk() {
		return dk;
	}

	public void setDk(DialogKorak dk) {
		this.dk = dk;
	}
	
	

}
