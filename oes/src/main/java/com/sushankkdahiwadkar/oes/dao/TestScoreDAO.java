/**
 * 
 */
package com.sushankkdahiwadkar.oes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sushankkdahiwadkar.oes.model.Question;
import com.sushankkdahiwadkar.oes.model.TestScore;
import com.sushankkdahiwadkar.oes.util.ConnectionUtil;

/**
 * This DAO class is used to interact with the testTestId table. the table is created dynamically.
 * This class performs the insert and read operation as well.
 */
public class TestScoreDAO {
	//Connection Object
	private Connection connection;
	
	/**
	 * Constructor.
	 * initilises the Connection Object.
	 */
	public TestScoreDAO() {
		super();
		connection = ConnectionUtil.getConnection();
	}

	/**
	 * This method insert the testresult into the test<testId> table. 
	 * @param testScore
	 * @return
	 */
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


	/**
	 * This method returns all the records from the table for particular test Id.
	 * @param testId
	 * @return
	 */
	public List<TestScore> getAllTestScore(int testId) {
		List<TestScore> listTestScore = new ArrayList<TestScore>();
		PreparedStatement preparedStatement;
		Question question;
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM test"+String.valueOf(testId)+" WHERE testid = ?");
			preparedStatement.setInt(1,  testId);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while ( resultSet.next() ) {
				TestScore ts = new TestScore();
				ts.setId(resultSet.getInt("id"));
				ts.setScore(resultSet.getInt("score"));
				ts.setTestId(resultSet.getInt("testid"));
				ts.setUserId(resultSet.getInt("userid"));
				ts.setTotalMarks(resultSet.getInt("totalmarks"));
				listTestScore.add(ts);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listTestScore;
	}
}
