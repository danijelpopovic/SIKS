package tree.model;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.tree.TreeNode;

import model.Faza;

public class ModelZcTree implements TreeNode{

	private ArrayList<Faza> faze = new ArrayList<Faza>();
	
	
	public ModelZcTree() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Faza> getFaze() {
		return faze;
	}

	public void setFaze(ArrayList<Faza> faze) {
		this.faze = faze;
	}


	public void addFaza(Faza faza){
		faze.add(faza);
	}
	
	public void removeFaza(Faza faza){
		faze.remove(faza);
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		// TODO Auto-generated method stub
		return faze.get(childIndex);
	}

	@Override
	public int getChildCount() {
		// TODO Auto-generated method stub
		return getFaze().size();
	}

	@Override
	public TreeNode getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getIndex(TreeNode node) {
		// TODO Auto-generated method stub
		return getFazaIndex((Faza)node);
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

	@SuppressWarnings("unchecked")
	@Override
	public Enumeration<Faza> children() {
		// TODO Auto-generated method stub
		return (Enumeration<Faza>)faze;
	}

	public int getFazaIndex(Faza o){
		return faze.indexOf(o);
	}
}
