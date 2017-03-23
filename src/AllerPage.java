import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

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
			a.setContentPane(new PanneauUser(this.a,user));
		}
		if(b==8){
			a.setContentPane(new modifCV(this.a,user));
			}
		a.repaint();
		a.revalidate();
	
	}

}