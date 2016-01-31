package tree.view;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

public class JTreePopupMenu{

	private JPopupMenu popupMenu;
	
	JMenuItem addFaza;
	JMenuItem addKorak;
	JMenuItem addModelZC;
	
	JMenuItem removeFaza;
	JMenuItem removeKorak;
	JMenuItem removeModelZC;
	
	public JTreePopupMenu(){
		addFaza = new JMenuItem("Dodaj fazu");
		addKorak = new JMenuItem("Dodaj korak");
		
		addModelZC = new JMenuItem("Dodaj novi model");
		
		removeFaza = new JMenuItem("Obrisi fazu");
		removeKorak = new JMenuItem("Obrisi korak");
		removeModelZC = new JMenuItem("Obrisi novi model");
		
		popupMenu = new JPopupMenu();
		popupMenu.add(addModelZC);
		popupMenu.add(removeModelZC);
		
		popupMenu.add(addKorak);
		popupMenu.add(removeKorak);
		
		popupMenu.add(addFaza);
		popupMenu.add(removeFaza);
	}

	public JPopupMenu getPopupMenu() {
		return popupMenu;
	}

	public void setPopupMenu(JPopupMenu popupMenu) {
		this.popupMenu = popupMenu;
	}
	
	public JMenuItem getAddFaza() {
		return addFaza;
	}

	public void setAddFaza(JMenuItem addFaza) {
		this.addFaza = addFaza;
	}

	public JMenuItem getAddKorak() {
		return addKorak;
	}

	public void setAddKorak(JMenuItem addKorak) {
		this.addKorak = addKorak;
	}

	public JMenuItem getAddModelZC() {
		return addModelZC;
	}

	public void setAddModelZC(JMenuItem addModelZC) {
		this.addModelZC = addModelZC;
	}

	public void setAddModelZC(JMenu addModelZC) {
		this.addModelZC = addModelZC;
	}
	
		
	public JMenuItem getRemoveFaza() {
		return removeFaza;
	}

	public void setRemoveFaza(JMenuItem removeFaza) {
		this.removeFaza = removeFaza;
	}

	public JMenuItem getRemoveKorak() {
		return removeKorak;
	}

	public void setRemoveKorak(JMenuItem removeKorak) {
		this.removeKorak = removeKorak;
	}

	public JMenuItem getRemoveModelZC() {
		return removeModelZC;
	}

	public void setRemoveModelZC(JMenuItem removeModelZC) {
		this.removeModelZC = removeModelZC;
	}

	public void show(Component component, int x, int y) {
		popupMenu.show(component, x, y);
	}


}
