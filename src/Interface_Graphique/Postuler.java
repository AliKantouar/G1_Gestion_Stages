package Interface_Graphique;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Principal.DemoJdbc;
import Principal.Offres;

public class Postuler extends JButton implements ActionListener{

	
	Offres o;
	String user;
	ListeCv lc;
	
	
	public Postuler(String nom, Offres offres, String user, ListeCv listeCv) {
		this.setText(nom);
		this.o=offres;
		this.user=user;
		this.addActionListener(this);
		this.lc=listeCv;
	}

	
	public void actionPerformed(ActionEvent arg0) {
		
		DemoJdbc.ajouterPostulation(user, o.getEnt(), o.poste(), o.getDur());
		
	}
	
	
}
