package Principal;
import java.sql.Statement;
import java.util.ArrayList;

import Interface_Graphique.Erreur;
import Interface_Graphique.modifCV;
import Interface_Graphique.modifEnt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {


//Crée une nouvelle ligne dans le tableau "cv" dans la Base de donnée
public static void Inscrire(String user,String mdp) {
	String url = "jdbc:mysql://localhost/gestionstages?useSSL=false";
	String login = "root";
	String passwd = "";
	Connection cn =null;
	Statement st =null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		cn = DriverManager.getConnection(url,login,passwd);
		st= cn.createStatement();
		
		
		String sql = "INSERT INTO `Utilisateur` (`Identifiant`, `Mdp`, `Telephone`, `Mail`, `Adresse`, `Nom`, `Prenom`, `Formation`, `Competences`, `Experience`, `Interets`) VALUES ('"+user+"', '"+mdp+"', '', '', '', '', '', '', '', '', '');";
		
		st.executeUpdate(sql);
	}
	catch (SQLException e){
		e.printStackTrace();
	}
	catch (ClassNotFoundException e){
		e.printStackTrace();
	} 
	finally {
			try {
				cn.close();
				st.close();
				}
			catch (SQLException e)
				{
				e.printStackTrace();
				}
			}
	
}


public static void supprEnBase(String personne) {
	String url = "jdbc:mysql://localhost/gestionstages?useSSL=false";
	String login = "root";
	String passwd = "";
	Connection cn =null;
	Statement st =null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		cn = DriverManager.getConnection(url,login,passwd);
		st= cn.createStatement();
		
		String sql = "DELETE FROM `javadb` WHERE (`personne`= '"+personne+"')";
		
		st.executeUpdate(sql);
	}
	catch (SQLException e){
		e.printStackTrace();
	}
	catch (ClassNotFoundException e){
		e.printStackTrace();
	} 
	finally {
			try {
				cn.close();
				st.close();
				}
			catch (SQLException e)
				{
				e.printStackTrace();
				}
			}
	
}

public static void reinitialiser() {
	String url = "jdbc:mysql://localhost/gestionstages?useSSL=false";
	String login = "root";
	String passwd = "";
	Connection cn =null;
	Statement st =null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		cn = DriverManager.getConnection(url,login,passwd);
		st= cn.createStatement();
		
		String sql = "DELETE FROM `javadb` WHERE 1";
		
		st.executeUpdate(sql);
	}
	catch (SQLException e){
		e.printStackTrace();
	}
	catch (ClassNotFoundException e){
		e.printStackTrace();
	} 
	finally {
			try {
				cn.close();
				st.close();
				}
			catch (SQLException e)
				{
				e.printStackTrace();
				}
			}
	
}




