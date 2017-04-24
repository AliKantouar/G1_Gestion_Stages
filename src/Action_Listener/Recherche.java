package Action_Listener;

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

import Interface_Graphique.ListeCv;
import Principal.DAO;
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
		boolean faire = true;
		if(e)
		{
			if(d)
			{
				if(p)
				{
					System.out.println("edp ---------------------------------------------------------------");
					offres=Rechercheedp();
				}
				else
				{
					System.out.println("ed");
					offres=Rechercheed();
				}	
			}
			else
			{
				if(p)
				{
					System.out.println("ep");
					offres=Rechercheep();
				}
				else
				{
					System.out.println("e");
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
					System.out.println("dp");
					offres=Recherchedp();
				}
				else
				{
					System.out.println("d");
					offres=Recherched();
				}	
			}
			else
			{
				if(p)
				{
					System.out.println("p");
					offres=Recherchep();
				}
				else
				{
					faire=false;
					this.lcv.setNbr(DAO.listeO().size());
					this.lcv.getPanel_2().remove(this.lcv.getScrollPane());
					this.lcv.afficherliste(DAO.listeO());
				}

			}
		}
		
		if(faire){
		this.lcv.setNbr(offres.size());
		this.lcv.getPanel_2().remove(this.lcv.getScrollPane());
		this.lcv.afficherliste(offres);
		}
	}

	

	private ArrayList<Offres> Recherchep() {
		// TODO Auto-generated method stub
	ArrayList<Offres> offres = DAO.listeO();
		for(int i = 0;i<offres.size();i++)
		{
			
			if(!offres.get(i).poste().equals(this.lcv.getComboBox_1().getSelectedItem().toString()))
			{
				
				offres.remove(i);
				i--;
			}
		}
		
		return offres;
	
	}

	private ArrayList<Offres> Recherched() {
		// TODO Auto-generated method stub
		
		ArrayList<Offres> offres = DAO.listeO();
		for(int i = 0;i<offres.size();i++)
		{
			if(this.lcv.getTextField().getText().toString().equals("")&&this.lcv.getTextField_1().getText().toString().equals("")){
			
			}
			else{
				if(this.lcv.getTextField().getText().toString().equals(""))
				{
					
					if(Integer.parseInt(offres.get(i).getDur())>Integer.parseInt(this.lcv.getTextField_1().getText().toString()))
					{
					
						offres.remove(i);
						i--;
					}
				}
				else if(this.lcv.getTextField_1().getText().toString().equals(""))
				{
					if(Integer.parseInt(offres.get(i).getDur())<Integer.parseInt(this.lcv.getTextField().getText().toString()))
					{
					
						offres.remove(i);
						i--;
					}
				}
				else
				{
					
					if(Integer.parseInt(offres.get(i).getDur())>Integer.parseInt(this.lcv.getTextField_1().getText().toString())||Integer.parseInt(offres.get(i).getDur())<Integer.parseInt(this.lcv.getTextField().getText().toString()))
					{
						
						offres.remove(i);
						i--;
					}
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
		ArrayList<Offres> offres = DAO.listeO();
		for(int i = 0;i<offres.size();i++)
		{
			if(!offres.get(i).getEnt().equals(this.lcv.getComboBox().getSelectedItem().toString()))
			{
				
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
				if(offres1.get(i).getEnt().equals(offres2.get(j).getEnt())&&offres1.get(i).getDur().equals(offres2.get(j).getDur())
						&&offres1.get(i).poste().equals(offres2.get(j).poste()))
				{
					
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
		
		ArrayList<Offres> offresp = Recherchep();
		
		ArrayList<Offres> offrese = Recherchee();
		
		ArrayList<Offres> offres = Commun3(offresd,offresp,offrese);
		
		return offres;
	}

	private void afficher(ArrayList<Offres> offresd) {
		for(int i =0;i<offresd.size();i++)
		{
			offresd.get(i).Afficher();
		}
	}

	private ArrayList<Offres> Commun3(ArrayList<Offres> offres1, ArrayList<Offres> offres2, ArrayList<Offres> offres3) {
		// TODO Auto-generated method stub
		ArrayList<Offres> offres = new ArrayList<Offres>();
		for(int i = 0;i<offres1.size();i++)
		{
			for(int j = 0;j<offres2.size();j++)
			{
				for(int k = 0;k<offres3.size();k++)
				{
					if(offres1.get(i).getEnt().equals(offres2.get(j).getEnt())&&offres1.get(i).getDur().equals(offres2.get(j).getDur())
							&&offres1.get(i).poste().equals(offres2.get(j).poste()))
					{
						if(offres1.get(i).getEnt().equals(offres3.get(k).getEnt())&&offres1.get(i).getDur().equals(offres3.get(k).getDur())
								&&offres1.get(i).poste().equals(offres3.get(k).poste()))
						{
							
							
								offres1.get(i).Afficher();
								offres.add(offres1.get(i));
							
						}
					}
				}	
				
			}
		}
		
		return offres;
	}

}
