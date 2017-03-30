package Action_Listener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Interface_Graphique.AjouterOffre;
import Principal.Application;
import Principal.DemoJdbc;

public class AjouterO implements ActionListener {

	Application a;
	AjouterOffre aj;
	String  entreprise;
	String	dur;
	String	poste;
	String	pla;
	
	
	
	
	public AjouterO(Application a, AjouterOffre ajouterOffre) {
		// TODO Auto-generated constructor stub
	this.a=a;
	this.aj=ajouterOffre;
	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	
		this.entreprise=this.aj.getComboBox().getToolTipText();
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
			System.out.println("fal");
		}
		
		a.setContentPane(new AjouterOffre(this.a));
		a.repaint();
		a.revalidate();
		
	}

}
