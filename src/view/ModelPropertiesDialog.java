package view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ModelPropertiesDialog extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5825208841624422507L;
	private JPanel panel;
	private JPanel panelNaziv;
	private JPanel panelSkraceni;
	private JPanel panelOpis;
	private JLabel lblNaziv;
	private JLabel txtNaziv;
	private JLabel lblSkraceni;
	private JLabel txtSkraceni;
	private JLabel lblOpis;
	private JLabel txtOpis;
	
	public ModelPropertiesDialog(JFrame parent) {

		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setTitle("Osobine modela");
		
		ImageIcon img = new ImageIcon("Icon/icon.png");
		this.setIconImage(img.getImage());
		
		Dimension size = new Dimension(100, 20);				
		
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		panelNaziv = new JPanel();
		panelSkraceni = new JPanel();
		panelOpis = new JPanel();
		
		lblNaziv = new JLabel("Naziv:");
		lblSkraceni = new JLabel("Skraceni naziv:");
		lblOpis = new JLabel("Opis:");
		
		Font f = lblNaziv.getFont();
		
		lblNaziv.setPreferredSize(size);
		lblNaziv.setMaximumSize(size);
		lblSkraceni.setPreferredSize(size);
		lblSkraceni.setMaximumSize(size);
		lblOpis.setPreferredSize(size);
		lblOpis.setMaximumSize(size);
		
		lblNaziv.setFont(f.deriveFont(f.getStyle() ^ Font.BOLD));
		lblSkraceni.setFont(f.deriveFont(f.getStyle() ^ Font.BOLD));
		lblOpis.setFont(f.deriveFont(f.getStyle() ^ Font.BOLD));
		
		txtNaziv = new JLabel();
		txtSkraceni = new JLabel();
		txtOpis = new JLabel();
		
		txtNaziv.setPreferredSize(size);
		txtNaziv.setMaximumSize(size);
		txtSkraceni.setPreferredSize(size);
		txtSkraceni.setMaximumSize(size);
		txtOpis.setPreferredSize(size);
		txtOpis.setMaximumSize(size);
		
		panelNaziv.add(lblNaziv);
		panelNaziv.add(txtNaziv);
		
		panelSkraceni.add(lblSkraceni);
		panelSkraceni.add(txtSkraceni);
		
		panelOpis.add(lblOpis);
		panelOpis.add(txtOpis);		
		
		panel.add(panelNaziv);
		panel.add(panelSkraceni);
		panel.add(panelOpis);
		
		add(panel);
		
		pack();
		setLocationRelativeTo(parent);
		setVisible(true);
	}

	public JLabel getTxtNaziv() {
		return txtNaziv;
	}

	public void setTxtNaziv(JLabel txtNaziv) {
		this.txtNaziv = txtNaziv;
	}

	public JLabel getTxtSkraceni() {
		return txtSkraceni;
	}

	public void setTxtSkraceni(JLabel txtSkraceni) {
		this.txtSkraceni = txtSkraceni;
	}

	public JLabel getTxtOpis() {
		return txtOpis;
	}

	public void setTxtOpis(JLabel txtOpis) {
		this.txtOpis = txtOpis;
	}	

}
