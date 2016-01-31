package tree.model;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

import model.Faza;
import model.ModelZCSoftvera;

public class RootTree implements TreeNode{

	
	private ArrayList<ModelZCSoftvera> modelZCSoftveras = new ArrayList<ModelZCSoftvera>();
	
	
	public RootTree() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return "Modeli ZC softvera";
	}

	public void addModelZCSoftvera(ModelZCSoftvera model){
		modelZCSoftveras.add(model);
	}
	
/*	@SuppressWarnings("rawtypes")
	public Enumeration<ModelZCSoftvera> children() {
		
		return ((Enumeration<ModelZCSoftvera>) modelZCSoftveras);
	}
*/
	public ArrayList<ModelZCSoftvera> getModelZCSoftveras() {
		return modelZCSoftveras;
	}

	public void setModelZCSoftveras(ArrayList<ModelZCSoftvera> modelZCSoftveras) {
		this.modelZCSoftveras = modelZCSoftveras;
	}

	
	public int getModelZCSoftverasIndex(ModelZCSoftvera modelZCSoftvera) {
		return modelZCSoftveras.indexOf(modelZCSoftvera);
	}

	public ModelZCSoftvera getModelZCSoftverasIndex(int index) {
		return modelZCSoftveras.get(index);
	}
	
	
	@Override
	public TreeNode getChildAt(int childIndex) {
		// TODO Auto-generated method stub
		return getModelZCSoftverasIndex(childIndex);
	}

	@Override
	public int getChildCount() {
		// TODO Auto-generated method stub
		return getModelZCSoftveras().size();
	}

	@Override
	public TreeNode getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getIndex(TreeNode node) {
		// TODO Auto-generated method stub
		return getModelZCSoftverasIndex((ModelZCSoftvera)node);
	}

	@Override
	public boolean getAllowsChildren() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Enumeration<Faza> children() {
		// TODO Auto-generated method stub
		return (Enumeration<Faza>)modelZCSoftveras;
	}

	
	
}
