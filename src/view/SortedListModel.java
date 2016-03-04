package view;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.swing.AbstractListModel;

@SuppressWarnings("rawtypes")
public class SortedListModel extends AbstractListModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6099909310271476728L;
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

	@SuppressWarnings("unchecked")
	public void add(Object element) {
		if (model.add(element)) {
			fireContentsChanged(this, 0, getSize());
		}
	}

	@SuppressWarnings("unchecked")
	public void addAll(Object elements[]) {

		Collection c = Arrays.asList(elements);

		for (Object o : c) {
			model.add(o);

		}

		fireContentsChanged(this, model.size(), getSize());
	}

	public void addAllDest(Object elements[]) {

		Collection c = Arrays.asList(elements);

		for (Object o : c) {
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
