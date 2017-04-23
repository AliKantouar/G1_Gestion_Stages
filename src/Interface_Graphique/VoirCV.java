package Interface_Graphique;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class VoirCV extends JButton implements ActionListener {

	
	String user;
	public VoirCV(String user)
	{
		
	}
	
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		new CV("user");
	}

	
	
}
