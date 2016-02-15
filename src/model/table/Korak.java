package model.table;

import java.util.List;

import services.KorakService;
import gui.MainFrame;
import gui.tablemodel.DialogTableModel;
import model.Faza;

public class Korak extends DialogTableModel{

	
	public Korak(Object[] colNames, int rowCount) {
		super(colNames, rowCount);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void open() {
		// TODO Auto-generated method stub
		KorakService ks = MainFrame.getInstance().getKorakService();
		List<model.Korak> koraci = (List<model.Korak>)ks.findAllKoraci();
		setRowCount(0);
		for(model.Korak k: koraci){
			String id = k.getId()+"";
			String naziv = k.getNaziv();
			String faza = "";
			if(k.getFaza()!=null){
				faza=k.getFaza().getNazivFaze();
			}
			
			addRow(new String[] {id, naziv, faza});
		}
		fireTableDataChanged();
	}

	@Override
	public void fillData(String sql) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void checkRow(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRow(int index) {
		// TODO Auto-generated method stub
		
	}
}
