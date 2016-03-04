package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.tree.DefaultTreeModel;

import model.Faza;
import model.Korak;
import model.ModelZCSoftvera;
import model.StrukturaModela;
import services.FazaService;
import services.KorakService;
import services.ModelZCSoftveraService;
import services.StrukturaModelaService;
import tree.model.RootTreeModel;
import tree.view.TreeView;
import util.DrawGraph;
import view.DefineStructView;
import view.DialogKorak;
import view.EditModelDialog;
import view.FazaPropertiesDialog;
import view.KorakPropertiesDialog;
import view.ModelPropertiesDialog;
import view.NewModelDialog;
import view.SetView;
import actions.ActionManager;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static MainFrame instance = null;
	public static int init = 0;
	private JPanel treePanel;
	private JPanel graphPanel = new JPanel();
	private JPanel panel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	private SetView setView;
	private DialogKorak dialogKorak;
	private NewModelDialog newModelDialog;
	private DefineStructView dialogDefine;
	private KorakPropertiesDialog korakProperties;
	private FazaPropertiesDialog fazaProperties;
	private ModelPropertiesDialog modelProperties;
	private EditModelDialog editModelDialog;

	private static DrawGraph draw = new DrawGraph();

	public static enum ActionType {
		KORAK, FAZA, MODEL
	};

	private ActionType actionType;

	public ActionManager actionManager;

	public static EntityManagerFactory emf;

	public static EntityManager em;

	private TreeView treeView;

	public static FazaService fazaService;
	public static KorakService korakService;
	public static ModelZCSoftveraService modelZCSoftveraService;
	public static StrukturaModelaService strukturaModelaService;

	public Menu menu;

	public static MainFrame getInstance() {
		if (init == 0) {

			instance = new MainFrame();
			init = 1;

			return instance;
		}
		return instance;
	}

	private MainFrame() {
		super();

		actionManager = new ActionManager();

		try {
			emf = Persistence.createEntityManagerFactory("SIKS");
			em = emf.createEntityManager();
			fazaService = new FazaService(getEm());
			korakService = new KorakService(getEm());
			modelZCSoftveraService = new ModelZCSoftveraService(getEm());
			strukturaModelaService = new StrukturaModelaService(getEm());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.setSize(1000, 700);
		this.setLocationRelativeTo(null);
		this.setTitle("Modelar zivotnog ciklusa softvera Tim 2");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ImageIcon img = new ImageIcon("Icon/icon.png");
		this.setIconImage(img.getImage());
		this.setGraph();

		getContentPane().setLayout(new BorderLayout(5, 5));

		treePanel = new JPanel();
		treePanel.setPreferredSize(new Dimension(250, 600));
		treePanel.setLayout(new BorderLayout());
		getContentPane().add(treePanel, BorderLayout.WEST);

		buttonPanel.setLayout(new BorderLayout());
		getContentPane().add(buttonPanel, BorderLayout.NORTH);

		initTree();

		getContentPane().add(panel, BorderLayout.CENTER);
		menu = new Menu();
		setJMenuBar(menu);

	}

	public void initTree() {

		DefaultTreeModel root = new RootTreeModel();
		updateTree(root);
		JScrollPane scrollPane = new JScrollPane(treeView);
		getTreePanel().add(scrollPane, BorderLayout.CENTER);

	}

	public void updateTree(DefaultTreeModel root) {

		treeView = new TreeView();

		treeView.setModel(root);

		ModelZCSoftveraService mzcss = getModelZCSoftveraService();

		List<ModelZCSoftvera> modelZCSoftveras = (List<ModelZCSoftvera>) mzcss
				.findAllModelZcSoftvera();

		for (ModelZCSoftvera modelZCSoftvera : modelZCSoftveras) {

			treeView.AddModelZC(modelZCSoftvera);

			List<Faza> faze2 = new ArrayList<Faza>();
			List<Korak> koraci = new ArrayList<Korak>();

			for (StrukturaModela struktura : modelZCSoftvera
					.getStrukturaModela()) {

				Faza f = struktura.getKorak().getFaza();
				Faza f2 = struktura.getSledeci_korak().getFaza();
				// modelZCSoftvera.add(fn);

				if (!faze2.contains(f))
					faze2.add(f);

				if (!faze2.contains(f2))
					faze2.add(f2);

				if (!koraci.contains(struktura.getKorak()))
					koraci.add(struktura.getKorak());
				if (!koraci.contains(struktura.getSledeci_korak()))
					koraci.add(struktura.getSledeci_korak());

			}

			for (Faza f : faze2) {
				Faza fn = new Faza(f.getId(), f.getNazivFaze());
				modelZCSoftvera.add(fn);
				for (Korak k : koraci) {
					if (fn.getId() == k.getFaza().getId())
						fn.add(new Korak(k.getId(), k.getNaziv(), null));
				}
			}

		}

	}

	public static EntityManagerFactory getEmf() {
		return emf;
	}

	@SuppressWarnings("static-access")
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public EntityManager getEm() {
		return em;
	}

	@SuppressWarnings("static-access")
	public void setEm(EntityManager em) {
		this.em = em;
	}

	public void addGraph() {
		BufferedImage graph;
		File png = new File("GraphViz/graph.png");
		try {

			// getDraw().draw();
			graph = ImageIO.read(png);
			JLabel graphLabel = new JLabel(new ImageIcon(graph));
			panel.setBackground(Color.WHITE);
			graphPanel.removeAll();

			graphPanel.add(graphLabel);

			this.getPanel().removeAll();
			panel.add(graphPanel, BorderLayout.EAST);
			panel.updateUI();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setGraph() {
		BufferedImage graph;
		File png = new File("Icon/team2.png");
		try {

			// getDraw().draw();
			graph = ImageIO.read(png);
			JLabel graphLabel = new JLabel(new ImageIcon(graph));
			graphLabel.setBackground(Color.WHITE);
			graphPanel.removeAll();

			graphPanel.add(graphLabel);

			this.getPanel().removeAll();
			panel.add(graphPanel, BorderLayout.EAST);
			panel.updateUI();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public static DrawGraph getDraw() {
		return draw;
	}

	public static void setDraw(DrawGraph draw) {
		MainFrame.draw = draw;
	}

	public TreeView getTreeView() {
		return treeView;
	}

	public void setTreeView(TreeView treeView) {
		this.treeView = treeView;
	}

	public ActionType getActionType() {
		return actionType;
	}

	public void setActionType(ActionType actionType) {
		this.actionType = actionType;
	}

	public ActionManager getActionManager() {
		return actionManager;
	}

	public void setActionManager(ActionManager actionManager) {
		this.actionManager = actionManager;
	}

	public SetView getSetView() {
		return setView;
	}

	public void setSetView(SetView setView) {
		this.setView = setView;
	}

	public FazaService getFazaService() {
		return fazaService;
	}

	@SuppressWarnings("static-access")
	public void setFazaService(FazaService fazaService) {
		this.fazaService = fazaService;
	}

	public KorakService getKorakService() {
		return korakService;
	}

	@SuppressWarnings("static-access")
	public void setKorakService(KorakService korakService) {
		this.korakService = korakService;
	}

	public ModelZCSoftveraService getModelZCSoftveraService() {
		return modelZCSoftveraService;
	}

	@SuppressWarnings("static-access")
	public void setModelZCSoftveraService(
			ModelZCSoftveraService modelZCSoftveraService) {
		this.modelZCSoftveraService = modelZCSoftveraService;
	}

	public StrukturaModelaService getStrukturaModelaService() {
		return strukturaModelaService;
	}

	@SuppressWarnings("static-access")
	public void setStrukturaModelaService(
			StrukturaModelaService strukturaModelaService) {
		this.strukturaModelaService = strukturaModelaService;
	}

	public DialogKorak getDialogKorak() {
		return dialogKorak;
	}

	public void setDialogKorak(DialogKorak dialogKorak) {
		this.dialogKorak = dialogKorak;
	}

	public DefineStructView getDialogDefine() {
		return dialogDefine;
	}

	public void setDialogDefine(DefineStructView dialogDefine) {
		this.dialogDefine = dialogDefine;
	}

	public NewModelDialog getNewModelDialog() {
		return newModelDialog;
	}

	public void setNewModelDialog(NewModelDialog newModelDialog) {
		this.newModelDialog = newModelDialog;
	}

	public KorakPropertiesDialog getKorakProperties() {
		return korakProperties;
	}

	public void setKorakProperties(KorakPropertiesDialog korakProperties) {
		this.korakProperties = korakProperties;
	}

	public FazaPropertiesDialog getFazaProperties() {
		return fazaProperties;
	}

	public void setFazaProperties(FazaPropertiesDialog fazaProperties) {
		this.fazaProperties = fazaProperties;
	}

	public ModelPropertiesDialog getModelProperties() {
		return modelProperties;
	}

	public void setModelProperties(ModelPropertiesDialog modelProperties) {
		this.modelProperties = modelProperties;
	}

	public EditModelDialog getEditModelDialog() {
		return editModelDialog;
	}

	public void setEditModelDialog(EditModelDialog editDialog) {
		this.editModelDialog = editDialog;
	}

	public JPanel getTreePanel() {
		return treePanel;
	}

	public void setTreePanel(JPanel treePanel) {
		this.treePanel = treePanel;
	}

}
