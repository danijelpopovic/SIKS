package tree.model;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.tree.TreeNode;

import model.ModelZCSoftvera;

public class RootTree implements TreeNode{

	
	private ArrayList<ModelZCSoftvera> modelZCSoftveras = new ArrayList<ModelZCSoftvera>();
	private ArrayList<String> list = new ArrayList<String>();
	
	public RootTree() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return "Modeli ZC softvera";
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		return (TreeNode) getModelZCSoftverasIndex(childIndex);
	}

	@Override
	public int getChildCount() {
		// TODO Auto-generated method stub
		return modelZCSoftveras.size();
	}

	@Override
	public TreeNode getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getIndex(TreeNode node) {
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

	@SuppressWarnings("rawtypes")
	public Enumeration children() {
		return ((Enumeration<ModelZCSoftvera>) modelZCSoftveras);
	}

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
	
	public void addModelZCSoftvera(ModelZCSoftvera modelZCSoftvera){
		modelZCSoftveras.add(modelZCSoftvera);
	}
	
	public void addTest(String a){
		list.add(a);
	}
}
