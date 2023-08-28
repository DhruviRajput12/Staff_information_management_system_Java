import java.sql.*;
//Connection class
public class DatabaseInfo  
{
	public Connection db_connection() throws ClassNotFoundException, SQLException 
	{
		//Code to connect to database
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//Create connection to database with conn object			
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@calvin.humber.ca:1521:grok","n01496176","oracle");
		
		//returning connection object
		return conn;
	}
}

