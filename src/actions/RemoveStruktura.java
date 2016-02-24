package actions;

import gui.MainFrame;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import services.StrukturaModelaService;
import view.DefineStructView;

public class RemoveStruktura extends AbstractAction {

	public RemoveStruktura(){
		putValue(NAME, "Obrisi");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		DefineStructView dsv = MainFrame.getInstance().getDialogDefine();
		int select = dsv.getTable().getSelectedRow();
		if(select>-1){
		
			int id = Integer.parseInt(dsv.getTable().getValueAt(select, 0).toString());
			StrukturaModelaService sms = MainFrame.getInstance().getStrukturaModelaService();
			sms.removeStrukturaModela(id);
			
			dsv.getTableModel().deleteRow(select);
		}
		
		if(select==-1){
			JOptionPane.showMessageDialog(null, "Morate prvo selektovati strukturu!", "", JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
