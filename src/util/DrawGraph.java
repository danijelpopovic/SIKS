package util;

import gui.MainFrame;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import services.FazaService;
import services.KorakService;
import model.Faza;
import model.Korak;
import model.ModelZCSoftvera;
import model.StrukturaModela;

public class DrawGraph {
	/*
	 * public static void main(String[] args) { DrawGraph p = new DrawGraph();
	 * p.start(); // p.start2(); }
	 */

	public static int counter = 0;

	/**
	 * Construct a DOT graph in memory, convert it to image and store the image
	 * in the file system.
	 */
	public void drawFaza(Faza faza) {

		FazaService fs = MainFrame.getInstance().getFazaService();
		KorakService ks = MainFrame.getInstance().getKorakService();
		Faza fazaDb = fs.findFaza(faza.getId());

		String labelFaza = fazaDb.getNazivFaze();

		GraphViz gv = new GraphViz();
		gv.addln(gv.start_graph());
		gv.addln(" label = <" + labelFaza + ">;");

		Set<Korak> koraci = (Set<Korak>) fs.findFaza(faza.getId()).getKoraci();

		/*
		 * for(Korak k : ks.findAllKoraci()){ if(k.getFaza()!=null &&
		 * k.getFaza().getId()==faza.getId()) koraci.add(k); }
		 */

		ArrayList<String> naziviKoraka = new ArrayList<String>();

		ArrayList<Integer> pozicije = new ArrayList<Integer>();
		for (Korak k : koraci) {
			pozicije.add(k.getPozicija());
		}

		Collections.sort(pozicije);

		for (int i = 0; i < pozicije.size(); i++) {
			for (Korak k : koraci) {
				if (pozicije.get(i) == k.getPozicija()) {
					naziviKoraka.add(k.getNaziv());
				}
			}
		}

		String node = "";
		String node1 = "";

		if (naziviKoraka.size() > 1) {
			for (int i = 0; i < naziviKoraka.size() - 1; i++) {
				node = naziviKoraka.get(i).replaceAll("\\s", "_");
				node1 = naziviKoraka.get(i + 1).replaceAll("\\s", "_");
				gv.addln(node
						+ "[style = filled; color = red; fontcolor = red; shape = mcircle; fillcolor = green]");
				gv.addln(node1
						+ "[style = filled; color = blue; fontcolor = blue; shape = mcircle; fillcolor = orange]");
				gv.addln(node + " ->  " + node1);
			}
		} else if (naziviKoraka.size() == 1) {
			gv.addln(naziviKoraka.get(naziviKoraka.size() - 1).replaceAll(
					"\\s", "_"));
		} else {
			gv.addln("Prazan cvor");
		}

		gv.addln(gv.end_graph());
		System.out.println(gv.getDotSource());

		gv.increaseDpi(); // 106 dpi

		String type = "png";
		String repesentationType = "dot";

		File out = new File("GraphViz/graph." + type); // Windows
		gv.writeGraphToFile(
				gv.getGraph(gv.getDotSource(), type, repesentationType), out);
	}

	private void addObject(int i, String object, ArrayList<String> list) {

	}

	public void drawModel(ModelZCSoftvera model) {

		Set<StrukturaModela> strukture = model.getStrukturaModela();
		Set<Korak> koraci = new HashSet<Korak>();
		Set<Faza> faze = new HashSet<Faza>();
		String labelModel = model.getNaziv();

		for (StrukturaModela s : strukture) {
			koraci.add(s.getKorak());
			faze.add(s.getKorak().getFaza());
			if (s.getSledeci_korak() != null) {
				koraci.add(s.getSledeci_korak());
				faze.add(s.getSledeci_korak().getFaza());
			}
		}

		String korak = "";
		String faza = "";

		GraphViz gv = new GraphViz();
		gv.addln(gv.start_graph());
		gv.addln("graph [autosize=false, size=\"20.7,7.0!\", resolution=100];");
		gv.addln("label = <" + labelModel + ">;");

		for (Faza f : faze) {
			
			faza = f.getNazivFaze().replaceAll("\\s", "_");
			
			gv.addln(gv.start_subgraph(f.getId()));
			gv.addln("style=filled; color=lightgrey; node [style=filled,color=white];");

			for (Korak k : koraci) {
				if (k.getFaza().getNazivFaze() == f.getNazivFaze()) {
					korak = k.getNaziv().replaceAll("\\s", "_");
					gv.addln(korak
					+ "[style = filled; color = yellow; fontcolor = white; fillcolor = violet]");
				}
			}
			gv.addln("label = <" + faza + ">;");
			gv.addln(gv.end_subgraph());
		}

		String korak1 = "";
		String korak2 = "";

		for (StrukturaModela s : strukture) {
			if (s.getSledeci_korak() != null) {
				korak1 = s.getKorak().getNaziv().replaceAll("\\s", "_");
				korak2 = s.getSledeci_korak().getNaziv().replaceAll("\\s", "_");
				gv.addln(korak1 + " -> " + korak2);
			}

		}
		
		gv.addln(gv.end_graph());
		System.out.println(gv.getDotSource());

		gv.decreaseDpi(); // 106 dpi

		String type = "png";
		String repesentationType = "dot";

		File out = new File("GraphViz/graph." + type); // Windows
		gv.writeGraphToFile(
				gv.getGraph(gv.getDotSource(), type, repesentationType), out);

	}
}
