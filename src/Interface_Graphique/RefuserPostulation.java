package Interface_Graphique;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Principal.DemoJdbc;
import Principal.Postulation;

public class RefuserPostulation extends JButton implements ActionListener {

	
	
	Postulation p;
	
	public RefuserPostulation(String string, Postulation p)
	{
		this.p=p;
		this.setText(string);
		this.addActionListener(this);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		DemoJdbc.modifPostulation(p,false);
	}

}
