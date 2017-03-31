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



	public String AfficherS() {
		// TODO Auto-generated method stub
		return "Entreprise : "+this.Ent+" Durée : "+this.Dur+" Poste : "+this.Pos+" Places : "+this.Pla;
	}
}
