package view;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class FazaPropertiesDialog extends JDialog{
	
	public FazaPropertiesDialog(JFrame parent) {

		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setTitle("Osobine faze");
		
		pack();
		setLocationRelativeTo(parent);
		setVisible(true);
	}

}
