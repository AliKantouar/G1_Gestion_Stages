package Interface_Graphique;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Recherche implements ActionListener {

	ListeCv lcv;
	boolean e;
	boolean d;
	boolean p;
	
	
	
	public Recherche(ListeCv listeCv) {
		// TODO Auto-generated constructor stub
	this.lcv=listeCv;
	this.e=lcv.getRdbtnNewRadioButtonE().isSelected();
	this.d=lcv.getRdbtnNewRadioButton_D().isSelected();
	this.p=lcv.getRdbtnNewRadioButton_p().isSelected();
	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(e)
		{
			if(d)
			{
				if(p)
				{
					Rechercheedp();
				}
				else
				{
					Rechercheed();
				}	
			}
			else
			{
				if(p)
				{
					Rechercheep();
				}
				else
				{
					Recherchee();
				}
			}
		}
		else
		{
			if(d)
			{
				if(p)
				{
					Recherchedp();
				}
				else
				{
					Recherched();
				}	
			}
			else
			{
				if(p)
				{
					Recherchep();
				}

			}
		}
	}

	

	private void Recherchep() {
		// TODO Auto-generated method stub
		
	}

	private void Recherched() {
		// TODO Auto-generated method stub
		
	}

	private void Recherchee() {
		// TODO Auto-generated method stub
		
	}
	
	private void Recherchedp() {
		// TODO Auto-generated method stub
		
	}

	

	private void Rechercheep() {
		// TODO Auto-generated method stub
		
	}

	private void Rechercheed() {
		// TODO Auto-generated method stub
		
	}

	private void Rechercheedp() {
		// TODO Auto-generated method stub
		
	}

}
