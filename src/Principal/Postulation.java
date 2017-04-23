package Principal;

public class Postulation {
	
	String user;
	String Ent;
	String Dur;
	String Pos;
	
	
		public Postulation(String user,String Ent,String Dur,String Pos)
		{
			this.user=user;
			this.Ent=Ent;
			this.Dur=Dur;
			this.Pos=Pos;
		
		}


		public String AfficherS() {
			// TODO Auto-generated method stub
			String nom ;
			
			nom=chercher(user);
			
			return("Nom Candidat : " + nom);
		}


		private String chercher(String user2) {
			// TODO Auto-generated method stub
			return user+" "+Pos+" "+Dur;
		}
		
		

}
