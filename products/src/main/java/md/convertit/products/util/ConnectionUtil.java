package md.convertit.products.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;



public class ConnectionUtil {
private static final Logger log = Logger.getLogger(ConnectionUtil.class.getName());
	
	private static Connection connection;
	private static String host="jdbc:mysql://localhost/magazin";
	private static String dbUserName="root";
	private static String dbPassword="convertit";
	
	
	// incarcam driver pt mysql
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			log.info("loaded mysql driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			log.severe(String.format("Class not found: %s",e.getMessage()));
	
		}
	}
	

	public static Connection getConnection() throws SQLException {
		//obtine permisiunea
		connection = DriverManager.getConnection(host, dbUserName, dbPassword);
		
		log.info("loaded connection");
		
		return connection;
	}

}
