package Interface_Graphique;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Principal.DemoJdbc;
import Principal.Offres;

public class AnnulerPostulation extends JButton implements ActionListener{

	Offres o;
	
	String user;
	
	public AnnulerPostulation(String nom, Offres offres, String user) {
		this.setText(nom);
		this.o=offres;
		this.user=user;
		this.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
		DemoJdbc.supprimerPostulation(user, o.getEnt(), o.poste(), o.getDur());
	}

}
