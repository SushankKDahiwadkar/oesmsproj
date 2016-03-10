/**
 * 
 */
package com.sushankkdahiwadkar.oes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sushankkdahiwadkar.oes.model.TestScore;
import com.sushankkdahiwadkar.oes.util.ConnectionUtil;

/**
 * @author sushank_dahiwadkar
 *
 */
public class TestScoreDAO {
	private Connection connection;
	
	
	
	public TestScoreDAO() {
		super();
		connection = ConnectionUtil.getConnection();
	}



	public TestScore createTestScore(TestScore testScore){
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("insert into test"+ testScore.getTestId() +" (testid, userid, score, totalmarks) values (?, ?, ?, ? )", PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, testScore.getTestId());
			preparedStatement.setInt(2, testScore.getUserId());
			preparedStatement.setInt(3, testScore.getScore());
			preparedStatement.setInt(4, testScore.getTotalMarks());
			preparedStatement.executeUpdate();
			ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
			
			if(generatedKeys.next()){
				testScore.setId(generatedKeys.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return testScore;
	}
}
