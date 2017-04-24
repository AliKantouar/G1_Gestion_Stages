package Interface_Graphique;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import Principal.DAO;
import Principal.Postulation;
import Principal.Utilisateur;

public class SupprimerUtilisateur extends JButton implements ActionListener{
	
	Utilisateur u;
	GererUser g;
	
	
	public SupprimerUtilisateur(String nom, Utilisateur u, GererUser gererUser)
	{
		this.setText(nom);
		this.u=u;
		this.g=gererUser;
		this.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
	
		ArrayList<Postulation> postulations = DAO.listePostulationViaUtilisateur(u.getId());
		
		for(int i = 0;i<postulations.size();i++)
		{
			System.out.println(postulations.get(i).getUser()+"/"+u.getId());
			if(postulations.get(i).getUser().equals(u.getId()))
			{
				
				if(postulations.get(i).getEtat()=='T')
				{
					DAO.IncrePlace(postulations.get(i));
				}
				DAO.supprimerPostulation(postulations.get(i).getUser(), postulations.get(i).getEnt(),  postulations.get(i).getPos(),  postulations.get(i).getDur());

							
			}
		}
		
		
		DAO.supprimerUtilisateur(u);
		
		this.g.a.setContentPane(new GererUser(this.g.a));
		this.g.a.repaint();
		this.g.a.revalidate();
		
	}
	
	
	

}
