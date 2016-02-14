package util;

import gui.MainFrame;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
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

		Set<Korak> koraci = new HashSet<Korak>();
		
		for(Korak k : ks.findAllKoraci()){
			if(k.getFaza()!=null && k.getFaza().getId()==faza.getId())
				koraci.add(k);
		}

		ArrayList<String> naziviKoraka = new ArrayList<String>();

		for (Korak k : koraci) {
			naziviKoraka.add(k.getNaziv());
			// System.out.println(k.getNaziv());
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

	public void drawModel(ModelZCSoftvera model) {

		Set<StrukturaModela> strukture = model.getStrukturaModela();
		Set<Korak> koraci = new HashSet<Korak>();
		String labelModel = model.getNaziv();
		
		for (StrukturaModela s : strukture) {
			koraci.add(s.getKorak());
			if (s.getSledeci_korak() != null)
				koraci.add(s.getSledeci_korak());
		}		

		GraphViz gv = new GraphViz();
		gv.addln(gv.start_graph());
		gv.addln("label = <" + labelModel + ">;");
		
		String korak = "";
		String korak1 = "";
		String korak2 = "";
		
		for (Korak k : koraci) {
			korak = k.getNaziv().replaceAll("\\s", "_");
			gv.addln(korak
					+ "[style = filled; color = yellow; fontcolor = white; fillcolor = violet]");
		}

		for (StrukturaModela s : strukture) {
			if (s.getSledeci_korak() != null) {
				korak1 = s.getKorak().getNaziv().replaceAll("\\s", "_");
				korak2 = s.getSledeci_korak().getNaziv().replaceAll("\\s", "_");
				gv.addln(korak1 + " -> " + korak2);
			}

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
}
