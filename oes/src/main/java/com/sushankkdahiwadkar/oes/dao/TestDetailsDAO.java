/**
 * 
 */
package com.sushankkdahiwadkar.oes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sushankkdahiwadkar.oes.model.TestDetails;
import com.sushankkdahiwadkar.oes.util.ConnectionUtil;

/**
 * @author SushankKDahiwadkar
 *
 */
public class TestDetailsDAO {
	
	private Connection connection;

	public TestDetailsDAO() {
		super();
		connection = ConnectionUtil.getConnection();
	}

	public TestDetails createTestId(TestDetails testDetails) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("insert into createtest(userid, testname, subject, totalquestions, activated, timeinminutes) values (?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, testDetails.getUserId());
			preparedStatement.setString(2, testDetails.getTestName());
			preparedStatement.setString(3, testDetails.getSubject());
			preparedStatement.setInt(4, testDetails.getTotalQuestions());
			preparedStatement.setBoolean(5, testDetails.isActivated());
			preparedStatement.setInt(6, testDetails.getTimeInMinutes());
			preparedStatement.executeUpdate();
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			if(resultSet.next()){
				if(resultSet.getInt(1) != 0){
					int testId = resultSet.getInt(1);
					testDetails.setTestId(testId);
					createTestTable(testId);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return testDetails;
	}

	private void createTestTable(int testId) {
		String query = "CREATE TABLE test" + String.valueOf(testId) + "( id INT NOT NULL AUTO_INCREMENT," + 
						" testid INT," +
						" userid INT," + 
						" score INT," + 
						" totalmarks INT,"+
						" PRIMARY KEY (id));";
		
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);
			System.out.println("table created");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public TestDetails getTestDetailsById(int testId) {
		TestDetails testDetails = new TestDetails();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM createtest WHERE testid = ?");
			preparedStatement.setInt(1, testId);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				testDetails.setTestId(resultSet.getInt("testid"));
				testDetails.setUserId(resultSet.getInt("userid"));
				testDetails.setTestName(resultSet.getString("testname"));
				testDetails.setSubject(resultSet.getString("subject"));
				testDetails.setTotalQuestions(resultSet.getInt("totalquestions"));
				testDetails.setActivated(resultSet.getBoolean("activated"));
				testDetails.setTimeInMinutes(resultSet.getInt("timeinminutes"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return testDetails;
	}
	

}
