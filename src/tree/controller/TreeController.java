package tree.controller;

import gui.MainFrame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;
import javax.swing.tree.TreePath;

import model.Faza;
import model.Korak;
import model.ModelZCSoftvera;
import tree.view.JTreePopupMenu;

public class TreeController implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object node = null;
		TreePath selPath = MainFrame.getInstance().getTreeView()
				.getPathForLocation(e.getX(), e.getY());
		if (selPath != null) {
			node = selPath.getLastPathComponent();
			if (node instanceof Faza) {
				ModelZCSoftvera m = (ModelZCSoftvera)((Faza) node).getParent();
				MainFrame.getInstance();
				MainFrame.getDraw().drawModel(m);
				MainFrame.getInstance().addGraph();			
			}
			else if (node instanceof Korak) {
				ModelZCSoftvera m = (ModelZCSoftvera)(((Korak) node).getParent()).getParent();
				MainFrame.getInstance();
				MainFrame.getDraw().drawModel(m);
				MainFrame.getInstance().addGraph();
			}
			else if (node instanceof ModelZCSoftvera) {
				ModelZCSoftvera model = (ModelZCSoftvera) node;
				MainFrame.getInstance();
				MainFrame.getDraw().drawModel(model);
				MainFrame.getInstance().addGraph();
			}

		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		Object node = null;
		TreePath selPath = MainFrame.getInstance().getTreeView()
				.getPathForLocation(e.getX(), e.getY());

		if (selPath != null)
			node = selPath.getLastPathComponent();

		if ((e.getClickCount() == 1) && (SwingUtilities.isRightMouseButton(e))
				&& (node != null)) {

			JTreePopupMenu jtreePmenu = new JTreePopupMenu();

			if (node instanceof Faza) {	
				jtreePmenu.setVisible("faza");
			} else if (node instanceof Korak) {
				jtreePmenu.setVisible("korak");
			} else if (node instanceof ModelZCSoftvera) {
				jtreePmenu.setVisible("model");
			} else {
				jtreePmenu.setVisibleFalse();
			}

			jtreePmenu.show(e.getComponent(), e.getX(), e.getY());

		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