public static boolean connexionU(String user,String mdp) {

	// Information d'accès à la base de données
	String url = "jdbc:mysql://localhost/gestionstages?useSSL=false";
	String login = "root";
	String passwd = "";
	Connection cn =null;
	Statement st =null;
	ResultSet rs =null;
	boolean existe = false;
	
	try {

		// Etape 1 : Chargement du driver
		Class.forName("com.mysql.jdbc.Driver");

		// Etape 2 : récupération de la connexion
		cn = DriverManager.getConnection(url, login, passwd);

		// Etape 3 : Création d'un statement
		st = cn.createStatement();

		String sql = "SELECT `Identifiant`, `Mdp`, `Telephone`, `Mail`, `Adresse`, `Nom`, `Prenom`, `Formation`, `Competences`, `Experience`, `Interets` FROM `Utilisateur` WHERE `Identifiant`=\""+user+"\" AND `Mdp`=\""+mdp+"\"";

		// Etape 4 : exécution requête
		rs = st.executeQuery(sql);

		// Si récup données alors étapes 5 (parcours Resultset)

		while (rs.next()) {

		

			if(rs.getString("Identifiant").equals(""))
			{
				existe=false;
			}
			else
			{
				if(rs.getString("Identifiant").equals(user)&&rs.getString("Mdp").equals(mdp))
				{

					existe = true;
			
				}
			}
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} finally {
		try {
		// Etape 6 : libérer ressources de la mémoire.
			cn.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return existe;
}
public static boolean dispoU(String user) {

	// Information d'accès à la base de données
	String url = "jdbc:mysql://localhost/gestionstages?useSSL=false";
	String login = "root";
	String passwd = "";
	Connection cn =null;
	Statement st =null;
	ResultSet rs =null;
	boolean existe = false;
	
	try {

		// Etape 1 : Chargement du driver
		Class.forName("com.mysql.jdbc.Driver");

		// Etape 2 : récupération de la connexion
		cn = DriverManager.getConnection(url, login, passwd);

		// Etape 3 : Création d'un statement
		st = cn.createStatement();

		String sql = "SELECT `Identifiant`, `Mdp`, `Telephone`, `Mail`, `Adresse`, `Nom`, `Prenom`, `Formation`, `Competences`, `Experience`, `Interets` FROM `Utilisateur` WHERE `Identifiant`=\""+user+"\"";

		// Etape 4 : exécution requête
		rs = st.executeQuery(sql);

		// Si récup données alors étapes 5 (parcours Resultset)

		while (rs.next()) {

		

			if(rs.getString("Identifiant").equals(""))
			{
				existe=false;
			}
			else
			{
				if(rs.getString("Identifiant").equals(user))
				{

					existe = true;
			
				}
			}
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} finally {
		try {
		// Etape 6 : libérer ressources de la mémoire.
			cn.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return existe;
}

public static void modifierCV(String user ,String nom, String prenom, String tel,String adr, String mail, String form,String comp,String exp ,String interets) {
	String url = "jdbc:mysql://localhost/gestionstages?useSSL=false";
	String login = "root";
	String passwd = "";
	Connection cn =null;
	Statement st =null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		cn = DriverManager.getConnection(url,login,passwd);
		st= cn.createStatement();
		
		String sql ="UPDATE `Utilisateur` SET `Telephone`=\""+tel+"\",`Mail`=\""+mail+"\",`Adresse`=\""+adr+"\",`Nom`=\""+nom+"\",`Prenom`=\""+prenom+"\",`Formation`=\""+form+"\",`Competences`=\""+comp+"\",`Experience`=\""+exp+"\",`Interets`=\""+interets+"\" WHERE Identifiant=\""+user+"\"";
		
		st.executeUpdate(sql);
	}
	catch (SQLException e){
		e.printStackTrace();
	}
	catch (ClassNotFoundException e){
		e.printStackTrace();
	} 
	finally {
			try {
				cn.close();
				st.close();
				}
			catch (SQLException e)
				{
				e.printStackTrace();
				}
			}
	
	
}


public static void initModifCV(modifCV modifCV) {

		// Information d'accès à la base de données
		String url = "jdbc:mysql://localhost/gestionstages?useSSL=false";
		String login = "root";
		String passwd = "";
		Connection cn =null;
		Statement st =null;
		ResultSet rs =null;
		
		try {

			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : récupération de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Création d'un statement
			st = cn.createStatement();

			String sql = "SELECT `Identifiant`, `Mdp`, `Telephone`, `Mail`, `Adresse`, `Nom`, `Prenom`, `Formation`, `Competences`, `Experience`, `Interets` FROM `Utilisateur` WHERE `Identifiant`=\""+modifCV.getUser()+"\"";

			// Etape 4 : exécution requête
			rs = st.executeQuery(sql);

			// Si récup données alors étapes 5 (parcours Resultset)

			while (rs.next()) {
				
				
				modifCV.getTextField().setText(rs.getString("Prenom"));
				modifCV.getTextField_1().setText(rs.getString("Mail"));
				modifCV.getTextField_2().setText(rs.getString("Nom"));
				modifCV.getTextField_3().setText(rs.getString("telephone"));
				modifCV.getTextField_4().setText(rs.getString("Adresse"));
				modifCV.getTextArea().setText(rs.getString("Formation"));
				modifCV.getTextArea_1().setText(rs.getString("Competences"));
				modifCV.getTextArea_2().setText(rs.getString("Experience"));
				modifCV.getTextArea_3().setText(rs.getString("Interets"));
				modifCV.validate();
				modifCV.repaint();
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
			// Etape 6 : libérer ressources de la mémoire.
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

//Crée une nouvelle ligne dans le tableau "entreprises" dans la Base de donnée



public static void ajouterE(String nom,String mdp, String adr, String tel, String com) {
	String url = "jdbc:mysql://localhost/gestionstages?useSSL=false";
	String login = "root";
	String passwd = "";
	Connection cn =null;
	Statement st =null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		cn = DriverManager.getConnection(url,login,passwd);
		st= cn.createStatement();
		
		String sql = "INSERT INTO `entreprises`(`NomEntreprise`, `Mdp`, `Adresse`, `Telephone`, `Commentaire`) VALUES ('"+nom+"','"+mdp+"','"+adr+"','"+tel+"','"+com+"')";
		st.executeUpdate(sql);
	}
	catch (SQLException e){
		e.printStackTrace();
	}
	catch (ClassNotFoundException e){
		e.printStackTrace();
	} 
	finally {
			try {
				cn.close();
				st.close();
				}
			catch (SQLException e)
				{
				e.printStackTrace();
				}
			}
	
}

//Renvoie VRAI si le nom d'entreprise existe
//sinon renvoie FAUX
public static boolean dispoE(String nom) {

	// Information d'accès à la base de données
	String url = "jdbc:mysql://localhost/gestionstages?useSSL=false";
	String login = "root";
	String passwd = "";
	Connection cn =null;
	Statement st =null;
	ResultSet rs =null;
	boolean existe = false;
	
	try {

		// Etape 1 : Chargement du driver
		Class.forName("com.mysql.jdbc.Driver");

		// Etape 2 : récupération de la connexion
		cn = DriverManager.getConnection(url, login, passwd);

		// Etape 3 : Création d'un statement
		st = cn.createStatement();

		String sql = "SELECT `NomEntreprise` FROM `Entreprises` WHERE `NomEntreprise`=\""+nom+"\"";

		// Etape 4 : exécution requête
		rs = st.executeQuery(sql);

		// Si récup données alors étapes 5 (parcours Resultset)

		while (rs.next()) {
			if(rs.getString("NomEntreprise").equals(""))
			{
				existe=false;
			}
			else
			{
				
					existe = true;
			
			}
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} finally {
		try {
		// Etape 6 : libérer ressources de la mémoire.
			cn.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return existe;
}

public static void modifierEnt(String user ,String tel,String adr,String com) {
	String url = "jdbc:mysql://localhost/gestionstages?useSSL=false";
	String login = "root";
	String passwd = "";
	Connection cn =null;
	Statement st =null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		cn = DriverManager.getConnection(url,login,passwd);
		st= cn.createStatement();
		
		String sql ="UPDATE `Entreprises` SET `Adresse`=\""+adr+"\",`Telephone`=\""+tel+"\",`Commentaire`=\""+com+"\" WHERE NomEntreprise=\""+user+"\"";
		
		st.executeUpdate(sql);
	}
	catch (SQLException e){
		e.printStackTrace();
	}
	catch (ClassNotFoundException e){
		e.printStackTrace();
	} 
	finally {
			try {
				cn.close();
				st.close();
				}
			catch (SQLException e)
				{
				e.printStackTrace();
				}
			}
	
	
}


public static void initModifEnt(modifEnt modifEnt) {

		// Information d'accès à la base de données
		String url = "jdbc:mysql://localhost/gestionstages?useSSL=false";
		String login = "root";
		String passwd = "";
		Connection cn =null;
		Statement st =null;
		ResultSet rs =null;
		
		try {

			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : récupération de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Création d'un statement
			st = cn.createStatement();

			String sql = "SELECT `Adresse`, `Telephone`, `Commentaire` FROM `Entreprises` WHERE `NomEntreprise`=\""+modifEnt.getUser()+"\"";

			// Etape 4 : exécution requête
			rs = st.executeQuery(sql);

			// Si récup données alors étapes 5 (parcours Resultset)

			while (rs.next()) {
				
				
				modifEnt.getTextField().setText(rs.getString("Telephone"));
				modifEnt.getTextField_1().setText(rs.getString("Adresse"));
				modifEnt.getTextArea().setText(rs.getString("Commentaire"));
				modifEnt.validate();
				modifEnt.repaint();
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
			// Etape 6 : libérer ressources de la mémoire.
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


//liste des noms des entreprises
public static ArrayList<String> liste() {
	String url = "jdbc:mysql://localhost/gestionstages?useSSL=false";
	String login = "root";
	String passwd = "";
	Connection cn =null;
	Statement st =null;
	ResultSet rs =null;
	ArrayList<String> list = new ArrayList<String>();
	
	try {

		// Etape 1 : Chargement du driver
		Class.forName("com.mysql.jdbc.Driver");

		// Etape 2 : récupération de la connexion
		cn = DriverManager.getConnection(url, login, passwd);

		// Etape 3 : Création d'un statement
		st = cn.createStatement();

		String sql = "SELECT `NomEntreprise` FROM `entreprises`";

		// Etape 4 : exécution requête
		rs = st.executeQuery(sql);

		// Si récup données alors étapes 5 (parcours Resultset)

		while (rs.next()) {
			list.add(rs.getString("NomEntreprise"));
					
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} finally {
		try {
		// Etape 6 : libérer ressources de la mémoire.
			cn.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	return list;
}


public static ArrayList<Offres> listeO() {
	String url = "jdbc:mysql://localhost/gestionstages?useSSL=false";
	String login = "root";
	String passwd = "";
	Connection cn =null;
	Statement st =null;
	ResultSet rs =null;
	ArrayList<Offres> list = new ArrayList<Offres>();
	
	try {

		// Etape 1 : Chargement du driver
		Class.forName("com.mysql.jdbc.Driver");

		// Etape 2 : récupération de la connexion
		cn = DriverManager.getConnection(url, login, passwd);

		// Etape 3 : Création d'un statement
		st = cn.createStatement();

		String sql = "SELECT `NomEntreprise`, `Duree`, `Poste`, `Places` FROM `offres`";

		// Etape 4 : exécution requête
		rs = st.executeQuery(sql);

		// Si récup données alors étapes 5 (parcours Resultset)

		while (rs.next()) {
			list.add(new Offres(rs.getString("NomEntreprise"),rs.getString("Duree"),rs.getString("Poste"),rs.getString("Places")));
					
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} finally {
		try {
		// Etape 6 : libérer ressources de la mémoire.
			cn.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	return list;
}

public static ArrayList<Entreprises> listeE() {
	String url = "jdbc:mysql://localhost/gestionstages?useSSL=false";
	String login = "root";
	String passwd = "";
	Connection cn =null;
	Statement st =null;
	ResultSet rs =null;
	ArrayList<Entreprises> list = new ArrayList<Entreprises>();
	
	try {

		// Etape 1 : Chargement du driver
		Class.forName("com.mysql.jdbc.Driver");

		// Etape 2 : récupération de la connexion
		cn = DriverManager.getConnection(url, login, passwd);

		// Etape 3 : Création d'un statement
		st = cn.createStatement();

		String sql = "SELECT `NomEntreprise`,`Adresse`,`Telephone`,`Commentaire` FROM `entreprises`";

		// Etape 4 : exécution requête
		rs = st.executeQuery(sql);

		// Si récup données alors étapes 5 (parcours Resultset)

		while (rs.next()) {
			list.add(new Entreprises(rs.getString("NomEntreprise"),rs.getString("Adresse"),rs.getString("Telephone"),rs.getString("Commentaire")));
					
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} finally {
		try {
		// Etape 6 : libérer ressources de la mémoire.
			cn.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	return list;
}



private static void afficher(ArrayList<String> list) {
	// TODO Auto-generated method stub
	for(int i = 0;i<list.size();i++)
	{
		System.out.println(list.get(i));
	}
}


//Renvoie VRAI si une offre est identique (meme entreprise, poste et durée) existe
//sinon renvoie FAUX
public static boolean verifO(String entreprise, String poste) {
	
	String url = "jdbc:mysql://localhost/gestionstages?useSSL=false";
	String login = "root";
	String passwd = "";
	Connection cn =null;
	Statement st =null;
	ResultSet rs =null;
	boolean existe = false;
	
	try {

		// Etape 1 : Chargement du driver
		Class.forName("com.mysql.jdbc.Driver");

		// Etape 2 : récupération de la connexion
		cn = DriverManager.getConnection(url, login, passwd);

		// Etape 3 : Création d'un statement
		st = cn.createStatement();

		String sql = "SELECT `NomEntreprise`,`Poste` FROM `offres` WHERE `NomEntreprise`=\""+entreprise+"\" AND `Poste`=\""+poste+"\"";

		// Etape 4 : exécution requête
		rs = st.executeQuery(sql);

		// Si récup données alors étapes 5 (parcours Resultset)

		while (rs.next()) {
			if(rs.getString("NomEntreprise").equals("")&&rs.getString("Poste").equals(""))
			{
				existe=false;
			}
			else
			{
				existe = true;
			}
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} finally {
		try {
		// Etape 6 : libérer ressources de la mémoire.
			cn.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return existe;

}

//Crée une nouvelle ligne dans le tableau "offres" dans la Base de donnée
public static void ajouterO(String entreprise, String dur, String poste, String pla) {
	// TODO Auto-generated method stub
	
	String url = "jdbc:mysql://localhost/gestionstages?useSSL=false";
	String login = "root";
	String passwd = "";
	Connection cn =null;
	Statement st =null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		cn = DriverManager.getConnection(url,login,passwd);
		st= cn.createStatement();
		
		String sql = "INSERT INTO `offres`(`NomEntreprise`, `Duree`, `Poste`, `Places`) VALUES ('"+entreprise+"','"+dur+"','"+poste+"','"+pla+"')";
		if(Integer.parseInt(pla)<=0)
		{
			Erreur a = new Erreur("Places incorects");
		}
		else
		{
			st.executeUpdate(sql);
		}

	}
	catch (SQLException e){
		e.printStackTrace();
	}
	catch (ClassNotFoundException e){
		e.printStackTrace();
	} 
	finally {
			try {
				cn.close();
				st.close();
				}
			catch (SQLException e)
				{
				e.printStackTrace();
				}
			}
		
}



public static ArrayList<String> listeP() {
	// TODO Auto-generated method stub
	String url = "jdbc:mysql://localhost/gestionstages?useSSL=false";
	String login = "root";
	String passwd = "";
	Connection cn =null;
	Statement st =null;
	ResultSet rs =null;
	ArrayList<String> list = new ArrayList<String>();
	
	try {

		// Etape 1 : Chargement du driver
		Class.forName("com.mysql.jdbc.Driver");

		// Etape 2 : récupération de la connexion
		cn = DriverManager.getConnection(url, login, passwd);

		// Etape 3 : Création d'un statement
		st = cn.createStatement();

		String sql = "SELECT `NomEntreprise`, `Duree`, `Poste`, `Places` FROM `offres`";

		// Etape 4 : exécution requête
		rs = st.executeQuery(sql);

		// Si récup données alors étapes 5 (parcours Resultset)

		while (rs.next()) {
			list.add(new String(rs.getString("Poste")));
					
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} finally {
		try {
		// Etape 6 : libérer ressources de la mémoire.
			cn.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	for(int i = 0;i<list.size();i++)
	{
		for(int j = i+1;j<list.size();j++)
		{
			if(list.get(i).equals(list.get(j)))
			{
				list.remove(j);
				j--;
				
			}
		}
	}
	return list;
}


public static void ajouterPostulation(String user, String ent, String poste, String dur) {
	// TODO Auto-generated method stub
	if(premierPostulation(user,ent,poste,dur))
	{
		
		String url = "jdbc:mysql://localhost/gestionstages?useSSL=false";
		String login = "root";
		String passwd = "";
		Connection cn =null;
		Statement st =null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url,login,passwd);
			st= cn.createStatement();
			
			String sql = "INSERT INTO `postulation`(`Identifiant`, `NomEntreprise`, `Poste`, `Duree`) VALUES ('"+user+"','"+ent+"','"+poste+"','"+dur+"')";
			st.executeUpdate(sql);
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		} 
		finally {
				try {
					cn.close();
					st.close();
					}
				catch (SQLException e)
					{
					e.printStackTrace();
					}
				}
	}
	

}


public static boolean premierPostulation(String user, String ent, String poste, String dur) {
	// TODO Auto-generated method stub
	String url = "jdbc:mysql://localhost/gestionstages?useSSL=false";
	String login = "root";
	String passwd = "";
	Connection cn =null;
	Statement st =null;
	ResultSet rs =null;
	boolean first = true;
	
	try {

		// Etape 1 : Chargement du driver
		Class.forName("com.mysql.jdbc.Driver");

		// Etape 2 : récupération de la connexion
		cn = DriverManager.getConnection(url, login, passwd);

		// Etape 3 : Création d'un statement
		st = cn.createStatement();

		String sql = "SELECT `Identifiant`,`NomEntreprise`,`Poste`,`Duree` FROM `postulation` WHERE `Identifiant`=\""+user+"\" AND `NomEntreprise`=\""+ent+"\" AND `Poste`=\""+poste+"\" AND `Duree`=\""+dur+"\"";

		// Etape 4 : exécution requête
		rs = st.executeQuery(sql);

		// Si récup données alors étapes 5 (parcours Resultset)

		while (rs.next()) {
			if(rs.getString("Identifiant").equals(""))
			{
				first=true;
			}
			else
			{
				first = false;
			}
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} finally {
		try {
		// Etape 6 : libérer ressources de la mémoire.
			cn.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return first;
}


public static void supprimerPostulation(String user, String ent, String poste, String dur) {
	String url = "jdbc:mysql://localhost/gestionstages?useSSL=false";
	String login = "root";
	String passwd = "";
	Connection cn =null;
	Statement st =null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		cn = DriverManager.getConnection(url,login,passwd);
		st= cn.createStatement();
		
		String sql = "DELETE FROM `postulation` WHERE `Identifiant`=\""+user+"\" AND `NomEntreprise`=\""+ent+"\" AND `Poste`=\""+poste+"\" AND `Duree`=\""+dur+"\"";
		
		st.executeUpdate(sql);
	}
	catch (SQLException e){
		e.printStackTrace();
	}
	catch (ClassNotFoundException e){
		e.printStackTrace();
	} 
	finally {
			try {
				cn.close();
				st.close();
				}
			catch (SQLException e)
				{
				e.printStackTrace();
				}
			}
	
}


public static boolean connexionE(String user, String mdp) {
	// TODO Auto-generated method stub
	String url = "jdbc:mysql://localhost/gestionstages?useSSL=false";
	String login = "root";
	String passwd = "";
	Connection cn =null;
	Statement st =null;
	ResultSet rs =null;
	boolean existe = false;
	
	try {

		// Etape 1 : Chargement du driver
		Class.forName("com.mysql.jdbc.Driver");

		// Etape 2 : récupération de la connexion
		cn = DriverManager.getConnection(url, login, passwd);

		// Etape 3 : Création d'un statement
		st = cn.createStatement();

		String sql = "SELECT `NomEntreprise`, `Mdp` FROM `Entreprises` WHERE `NomEntreprise`=\""+user+"\" AND `Mdp`=\""+mdp+"\"";

		// Etape 4 : exécution requête
		rs = st.executeQuery(sql);

		// Si récup données alors étapes 5 (parcours Resultset)

		while (rs.next()) {
			if(rs.getString("NomEntreprise").equals(""))
			{
				existe=false;
			}
			else
			{
				if(rs.getString("NomEntreprise").equals(user)&&rs.getString("Mdp").equals(mdp))
				{
				existe = true;
				}
			}
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} finally {
		try {
		// Etape 6 : libérer ressources de la mémoire.
			cn.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return existe;
}


public static ArrayList<Postulation> listePostulation(String user) {
	// TODO Auto-generated method stub
	
	
	String url = "jdbc:mysql://localhost/gestionstages?useSSL=false";
	String login = "root";
	String passwd = "";
	Connection cn =null;
	Statement st =null;
	ResultSet rs =null;
	ArrayList<Postulation> list = new ArrayList<Postulation>();
	
	try {

		// Etape 1 : Chargement du driver
		Class.forName("com.mysql.jdbc.Driver");

		// Etape 2 : récupération de la connexion
		cn = DriverManager.getConnection(url, login, passwd);

		// Etape 3 : Création d'un statement
		st = cn.createStatement();

		String sql = "SELECT `Identifiant`,`NomEntreprise`, `Poste`, `Duree`, `Etat` FROM `postulation` WHERE `NomEntreprise`=\""+user+"\" ";

		// Etape 4 : exécution requête
		rs = st.executeQuery(sql);

		// Si récup données alors étapes 5 (parcours Resultset)

		while (rs.next()) {
			list.add(new Postulation(rs.getString("Identifiant"),rs.getString("NomEntreprise"),rs.getString("Duree"),rs.getString("Poste"),rs.getString("Etat").charAt(0)));
					
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} finally {
		try {
		// Etape 6 : libérer ressources de la mémoire.
			cn.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	return list;
}

public static ArrayList<Postulation> listePostulationViaUtilisateur(String user) {
	// TODO Auto-generated method stub
	
	
	String url = "jdbc:mysql://localhost/gestionstages?useSSL=false";
	String login = "root";
	String passwd = "";
	Connection cn =null;
	Statement st =null;
	ResultSet rs =null;
	ArrayList<Postulation> list = new ArrayList<Postulation>();
	
	try {

		// Etape 1 : Chargement du driver
		Class.forName("com.mysql.jdbc.Driver");

		// Etape 2 : récupération de la connexion
		cn = DriverManager.getConnection(url, login, passwd);

		// Etape 3 : Création d'un statement
		st = cn.createStatement();

		String sql = "SELECT `Identifiant`,`NomEntreprise`, `Poste`, `Duree`, `Etat` FROM `postulation` WHERE `Identifiant`=\""+user+"\" ";

		// Etape 4 : exécution requête
		rs = st.executeQuery(sql);

		// Si récup données alors étapes 5 (parcours Resultset)

		while (rs.next()) {
			list.add(new Postulation(rs.getString("Identifiant"),rs.getString("NomEntreprise"),rs.getString("Duree"),rs.getString("Poste"),rs.getString("Etat").charAt(0)));
					
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} finally {
		try {
		// Etape 6 : libérer ressources de la mémoire.
			cn.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	return list;
}

public static Utilisateur UtilisateurViaId(String id) {
	// TODO Auto-generated method stub
	String url = "jdbc:mysql://localhost/gestionstages?useSSL=false";
	String login = "root";
	String passwd = "";
	Connection cn =null;
	Statement st =null;
	ResultSet rs =null;
	Utilisateur a=new Utilisateur();
	try {

		// Etape 1 : Chargement du driver
		Class.forName("com.mysql.jdbc.Driver");

		// Etape 2 : récupération de la connexion
		cn = DriverManager.getConnection(url, login, passwd);

		// Etape 3 : Création d'un statement
		st = cn.createStatement();

		String sql = "SELECT `Identifiant`, `Mdp`, `Telephone`, `Mail`, `Adresse`, `Nom`, `Prenom`, `Formation`, `Competences`, `Experience`, `Interets` FROM `Utilisateur` WHERE `Identifiant`=\""+id+"\"";

		// Etape 4 : exécution requête
		rs = st.executeQuery(sql);

		// Si récup données alors étapes 5 (parcours Resultset)

		while (rs.next()) {

		

			a=new Utilisateur(rs.getString("Identifiant"), rs.getString("Mdp"), rs.getString("Telephone"), rs.getString("Mail"), rs.getString("Adresse"), rs.getString("Nom"), rs.getString("Prenom"), rs.getString("Formation"), rs.getString("Competences"), rs.getString("Experience"), rs.getString("Interets"));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} finally {
		try {
		// Etape 6 : libérer ressources de la mémoire.
			cn.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return a;
}


public static void modifPostulation(Postulation p,boolean etat) {
	String url = "jdbc:mysql://localhost/gestionstages?useSSL=false";
	String login = "root";
	String passwd = "";
	Connection cn =null;
	Statement st =null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		cn = DriverManager.getConnection(url,login,passwd);
		st= cn.createStatement();
		String sql = "";
		if(etat)
		{
			sql ="UPDATE `postulation` SET `Etat`=\""+"T"+"\" WHERE Identifiant=\""+p.user+"\" AND `NomEntreprise`=\""+p.Ent+"\" AND `Poste`=\""+p.Pos+"\"";
			
			if(!etaitaccepter(p))
			{
				SoustrairePlace(p);
					
			}
						
		}
		else
		{
			sql ="UPDATE `postulation` SET `Etat`=\""+"F"+"\" WHERE Identifiant=\""+p.user+"\" AND `NomEntreprise`=\""+p.Ent+"\" AND `Poste`=\""+p.Pos+"\"";
			if(etaitaccepter(p))
			{
				IncrePlace(p);	
			}
		}
		
		st.executeUpdate(sql);
		
	}
	catch (SQLException e){
		e.printStackTrace();
	}
	catch (ClassNotFoundException e){
		e.printStackTrace();
	} 
	finally {
			try {
				cn.close();
				st.close();
				}
			catch (SQLException e)
				{
				e.printStackTrace();
				}
			}
	
}


private static boolean etaitaccepter(Postulation p) {
	String url = "jdbc:mysql://localhost/gestionstages?useSSL=false";
	String login = "root";
	String passwd = "";
	Connection cn =null;
	Statement st =null;
	ResultSet rs =null;
	boolean etaitaccepter = false;
	
	try {

		// Etape 1 : Chargement du driver
		Class.forName("com.mysql.jdbc.Driver");

		// Etape 2 : récupération de la connexion
		cn = DriverManager.getConnection(url, login, passwd);

		// Etape 3 : Création d'un statement
		st = cn.createStatement();

		String sql = "SELECT `Identifiant`, `NomEntreprise`, `Duree`, `Poste`, `Etat` FROM `postulation` WHERE `Identifiant`=\""+p.user+"\" AND `NomEntreprise`=\""+p.Ent+"\" AND `Duree`=\""+p.Dur+"\" AND `Poste`=\""+p.Pos+"\"";

		// Etape 4 : exécution requête
		rs = st.executeQuery(sql);

		// Si récup données alors étapes 5 (parcours Resultset)

		while (rs.next()) {
			if(rs.getString("Etat").equals("T"))
			{
				etaitaccepter = true;
			}
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} finally {
		try {
		// Etape 6 : libérer ressources de la mémoire.
			cn.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	return etaitaccepter;
}



public static void IncrePlace(Postulation p) {
	String url = "jdbc:mysql://localhost/gestionstages?useSSL=false";
	String login = "root";
	String passwd = "";
	Connection cn =null;
	Statement st =null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		cn = DriverManager.getConnection(url,login,passwd);
		st= cn.createStatement();
		
		String sql  ="UPDATE `Offres` SET `Places`=\""+(NombrePlaces(p)+1)+"\" WHERE `NomEntreprise`=\""+p.Ent+"\" AND `Poste`=\""+p.Pos+"\" AND `Duree`=\""+p.Dur+"\"";
			
		
		
		st.executeUpdate(sql);
		
	}
	catch (SQLException e){
		e.printStackTrace();
	}
	catch (ClassNotFoundException e){
		e.printStackTrace();
	} 
	finally {
			try {
				cn.close();
				st.close();
				}
			catch (SQLException e)
				{
				e.printStackTrace();
				}
			}
}


public static void SoustrairePlace(Postulation p) {
	String url = "jdbc:mysql://localhost/gestionstages?useSSL=false";
	String login = "root";
	String passwd = "";
	Connection cn =null;
	Statement st =null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		cn = DriverManager.getConnection(url,login,passwd);
		st= cn.createStatement();
		
		String sql  ="UPDATE `Offres` SET `Places`=\""+(NombrePlaces(p)-1)+"\" WHERE `NomEntreprise`=\""+p.Ent+"\" AND `Poste`=\""+p.Pos+"\" AND `Duree`=\""+p.Dur+"\"";
			
		
		
		st.executeUpdate(sql);
		
	}
	catch (SQLException e){
		e.printStackTrace();
	}
	catch (ClassNotFoundException e){
		e.printStackTrace();
	} 
	finally {
			try {
				cn.close();
				st.close();
				}
			catch (SQLException e)
				{
				e.printStackTrace();
				}
			}
}


public static int NombrePlaces(Postulation p) {
	{
		String url = "jdbc:mysql://localhost/gestionstages?useSSL=false";
		String login = "root";
		String passwd = "";
		Connection cn =null;
		Statement st =null;
		ResultSet rs =null;
		int places = 0; 
		
		try {

			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : récupération de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Création d'un statement
			st = cn.createStatement();

			String sql = "SELECT `NomEntreprise`, `Duree`, `Poste`, `Places` FROM `offres` WHERE `NomEntreprise`=\""+p.Ent+"\" AND `Duree`=\""+p.Dur+"\" AND `Poste`=\""+p.Pos+"\"";

			// Etape 4 : exécution requête
			rs = st.executeQuery(sql);

			// Si récup données alors étapes 5 (parcours Resultset)

			while (rs.next()) {
				places = Integer.parseInt(rs.getString("Places"));		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
			// Etape 6 : libérer ressources de la mémoire.
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return places;
	}
}



public static String numeroEntreprise(Offres o) {
	String url = "jdbc:mysql://localhost/gestionstages?useSSL=false";
	String login = "root";
	String passwd = "";
	Connection cn =null;
	Statement st =null;
	ResultSet rs =null;
	String num = "";
	
	try {

		// Etape 1 : Chargement du driver
		Class.forName("com.mysql.jdbc.Driver");

		// Etape 2 : récupération de la connexion
		cn = DriverManager.getConnection(url, login, passwd);

		// Etape 3 : Création d'un statement
		st = cn.createStatement();

		String sql = "SELECT `Telephone` FROM `Entreprises` WHERE `NomEntreprise`=\""+o.Ent+"\"";

		// Etape 4 : exécution requête
		rs = st.executeQuery(sql);

		// Si récup données alors étapes 5 (parcours Resultset)

		while (rs.next()) {
			num=rs.getString("Telephone");
			
			
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} finally {
		try {
		// Etape 6 : libérer ressources de la mémoire.
			cn.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return num;
	
}


public static void supprimerOffre(Offres o) {
	
	String url = "jdbc:mysql://localhost/gestionstages?useSSL=false";
	String login = "root";
	String passwd = "";
	Connection cn =null;
	Statement st =null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		cn = DriverManager.getConnection(url,login,passwd);
		st= cn.createStatement();
		
		String sql = "DELETE FROM `Offres` WHERE `NomEntreprise`=\""+o.Ent+"\" AND `Poste`=\""+o.Pos+"\" AND `Duree`=\""+o.Dur+"\"";
		
		st.executeUpdate(sql);
	}
	catch (SQLException e){
		e.printStackTrace();
	}
	catch (ClassNotFoundException e){
		e.printStackTrace();
	} 
	finally {
			try {
				cn.close();
				st.close();
				}
			catch (SQLException e)
				{
				e.printStackTrace();
				}
			}
}


public static void supprimerPostulationViaO(Offres o) {
	
	String url = "jdbc:mysql://localhost/gestionstages?useSSL=false";
	String login = "root";
	String passwd = "";
	Connection cn =null;
	Statement st =null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		cn = DriverManager.getConnection(url,login,passwd);
		st= cn.createStatement();
		
		String sql = "DELETE FROM `postulation` WHERE `NomEntreprise`=\""+o.Ent+"\" AND `Poste`=\""+o.Pos+"\" AND `Duree`=\""+o.Dur+"\"";
		
		st.executeUpdate(sql);
	}
	catch (SQLException e){
		e.printStackTrace();
	}
	catch (ClassNotFoundException e){
		e.printStackTrace();
	} 
	finally {
			try {
				cn.close();
				st.close();
				}
			catch (SQLException e)
				{
				e.printStackTrace();
				}
			}
	
}


public static void supprimerEntreprises(String nom, String adresse, String tel, String com) {
	
	String url = "jdbc:mysql://localhost/gestionstages?useSSL=false";
	String login = "root";
	String passwd = "";
	Connection cn =null;
	Statement st =null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		cn = DriverManager.getConnection(url,login,passwd);
		st= cn.createStatement();
		
		String sql = "DELETE FROM `Entreprises` WHERE `NomEntreprise`=\""+nom+"\" AND `Adresse`=\""+adresse+"\" AND `Telephone`=\""+tel+"\" AND `Commentaire`=\""+com+"\"";
		
		st.executeUpdate(sql);
	}
	catch (SQLException e){
		e.printStackTrace();
	}
	catch (ClassNotFoundException e){
		e.printStackTrace();
	} 
	finally {
			try {
				cn.close();
				st.close();
				}
			catch (SQLException e)
				{
				e.printStackTrace();
				}
			}
}


public static ArrayList<Utilisateur> listeU() {

		String url = "jdbc:mysql://localhost/gestionstages?useSSL=false";
		String login = "root";
		String passwd = "";
		Connection cn =null;
		Statement st =null;
		ResultSet rs =null;
		ArrayList<Utilisateur> list = new ArrayList<Utilisateur>();
		
		try {

			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : récupération de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Création d'un statement
			st = cn.createStatement();

			String sql = "SELECT `Identifiant`,`Nom`,`Prenom` FROM `Utilisateur`";

			// Etape 4 : exécution requête
			rs = st.executeQuery(sql);

			// Si récup données alors étapes 5 (parcours Resultset)

			while (rs.next()) {
				list.add(new Utilisateur(rs.getString("Identifiant"),rs.getString("Nom"),rs.getString("Prenom")));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
			// Etape 6 : libérer ressources de la mémoire.
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}


public static void supprimerPostulationViaId(Utilisateur u) {
	String url = "jdbc:mysql://localhost/gestionstages?useSSL=false";
	String login = "root";
	String passwd = "";
	Connection cn =null;
	Statement st =null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		cn = DriverManager.getConnection(url,login,passwd);
		st= cn.createStatement();
		
		String sql = "DELETE FROM `postulation` WHERE `Identifiant`=\""+u.id+"\" ";
		
		st.executeUpdate(sql);
	}
	catch (SQLException e){
		e.printStackTrace();
	}
	catch (ClassNotFoundException e){
		e.printStackTrace();
	} 
	finally {
			try {
				cn.close();
				st.close();
				}
			catch (SQLException e)
				{
				e.printStackTrace();
				}
			}
	
}


public static void supprimerUtilisateur(Utilisateur u) {
	
	String url = "jdbc:mysql://localhost/gestionstages?useSSL=false";
	String login = "root";
	String passwd = "";
	Connection cn =null;
	Statement st =null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		cn = DriverManager.getConnection(url,login,passwd);
		st= cn.createStatement();
		
		String sql = "DELETE FROM `Utilisateur` WHERE `Identifiant`=\""+u.id+"\" ";
		
		st.executeUpdate(sql);
	}
	catch (SQLException e){
		e.printStackTrace();
	}
	catch (ClassNotFoundException e){
		e.printStackTrace();
	} 
	finally {
			try {
				cn.close();
				st.close();
				}
			catch (SQLException e)
				{
				e.printStackTrace();
				}
			}
}


	



}