/**
 * 
 */
package com.sushankkdahiwadkar.oes.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This the Connection Utility Class. This is the common class. Here the connection with database server is initilised.
 * Single Conection object is used in order to reduce the chaos.
 *
 */
public class ConnectionUtil {
	
	// Connection Object
	private static Connection connection;
	
	public static Connection getConnection(){
		if(connection != null){
			return connection;
		}else{
			try {
				//JDBC Driver Name.
				Class.forName("com.mysql.jdbc.Driver");
				//Initilising the connection object with the proper JDBC driver and connection strings.
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/oes_db","root"
						,"");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return connection;
		}
	}
	
}
