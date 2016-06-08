/**
 * 
 */
package com.sushankkdahiwadkar.oes.service;

import java.util.List;

import com.sushankkdahiwadkar.oes.dao.QuestionDAO;
import com.sushankkdahiwadkar.oes.model.Question;

/**
 * This is the service class for Question DAO. This class is the intermediate class between the Controller and the DAO.
 *
 */
public class QuestionService {
	
	// QuestionDAO Object
	QuestionDAO questionDAO;
	
	/**
	 * Constructor.
	 * Initialises the QuestionDAO Object.
	 */
	public QuestionService() {
		super();
		questionDAO = new QuestionDAO();
	}

	/**
	 * method is used to create a question.
	 * @param question
	 * @return
	 */
	public Question createQuestion(Question question) {
		return questionDAO.createQuestion(question);
	}

	/**
	 * Method returns the question by it's Id.
	 * @param questionId
	 * @return
	 */
	public Question getQuestionById(int questionId) {
		return questionDAO.getQuestionById(questionId);
	}

	/**
	 * Returns the List of questions for a specific test Id.
	 * @param testId
	 * @return
	 */
	public List<Question> getQuestionsByTestId(int testId) {
		return questionDAO.getQuestionsByTestId(testId);
	}

}
