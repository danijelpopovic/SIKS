package gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import actions.KorakTable;
import actions.Set;

public class Menu extends JMenuBar{

	JMenu struktura;
	JMenuItem dodajStrukturu;
	
	JMenu korak;
	JMenuItem korakView;
	
	
	public Menu() {
		
		struktura = new JMenu("Struktura");
		
		
		dodajStrukturu = new JMenuItem("Dodaj strukturu");
		dodajStrukturu.addActionListener(new Set());
		struktura.add(dodajStrukturu);
		
		add(struktura);
		
		korak = new JMenu("Koraci");
		
		korakView = new JMenuItem("Pregled");
		korakView.addActionListener(new KorakTable());
		korak.add(korakView);
		add(korak);
	}
}
