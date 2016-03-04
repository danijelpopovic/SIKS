package actions;

import gui.MainFrame;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import view.NewModelDialog;

public class AddNewModel extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8432984352187983328L;
	public NewModelDialog md;
	
	public AddNewModel(){
		putValue(NAME, "Dodaj novi model");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		md = new NewModelDialog(MainFrame.getInstance());
		MainFrame.getInstance().setNewModelDialog(md);
	}

	public NewModelDialog getMd() {
		return md;
	}

	public void setMd(NewModelDialog md) {
		this.md = md;

	}

}
