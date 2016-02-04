/**
 * 
 */
package com.sushankkdahiwadkar.oes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
			PreparedStatement preparedStatement = connection.prepareStatement("insert into createtest(userid, testname, subject, totalquestions, activated) values (?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, testDetails.getUserId());
			preparedStatement.setString(2, testDetails.getTestName());
			preparedStatement.setString(3, testDetails.getSubject());
			preparedStatement.setInt(4, testDetails.getTotalQuestions());
			preparedStatement.setBoolean(5, testDetails.isActivated());
			preparedStatement.executeUpdate();
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			if(resultSet.next()){
				testDetails.setTestId(resultSet.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return testDetails;
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
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return testDetails;
	}
	

}
