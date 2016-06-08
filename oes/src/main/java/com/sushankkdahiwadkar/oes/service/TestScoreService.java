/**
 * 
 */
package com.sushankkdahiwadkar.oes.service;

import java.util.List;

import com.sushankkdahiwadkar.oes.dao.TestScoreDAO;
import com.sushankkdahiwadkar.oes.model.TestScore;

/**
 * This is a Service Class for TestScoreDAO. It works as intermediate class between TestScoreDAO and TestScoreController. 
 */
public class TestScoreService {
	
	//TestScoreDAO Object
	TestScoreDAO testScoreDAO;
	
	/**
	 * Constructor.
	 * Initilises the testScoreDAO Object.
	 */
	public TestScoreService() {
		super();
		testScoreDAO = new TestScoreDAO();
	}

	/**
	 * This Method inserts the new test score data into the database.
	 * @param testScore
	 * @return
	 */
	public TestScore createTestScore(TestScore testScore) {
		return testScoreDAO.createTestScore(testScore);
	}


	/**
	 * This method returns all the testResult Data for a particluar testId.
	 * @param testId
	 * @return
	 */
	public List<TestScore> getAllTestScore(int testId) {
		return testScoreDAO.getAllTestScore(testId);
	}

}
