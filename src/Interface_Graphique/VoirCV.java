package Interface_Graphique;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class VoirCV extends JButton implements ActionListener {

	
	String user;
	String nom;
	public VoirCV(String nom ,String user)
	{
		
		this.nom=nom;
		this.user=user;
		this.setText(nom);
		this.addActionListener(this);
	}
	
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		CV a =new CV(user);
		
	}

	
	
}
