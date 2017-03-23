import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnexionU implements ActionListener {

	Application a;
	Connexion c;
	String user;
	String mdp;
	public ConnexionU(Application a , Connexion c)
	{
		this.a=a;
		this.c=c;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		this.user=c.getTextField().getText();
		this.mdp=c.getTextField_1().getText();
		if(this.user.equals("")||this.mdp.equals(""))
		{
			System.out.println("Fail");
		}
		else
		{
			if(DemoJdbc.connexion(user,mdp))
			{
				a.setContentPane(new PanneauUser(this.a,user));
				a.repaint();
				a.revalidate();
			}
		
		
		}
		
		
	}

}
