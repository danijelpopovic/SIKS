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
				Faza faza = (Faza) node;
				MainFrame.getInstance();
				MainFrame.getDraw().drawFaza(faza);
				MainFrame.getInstance().addGraph();
			}
			else if (node instanceof Korak) {
				Korak korak = (Korak) node;
				Faza faza = korak.getFaza();
				MainFrame.getInstance();
				MainFrame.getDraw().drawFaza(faza);
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
		Object pathComponent2;

		if (selPath != null)
			node = selPath.getLastPathComponent();

		if ((e.getClickCount() == 1) && (SwingUtilities.isRightMouseButton(e))
				&& (node != null)) {

			JTreePopupMenu jtreePmenu = new JTreePopupMenu();

			if (node instanceof Faza) {
				jtreePmenu.getAddKorak().setVisible(true);
				jtreePmenu.getAddModelZC().setVisible(false);
				jtreePmenu.getRemoveKorak().setVisible(false);
				jtreePmenu.getRemoveModelZC().setVisible(false);
				jtreePmenu.getRemoveFaza().setVisible(true);
				jtreePmenu.getAddFaza().setVisible(false);
			} else if (node instanceof Korak) {
				jtreePmenu.getAddKorak().setVisible(false);
				jtreePmenu.getAddFaza().setVisible(false);
				jtreePmenu.getAddModelZC().setVisible(false);
				jtreePmenu.getRemoveFaza().setVisible(false);
				jtreePmenu.getRemoveModelZC().setVisible(false);
			} else if (node instanceof ModelZCSoftvera) {
				jtreePmenu.getAddFaza().setVisible(true);
				jtreePmenu.getAddKorak().setVisible(false);
				jtreePmenu.getRemoveFaza().setVisible(false);
				jtreePmenu.getRemoveKorak().setVisible(false);
				jtreePmenu.getRemoveModelZC().setVisible(true);
				jtreePmenu.getAddModelZC().setVisible(false);
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
