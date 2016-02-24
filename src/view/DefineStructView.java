package view;

import gui.MainFrame;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import model.StrukturaModela;
import net.miginfocom.swing.MigLayout;

public class DefineStructView extends JDialog{
	
	public JLabel lblModel;
	public JComboBox cmbModel;
	public JComboBox cmbKorak;
	public JComboBox cmbSledeciKorak;
	public JButton btnSnimi;
	public JButton btnOdustani;
	public model.table.StrukturaModela tableModel;
	public JPanel panDetail;
	public JPanel panTable;
	public String[] columns;
	public JTable table;
	public JSplitPane splitPane;
	public JButton btnObrisi;
	
	public DefineStructView(JFrame parent) {
		super(parent);
		 this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		
		
		panTable = new JPanel(new BorderLayout());
		panTable.setBackground(Color.WHITE);
		
		columns = new String[4];
		columns[0] = "id";
		columns[1] = "model";
		columns[2] = "korak";
		columns[3] = "sledeci korak";
		
		tableModel = new model.table.StrukturaModela(columns, 0);
		table = new JTable(tableModel);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setColumnSelectionAllowed(false);
		panTable.add(new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS),BorderLayout.CENTER);
		
		panDetail = new JPanel();
		panDetail.setLayout(new MigLayout("", "[][grow]", "[][][][][grow]"));
		lblModel = new JLabel("Model");
		panDetail.add(lblModel, "cell 0 1,alignx trailing");
		
		cmbModel = new JComboBox();
		panDetail.add(cmbModel, "cell 1 1,growx");
		
		JLabel lblKorak = new JLabel("Korak");
		panDetail.add(lblKorak, "cell 0 2,alignx trailing");
		
		cmbKorak = new JComboBox();
		panDetail.add(cmbKorak, "cell 1 2,growx");
		
		JLabel lblSledeciKorak = new JLabel("Sledeci korak");
		panDetail.add(lblSledeciKorak, "cell 0 3,alignx trailing");
		
		cmbSledeciKorak = new JComboBox();
		panDetail.add(cmbSledeciKorak, "cell 1 3,growx");
		
		JPanel panel = new JPanel();
		panDetail.add(panel, "cell 1 4,grow");
		panel.setLayout(new MigLayout("", "[][][][][][][][][][]", "[]"));
		
		btnSnimi = new JButton(MainFrame.getInstance().getActionManager().getDefineStructSubmit());
		
		
		btnOdustani = new JButton("Odustani");
		panel.add(btnOdustani, "cell 8 0");
		panel.add(btnSnimi, "cell 9 0");
		
		btnObrisi = new JButton(MainFrame.getInstance().getActionManager().getRemoveStruktura());
		panel.add(btnObrisi, "cell 10 0");
		
		
		splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,panTable,panDetail);
		splitPane.setResizeWeight(0.5);
		getContentPane().add(splitPane,BorderLayout.CENTER);
		
		this.pack();		
		 setLocationRelativeTo(parent);
		 this.setVisible(true);
	}

	public JComboBox getCmbModel() {
		return cmbModel;
	}

	public void setCmbModel(JComboBox cmbModel) {
		this.cmbModel = cmbModel;
	}

	public JComboBox getCmbKorak() {
		return cmbKorak;
	}

	public void setCmbKorak(JComboBox cmbKorak) {
		this.cmbKorak = cmbKorak;
	}

	public JComboBox getCmbSledeciKorak() {
		return cmbSledeciKorak;
	}

	public void setCmbSledeciKorak(JComboBox cmbSledeciKorak) {
		this.cmbSledeciKorak = cmbSledeciKorak;
	}

	public JButton getBtnSnimi() {
		return btnSnimi;
	}

	public void setBtnSnimi(JButton btnSnimi) {
		this.btnSnimi = btnSnimi;
	}

	public JButton getBtnOdustani() {
		return btnOdustani;
	}

	public void setBtnOdustani(JButton btnOdustani) {
		this.btnOdustani = btnOdustani;
	}

	public model.table.StrukturaModela getTableModel() {
		return tableModel;
	}

	public void setTableModel(model.table.StrukturaModela tableModel) {
		this.tableModel = tableModel;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
	
	
	

	
	
}
