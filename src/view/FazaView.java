package view;

import gui.MainFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class FazaView extends JDialog{

	public JTextField nazivFaze;
	public JButton submit;
	public FazaView(JFrame parent, String title){
		 super(parent, title);
		
		
		 this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		 
		 this.setLocationRelativeTo(parent);
		
		 JPanel panel = new JPanel();
		 panel.setSize(400, 400);
		 
		 
		 nazivFaze = new JTextField(10);
		 nazivFaze.setBounds(5, 6, 86, 20);
		// nazivFaze.set
		 panel.add(nazivFaze, "cell 0 0,alignx left,aligny center");
		 this.getContentPane().add(panel);		
		 
		 
		 submit = new JButton(MainFrame.getInstance().getActionManager().getSubmitAddFaza());
		 submit.setBounds(96, 5, 47, 23);

		  panel.add(submit);
		 this.pack();		 
		 this.setVisible(true);
		 
		 
	}

	public JTextField getNazivFaze() {
		return nazivFaze;
	}

	public void setNazivFaze(JTextField nazivFaze) {
		this.nazivFaze = nazivFaze;
	}

	public JButton getSubmit() {
		return submit;
	}

	public void setSubmit(JButton submit) {
		this.submit = submit;
	}
	
	
}
