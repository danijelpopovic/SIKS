package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.tree.DefaultMutableTreeNode;
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
import util.JPAUtil;
import view.DefineStructView;
import view.DialogKorak;
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
	private JPanel treePanel = new JPanel();
	private JPanel graphPanel = new JPanel();
	private JPanel panel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	private JButton btnSet;// = new JButton("Set");
	private SetView setView;
	private DialogKorak dialogKorak;
	private NewModelDialog newModelDialog;
	private DefineStructView dialogDefine;
	private KorakPropertiesDialog korakProperties;
	private FazaPropertiesDialog fazaProperties;
	private ModelPropertiesDialog modelProperties;

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
			JPAUtil util = new JPAUtil();
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
		this.setTitle("Standardizacija i kvalitet softvera Tim2");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(5, 5));

		treePanel.setPreferredSize(new Dimension(250, 600));
		treePanel.setLayout(new BorderLayout());
		getContentPane().add(treePanel, BorderLayout.WEST);

		buttonPanel.setLayout(new BorderLayout());
		getContentPane().add(buttonPanel, BorderLayout.NORTH);

		/*
		 * graphPanel.setPreferredSize(new Dimension(225, 600));
		 * graphPanel.setLayout(new BorderLayout());
		 * getContentPane().add(graphPanel, BorderLayout.EAST);
		 */

		initTree();

		getContentPane().add(panel, BorderLayout.CENTER);
		btnSet = new JButton(getActionManager().getSet());
		panel.add(btnSet);
		menu = new Menu();
		setJMenuBar(menu);

	}

	public void initTree() {

		updateTree();
		JScrollPane scrollPane = new JScrollPane(treeView);
		treePanel.add(scrollPane, BorderLayout.CENTER);

		/*
		 * DefaultMutableTreeNode rootNode = new
		 * DefaultMutableTreeNode("Root Node"); DefaultTreeModel treeModel = new
		 * DefaultTreeModel(rootNode); //treeModel.addTreeModelListener(new
		 * MyTreeModelListener());
		 * 
		 * JTree tree = new JTree(treeModel); tree.setEditable(true);
		 * tree.getSelectionModel().setSelectionMode
		 * (TreeSelectionModel.SINGLE_TREE_SELECTION);
		 * tree.setShowsRootHandles(true); treePanel.add(tree,
		 * BorderLayout.CENTER);
		 */
	}

	public void updateTree() {
		DefaultTreeModel root = new RootTreeModel();
		treeView = new TreeView();

		treeView.setModel(root);

		ModelZCSoftveraService mzcss = new ModelZCSoftveraService(getEm());
		StrukturaModelaService sms = new StrukturaModelaService(getEm());
		FazaService fs = new FazaService(getEm());

		List<ModelZCSoftvera> modelZCSoftveras = (List<ModelZCSoftvera>) mzcss
				.findAllModelZcSoftvera();
		List<StrukturaModela> struktureModela = (List<StrukturaModela>) sms
				.findAllStrukturaModela();
		List<Faza> faze = (List<Faza>) fs.findAllFaze();

		for (ModelZCSoftvera modelZCSoftvera : modelZCSoftveras) {

			treeView.AddModelZC(modelZCSoftvera);

			DefaultMutableTreeNode dNode, child;
			RootTreeModel a = (RootTreeModel) root;

			for (StrukturaModela struktura : modelZCSoftvera
					.getStrukturaModela()) {
				for (Faza f : faze) {
					if (struktura.getKorak().getFaza().id == f.id) {
						// System.out.println(f.getNazivFaze());
						modelZCSoftvera.add(f);
						if (f.getKoraci() != null && f.getKoraci().size() > 0) {
							for (Korak k : f.getKoraci()) {
								if (struktura.getKorak().getId() == k.getId())
									f.add(k);
							}
						}

					}
				}

			}

		}

	}

	public static EntityManagerFactory getEmf() {
		return emf;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public EntityManager getEm() {
		return em;
	}

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

	public void setFazaService(FazaService fazaService) {
		this.fazaService = fazaService;
	}

	public KorakService getKorakService() {
		return korakService;
	}

	public void setKorakService(KorakService korakService) {
		this.korakService = korakService;
	}

	public ModelZCSoftveraService getModelZCSoftveraService() {
		return modelZCSoftveraService;
	}

	public void setModelZCSoftveraService(
			ModelZCSoftveraService modelZCSoftveraService) {
		this.modelZCSoftveraService = modelZCSoftveraService;
	}

	public StrukturaModelaService getStrukturaModelaService() {
		return strukturaModelaService;
	}

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

}
