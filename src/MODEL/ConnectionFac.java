package MODEL;


import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;

public class ConnectionFac {

	public Connection getConnection(){
		try {
			
		Class.forName("com.mysql.jdbc.Driver");
		return(Connection) DriverManager.getConnection("jdbc:mysql://localhost/adega?useSSL=false", "root", "asdqwe");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}catch(ClassNotFoundException e) {
			System.err.println("Erro-> " + e);
		return null;
		}
	}

}
