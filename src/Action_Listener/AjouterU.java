package Action_Listener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Interface_Graphique.Connexion;
import Interface_Graphique.Erreur;
import Interface_Graphique.Inscription;
import Principal.Application;
import Principal.DemoJdbc;
import Principal.Md5;

public class AjouterU implements ActionListener {

	Application a ;
	String user ;
	String mdp ;
	int z ;
	Inscription b;
	
	
	public AjouterU(Application a , Inscription b)
	{
		this.a=a;
		this.b=b;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
	

		this.user=b.getTextField().getText();
		this.mdp=b.getTextField_1().getText();
		//criptage du mot de passe
		
			
		if(user.equals("")||mdp.equals("")||DemoJdbc.verifU(user, mdp)){
			Erreur error=new Erreur("Ce nom d'utilisateur n'est pas disponible");
		}
		else
		{
			Md5 criptage=new Md5(mdp);
			mdp=criptage.getCode();
			DemoJdbc.Inscrire(user, mdp);
			a.setContentPane(new Connexion(this.a));
			a.repaint();
			a.revalidate();
		}
	}

}
