package Action_Listener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Interface_Graphique.Connexion;
import Interface_Graphique.ConnexionAdmin;
import Interface_Graphique.Erreur;
import Interface_Graphique.PanneauAdmin;
import Interface_Graphique.PanneauEnt;
import Interface_Graphique.PanneauUser;
import Principal.Application;
import Principal.DAO;
import Principal.Md5;

public class ConnexionA implements ActionListener {

	Application a;
	ConnexionAdmin c;
	String user;
	String mdp;
	public ConnexionA(Application a , ConnexionAdmin c)
	{
		this.a=a;
		this.c=c;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		this.mdp=c.getTextField_1().getText();
		//criptage du mot de passe
		Md5 criptage=new Md5(mdp);
		mdp=criptage.getCode();
		if(this.mdp.equals("d41d8cd98f00b204e9800998ecf8427e")) //code du mot ""
		{
			Erreur mdpInconnu= new Erreur("Veuillez entrer un mot de passe");
		}
		else
		{
			if(mdp.equals("9d0c2b5e15cc600a9828a18a5ffe7dba")) //code secret!
			{
				a.setContentPane(new PanneauAdmin(a));
				a.repaint();
				a.revalidate();
			}
			else{
				Erreur mdpInconnu= new Erreur("Mot de passe incorrecte");
			}
		
		
		}
		
		
	}

}
