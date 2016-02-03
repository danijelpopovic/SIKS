package util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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
		String labelFaza = faza.getNazivFaze();

		GraphViz gv = new GraphViz();
		gv.addln(gv.start_graph());
		gv.addln("style=filled; color=grey;");
		gv.addln(" label = <" + labelFaza + ">;");

		Set<Korak> koraci = faza.getKoraci();

		ArrayList<String> naziviKoraka = new ArrayList<String>();

		for (Korak k : koraci) {
			naziviKoraka.add(k.getNaziv());
			// System.out.println(k.getNaziv());
		}

		String node = "";
		String node1 = "";

		if (naziviKoraka.size() > 1) {
			for (int i = 0; i < naziviKoraka.size() - 1; i++) {
				node = naziviKoraka.get(i).replaceAll("\\s", "");
				node1 = naziviKoraka.get(i + 1).replaceAll("\\s", "");
				gv.addln(node + " -> " + node1);
			}
		} else if (naziviKoraka.size() == 1) {
			gv.addln(naziviKoraka.get(naziviKoraka.size() - 1).replaceAll(
					"\\s", ""));
		} else {
			gv.addln("Prazan cvor");
		}

		// gv.addln("A" + counter + " -> B" + counter + ";");
		// gv.addln("B" + counter + " -> C" + counter + ";");

		// test
		counter++;

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
		Set<String> naziviFaza = new HashSet<String>();
		Korak korak = new Korak();
		Faza faza = new Faza();
		String nazivFaze = "";
		String labelModel = model.getNaziv();

		for (StrukturaModela s : strukture) {
			if (s.getKorak() != null) {
				korak = s.getKorak();
				// System.out.println(korak.getNaziv());
				if (korak.getFaza() != null) {
					faza = korak.getFaza();
					nazivFaze = faza.getNazivFaze();
					naziviFaza.add(nazivFaze);
				}
			}
		}

		GraphViz gv = new GraphViz();
		gv.addln(gv.start_graph());
		gv.addln("style=filled; color=grey;");
		gv.addln(" label = <" + labelModel + ">;");

		String node = "";
		String node1 = "";

		System.out.println(naziviFaza.toString());

		ArrayList<String> nazivi = new ArrayList<String>();
		for (String n : naziviFaza)
			nazivi.add(n);

		if (nazivi.size() > 1) {
			for (int i = 0; i < nazivi.size() - 1; i++) {
				node = nazivi.get(i).replaceAll("\\s", "");
				node1 = nazivi.get(i + 1).replaceAll("\\s", "");
				gv.addln(node + " -> " + node1);
			}
		} else if (nazivi.size() == 1){
			gv.addln(nazivi.get(nazivi.size()-1).replaceAll("\\s", ""));
		} else {
			gv.addln(" label = <Prazan model>;");
		}

		/*
		 * gv.addln("A" + counter + " -> B" + counter + ";"); gv.addln("B" +
		 * counter + " -> C" + counter + ";");
		 */

		// test
		counter++;

		gv.addln(gv.end_graph());
		System.out.println(gv.getDotSource());

		gv.increaseDpi(); // 106 dpi

		String type = "png";
		String repesentationType = "dot";

		File out = new File("GraphViz/graph." + type); // Windows
		gv.writeGraphToFile(
				gv.getGraph(gv.getDotSource(), type, repesentationType), out);
	}

	/**
	 * Read the DOT source from a file, convert to image and store the image in
	 * the file system.
	 */
	/*
	 * private void start2() { //String dir =
	 * "/home/jabba/Dropbox/git.projects/laszlo.own/graphviz-java-api"; // Linux
	 * //String input = dir + "/sample/simple.dot"; String input =
	 * "D:\\Master\\SiKS\\Za SiKS\\graphviz-java-api-master\\sample\\simple.dot"
	 * ; // Windows
	 * 
	 * GraphViz gv = new GraphViz(); gv.readSource(input);
	 * System.out.println(gv.getDotSource());
	 * 
	 * String type = "gif"; // String type = "dot"; // String type = "fig"; //
	 * open with xfig // String type = "pdf"; // String type = "ps"; // String
	 * type = "svg"; // open with inkscape // String type = "png"; // String
	 * type = "plain";
	 * 
	 * 
	 * String repesentationType= "dot"; // String repesentationType= "neato"; //
	 * String repesentationType= "fdp"; // String repesentationType= "sfdp"; //
	 * String repesentationType= "twopi"; // String repesentationType= "circo";
	 * 
	 * //File out = new File("/tmp/simple." + type); // Linux File out = new
	 * File("D:\\Master\\SiKS\\Za SiKS\\graphviz-java-api-master\\tmp\\simple."
	 * + type); // Windows gv.writeGraphToFile( gv.getGraph(gv.getDotSource(),
	 * type, repesentationType), out ); }
	 */
}
