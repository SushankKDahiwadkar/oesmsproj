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

import com.sushankkdahiwadkar.oes.model.TestScore;
import com.sushankkdahiwadkar.oes.service.TestScoreService;

/**
 * this controller is used to manage the test score data.
 */

@Path("/Score")
public class TestScoreController {
	TestScoreService testScoreService;
	
	
	/**
	 * constructor
	 */
	public TestScoreController() {
		super();
		testScoreService = new TestScoreService();
	}


	/**
	 * this method is used to create the test score.
	 * @param testScore
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TestScore createTestScore(TestScore testScore){
		TestScore score = testScoreService.createTestScore(testScore);
		return score;
	}
	
	/**
	 * this method returns scores of all the participants in particular test.
	 * @param testId
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Test/{testId}")
	public List<TestScore> getAllTestScores(@PathParam("testId") int testId){
		List<TestScore> listTestScore = testScoreService.getAllTestScore(testId);
		return listTestScore;
	}
}
