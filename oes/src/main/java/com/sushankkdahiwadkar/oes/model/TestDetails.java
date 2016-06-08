/**
 * 
 */
package com.sushankkdahiwadkar.oes.model;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * This class is bean class for TestDetails. this class is very similar to createtest table in database 
 */

@XmlRootElement
public class TestDetails {
	int testId;
	int userId;
	String testName;
	String subject;
	int totalQuestions;
	boolean activated;
	int timeInMinutes;
	
	/**
	 * simple constructor.
	 */
	public TestDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Parameterised Constructor
	 * @param userId
	 * @param testName
	 * @param subject
	 * @param totalQuestions
	 * @param activated
	 * @param timeInMinutes
	 */
	public TestDetails(int userId, String testName, String subject, int totalQuestions, boolean activated,
			int timeInMinutes) {
		super();
		this.userId = userId;
		this.testName = testName;
		this.subject = subject;
		this.totalQuestions = totalQuestions;
		this.activated = activated;
		this.timeInMinutes = timeInMinutes;
	}
	
	
	// below are all the getter and setter methods for all the variables.
	
	
	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getTotalQuestions() {
		return totalQuestions;
	}

	public void setTotalQuestions(int totalQuestions) {
		this.totalQuestions = totalQuestions;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public int getTimeInMinutes() {
		return timeInMinutes;
	}

	public void setTimeInMinutes(int timeInMinutes) {
		this.timeInMinutes = timeInMinutes;
	}
	
	/**
	 * toString() method for the class.
	 */
	@Override
	public String toString() {
		return "TestDetails [testId=" + testId + ", userId=" + userId + ", testName=" + testName + ", subject="
				+ subject + ", totalQuestions=" + totalQuestions + ", activated=" + activated + ", timeInMinutes="
				+ timeInMinutes + "]";
	}
	
	
}
