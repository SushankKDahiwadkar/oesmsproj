/**
 * 
 */
package com.sushankkdahiwadkar.oes.service;

import com.sushankkdahiwadkar.oes.dao.QuestionDAO;
import com.sushankkdahiwadkar.oes.model.Question;

/**
 * @author sushank_dahiwadkar
 *
 */
public class QuestionService {

	QuestionDAO questionDAO;
	
	
	public QuestionService() {
		super();
		questionDAO = new QuestionDAO();
	}


	public Question createQuestion(Question question) {
		return questionDAO.createQuestion(question);
	}


	public Question getQuestionById(int questionId) {
		return questionDAO.getQuestionById(questionId);
	}

}