/**
 * 
 */
package com.sushankkdahiwadkar.oes.service;

import com.sushankkdahiwadkar.oes.dao.TestDetailsDAO;
import com.sushankkdahiwadkar.oes.model.TestDetails;

/**
 * This is the Service Class for TestDetails DAO. This is the intermediate class between the 
 * TestDetailsController and TestDetails DAO.
 */
public class TestDetailsService {
	
	//TestDetailsDAO Obbject
	TestDetailsDAO testDetailsDAO;
	
	/**
	 * Constructor.
	 * Initilises the TestDetailsDAO Object.
	 */
	public TestDetailsService() {
		super();
		testDetailsDAO = new TestDetailsDAO();
	}

	/**
	 * This method is used to create an test.
	 * @param createTest
	 * @return
	 */
	public TestDetails createTestId(TestDetails createTest) {
		return testDetailsDAO.createTestId(createTest);
	}

	/**
	 * Method return the testDetails by testId.
	 * @param testId
	 * @return
	 */
	public TestDetails getTestDetailsById(int testId) {
		return testDetailsDAO.getTestDetailsById(testId);
	}

}
