package tree.model;

import javax.swing.tree.DefaultTreeModel;

import model.Faza;
import model.Korak;
import model.ModelZCSoftvera;

public class RootTreeModel extends DefaultTreeModel{

	
	
	public RootTreeModel() {
		super(new RootTree());
	/*	Faza f = new Faza();
		f.setNazivFaze("123");
		addFaza(f);
		Faza f1 = new Faza();
		f1.setNazivFaze("456");
		f.add(f1)*/;
		// TODO Auto-generated constructor stub
	}

	/*public Object getChild(Object parent, int index) {
		
		if (parent instanceof RootTree) {
			RootTree root =  ((RootTree) parent);
			List<Object> objects = new ArrayList<Object>();
			
			objects.addAll(root.getModelZCSoftveras());
			objects.addAll(root.getFaze());
			int i = -1;
			for(Object o : objects){
				i++;
				if(i == index){
					if(o instanceof ModelZCSoftvera){
						return (ModelZCSoftvera)o;
					}else if(o instanceof Faza){
						return (Faza)o;
					}else if(o instanceof ModelZCSoftvera){
							return (ModelZCSoftvera)o;
						
					}
				}
			}
		}else if (parent instanceof ModelZCSoftvera){ 
			
			RootTree root =  ((RootTree) parent);
			List<Object> objects = new ArrayList<Object>();
			
			objects.addAll(root.getModelZCSoftveras());
			objects.addAll(root.getFaze());
			
			int i = -1;
			for(Object o : objects){
				i++;
				if(i == index){
					if(o instanceof Faza){
						return (Faza)o;
					}else if(o instanceof ModelZCSoftvera){
							return (ModelZCSoftvera)o;
						
					}
				}
			}
		}
		
			
		return getRoot();
	}
	
	public int getChildCount(Object parent) {
		
		int count = ((RootTree) parent).getChildCount();
		return count;
	}
	
	public boolean isLeaf(Object node) {
		
		if(node instanceof ModelZCSoftvera)
			return true;
		if(node instanceof Faza)
			return true;
		return false;
	}
	*/
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

	
	public void addFaza(Faza faza){
		((ModelZcTree)getRoot()).addFaza(faza);
	}
	
	public void addKorak(Korak korak){
		((FazaTree)getRoot()).addKorak(korak);
	}
	
	public void removeModelZCSoftvera(ModelZCSoftvera modelZCSoftvera){
		((RootTree)getRoot()).removeModelZCSoftvera(modelZCSoftvera);
	}
	
	
}
