package gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import actions.AddNewModel;
import actions.KorakTable;

public class Menu extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5127465600114178027L;
	JMenu model;
	JMenuItem dodajModel;

	JMenu struktura;
	JMenuItem dodajStrukturu;

	JMenu korak;
	JMenuItem korakView;

	public Menu() {

		model = new JMenu("Model");

		dodajModel = new JMenuItem("Dodaj model");
		dodajModel.addActionListener(new AddNewModel());
		model.add(dodajModel);
		add(model);

		korak = new JMenu("Korak");

		korakView = new JMenuItem("Koraci");
		korakView.addActionListener(new KorakTable());
		korak.add(korakView);
		add(korak);
	}
}
