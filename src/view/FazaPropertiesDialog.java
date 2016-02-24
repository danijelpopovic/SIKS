package view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FazaPropertiesDialog extends JDialog {

	private JPanel panel;
	private JPanel panelNaziv;
	private JPanel panelKoraci;
	private JLabel lblNaziv;
	private JLabel lblNazivFaze;
	private JLabel lblKoraci;
	private JComboBox koraci;
	
	public FazaPropertiesDialog(JFrame parent) {

		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setTitle("Osobine faze");

		Dimension size = new Dimension(100, 20);
		
		koraci = new JComboBox();

		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		panelNaziv = new JPanel();
		panelKoraci = new JPanel();

		lblNaziv = new JLabel("Naziv:");
		lblKoraci = new JLabel("Koraci u fazi:");

		Font f = lblNaziv.getFont();

		lblNaziv.setPreferredSize(size);
		lblNaziv.setMaximumSize(size);
		lblKoraci.setPreferredSize(size);
		lblKoraci.setMaximumSize(size);
		koraci.setPreferredSize(size);
		koraci.setMaximumSize(size);
		
		lblNaziv.setFont(f.deriveFont(f.getStyle() ^ Font.BOLD));
		lblKoraci.setFont(f.deriveFont(f.getStyle() ^ Font.BOLD));

		lblNazivFaze = new JLabel();

		lblNazivFaze.setPreferredSize(size);
		lblNazivFaze.setMaximumSize(size);

		panelNaziv.add(lblNaziv);
		panelNaziv.add(lblNazivFaze);
		
		panelKoraci.add(lblKoraci);
		panelKoraci.add(koraci);

		panel.add(panelNaziv);
		panel.add(panelKoraci);

		add(panel);

		pack();
		setLocationRelativeTo(parent);
		setVisible(true);
	}

	public JLabel getLblNazivFaze() {
		return lblNazivFaze;
	}

	public void setLblNazivFaze(JLabel lblNazivFaze) {
		this.lblNazivFaze = lblNazivFaze;
	}

	public JComboBox getKoraci() {
		return koraci;
	}

	public void setKoraci(JComboBox koraci) {
		this.koraci = koraci;
	}
	
	

}
