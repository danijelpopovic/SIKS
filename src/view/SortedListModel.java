package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;



import javax.swing.AbstractListModel;


public class SortedListModel extends AbstractListModel {

 SortedSet model;

  public SortedListModel() {
    model = new TreeSet();
  }

  public int getSize() {
    return model.size();
  }

  public Object getElementAt(int index) {
    return model.toArray()[index];
  }

  public void add(Object element) {
    if (model.add(element)) {
      fireContentsChanged(this,0, getSize());
    }
  }

  public void addAll(Object elements[]) {
	  
	String a="";
	  
    Collection c = Arrays.asList(elements);
     
    
    for(Object o : c){
    	model.add(o);
    	
    }    
    
    fireContentsChanged(this, model.size(), getSize());
  }

  
  public void addAllDest(Object elements[]) {
	  
	  String a="";
	  
	    Collection c = Arrays.asList(elements);
	    
	    
	    
	    for(Object o : c){
	    	add(o);
	    }    
	    
	    fireContentsChanged(this, 0, getSize());
	  }
  
  public void clear() {
    model.clear();
    fireContentsChanged(this, 0, getSize());
  }

  public boolean contains(Object element) {
    return model.contains(element);
  }

  public Object firstElement() {
    return ((SortedSet) model).first();
  }

  public Iterator iterator() {
    return model.iterator();
  }

  public Object lastElement() {
    return ((TreeSet) model).last();
  }

  public boolean removeElement(Object element) {
    boolean removed = model.remove(element);
    if (removed) {
      fireContentsChanged(this, 0, getSize());
    }
    return removed;
  }

	public SortedSet getModel() {
		return model;
	}
	
	public void setModel(SortedSet model) {
		this.model = model;
}
  
  
}
