import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AjouterU implements ActionListener {

	Application a ;
	String user ;
	String mdp ;
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
		
		if(user.equals("")||mdp.equals("")||DemoJdbc.connexion(user, mdp)){
			System.out.println("Fail");
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
