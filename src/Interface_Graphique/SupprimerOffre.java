package Interface_Graphique;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Principal.DAO;
import Principal.Offres;

public class SupprimerOffre extends JButton implements ActionListener {
	
	GererOffr lcv;
	GererOffrE lcve;
	
	Offres o ;
	public SupprimerOffre(String string, Offres o, GererOffr gererOffr)
	{
		this.setText(string);
		this.o=o;
		this.addActionListener(this);
		this.lcv=gererOffr;
	}
	
	
	
	
	
	public SupprimerOffre(String string, Offres o, GererOffrE gererOffrE) {
		this.setText(string);
		this.o=o;
		this.addActionListener(this);
		this.lcve=gererOffrE;
	}





	public void actionPerformed(ActionEvent arg0) {
		DAO.supprimerPostulationViaO(o);
		DAO.supprimerOffre(o);
		
		if(lcv!=null)
		{
		this.lcv.a.setContentPane(new GererOffr(this.lcv.a));
		this.lcv.a.repaint();
		this.lcv.a.revalidate();
		}
		else
		{
			this.lcve.a.setContentPane(new GererOffrE(this.lcve.a,lcve.user));
			this.lcve.a.repaint();
			this.lcve.a.revalidate();
		}
		
	}

	
	
	
}
