package view;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class KorakPropertiesDialog extends JDialog {
	
	public KorakPropertiesDialog(JFrame parent) {

		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setTitle("Osobine koraka");
		
		pack();
		setLocationRelativeTo(parent);
		setVisible(true);
	}

}
