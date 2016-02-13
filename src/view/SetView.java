package view;

import gui.MainFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;

import app.DualListBox;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;

import java.awt.FlowLayout;


public class SetView extends JDialog {

	  private static final Insets EMPTY_INSETS = new Insets(0, 0, 0, 0);

	  private static final String ADD_BUTTON_LABEL = "Add >>";

	  private static final String REMOVE_BUTTON_LABEL = "<< Remove";

	  private static final String DEFAULT_SOURCE_CHOICE_LABEL = "Available Choices";

	  private static final String DEFAULT_DEST_CHOICE_LABEL = "Your Choices";

	  private JLabel sourceLabel;

	  private JList sourceList;

	  private SortedListModel sourceListModel;

	  private JList destList;

	  private SortedListModel destListModel;

	  private JLabel destLabel;

	  private JButton addButton;

	  private JButton removeButton;
	  private JLabel lblFaza;
	  private JTextField txtFaza;
	  private JButton btnSave;
	  private JPanel panel_1;
	  private JButton btnCancel;

	  public SetView(JFrame parent) {
		  super(parent);
	    initScreen(parent);
	  }

	  public String getSourceChoicesTitle() {
	    return sourceLabel.getText();
	  }

	  public void setSourceChoicesTitle(String newValue) {
	    sourceLabel.setText(newValue);
	  }

	  public String getDestinationChoicesTitle() {
	    return destLabel.getText();
	  }

	  public void setDestinationChoicesTitle(String newValue) {
	    destLabel.setText(newValue);
	  }

	  public void clearSourceListModel() {
	    sourceListModel.clear();
	  }

	  public void clearDestinationListModel() {
	    destListModel.clear();
	  }

	  public void addSourceElements(ListModel newValue) {
	    fillListModel(sourceListModel, newValue);
	  }

	  public void setSourceElements(ListModel newValue) {
	    clearSourceListModel();
	    addSourceElements(newValue);
	  }

	  public void addDestinationElements(ListModel newValue) {
	    fillListModel(destListModel, newValue);
	  }

	  private void fillListModel(SortedListModel model, ListModel newValues) {
	    int size = newValues.getSize();
	    for (int i = 0; i < size; i++) {
	      model.add(newValues.getElementAt(i));
	    }
	  }

	  public void addSourceElements(Object newValue[]) {
	    fillListModel(sourceListModel, newValue);
	  }

	  public void setSourceElements(Object newValue[]) {
	    clearSourceListModel();
	    addSourceElements(newValue);
	  }

	  public void addDestinationElements(Object newValue[]) {
	    fillListModel(destListModel, newValue);
	  }

	  private void fillListModel(SortedListModel model, Object newValues[]) {
	    model.addAll(newValues);
	  }

	  public Iterator sourceIterator() {
	    return sourceListModel.iterator();
	  }

	  public Iterator destinationIterator() {
	    return destListModel.iterator();
	  }

	  public void setSourceCellRenderer(ListCellRenderer newValue) {
	    sourceList.setCellRenderer(newValue);
	  }

	  public ListCellRenderer getSourceCellRenderer() {
	    return sourceList.getCellRenderer();
	  }

	  public void setDestinationCellRenderer(ListCellRenderer newValue) {
	    destList.setCellRenderer(newValue);
	  }

	  public ListCellRenderer getDestinationCellRenderer() {
	    return destList.getCellRenderer();
	  }

	  public void setVisibleRowCount(int newValue) {
	    sourceList.setVisibleRowCount(newValue);
	    destList.setVisibleRowCount(newValue);
	  }

	  public int getVisibleRowCount() {
	    return sourceList.getVisibleRowCount();
	  }

	  public void setSelectionBackground(Color newValue) {
	    sourceList.setSelectionBackground(newValue);
	    destList.setSelectionBackground(newValue);
	  }

	  public Color getSelectionBackground() {
	    return sourceList.getSelectionBackground();
	  }

	  public void setSelectionForeground(Color newValue) {
	    sourceList.setSelectionForeground(newValue);
	    destList.setSelectionForeground(newValue);
	  }

	  public Color getSelectionForeground() {
	    return sourceList.getSelectionForeground();
	  }

	  private void clearSourceSelected() {
	    Object selected[] = sourceList.getSelectedValues();
	    for (int i = selected.length - 1; i >= 0; --i) {
	      sourceListModel.removeElement(selected[i]);
	    }
	    sourceList.getSelectionModel().clearSelection();
	  }

	  private void clearDestinationSelected() {
	    Object selected[] = destList.getSelectedValues();
	    for (int i = selected.length - 1; i >= 0; --i) {
	      destListModel.removeElement(selected[i]);
	    }
	    destList.getSelectionModel().clearSelection();
	  }

	  private void initScreen(JFrame parent) {
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setSize(300,300);
	    panel.setBorder(BorderFactory.createEtchedBorder());
	    GridBagLayout gbl_panel = new GridBagLayout();
	    gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
	    gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0};
	    panel.setLayout(gbl_panel);
	    sourceLabel = new JLabel(DEFAULT_SOURCE_CHOICE_LABEL);
	    sourceListModel = new SortedListModel();
	    sourceList = new JList(sourceListModel);
	    panel.add(sourceLabel, new GridBagConstraints(0, 0, 1, 1, 0, 0,
	        GridBagConstraints.CENTER, GridBagConstraints.NONE,
	        new Insets(0, 0, 5, 5), 0, 0));
	    panel.add(new JScrollPane(sourceList), new GridBagConstraints(0, 1, 1, 5, .5,
	        1, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
	        new Insets(0, 0, 5, 5), 0, 0));

