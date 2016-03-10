/**
 * 
 */
package com.sushankkdahiwadkar.oes.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sushankkdahiwadkar.oes.model.TestScore;
import com.sushankkdahiwadkar.oes.service.TestScoreService;

/**
 * @author sushank_dahiwadkar
 *
 */

@Path("/Score")
public class TestScoreController {
	TestScoreService testScoreService;
	
	
	
	public TestScoreController() {
		super();
		testScoreService = new TestScoreService();
	}



	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TestScore createTestScore(TestScore testScore){
		TestScore score = testScoreService.createTestScore(testScore);
		return score;
	}
}
