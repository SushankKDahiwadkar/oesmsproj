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
public class UserTestDetails {
	int id;
	int testId;
	int userId;
	String question;
	String optionSelected;
	String correctAnswer;
	
	public UserTestDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserTestDetails(int id, int testId, int userId, String question, String optionSelected,
			String correctAnswer) {
		super();
		this.id = id;
		this.testId = testId;
		this.userId = userId;
		this.question = question;
		this.optionSelected = optionSelected;
		this.correctAnswer = correctAnswer;
	}

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

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOptionSelected() {
		return optionSelected;
	}

	public void setOptionSelected(String optionSelected) {
		this.optionSelected = optionSelected;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	@Override
	public String toString() {
		return "UserTestDetails [id=" + id + ", testId=" + testId + ", userId=" + userId + ", question=" + question
				+ ", optionSelected=" + optionSelected + ", correctAnswer=" + correctAnswer + "]";
	}
	
}
