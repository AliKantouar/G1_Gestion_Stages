package Principal;

public class Utilisateur {

	String id;
	String mdp;
	String tel;
	String mail;
	String adr;
	String nom;
	String prenom;
	String formation;
	String competence;
	String exp;
	String inte;
	
	public Utilisateur(String id,String mdp,String tel,String mail,String adr,String nom,String prenom,String formation,String competence,String exp,String inte)
	{
		this.id=id;
		this.mdp=mdp;
		this.tel=tel;
		this.mail=mail;
		this.adr=adr;
		this.nom=nom;
		this.prenom=prenom;
		this.formation=formation;
		this.competence=competence;
		this.exp=exp;
		this.inte=inte;
		
	}
	
	

	public Utilisateur() {
		// TODO Auto-generated constructor stub
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getMdp() {
		return mdp;
	}



	public void setMdp(String mdp) {
		this.mdp = mdp;
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



	public String getAdr() {
		return adr;
	}



	public void setAdr(String adr) {
		this.adr = adr;
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



	public String getFormation() {
		return formation;
	}



	public void setFormation(String formation) {
		this.formation = formation;
	}



	public String getCompetence() {
		return competence;
	}



	public void setCompetence(String competence) {
		this.competence = competence;
	}



	public String getExp() {
		return exp;
	}



	public void setExp(String exp) {
		this.exp = exp;
	}



	public String getInte() {
		return inte;
	}



	public void setInte(String inte) {
		this.inte = inte;
	}



	public void parametrer(Utilisateur user)
	{
		this.id=user.id;
		this.mdp=user.mdp;
		this.tel=user.tel;
		this.mail=user.mail;
		this.adr=user.adr;
		this.nom=user.nom;
		this.prenom=user.prenom;
		this.formation=user.formation;
		this.competence=user.competence;
		this.exp=user.exp;
		this.inte=user.inte;
	}
	
	
	
}
