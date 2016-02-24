package view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class KorakPropertiesDialog extends JDialog {

	private JPanel panel;
	private JPanel panelNaziv;
	private JPanel panelFaza;
	private JLabel lblNaziv;
	private JLabel lblNazivKoraka;
	private JLabel lblFaza;
	private JLabel lblFazaKoraka;

	public KorakPropertiesDialog(JFrame parent) {

		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setTitle("Osobine koraka");

		Dimension size = new Dimension(100, 20);

		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		panelNaziv = new JPanel();
		panelFaza = new JPanel();

		lblNaziv = new JLabel("Naziv:");
		lblFaza = new JLabel("Faza:");

		Font f = lblNaziv.getFont();

		lblNaziv.setPreferredSize(size);
		lblNaziv.setMaximumSize(size);
		lblFaza.setPreferredSize(size);
		lblFaza.setMaximumSize(size);

		lblNaziv.setFont(f.deriveFont(f.getStyle() ^ Font.BOLD));
		lblFaza.setFont(f.deriveFont(f.getStyle() ^ Font.BOLD));

		lblNazivKoraka = new JLabel();
		lblFazaKoraka = new JLabel();

		lblNazivKoraka.setPreferredSize(size);
		lblNazivKoraka.setMaximumSize(size);
		lblFazaKoraka.setPreferredSize(size);
		lblFazaKoraka.setMaximumSize(size);

		panelNaziv.add(lblNaziv);
		panelNaziv.add(lblNazivKoraka);

		panelFaza.add(lblFaza);
		panelFaza.add(lblFazaKoraka);

		panel.add(panelNaziv);
		panel.add(panelFaza);

		add(panel);

		pack();
		setLocationRelativeTo(parent);
		setVisible(true);
	}

	public JLabel getLblNazivKoraka() {
		return lblNazivKoraka;
	}

	public void setLblNazivKoraka(JLabel lblNazivKoraka) {
		this.lblNazivKoraka = lblNazivKoraka;
	}

	public JLabel getLblFazaKoraka() {
		return lblFazaKoraka;
	}

	public void setLblFazaKoraka(JLabel lblFazaKoraka) {
		this.lblFazaKoraka = lblFazaKoraka;
	}	

}
