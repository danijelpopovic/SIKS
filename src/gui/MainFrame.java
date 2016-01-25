package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;


public class MainFrame extends JFrame {
	
	private static MainFrame instance = null;
	private JPanel treePanel = new JPanel();
	
	public static MainFrame getInstance(){
		if(instance == null){
			instance = new MainFrame();
			return instance;
		}
		return instance;
	}
	
	private MainFrame() {
		super();

		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setTitle("Standardizacija i kvalitet softvera Tim2");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(5, 5));

		treePanel.setPreferredSize(new Dimension(225, 600));
		treePanel.setLayout(new BorderLayout());
		getContentPane().add(treePanel, BorderLayout.WEST);

		initTree();
	}

	
	public void initTree(){
		
		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Root Node");
		DefaultTreeModel treeModel = new DefaultTreeModel(rootNode);
		//treeModel.addTreeModelListener(new MyTreeModelListener());

		JTree tree = new JTree(treeModel);
		tree.setEditable(true);
		tree.getSelectionModel().setSelectionMode
		        (TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.setShowsRootHandles(true);
		treePanel.add(tree, BorderLayout.CENTER);
	}
	
}
