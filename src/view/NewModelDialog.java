package view;

import gui.MainFrame;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewModelDialog extends JDialog {

	public JPanel panDetail;
	public JPanel panNaziv;
	public JPanel panSkraceni;
	public JPanel panSave;
	public JPanel panOpis;

	public JTextField txtNaziv;
	public JLabel lblNaziv;
	public JTextField txtSkraceni;
	public JLabel lblSkraceni;
	public JTextField txtOpis;
	public JLabel lblOpis;
	public JLabel lblPrazna;

	public NewModelDialog(JFrame parent) {

		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setTitle("Dodavanje novog modela");

		Dimension size = new Dimension(100, 20);

		panDetail = new JPanel();
		panDetail.setLayout(new BoxLayout(panDetail, BoxLayout.Y_AXIS));

		panNaziv = new JPanel();
		panNaziv.setAlignmentX(Component.LEFT_ALIGNMENT);
		lblNaziv = new JLabel("Naziv:");
		lblNaziv.setPreferredSize(size);
		lblNaziv.setMaximumSize(size);
		panNaziv.add(lblNaziv);
		txtNaziv = new JTextField();
		txtNaziv.setColumns(10);
		panNaziv.add(txtNaziv);
		panDetail.add(panNaziv);

		panSkraceni = new JPanel();
		panSkraceni.setAlignmentX(Component.LEFT_ALIGNMENT);
		lblSkraceni = new JLabel("Skraceni naziv:");
		lblSkraceni.setPreferredSize(size);
		lblSkraceni.setMaximumSize(size);
		panSkraceni.add(lblSkraceni);
		txtSkraceni = new JTextField();
		txtSkraceni.setColumns(10);
		panSkraceni.add(txtSkraceni);
		panDetail.add(panSkraceni);

		panOpis = new JPanel();
		panOpis.setAlignmentX(Component.LEFT_ALIGNMENT);
		lblOpis = new JLabel("Opis:");
		lblOpis.setPreferredSize(size);
		lblOpis.setMaximumSize(size);
		panOpis.add(lblOpis);
		txtOpis = new JTextField();
		txtOpis.setColumns(10);
		panOpis.add(txtOpis);
		panDetail.add(panOpis);

		panSave = new JPanel();
		panSave.setAlignmentX(Component.LEFT_ALIGNMENT);
		lblPrazna = new JLabel("");
		lblPrazna.setPreferredSize(size);
		lblPrazna.setMaximumSize(size);
		JButton btnSave = new JButton(MainFrame.getInstance()
				.getActionManager().getAddNewModelSubmit());
		btnSave.setPreferredSize(new Dimension(75, 20));
		btnSave.setMaximumSize(new Dimension(75, 20));
		panSave.add(lblPrazna);
		panSave.add(btnSave);
		panDetail.add(panSave);

		add(panDetail);

		pack();
		setLocationRelativeTo(parent);
		setVisible(true);
	}

	public JTextField getTxtNaziv() {
		return txtNaziv;
	}

	public void setTxtNaziv(JTextField txtNaziv) {
		this.txtNaziv = txtNaziv;
	}

	public JTextField getTxtSkraceni() {
		return txtSkraceni;
	}

	public void setTxtSkraceni(JTextField txtSkraceni) {
		this.txtSkraceni = txtSkraceni;
	}

	public JTextField getTxtOpis() {
		return txtOpis;
	}

	public void setTxtOpis(JTextField txtOpis) {
		this.txtOpis = txtOpis;
	}

}
