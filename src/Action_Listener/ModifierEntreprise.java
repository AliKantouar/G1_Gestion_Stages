package Action_Listener;
<<<<<<< HEAD

public class ModifierEntreprise {

}
=======
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Interface_Graphique.PanneauEnt;
import Interface_Graphique.PanneauUser;
import Interface_Graphique.modifCV;
import Interface_Graphique.modifEnt;
import Principal.Application;
import Principal.DemoJdbc;

public class ModifierEntreprise implements ActionListener {

	Application a;

	modifEnt m;
	String user;
	String tel;
	String adr;
	String com;
	
	public ModifierEntreprise(Application a, modifEnt modifEnt,String user) {
		// TODO Auto-generated constructor stub
	this.a=a;
	this.m=modifEnt;
	this.user=user;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		this.tel=this.m.getTextField().getText();
		this.com=this.m.getTextArea().getText();
		this.adr=this.m.getTextField_1().getText();
		
		DemoJdbc.modifierEnt(user,tel,adr,com);
		
		a.setContentPane(new PanneauEnt(this.a,user));
		a.repaint();
		a.revalidate();
	}

}

>>>>>>> origin/master
