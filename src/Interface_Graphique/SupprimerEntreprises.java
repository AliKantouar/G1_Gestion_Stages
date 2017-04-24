package Interface_Graphique;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import Principal.DAO;
import Principal.Entreprises;
import Principal.Offres;

public class SupprimerEntreprises extends JButton implements ActionListener {

	Entreprises ent;
	GererEnt gererEnt;
	
	
	public SupprimerEntreprises(String string, Entreprises e, GererEnt gererEnt) {
	this.setText(string);
	this.ent=e;
	this.gererEnt=gererEnt;
	this.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		ArrayList<Offres> offres = DAO.listeO();
		
		for(int j = 0;j<offres.size();j++)
		{
			if(offres.get(j).getEnt().equals(ent.getNom()))
			{
				DAO.supprimerPostulationViaO(offres.get(j));
				DAO.supprimerOffre(offres.get(j));
			}
		}
		
		DAO.supprimerEntreprises(ent.getNom(), ent.getAdresse(), ent.getTel(), ent.getCom());
		
		this.gererEnt.a.setContentPane(new GererEnt(this.gererEnt.a));
		this.gererEnt.a.repaint();
		this.gererEnt.a.revalidate();
	}

}
