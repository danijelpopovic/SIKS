package tree.model;

import java.util.List;
import java.util.ArrayList;

import javax.swing.tree.DefaultTreeModel;

import model.ModelZCSoftvera;

public class RootTreeModel extends DefaultTreeModel{

	
	
	public RootTreeModel() {
		super(new RootTree());
		// TODO Auto-generated constructor stub
	}

	public Object getChild(Object parent, int index) {
		
		if (parent instanceof RootTree) {
			RootTree root =  ((RootTree) parent);
			List<Object> objects = new ArrayList<Object>();
			
			objects.addAll(root.getModelZCSoftveras());
			int i = -1;
			for(Object o : objects){
				i++;
				if(i == index){
					if(o instanceof ModelZCSoftvera){
						return (ModelZCSoftvera)o;
					}
				}
			}
		}
		
			
		return getRoot();
	}
	
	public int getChildCount(Object parent) {
		
		return ((RootTree) parent).getChildCount();
	}
	
	public boolean isLeaf(Object node) {
		
		if(node instanceof ModelZCSoftvera)
			return true;
		return false;
	}
	
	/*public int getIndexOfChild(Object parent, Object child) {
		
		if(parent instanceof RootTree){
			
			if(child instanceof ModelZCSoftvera){
				return ((ModelZCSoftvera)parent).getSubPackages().indexOf((Package) child);
			}
				
		}
	}*/
	
	public void addModelZCSoftvera(ModelZCSoftvera modelZCSoftvera){
		((RootTree)getRoot()).addModelZCSoftvera(modelZCSoftvera);
	}

	
	public void addTest(String a){
		((RootTree)getRoot()).addTest(a);
	}
}
