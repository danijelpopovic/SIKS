package gui.tablemodel;



import javax.swing.table.DefaultTableModel;

public abstract class DialogTableModel extends DefaultTableModel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -359194162470452051L;
	public DialogTableModel(Object[] colNames, int rowCount){
		super(colNames, rowCount);
	}
	
	public abstract void open();
	public abstract void fillData(String sql);
	public abstract boolean isCellEditable(int arg0, int arg1);
	public abstract void checkRow(int index);
	public abstract void deleteRow(int index);
	public abstract void open(int id);	
	
}

