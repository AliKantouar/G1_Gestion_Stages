package Action_Listener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Interface_Graphique.AjouterEntreprise;
import Interface_Graphique.AjouterUtilisateur;
import Interface_Graphique.Connexion;
import Interface_Graphique.Erreur;
import Interface_Graphique.Inscription;
import Principal.Application;
import Principal.DAO;
import Principal.Md5;

public class AjouterU implements ActionListener {

	Application a ;
	String user ;
	String mdp ;
	int z ;
	Inscription b;

	AjouterUtilisateur c;

	public AjouterU(Application a , Inscription b)
	{
		this.a=a;
		this.b=b;
	}
	
	public AjouterU(Application a , AjouterUtilisateur c)
	{
		this.a=a;
		this.c=c;
		this.b=null;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
	
		
		//difference entre admin et utilisateur
		if(b!=null){
			this.user=b.getTextField().getText();
			this.mdp=b.getTextField_1().getText();
		}
		else{
			this.user=c.getTextField().getText();
			this.mdp=c.getTextField_1().getText();
		}
		//criptage du mot de passe
		if(DAO.dispoU(user)){
			Erreur error=new Erreur("Ce nom d'utilisateur n'est pas disponible");
		}
		else if(user.equals("")){
			Erreur error=new Erreur("Veuillez entrer un nom d'utilisateur");
		}
		else if(mdp.equals("")){
			Erreur error=new Erreur("Veuillez entrer un mot de passe");
		}
		else{		
			
			Md5 criptage=new Md5(mdp);
			mdp=criptage.getCode();
			DAO.Inscrire(user, mdp);
			
			//difference entre admin et utilisateur
			if(b!=null){
				a.setContentPane(new Connexion(this.a));
			}
			else{
				a.setContentPane(new AjouterUtilisateur(this.a));
			}
			
			a.repaint();
			a.revalidate();
		}
	}

}
