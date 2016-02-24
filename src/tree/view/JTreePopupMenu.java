package tree.view;

import gui.MainFrame;

import java.awt.Component;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class JTreePopupMenu {

	private JPopupMenu popupMenu;

	JMenuItem addFaza;
	JMenuItem addKorak;
	JMenuItem addModelZC;
	JMenuItem defineModel;

	JMenuItem removeFaza;
	JMenuItem removeKorak;
	JMenuItem removeModelZC;

	JMenuItem modelProperties;
	JMenuItem fazaProperties;
	JMenuItem korakProperties;

	public JTreePopupMenu() {
		addFaza = new JMenuItem(MainFrame.getInstance().getActionManager()
				.getAddNewFaza());
		addKorak = new JMenuItem("Dodaj korak");

		addModelZC = new JMenuItem(MainFrame.getInstance().getActionManager()
				.getAddNewModel());

		removeFaza = new JMenuItem("Obrisi fazu");
		removeKorak = new JMenuItem("Obrisi korak");
		removeModelZC = new JMenuItem("Obrisi model");
		defineModel = new JMenuItem(MainFrame.getInstance().getActionManager()
				.getDefineStructGet());

		modelProperties = new JMenuItem(MainFrame.getInstance().getActionManager()
				.getModelProperties());
		fazaProperties = new JMenuItem(MainFrame.getInstance().getActionManager()
				.getFazaProperties());
		korakProperties = new JMenuItem(MainFrame.getInstance().getActionManager()
				.getKorakProperties());

		popupMenu = new JPopupMenu();

		popupMenu.add(addModelZC);
		popupMenu.add(removeModelZC);
		popupMenu.add(defineModel);
		

		popupMenu.add(addKorak);
		popupMenu.add(removeKorak);
		popupMenu.add(korakProperties);

		popupMenu.add(addFaza);
		popupMenu.add(removeFaza);
		
		popupMenu.add(modelProperties);
		popupMenu.add(fazaProperties);
		popupMenu.add(korakProperties);
	}

	public void setVisible(String type) {

		if (type.equals("model")) {
			setVisibleFalse();
			addKorak.setVisible(true);
			removeModelZC.setVisible(true);
			defineModel.setVisible(true);
			modelProperties.setVisible(true);
		}

		if (type.equals("faza")) {
			setVisibleFalse();
			removeFaza.setVisible(true);
			fazaProperties.setVisible(true);
		}

		if (type.equals("korak")) {
			setVisibleFalse();
			removeKorak.setVisible(true);
			korakProperties.setVisible(true);
		}
	}

	public void setVisibleFalse() {

		addFaza.setVisible(false);
		addKorak.setVisible(false);
		addModelZC.setVisible(false);
		defineModel.setVisible(false);
		removeFaza.setVisible(false);
		removeKorak.setVisible(false);
		removeModelZC.setVisible(false);
		modelProperties.setVisible(false);
		fazaProperties.setVisible(false);
		korakProperties.setVisible(false);

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

	public JMenuItem getDefineModel() {
		return defineModel;
	}

	public void setDefineModel(JMenuItem defineModel) {
		this.defineModel = defineModel;
	}

	public JMenuItem getModelProperties() {
		return modelProperties;
	}

	public void setModelProperties(JMenuItem modelProperties) {
		this.modelProperties = modelProperties;
	}

	public JMenuItem getFazaProperties() {
		return fazaProperties;
	}

	public void setFazaProperties(JMenuItem fazaProperties) {
		this.fazaProperties = fazaProperties;
	}

	public JMenuItem getKorakProperties() {
		return korakProperties;
	}

	public void setKorakProperties(JMenuItem korakProperties) {
		this.korakProperties = korakProperties;
	}
}
