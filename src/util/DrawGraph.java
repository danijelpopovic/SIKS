package util;

import gui.MainFrame;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.Faza;
import model.Korak;
import model.ModelZCSoftvera;
import model.StrukturaModela;
import services.StrukturaModelaService;

public class DrawGraph {

	public static int counter = 0;

	/**
	 * Construct a DOT graph in memory, convert it to image and store the image
	 * in the file system.
	 */

	public void drawModel(ModelZCSoftvera model) {

		ModelZCSoftvera m = model;
		StrukturaModelaService sms = MainFrame.getInstance()
				.getStrukturaModelaService();
		List<StrukturaModela> sveStrukture = (List<StrukturaModela>) sms
				.findAllStrukturaModela();
		Set<StrukturaModela> strukture = new HashSet<StrukturaModela>();

		for (StrukturaModela sm : sveStrukture) {
			if (sm.getModel().getId() == m.getId())
				strukture.add(sm);
		}

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
		gv.addln("graph [autosize=false, size=\"7.0,7.0!\", resolution=100];");
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

		gv.decreaseDpi();

		String type = "png";
		String repesentationType = "dot";

		File out = new File("GraphViz/graph." + type);
		gv.writeGraphToFile(
				gv.getGraph(gv.getDotSource(), type, repesentationType), out);

	}
}
