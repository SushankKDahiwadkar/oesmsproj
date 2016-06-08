/**
 * 
 */
package com.sushankkdahiwadkar.oes.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.sushankkdahiwadkar.oes.model.Question;
import com.sushankkdahiwadkar.oes.service.QuestionService;

/**
 * This is Rest Controller class for Question related operations. Controller provides all the Create, Read, Update and Delete operations
 * on any specific object. here we are dealing with Questions. 
 */

@Path("/Question")
public class QuestionController {
	
	/**
	 * QuestionService Object
	 */
	QuestionService questionSetService;
	
	/**
	 * Logger Object
	 */
	private static final Logger logger = LoggerFactory.getLogger(QuestionController.class);
	
	/**
	 * Default Constructor, this initializes QuestionService Object
	 */
	public QuestionController() {
		super();
		logger.info("Inside QuestionController Constructor");
		questionSetService = new QuestionService();
	}
	
	
	/**
	 * Creates the question.
	 * @param question
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createQuestion(Question question){
		Question createdQuestion = questionSetService.createQuestion(question);
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonObject = null;
		try {
			jsonObject = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(createdQuestion);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return Response.status(201).entity(jsonObject).build();
	}
	
	/**
	 * method returns the question by question id.
	 * @param questionId
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{questionId}")
	public Response getQuestionById(@PathParam("questionId") int questionId){
		Question question = questionSetService.getQuestionById(questionId);
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonObject = null;
		try {
			jsonObject = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(question);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return Response.status(200).entity(jsonObject).build();
	}
	
	
	/**
	 * returns the question set of a particular test. Test id needs to be passed.
	 * @param testId
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Test/{testId}")
	public Response getQuestionsByTestId(@PathParam("testId") int testId){
		List<Question> listQuestion = questionSetService.getQuestionsByTestId(testId);
		JSONObject obj = new JSONObject();		
		obj.put("entries", listQuestion);
		return Response.status(200).entity(obj.toString()).build();
	}
}
