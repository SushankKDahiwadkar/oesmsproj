/**
 * 
 */
package com.sushankkdahiwadkar.oes.service;

import java.util.List;

import com.sushankkdahiwadkar.oes.dao.TestScoreDAO;
import com.sushankkdahiwadkar.oes.model.TestScore;

/**
 * @author sushank_dahiwadkar
 *
 */
public class TestScoreService {
	TestScoreDAO testScoreDAO;
	
	
	
	public TestScoreService() {
		super();
		testScoreDAO = new TestScoreDAO();
	}



	public TestScore createTestScore(TestScore testScore) {
		return testScoreDAO.createTestScore(testScore);
	}



	public List<TestScore> getAllTestScore(int testId) {
		return testScoreDAO.getAllTestScore(testId);
	}

}
