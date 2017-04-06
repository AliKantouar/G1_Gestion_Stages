package Interface_Graphique;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import Principal.DemoJdbc;
import Principal.Offres;

public class Recherche implements ActionListener {

	ListeCv lcv;
	boolean e;
	boolean d;
	boolean p;
	
	
	
	public Recherche(ListeCv listeCv) {
		// TODO Auto-generated constructor stub
	this.lcv=listeCv;
	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		this.e=lcv.getRdbtnNewRadioButtonE().isSelected();
		this.d=lcv.getRdbtnNewRadioButton_D().isSelected();
		this.p=lcv.getRdbtnNewRadioButton_p().isSelected();
		ArrayList<Offres> offres = new ArrayList<Offres>();
		if(e)
		{
			if(d)
			{
				if(p)
				{
					offres=Rechercheedp();
				}
				else
				{
					offres=Rechercheed();
				}	
			}
			else
			{
				if(p)
				{
					offres=Rechercheep();
				}
				else
				{
					offres=Recherchee();
				}
			}
		}
		else
		{
			if(d)
			{
				if(p)
				{
					offres=Recherchedp();
				}
				else
				{
					offres=Recherched();
				}	
			}
			else
			{
				if(p)
				{
					offres=Recherchep();
				}

			}
		}
		
		this.lcv.getPanel_2().remove(this.lcv.getScrollPane());
		this.lcv.afficherliste(offres);

	}

	

	private ArrayList<Offres> Recherchep() {
		// TODO Auto-generated method stub
	ArrayList<Offres> offres = DemoJdbc.listeO();
		for(int i = 0;i<offres.size();i++)
		{
			if(!offres.get(i).poste().equals(this.lcv.getComboBox_1().getSelectedItem().toString()))
			{
				System.out.println("different !");
				offres.remove(i);
				i--;
			}
		}
		
		return offres;
	
	}

	private ArrayList<Offres> Recherched() {
		// TODO Auto-generated method stub
		System.out.println("rentre");
		ArrayList<Offres> offres = DemoJdbc.listeO();
		for(int i = 0;i<offres.size();i++)
		{
			if(this.lcv.getTextField().getText().toString().equals("")&&this.lcv.getTextField_1().getText().toString().equals("")){
				System.out.println("BUG");
			}
			else
				if(this.lcv.getTextField().getText().toString().equals(""))
				{
					System.out.println("à l'aide");
					if(Integer.parseInt(offres.get(i).getDur())>Integer.parseInt(this.lcv.getTextField_1().getText().toString()))
					{
						System.out.println("trop grand");
						offres.remove(i);
						i--;
					}
				}
				else
				{
					if(Integer.parseInt(offres.get(i).getDur())<Integer.parseInt(this.lcv.getTextField().getText().toString()))
					{
						System.out.println("trop petit");
						offres.remove(i);
						i--;
					}
				}
			
		}
		
		System.out.println(offres.size());
		/*for(int d=0;d<offres.size();d++)
		{
			offres.get(d).Afficher();
		}*/

		return offres;
	}

	private ArrayList<Offres> Recherchee() {
		// TODO Auto-generated method stub
		ArrayList<Offres> offres = DemoJdbc.listeO();
		for(int i = 0;i<offres.size();i++)
		{
			if(!offres.get(i).getEnt().equals(this.lcv.getComboBox().getSelectedItem().toString()))
			{
				System.out.println("different !");
				offres.remove(i);
				i--;
			}
		}
		
		return offres;
		
	}
	
	private ArrayList<Offres> Recherchedp() {
		// TODO Auto-generated method stub

		
		ArrayList<Offres> offresd = Recherched();
		ArrayList<Offres> offresp = Recherchep();
		ArrayList<Offres> offres = Commun(offresd,offresp);
		
		return offres;
	}

	

	private ArrayList<Offres> Commun(ArrayList<Offres> offres1, ArrayList<Offres> offres2) {
		// TODO Auto-generated method stub
		ArrayList<Offres> offres = new ArrayList<Offres>();
		for(int i = 0;i<offres1.size();i++)
		{
			for(int j = 0;j<offres2.size();j++)
			{
				System.out.println(offres1.get(i).AfficherS()+"----------"+offres2.get(j).AfficherS());
				if(offres1.get(i).getEnt().equals(offres2.get(j).getEnt())&&offres1.get(i).getDur().equals(offres2.get(j).getDur())
						&&offres1.get(i).poste().equals(offres2.get(j).poste()))
				{
					System.out.println("ICI");
					offres.add(offres1.get(i));
				}
			}
		}
		
		return offres;
	}

	private ArrayList<Offres> Rechercheep() {
		// TODO Auto-generated method stub
		ArrayList<Offres> offresd = Recherchee();
		ArrayList<Offres> offresp = Recherchep();
		ArrayList<Offres> offres = Commun(offresd,offresp);
		
		return offres;	
	}

	private ArrayList<Offres> Rechercheed() {
		// TODO Auto-generated method stub
		ArrayList<Offres> offresd = Recherched();
		ArrayList<Offres> offresp = Recherchee();
		ArrayList<Offres> offres = Commun(offresd,offresp);
		
		return offres;
	}

	private ArrayList<Offres> Rechercheedp() {
		// TODO Auto-generated method stub
		ArrayList<Offres> offresd = Recherched();
		ArrayList<Offres> offresp = Recherchee();
		ArrayList<Offres> offrese = Recherchee();
		ArrayList<Offres> offres = Commun3(offresd,offresp,offrese);
		return offres;
	}

	private ArrayList<Offres> Commun3(ArrayList<Offres> offres1, ArrayList<Offres> offres2, ArrayList<Offres> offres3) {
		// TODO Auto-generated method stub
		ArrayList<Offres> offres = new ArrayList<Offres>();
		for(int i = 0;i<offres1.size();i++)
		{
			for(int j = 0;j<offres2.size();j++)
			{
				for(int k = 0;k<offres2.size();k++)
				{
					if(offres1.get(i).getEnt().equals(offres2.get(j).getEnt())&&offres1.get(i).getDur().equals(offres2.get(j).getDur())
							&&offres1.get(i).poste().equals(offres2.get(j).poste()))
					{
						if(offres1.get(i).getEnt().equals(offres3.get(j).getEnt())&&offres1.get(i).getDur().equals(offres3.get(j).getDur())
								&&offres1.get(i).poste().equals(offres3.get(j).poste()))
						{
							System.out.println("ICI");
							offres.add(offres1.get(i));
						}
					}
				}	
				
			}
		}
		
		return offres;
	}

}
