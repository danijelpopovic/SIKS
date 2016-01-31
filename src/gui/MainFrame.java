package gui;

import java.awt.BorderLayout;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.ModelZCSoftvera;
import model.StrukturaModela;
import services.ModelZCSoftveraService;
<<<<<<< HEAD
import services.StrukturaModelaService;
=======
>>>>>>> 817de92204a4a17ff714bb14b2dab92493ffe45c
import tree.model.RootTreeModel;
import tree.view.TreeView;
import util.JPAUtil;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static MainFrame instance = null;
	public static int init = 0;
	private JPanel treePanel = new JPanel();
	private JPanel graphPanel = new JPanel();

	public static EntityManagerFactory emf;// =
											// Persistence.createEntityManagerFactory("SIKS");
	public static EntityManager em;// = emf.createEntityManager();

	private TreeView treeView;

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
		

		try {
			JPAUtil util = new JPAUtil();
			 emf = Persistence.createEntityManagerFactory("SIKS");
			 em = emf.createEntityManager();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		this.setSize(1000, 700 );
		this.setLocationRelativeTo(null);
		this.setTitle("Standardizacija i kvalitet softvera Tim2");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(5, 5));

		treePanel.setPreferredSize(new Dimension(250, 600));
		treePanel.setLayout(new BorderLayout());
		getContentPane().add(treePanel, BorderLayout.WEST);		
		
		BufferedImage graph;
		File png = new File("GraphViz/graph.png");
		try {
			graph = ImageIO.read(png);
			JLabel graphLabel = new JLabel(new ImageIcon(graph));
			graphPanel.add(graphLabel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		treePanel.add(graphPanel, BorderLayout.EAST);
		
		/*graphPanel.setPreferredSize(new Dimension(225, 600));
		graphPanel.setLayout(new BorderLayout());
		getContentPane().add(graphPanel, BorderLayout.EAST);*/		

		initTree();
	}

	public void initTree() {

		RootTreeModel root = new RootTreeModel();
		treeView = new TreeView();

		ModelZCSoftveraService mzcss = new ModelZCSoftveraService(getEm());
<<<<<<< HEAD
		StrukturaModelaService sms = new StrukturaModelaService(getEm());
		
		List<ModelZCSoftvera> modelZCSoftveras  = (List<ModelZCSoftvera>) mzcss.findAllModelZcSoftvera();
		List<StrukturaModela> struktureModela = (List<StrukturaModela>) sms.findAllStrukturaModela();
		
		for(ModelZCSoftvera modelZCSoftvera : modelZCSoftveras){
=======

		List<ModelZCSoftvera> modelZCSoftveras = (List<ModelZCSoftvera>) mzcss
				.findAllModelZcSoftvera();

		for (ModelZCSoftvera modelZCSoftvera : modelZCSoftveras) {
>>>>>>> 817de92204a4a17ff714bb14b2dab92493ffe45c
			root.addModelZCSoftvera(modelZCSoftvera);
			
		}

		treeView.setModel(root);
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

	public static EntityManagerFactory getEmf() {
		return emf;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public static EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

}
