package actions;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

import view.SetView;

public class SetSubmit extends AbstractAction{

	
	
	public SetSubmit(){
		putValue(NAME, "Ok");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Component component = (Component) e.getSource();
		Component component2 = component.getParent();
		Component component3 = component2.getParent();
		System.out.println(((SetView)component3).getTxtFaza());
	}
}
