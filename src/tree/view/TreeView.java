package tree.view;

import javax.swing.JTree;
import javax.swing.SwingUtilities;

import model.Faza;
import model.Korak;
import model.ModelZCSoftvera;
import tree.controller.TreeController;
import tree.model.RootTreeModel;

@SuppressWarnings("serial")
public class TreeView extends JTree{

	public TreeView(){
		addMouseListener(new TreeController());
		setCellRenderer(new TreeCellRendered());
		setEditable(false);
	}
	
	public void addFaza(Faza p){
		((RootTreeModel)getModel()).addFaza(p);
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	public void AddModelZC(ModelZCSoftvera modelZCSoftvera){
		((RootTreeModel)getModel()).addModelZCSoftvera(modelZCSoftvera);
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	public void AddKorak(Korak k){
		((RootTreeModel)getModel()).addKorak(k);
		SwingUtilities.updateComponentTreeUI(this);
	}
	
}


