/**
 * 
 */
package com.sushankkdahiwadkar.oes.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserTest {
	int id;
	int testId;
	int userId;
	int correctAnswers;
	int wrongAnswers;
	
	/**
	 * simple constructor
	 */
	public UserTest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * parameterised constructor
	 * @param testId
	 * @param userId
	 * @param correctAnswers
	 * @param wrongAnswers
	 */
	public UserTest(int testId, int userId, int correctAnswers, int wrongAnswers) {
		super();
		this.testId = testId;
		this.userId = userId;
		this.correctAnswers = correctAnswers;
		this.wrongAnswers = wrongAnswers;
	}
	
	// getter and setter methods for all the variables.
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getCorrectAnswers() {
		return correctAnswers;
	}

	public void setCorrectAnswers(int correctAnswers) {
		this.correctAnswers = correctAnswers;
	}

	public int getWrongAnswers() {
		return wrongAnswers;
	}

	public void setWrongAnswers(int wrongAnswers) {
		this.wrongAnswers = wrongAnswers;
	}
	
	/**
	 * toString method for the class.
	 */
	@Override
	public String toString() {
		return "UserTest [id=" + id + ", testId=" + testId + ", userId=" + userId + ", correctAnswers=" + correctAnswers
				+ ", wrongAnswers=" + wrongAnswers + "]";
	}
	
}
