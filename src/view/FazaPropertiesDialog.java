package view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FazaPropertiesDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6941225086152129185L;
	private JPanel panel;
	private JPanel panelNaziv;
	private JPanel panelKoraci;
	private JLabel lblNaziv;
	private JLabel lblNazivFaze;
	private JLabel lblKoraci;
	@SuppressWarnings("rawtypes")
	private JComboBox koraci;

	@SuppressWarnings("rawtypes")
	public FazaPropertiesDialog(JFrame parent) {

		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setTitle("Osobine faze");

		ImageIcon img = new ImageIcon("Icon/icon.png");
		this.setIconImage(img.getImage());

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

	@SuppressWarnings("rawtypes")
	public JComboBox getKoraci() {
		return koraci;
	}

	@SuppressWarnings("rawtypes")
	public void setKoraci(JComboBox koraci) {
		this.koraci = koraci;
	}

}
