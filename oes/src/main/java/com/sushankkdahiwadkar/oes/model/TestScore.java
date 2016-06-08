/**
 * 
 */
package com.sushankkdahiwadkar.oes.model;

/**
 * @author sushank_dahiwadkar
 *	this class is bean class for TestScore. we have similar table in the database.
 */
public class TestScore {
	int id, testId, userId, score, totalMarks;
	
	/**
	 * Simple Constructor.
	 */
	public TestScore() {
		super();
	}
	
	/**
	 * Parameterised Constructor.
	 * @param id
	 * @param testId
	 * @param userId
	 * @param score
	 * @param totalMarks
	 */
	public TestScore(int id, int testId, int userId, int score, int totalMarks) {
		super();
		this.id = id;
		this.testId = testId;
		this.userId = userId;
		this.score = score;
		this.totalMarks = totalMarks;
	}
	
	
	// below are all the getter and setter methods for all the variables.
	
	
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
	
	
	/**
	 * toString() method for the class.
	 */
	@Override
	public String toString() {
		return "TestScore [id=" + id + ", testId=" + testId + ", userId=" + userId + ", score=" + score
				+ ", totalMarks=" + totalMarks + "]";
	}
	
	
}
