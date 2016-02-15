/**
 * 
 */
package com.sushankkdahiwadkar.oes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sushankkdahiwadkar.oes.model.Question;
import com.sushankkdahiwadkar.oes.util.ConnectionUtil;

/**
 * @author sushank_dahiwadkar
 *
 */
public class QuestionDAO {

	private Connection connection;

	public QuestionDAO() {
		super();
		connection = ConnectionUtil.getConnection();
	}

	public Question createQuestion(Question question) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO questionset (testid, question, option1, option2, option3, option4, correctanswer) values (?, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, question.getTestId());
			preparedStatement.setString(2, question.getQuestion());
			preparedStatement.setString(3, question.getOption1());
			preparedStatement.setString(4, question.getOption2());
			preparedStatement.setString(5, question.getOption3());
			preparedStatement.setString(6, question.getOption4());
			preparedStatement.setString(7, question.getCorrectAnswer());
			preparedStatement.executeUpdate();
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			while(resultSet.next()){
				question.setId(resultSet.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return question;
	}

	public Question getQuestionById(int questionId) {
		Question question = new Question();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM questionset WHERE questionid = ?");
			preparedStatement.setInt(1, questionId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()){
				question.setId(resultSet.getInt("questionid"));
				question.setTestId(resultSet.getInt("testid"));
				question.setQuestion(resultSet.getString("question"));
				question.setOption1(resultSet.getString("option1"));
				question.setOption2(resultSet.getString("option1"));
				question.setOption3(resultSet.getString("option1"));
				question.setOption4(resultSet.getString("option1"));
				question.setCorrectAnswer(resultSet.getString("correctanswer"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return question;
	}

	public List<Question> getQuestionsByTestId(int testId) {
		List<Question> listQuestions = new ArrayList<Question>();
		PreparedStatement preparedStatement;
		Question question;
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM questionset WHERE testid = ?");
			preparedStatement.setInt(1,  testId);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while ( resultSet.next() ) {
				question = new Question();
				question.setId(resultSet.getInt("questionid"));
				question.setTestId(resultSet.getInt("testid"));
				question.setQuestion(resultSet.getString("question"));
				question.setOption1(resultSet.getString("option1"));
				question.setOption2(resultSet.getString("option2"));
				question.setOption3(resultSet.getString("option3"));
				question.setOption4(resultSet.getString("option4"));
				question.setCorrectAnswer(resultSet.getString("correctanswer"));
				listQuestions.add(question);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listQuestions;
	}

}
