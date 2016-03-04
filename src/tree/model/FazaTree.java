package tree.model;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.tree.TreeNode;

import model.Korak;

public class FazaTree implements TreeNode{

	private ArrayList<Korak> koraci = new ArrayList<Korak>();

	
	public FazaTree() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void addKorak(Korak korak){
		koraci.add(korak);
	}
	
	@Override
	public TreeNode getChildAt(int childIndex) {
		// TODO Auto-generated method stub
		return getKorak(childIndex);
	}

	@Override
	public int getChildCount() {
		// TODO Auto-generated method stub
		return koraci.size();
	}

	@Override
	public TreeNode getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getIndex(TreeNode node) {
		// TODO Auto-generated method stub
		return GetKorakIndex((Korak)node);
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
	public Enumeration<Korak> children() {
		// TODO Auto-generated method stub
		return (Enumeration<Korak>)koraci;
	}

	public ArrayList<Korak> getKoraci() {
		return koraci;
	}

	public void setKoraci(ArrayList<Korak> koraci) {
		this.koraci = koraci;
	}
	
	public Korak getKorak(int i){
		return koraci.get(i);
	}
	
	public int GetKorakIndex(Korak korak){
		return koraci.indexOf(korak);
	}
	
}
