/**
 * 
 */
package com.sushankkdahiwadkar.oes.model;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * This is Bean class for Question. This class is exactly similar to the question table in database.
 */

@XmlRootElement
public class Question {
	int id;
	int testId;
	String question;
	String option1;
	String option2;
	String option3;
	String option4;
	String correctAnswer;
	
	/**
	 * Simple Constructor
	 */
	public Question() {
		super();
	}
	
	/**
	 * Parameterised Constructor.
	 * @param testId
	 * @param question
	 * @param option1
	 * @param option2
	 * @param option3
	 * @param option4
	 * @param correctAnswer
	 */
	public Question(int testId, String question, String option1, String option2, String option3,
			String option4, String correctAnswer) {
		super();
		this.testId = testId;
		this.question = question;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.correctAnswer = correctAnswer;
	}
	
	// Below are all the getter and setter methods for all the variables.
	
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

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	
	/**
	 * toString() method for the class.
	 */
	@Override
	public String toString() {
		return "QuestionSet [id=" + id + ", testId=" + testId + ", question=" + question + ", option1=" + option1
				+ ", option2=" + option2 + ", option3=" + option3 + ", option4=" + option4 + ", correctAnswer="
				+ correctAnswer + "]";
	}
	
	
}
