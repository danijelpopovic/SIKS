package tree.view;

import javax.swing.JTree;

import tree.controller.TreeController;

public class TreeView extends JTree{

	public TreeView(){
		addMouseListener(new TreeController());
		setCellRenderer(new TreeCellRendered());
		setEditable(true);
	}
}
