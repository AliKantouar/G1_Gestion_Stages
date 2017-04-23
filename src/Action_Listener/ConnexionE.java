package Action_Listener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Interface_Graphique.Connexion;
import Interface_Graphique.ConnexionEnt;
import Interface_Graphique.Erreur;
import Interface_Graphique.PanneauEnt;
import Interface_Graphique.PanneauUser;
import Principal.Application;
import Principal.DemoJdbc;
import Principal.Md5;

public class ConnexionE implements ActionListener {

	Application a;
	ConnexionEnt c;
	String user;
	String mdp;
	public ConnexionE(Application a , ConnexionEnt c)
	{
		this.a=a;
		this.c=c;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		this.user=c.getTextField().getText();
		this.mdp=c.getTextField_1().getText();
		//criptage du mot de passe
		
		if(this.user.equals("")||this.mdp.equals(""))
		{
			Erreur mdpInconnu= new Erreur("Mot de passe incorrect ou nom d'utilisateur inconnu");
		}
		else
		{
			Md5 criptage=new Md5(mdp);
			mdp=criptage.getCode();
			if(DemoJdbc.connexionE(user,mdp))
			{
				a.setContentPane(new PanneauEnt(a,user));
				a.repaint();
				a.revalidate();
			}
			else{
				Erreur mdpInconnu= new Erreur("Mot de passe incorrect ou nom d'utilisateur inconnu");
			}
		
		
		}
		
		
	}

}
