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

import com.sushankkdahiwadkar.oes.model.User;
import com.sushankkdahiwadkar.oes.service.UserService;

/**
 * This Controller is used to Manage User Functions. which consist of creating an user, reading a user.
 */

@Path("/User")
public class UserController {
	UserService userService;
	
	/**
	 * Constructor
	 */
	public UserController() {
		super();
		this.userService = new UserService();
	}

	/**
	 * Method is used to create an user.
	 * @param user
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({"application/json"})
	public User createUser(User user){
		User createdUser = new User();
		createdUser = userService.createUser(user);
		return createdUser;
	}
	
	/**
	 * Method is used to read all the users.
	 * @return
	 */
	@GET
	@Produces({"application/json"})
	public List<User> getAllUsers(){
		List<User> listUser = userService.getAllUsers();
		return listUser;
	}
	
	/**
	 * method is used to read user by id.
	 * @param userId
	 * @return
	 */
	@GET
	@Produces({"application/json"})
	@Path("/{userId}")
	public User getUserById(@PathParam("userId") int userId){
		User user = userService.getUserById(userId);
		return user;
	}
	
}
