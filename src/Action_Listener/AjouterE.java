package Action_Listener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Interface_Graphique.AjouterEntreprise;
import Interface_Graphique.ConnexionEnt;
import Interface_Graphique.Erreur;
import Interface_Graphique.InscriptionEnt;
import Principal.Application;
import Principal.DAO;
import Principal.Md5;

public class AjouterE implements ActionListener {

	Application a ;
	String mdp ;
	String tel ;
	String adr ;
	String com ;
	String nom;
		int z ;
	AjouterEntreprise b;
	InscriptionEnt c;
	
	public AjouterE(Application a , AjouterEntreprise b)
	{
		this.a=a;
		this.b=b;
	}
	
	public AjouterE(Application a , InscriptionEnt c)
	{
		this.a=a;
		this.c=c;
		this.b=null;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
	
		if(b!=null){
			this.nom=b.getTextField().getText();
			this.mdp=b.getTextField_1().getText();
			this.tel=b.getTextField_3().getText();
			this.adr=b.getTextField_2().getText();
			this.com=b.getTextArea().getText();
		}
		else{
			this.nom=c.getTextField().getText();
			this.mdp=c.getTextField_1().getText();
			this.tel=c.getTextField_3().getText();
			this.adr=c.getTextField_2().getText();
			this.com=c.getTextArea().getText();
		}
		
		
		if(!mdp.equals("")&&!DAO.verifE(nom))
		{
			Md5 criptage=new Md5(mdp);
			mdp=criptage.getCode();
			DAO.ajouterE(nom,mdp,adr,tel,com);
		}
		else
		{
			Erreur error=new Erreur("Cette entreprise est déjà enregistrée");
		}
		if (b!=null){
			a.setContentPane(new AjouterEntreprise(this.a));
		}
		else{
			a.setContentPane(new ConnexionEnt(this.a));
		}
		a.repaint();
		a.revalidate();
		}
	

}
