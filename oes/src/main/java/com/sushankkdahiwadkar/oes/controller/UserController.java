/**
 * 
 */
package com.sushankkdahiwadkar.oes.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sushankkdahiwadkar.oes.model.User;
import com.sushankkdahiwadkar.oes.service.UserService;

/**
 * @author SushankKDahiwadkar
 *
 */

@Path("/User")
public class UserController {
	UserService userService;
	
	public UserController() {
		super();
		this.userService = new UserService();
	}


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({"application/json"})
	public User createUser(User user){
		User createdUser = new User();
		createdUser = userService.createUser(user);
		return createdUser;
	}
	
}
