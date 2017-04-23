package Action_Listener;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Interface_Graphique.AjouterEntreprise;
import Interface_Graphique.AjouterOffre;
import Interface_Graphique.AjouterUtilisateur;
import Interface_Graphique.Connexion;
import Interface_Graphique.ConnexionAdmin;
import Interface_Graphique.ConnexionEnt;
import Interface_Graphique.Inscription;
import Interface_Graphique.ListeCv;
import Interface_Graphique.ListePostulation;
import Interface_Graphique.PanneauAdmin;
import Interface_Graphique.PanneauEnt;
import Interface_Graphique.PanneauUser;
import Interface_Graphique.choix;
import Interface_Graphique.modifCV;
import Principal.Application;

public class AllerPage implements ActionListener {

	private int b;
	private Application a ;
	private String user;
	
	public AllerPage(Application app,int b){
		// TODO Auto-generated constructor stub
		this.a=app;
		this.b=b;
		
	}

	public AllerPage(Application a2, int i, String user) {
		this.a=a2;
		this.b=i;
		this.user=user;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {	
		a.setPreferredSize(new Dimension(400,300));
		if(b==1){
			a.setContentPane(new choix(this.a));
		}
		if(b==2){
			a.setContentPane(new PanneauAdmin(this.a));
		}
		if(b==3){
			a.setContentPane(new AjouterEntreprise(this.a));
		}
		if(b==4){
			a.setContentPane(new AjouterOffre(this.a));
		}
		if(b==5){
			a.setContentPane(new Connexion(this.a));
		}
		if(b==6){
			a.setContentPane(new Inscription(this.a));
		}
		if(b==7){
			a.setPreferredSize(new Dimension(400,300));
			a.setContentPane(new PanneauUser(this.a,user));
		}
		if(b==8){
			a.setContentPane(new modifCV(this.a,user));
			}
		if(b==9){
			a.setContentPane(new ListeCv(this.a,user));
		}
		if(b==10){
			a.setContentPane(new ConnexionEnt(this.a,user));
		}
		if(b==11){
			a.setContentPane(new PanneauEnt(this.a,user));
		}
		if(b==12){
			a.setContentPane(new ListePostulation(this.a,user));
		}
		if(b==13){
			a.setContentPane(new ConnexionAdmin(this.a));
		}

		if(b==14){
			a.setContentPane(new AjouterUtilisateur(this.a));
		}

		a.repaint();
		a.revalidate();
	
	}

}