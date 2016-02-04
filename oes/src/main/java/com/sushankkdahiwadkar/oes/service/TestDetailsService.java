/**
 * 
 */
package com.sushankkdahiwadkar.oes.service;

import com.sushankkdahiwadkar.oes.dao.TestDetailsDAO;
import com.sushankkdahiwadkar.oes.model.TestDetails;

/**
 * @author SushankKDahiwadkar
 *
 */
public class TestDetailsService {
	
	TestDetailsDAO testDetailsDAO;
	
	
	public TestDetailsService() {
		super();
		testDetailsDAO = new TestDetailsDAO();
	}


	public TestDetails createTestId(TestDetails createTest) {
		return testDetailsDAO.createTestId(createTest);
	}


	public TestDetails getTestDetailsById(int testId) {
		return testDetailsDAO.getTestDetailsById(testId);
	}

}