	    addButton = new JButton(ADD_BUTTON_LABEL);
	    panel.add(addButton, new GridBagConstraints(1, 2, 1, 2, 0, .25,
	        GridBagConstraints.CENTER, GridBagConstraints.NONE,
	        new Insets(0, 0, 5, 5), 0, 0));
	    addButton.addActionListener(new AddListener());
	    removeButton = new JButton(REMOVE_BUTTON_LABEL);
	    panel.add(removeButton, new GridBagConstraints(1, 4, 1, 2, 0, .25,
	        GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 5, 5, 5), 0, 0));
	    removeButton.addActionListener(new RemoveListener());

	    destLabel = new JLabel(DEFAULT_DEST_CHOICE_LABEL);
	    destListModel = new SortedListModel();
	    destList = new JList(destListModel);
	    panel.add(destLabel, new GridBagConstraints(2, 0, 1, 1, 0, 0,
	        GridBagConstraints.CENTER, GridBagConstraints.NONE,
	        new Insets(0, 0, 5, 0), 0, 0));
	    panel.add(new JScrollPane(destList), new GridBagConstraints(2, 1, 1, 5, .5,
	        1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
	        new Insets(0, 0, 5, 0), 0, 0));
	    
	    getContentPane().add(panel);
	    
	    lblFaza = new JLabel("Faza");
	    GridBagConstraints gbc_lblFaza = new GridBagConstraints();
	    gbc_lblFaza.anchor = GridBagConstraints.EAST;
	    gbc_lblFaza.insets = new Insets(0, 0, 5, 5);
	    gbc_lblFaza.gridx = 1;
	    gbc_lblFaza.gridy = 6;
	    panel.add(lblFaza, gbc_lblFaza);
	    
	    txtFaza = new JTextField();
	    GridBagConstraints gbc_txtFaza = new GridBagConstraints();
	    gbc_txtFaza.insets = new Insets(0, 0, 5, 0);
	    gbc_txtFaza.fill = GridBagConstraints.HORIZONTAL;
	    gbc_txtFaza.gridx = 2;
	    gbc_txtFaza.gridy = 6;
	    panel.add(txtFaza, gbc_txtFaza);
	    txtFaza.setColumns(10);
	    
	    panel_1 = new JPanel();
	    GridBagConstraints gbc_panel_1 = new GridBagConstraints();
	    gbc_panel_1.fill = GridBagConstraints.BOTH;
	    gbc_panel_1.gridx = 2;
	    gbc_panel_1.gridy = 7;
	    panel.add(panel_1, gbc_panel_1);
	    panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
	    
	    btnCancel = new JButton("Cancel");
	    btnCancel.setHorizontalAlignment(SwingConstants.RIGHT);
	    btnCancel.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	}
	    });
	    panel_1.add(btnCancel);
	    
	    btnSave = new JButton(MainFrame.getInstance().getActionManager().getSetSubmit());
	    btnSave.setHorizontalAlignment(SwingConstants.RIGHT);
	    panel_1.add(btnSave);
	    pack();
	    setLocationRelativeTo(parent);
	    setVisible(true);
	  }

	  /*public static void main(String args[]) {
	    JFrame f = new JFrame("Dual List Box Tester");
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    DualListBox dual = new DualListBox();
	    dual.addSourceElements(new String[] { "One", "Two", "Three" });
	    dual.addSourceElements(new String[] { "Four", "Five", "Six" });
	    dual.addSourceElements(new String[] { "Seven", "Eight", "Nine" });
	    dual.addSourceElements(new String[] { "Ten", "Eleven", "Twelve" });
	    dual
	        .addSourceElements(new String[] { "Thirteen", "Fourteen",
	            "Fifteen" });
	    dual.addSourceElements(new String[] { "Sixteen", "Seventeen",
	        "Eighteen" });
	    dual.addSourceElements(new String[] { "Nineteen", "Twenty", "Thirty" });
	    f.getContentPane().add(dual, BorderLayout.CENTER);
	    f.setSize(400, 300);
	    f.setVisible(true);
	  }*/

	  private class AddListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	      Object selected[] = sourceList.getSelectedValues();
	      addDestinationElements(selected);
	      clearSourceSelected();
	    }
	  }

	  private class RemoveListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	      Object selected[] = destList.getSelectedValues();
	      addSourceElements(selected);
	      clearDestinationSelected();
	    }
	  }

	public JList getSourceList() {
		return sourceList;
	}

	public void setSourceList(JList sourceList) {
		this.sourceList = sourceList;
	}

	public JList getDestList() {
		return destList;
	}

	public void setDestList(JList destList) {
		this.destList = destList;
	}

	public JTextField getTxtFaza() {
		return txtFaza;
	}

	public void setTxtFaza(JTextField txtFaza) {
		this.txtFaza = txtFaza;
	}
	  
	  
}

	class SortedListModel extends AbstractListModel {

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
	      fireContentsChanged(this, 0, getSize());
	    }
	  }

	  public void addAll(Object elements[]) {
	    Collection c = Arrays.asList(elements);
	    model.addAll(c);
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
	    return model.first();
	  }

	  public Iterator iterator() {
	    return model.iterator();
	  }

	  public Object lastElement() {
	    return model.last();
	  }

	  public boolean removeElement(Object element) {
	    boolean removed = model.remove(element);
	    if (removed) {
	      fireContentsChanged(this, 0, getSize());
	    }
	    return removed;
	  }
	}