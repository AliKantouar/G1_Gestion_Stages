package Principal;
import java.sql.Statement;
import java.util.ArrayList;

import Interface_Graphique.modifCV;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DemoJdbc {


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
		System.out.println(mdp);
		
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




public static boolean verifU(String user, String mdp) {

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
public static boolean verifE(String nom) {

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
	afficher(list);
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
	for(int i = 0;i<list.size();i++)
	{
		list.get(i).Afficher();
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
		System.out.println("premiere");
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
	else
	{
		System.out.println("Deja postuler");
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
	return false;
}

	



}