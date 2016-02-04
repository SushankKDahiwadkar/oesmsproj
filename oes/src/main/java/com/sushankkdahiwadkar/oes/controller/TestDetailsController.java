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
import com.sushankkdahiwadkar.oes.model.TestDetails;
import com.sushankkdahiwadkar.oes.service.TestDetailsService;

/**
 * @author SushankKDahiwadkar
 *
 */
@Path("/Test")
public class TestDetailsController {
	
	TestDetailsService testDetailsService;
	
	
	public TestDetailsController() {
		super();
		testDetailsService = new TestDetailsService();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createTest(TestDetails createTest){
		TestDetails createdTest = testDetailsService.createTestId(createTest);
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonObject = null;
		try {
			jsonObject = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(createdTest);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return Response.status(201).entity(jsonObject).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{testId}")
	public Response getTestDetailsById(@PathParam("testId") int testId){
		TestDetails testDetails = testDetailsService.getTestDetailsById(testId);
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonObject = null;
		try {
			jsonObject = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(testDetails);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return Response.status(200).entity(jsonObject).build();
	}
}
