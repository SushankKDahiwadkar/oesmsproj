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
 * @author SushankKDahiwadkar
 *
 */
public class ConnectionUtil {

	private static Connection connection;
	
	public static Connection getConnection(){
		if(connection != null){
			return connection;
		}else{
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://104.197.79.26:3306/oes","sushank"
						,"sushank");
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
