package view;

import gui.MainFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import net.miginfocom.swing.MigLayout;
import model.table.Korak;

import javax.swing.JComboBox;

public class DialogKorak extends JDialog{

	public Korak tableModel;
	public JPanel panDetail;
	public JPanel panTable;
	public JSplitPane splitPane;
	public String[] columns;
	public JTable table;
	public JTextField txtNaziv;
	private JTextField textFaza;
	public JComboBox cmbFazaAkcija;
	public JComboBox cmbFaza;
	
	public DialogKorak(JFrame parent){
		
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setTitle("Koraci");
		panTable = new JPanel(new BorderLayout());
		panTable.setBackground(Color.WHITE);
		
		columns = new String[3];
		columns[0] = "id";
		columns[1] = "naziv";
		columns[2] = "faza";
		
		
		tableModel = new Korak(columns, 0);
		
		//Kreiranje tabele
		table = new JTable(tableModel);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setColumnSelectionAllowed(false);
		
		panTable.add(new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS),BorderLayout.CENTER);

		
		panDetail = new JPanel();
		panDetail.setLayout(new MigLayout("", "[64.00px][169.00px,grow][63.00px,grow]", "[20.00px][23px][30.00px,grow]"));
		JLabel label = new JLabel("");
		panDetail.add(label, "cell 0 0,grow");
		JLabel label_2 = new JLabel("");
		panDetail.add(label_2, "cell 1 0,grow");
		JLabel label_3 = new JLabel("");
		panDetail.add(label_3, "cell 2 0,grow");
		JLabel lblNaziv = new JLabel("Naziv");
		panDetail.add(lblNaziv, "cell 0 1,grow");
		txtNaziv = new JTextField();
		panDetail.add(txtNaziv, "cell 1 1,grow");
		txtNaziv.setColumns(10);
		
		JButton btnSave = new JButton(MainFrame.getInstance().getActionManager().getKorakTableSubmit());
		panDetail.add(btnSave, "cell 2 1,grow");
		
		
		splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,panTable,panDetail);
		
		JLabel lblFaza = new JLabel("Faza");
		panDetail.add(lblFaza, "cell 0 2");
		
		JPanel panel = new JPanel();
		panDetail.add(panel, "cell 1 2,grow");
		panel.setLayout(new MigLayout("", "[grow][][grow]", "[]"));
		
		cmbFazaAkcija = new JComboBox();
		cmbFazaAkcija.addItem("Postojeca");
		cmbFazaAkcija.addItem("Nova");
		
		
		textFaza = new JTextField();
		panel.add(textFaza, "cell 2 0,growx");
		textFaza.setVisible(false);
		textFaza.setColumns(10);
		
		cmbFaza = new JComboBox();
		panel.add(cmbFaza, "cell 2 0,growx");
			
		
		splitPane.setResizeWeight(0.5);

		
		cmbFazaAkcija.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(cmbFazaAkcija.getSelectedIndex()==0){
					textFaza.setVisible(false);
					cmbFaza.setVisible(true);					
				}else if(cmbFazaAkcija.getSelectedIndex()==1){
					textFaza.setVisible(true);
					cmbFaza.setVisible(false);
				}
			}
		});
		
		panel.add(cmbFazaAkcija, "cell 0 0 2 1,growx");
		
		getContentPane().add(splitPane,BorderLayout.CENTER);
		
		tableModel.open();
		
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

	public JTextField getTextFaza() {
		return textFaza;
	}

	public void setTextFaza(JTextField textFaza) {
		this.textFaza = textFaza;
	}

	public JComboBox getCmbFazaAkcija() {
		return cmbFazaAkcija;
	}

	public void setCmbFazaAkcija(JComboBox cmbFazaAkcija) {
		this.cmbFazaAkcija = cmbFazaAkcija;
	}

	public JComboBox getCmbFaza() {
		return cmbFaza;
	}

	public void setCmbFaza(JComboBox cmbFaza) {
		this.cmbFaza = cmbFaza;
	}

	
	
	
}
