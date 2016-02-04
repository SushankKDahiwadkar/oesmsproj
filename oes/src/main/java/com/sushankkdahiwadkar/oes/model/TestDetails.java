/**
 * 
 */
package com.sushankkdahiwadkar.oes.model;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * @author SushankKDahiwadkar
 *
 */

@XmlRootElement
public class TestDetails {
	int testId;
	int userId;
	String testName;
	String subject;
	int totalQuestions;
	boolean activated;
	
	
	public TestDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public TestDetails(int userId, String testName, String subject, int totalQuestions, boolean activated) {
		super();
		this.userId = userId;
		this.testName = testName;
		this.subject = subject;
		this.totalQuestions = totalQuestions;
		this.activated = activated;
	}


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

	@Override
	public String toString() {
		return "TestDetails [testId=" + testId + ", userId=" + userId + ", testName=" + testName + ", subject="
				+ subject + ", totalQuestions=" + totalQuestions + ", activated=" + activated + "]";
	}

	
	
	
}
