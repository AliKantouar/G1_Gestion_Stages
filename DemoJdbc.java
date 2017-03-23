import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DemoJdbc {
	
public static void main(String[] args)
{
	reinitialiser();
	sauverEnBase("Tomy");
	sauverEnBase("Boby");
	supprEnBase("Tomy");
}




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

}