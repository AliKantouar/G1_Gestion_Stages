import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DemoJdbc {
	/*
public static void main(String[] args)
{
	reinitialiser();
	sauverEnBase("Tomy");
	sauverEnBase("Tomyli");
	sauverEnBase("Boby");
	supprEnBase("Tomy");
	System.out.println("paf");
	
}

*/


public static void sauverEnBase(String personne) {
	String url = "jdbc:mysql://localhost/formation?useSSL=false";
	String login = "root";
	String passwd = "";
	Connection cn =null;
	Statement st =null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		cn = DriverManager.getConnection(url,login,passwd);
		st= cn.createStatement();
		
		String sql = "INSERT INTO `javadb`(`personne`) VALUES ('"+personne+"')";
		
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

public static void Inscrire(String user,String mdp) {
	String url = "jdbc:mysql://localhost/formation?useSSL=false";
	String login = "root";
	String passwd = "";
	Connection cn =null;
	Statement st =null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		cn = DriverManager.getConnection(url,login,passwd);
		st= cn.createStatement();
		
		String sql = "INSERT INTO `cv` (`user`, `mdp`, `tel`, `mail`, `addr`, `formation`, `nom`, `prenom`) VALUES ('"+user+"', '"+mdp+"', '', '', '', '', '', '');";
		
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
	String url = "jdbc:mysql://localhost/formation?useSSL=false";
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
	String url = "jdbc:mysql://localhost/formation?useSSL=false";
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



/*
public static void connexion(String user, String mdp) {
	String url = "jdbc:mysql://localhost/formation?useSSL=false";
	String login = "root";
	String passwd = "";
	Connection cn =null;
	Statement st =null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		cn = DriverManager.getConnection(url,login,passwd);
		st= cn.createStatement();
		
		String sql = "SELECT `user`, `mdp`, `tel`, `mail`, `addr`, `formation` FROM `cv` WHERE `user`=\""+user+"\" AND `mdp`=\""+mdp+"\"";
		
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
*/
public static boolean connexion(String user, String mdp) {

	// Information d'accès à la base de données
	String url = "jdbc:mysql://localhost/formation?useSSL=false";
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

		String sql = "SELECT `user`, `mdp`, `tel`, `mail`, `addr`, `formation` FROM `cv` WHERE `user`=\""+user+"\" AND `mdp`=\""+mdp+"\"";

		// Etape 4 : exécution requête
		rs = st.executeQuery(sql);

		// Si récup données alors étapes 5 (parcours Resultset)

		while (rs.next()) {
			System.out.println(rs.getString("user")+rs.getString("mdp"));
			if(rs.getString("user").equals("")&&rs.getString("mdp").equals(""))
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

public static void modifierCV(String user ,String nom, String prenom, String tel,String adr, String mail, String descr) {
	String url = "jdbc:mysql://localhost/formation";
	String login = "root";
	String passwd = "";
	Connection cn =null;
	Statement st =null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		cn = DriverManager.getConnection(url,login,passwd);
		st= cn.createStatement();
		
		String sql ="UPDATE `cv` SET `tel`=\""+tel+"\",`mail`=\""+mail+"\",`addr`=\""+adr+"\",`formation`=\""+descr+"\",`nom`=\""+nom+"\",`prenom`=\""+prenom+"\" WHERE user=\""+user+"\"";
		
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
		String url = "jdbc:mysql://localhost/formation?useSSL=false";
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

			String sql = "SELECT `user`, `mdp`, `tel`, `mail`, `addr`, `formation` FROM `cv` WHERE `user`=\""+modifCV.user+"\"";

			// Etape 4 : exécution requête
			rs = st.executeQuery(sql);

			// Si récup données alors étapes 5 (parcours Resultset)

			while (rs.next()) {
				
				System.out.println(rs.getString("user")+rs.getString("nom"));
				
				/*modifCV.getTextField().setText(rs.getString("prenom"));
				if(rs.getString("prenom").equals(""))
				{
					System.out.println("pe");
				}
				modifCV.getTextField_1().setText(rs.getString("mail"));
				modifCV.getTextField_2().setText(rs.getString("nom"));
				modifCV.getTextField_3().setText(rs.getString("tel"));
				modifCV.getTextField_4().setText(rs.getString("adr"));
				modifCV.getTextArea().setText(rs.getString("descr"));
				*/
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

public static void ajouterE(String nom,String chef, String tel, String adr, String com) {
	String url = "jdbc:mysql://localhost/formation?useSSL=false";
	String login = "root";
	String passwd = "";
	Connection cn =null;
	Statement st =null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		cn = DriverManager.getConnection(url,login,passwd);
		st= cn.createStatement();
		
		String sql = "INSERT INTO `entreprises`(`Nom`, `Chef`, `Tel`, `Adr`, `Com`) VALUES ('"+nom+"','"+chef+"','"+tel+"','"+adr+"','"+com+"')";
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

public static boolean verifE(String nom) {

	// Information d'accès à la base de données
	String url = "jdbc:mysql://localhost/formation?useSSL=false";
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

		String sql = "SELECT `Nom` FROM `Entreprises` WHERE `Nom`=\""+nom+"\"";

		// Etape 4 : exécution requête
		rs = st.executeQuery(sql);

		// Si récup données alors étapes 5 (parcours Resultset)

		while (rs.next()) {
			if(rs.getString("nom").equals(""))
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
	



}




