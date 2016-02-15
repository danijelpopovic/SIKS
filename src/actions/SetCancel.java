package actions;

import gui.MainFrame;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class SetCancel extends AbstractAction{

	public SetCancel(){
		putValue(NAME, "Cancel");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		MainFrame.getInstance().getSetView().dispose();
	}

}
