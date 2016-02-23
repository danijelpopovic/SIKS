package model.table;

import java.util.List;

import services.StrukturaModelaService;
import gui.MainFrame;
import gui.tablemodel.DialogTableModel;

public class StrukturaModela extends DialogTableModel{

	public StrukturaModela(Object[] colNames, int rowCount) {
		super(colNames, rowCount);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void open(int id) {
		// TODO Auto-generated method stub
		StrukturaModelaService sms = MainFrame.getInstance().getStrukturaModelaService();
		List<model.StrukturaModela> modeli = (List<model.StrukturaModela>)sms.findAllStrukturaModela();
		setRowCount(0);
		for(model.StrukturaModela s : modeli){
			if(s.getModel().getId()==id){
				String mId = s.getId()+"";
				String model = s.getModel().getNaziv();
				String korak = s.getKorak().getNaziv();
				String sledeciKorak = s.getSledeci_korak().getNaziv();
				addRow(new String[] {mId, model, korak, sledeciKorak});
			}
		}
		fireTableDataChanged();
	}

	
	@Override
	public void open() {
		// TODO Auto-generated method stub
		StrukturaModelaService sms = MainFrame.getInstance().getStrukturaModelaService();
		List<model.StrukturaModela> modeli = (List<model.StrukturaModela>)sms.findAllStrukturaModela();
		setRowCount(0);
		for(model.StrukturaModela s : modeli){
			
				String mId = s.getId()+"";
				String model = s.getModel().getNaziv();
				String korak = s.getKorak().getNaziv();
				String sledeciKorak = s.getSledeci_korak().getNaziv();
				addRow(new String[] {mId, model, korak, sledeciKorak});
			
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
