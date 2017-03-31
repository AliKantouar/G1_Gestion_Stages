package Action_Listener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Interface_Graphique.Connexion;
import Interface_Graphique.Erreur;
import Interface_Graphique.Inscription;
import Principal.Application;
import Principal.DemoJdbc;

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
		
		if(user.equals("")||mdp.equals("")||DemoJdbc.verifU(user, mdp)){
			Erreur error=new Erreur("Ce nom d'utilisateur n'est pas disponible");
		}
		else
		{
		DemoJdbc.Inscrire(user, mdp);
		a.setContentPane(new Connexion(this.a));
		a.repaint();
		a.revalidate();
		}
	}

}
