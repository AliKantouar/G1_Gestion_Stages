package Action_Listener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Interface_Graphique.PanneauUser;
import Interface_Graphique.modifCV;
import Principal.Application;
import Principal.DemoJdbc;

public class ModifierCV implements ActionListener {

	Application a;
	public Application getA() {
		return a;
	}

	public void setA(Application a) {
		this.a = a;
	}

	public modifCV getM() {
		return m;
	}

	public void setM(modifCV m) {
		this.m = m;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getAdr() {
		return adr;
	}

	public void setAdr(String adr) {
		this.adr = adr;
	}

	modifCV m;
	String user;
	String mdp;
	String nom;
	String prenom;
	String tel;
	String mail;
	String descr;
	String adr;
	String form;
	String comp;
	String inte;
	String exp;
	
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
		
		DemoJdbc.modifierCV(user,nom,prenom,tel,adr,mail,form,comp,exp,inte);
		
		a.setContentPane(new PanneauUser(this.a,user));
		a.repaint();
		a.revalidate();
	}

}
