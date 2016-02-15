package gui.tablemodel;



import javax.swing.table.DefaultTableModel;

public abstract class DialogTableModel extends DefaultTableModel {

	
	public DialogTableModel(Object[] colNames, int rowCount){
		super(colNames, rowCount);
	}
	
	public abstract void open();
	public abstract void fillData(String sql);
	public abstract boolean isCellEditable(int arg0, int arg1);
	public abstract void checkRow(int index);
	public abstract void deleteRow(int index);
	//public abstract int sortedInsert(String sifra, String naziv); 
	//public abstract void updateRow(int index, String sifra, String naziv) throws SQLException;
	//public abstract int insertRow(String sifra, String naziv) throws SQLException;
	//public abstract void openAsChildForm(String where) throws SQLException;
	
	
}

