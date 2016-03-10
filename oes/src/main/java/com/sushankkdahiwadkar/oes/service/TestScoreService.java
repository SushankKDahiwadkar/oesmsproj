/**
 * 
 */
package com.sushankkdahiwadkar.oes.service;

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

}
