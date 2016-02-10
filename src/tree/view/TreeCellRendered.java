package tree.view;

import java.awt.Component;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

public class TreeCellRendered extends DefaultTreeCellRenderer{

	
	
	public TreeCellRendered() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Component getTreeCellRender(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus){
	
		return this;
	}

	
	
}
