package Principal;

public class Postulation {
	
	String user;
	String Ent;
	String Dur;
	char etat;
	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
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


	public String getPos() {
		return Pos;
	}


	public void setPos(String pos) {
		Pos = pos;
	}


	String Pos;
	
	
		public Postulation(String user,String Ent,String Dur,String Pos,char etat)
		{
			this.user=user;
			this.Ent=Ent;
			this.Dur=Dur;
			this.Pos=Pos;
			this.etat=etat;
		}


		public String AfficherS() {
			// TODO Auto-generated method stub
			
			
			String statut = "";
			
			if(etat=='A')
			{
				statut = "En attente";
			}
			if(etat=='T')
			{
				statut = "Accepté";
			}
			if(etat=='F')
			{
				statut = "Refusé";
			}
			
			String nom = DAO.nomUtilisateur(user);
			
			
			return "<html><b><u>Nom du candidat</b></u> :"+nom+" "+"<b><u>Poste</b></u> :"+Pos+" "+"<b><u>Duree</b></u> :"+Dur+" "+"<b><u>Statut</b></u> :"+statut+"</html>";
		}


		

		public char getEtat() {
			return etat;
		}


		public void setEtat(char etat) {
			this.etat = etat;
		}
		
		

}
