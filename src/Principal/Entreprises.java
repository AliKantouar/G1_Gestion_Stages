package Principal;

public class Entreprises {
	String nom;
	String adresse;
	String tel;
	String com;
	
	public Entreprises(String nom,String adresse,String tel,String com)
	{
		this.nom=nom;
		this.adresse=adresse;
		this.tel=tel;
		this.com=com;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCom() {
		return com;
	}

	public void setCom(String com) {
		this.com = com;
	}

	public String AfficherS() {
		// TODO Auto-generated method stub
		return "<html><b><u>Nom Entreprise</u></b> : "+nom+"<br><br> <b><u>Adresse</u></b> : "+adresse+" <b><u>        Téléphone</u></b> : "+tel+"<br><br> <b><u>Commentaire</u></b> : "+com+"</html>";
	}
	
	
}
