/**
 * 
 */
package com.sushankkdahiwadkar.oes.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sushankkdahiwadkar.oes.model.Question;
import com.sushankkdahiwadkar.oes.service.QuestionService;

/**
 * @author sushank_dahiwadkar
 *
 */

@Path("/Question")
public class QuestionController {
	QuestionService questionSetService;

	public QuestionController() {
		super();
		questionSetService = new QuestionService();
	}
	
	
	
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
		return Response.status(201).entity(jsonObject).build();
	}
}
