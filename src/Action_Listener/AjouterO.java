package Action_Listener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Interface_Graphique.AjouterOffre;
import Interface_Graphique.AjouterOffreE;
import Interface_Graphique.Erreur;
import Principal.Application;
import Principal.DemoJdbc;

public class AjouterO implements ActionListener {

	Application a;
	AjouterOffre aj;
	AjouterOffreE ajE;
	String  entreprise;
	String	dur;
	String	poste;
	String	pla;
	
	boolean ent = false;
	
	
	public AjouterO(Application a, AjouterOffre ajouterOffre) {
		// TODO Auto-generated constructor stub
	this.a=a;
	this.aj=ajouterOffre;
	
	}
	
	public AjouterO(Application a, AjouterOffreE ajouterOffreE,String ent) {
		// TODO Auto-generated constructor stub
	this.a=a;
	this.ajE=ajouterOffreE;
	this.entreprise=ent;
	this.ent = true;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	
	if(!ent){	
		if(this.aj.getComboBox().getSelectedItem()!=null){
		this.entreprise=this.aj.getComboBox().getSelectedItem().toString();
		this.dur=this.aj.getTextField_1().getText();
		this.poste=this.aj.getTextField().getText();
		this.pla=this.aj.getTextField_2().getText();
		//a modifier/creer
		if(!DemoJdbc.verifO(entreprise,poste))
		{
			DemoJdbc.ajouterO(entreprise,dur,poste,pla);
		}
		else
		{
			Erreur error=new Erreur("Cette offre est déjà proposée");
		}
		
		a.setContentPane(new AjouterOffre(this.a));
		a.repaint();
		a.revalidate();
		}
	}
	else
	{
		
			
			this.dur=this.ajE.getTextField_1().getText();
			this.poste=this.ajE.getTextField().getText();
			this.pla=this.ajE.getTextField_2().getText();
			//a modifier/creer
			if(!DemoJdbc.verifO(entreprise,poste))
			{
				DemoJdbc.ajouterO(entreprise,dur,poste,pla);
			}
			else
			{
				Erreur error=new Erreur("Cette offre est déjà proposée");
			}
			
			a.setContentPane(new AjouterOffreE(this.a,this.entreprise));
			a.repaint();
			a.revalidate();
			
	}
	}

}
