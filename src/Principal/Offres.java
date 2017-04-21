package Principal;

public class Offres {
	
	String Ent;
	String Dur;
	String Pos;
	String Pla;

	
	Offres(String Ent , String Dur , String Pos , String Pla){
		this.Ent=Ent;
		this.Dur=Dur;
		this.Pos=Pos;
		this.Pla=Pla;
	}

	
	
	public void Afficher()
	{
		System.out.println("Entreprise : "+this.Ent+" Durée : "+this.Dur+" Poste : "+this.Pos+" Places : "+this.Pla);
	}

	public String poste()
	{
		return this.Pos;
	}

	public String getEnt() {
		return Ent;
	}



	public void setEnt(String ent) {
		Ent = ent;
	}



	public String getDur() {
		return Dur;
	}



	public void setDur(String dur) {
		Dur = dur;
	}



	public String getPla() {
		return Pla;
	}



	public void setPla(String pla) {
		Pla = pla;
	}



	public String AfficherS() {
		// TODO Auto-generated method stub
		return "Entreprise : "+this.Ent+" Durée : "+this.Dur+" Poste : "+this.Pos+" Places : "+this.Pla;
	}
}
