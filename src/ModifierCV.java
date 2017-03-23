import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifierCV implements ActionListener {

	Application a;
	modifCV m;
	String user;
	String mdp;
	String nom;
	String prenom;
	String tel;
	String mail;
	String descr;
	String adr;
	
	public ModifierCV(Application a, modifCV modifCV,String user) {
		// TODO Auto-generated constructor stub
	this.a=a;
	this.m=modifCV;
	this.user=user;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.nom=this.m.getTextField_2().getText();
		this.prenom=this.m.getTextField().getText();
		this.tel=this.m.getTextField_3().getText();
		this.mail=this.m.getTextField_1().getText();
		this.descr=this.m.getTextArea().getText();
		this.adr=this.m.getTextField_4().getText();
		
		DemoJdbc.modifierCV(user,nom,prenom,tel,adr,mail,descr);
		
		a.setContentPane(new PanneauUser(this.a,user));
		a.repaint();
		a.revalidate();
	}

}
