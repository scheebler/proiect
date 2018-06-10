package Connection;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class Conn {

	public static Connection getConnection() throws Exception
	{
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url= "jdbc:mysql://localhost:3306/ag?useSSL=false";
			String username = "root";
			String pass = "smen";
			Class.forName(driver);
			Connection con = (Connection) DriverManager.getConnection(url, username, pass);
			System.out.println("connected");
			return con;
			
		}catch(Exception e) {System.out.println(e);}
		return null;
	}
}
