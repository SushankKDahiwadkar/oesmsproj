/**
 * 
 */
package com.sushankkdahiwadkar.oes.service;

import java.util.List;

import com.sushankkdahiwadkar.oes.dao.UserDAO;
import com.sushankkdahiwadkar.oes.model.User;

/**
 * This is the Service Class for UserDAO class. this is the intermediate class for UserDAO and UserControlller.
 *
 */
public class UserService {
	
	//UserDAO Object.
	UserDAO userDAO;
	
	/**
	 * Constructor.
	 * Initilises the UserDAO Object.
	 */
	public UserService() {
		super();
		userDAO = new UserDAO();
	}

	/**
	 * Method Creates the new User.
	 */
	public User createUser(User user) {
		return userDAO.createUser(user);
	}

	/**
	 * Method returns all the the users.
	 * @return
	 */
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}

	/**
	 * Method returns the user by userId.
	 * @param userId
	 * @return
	 */
	public User getUserById(int userId) {
		return userDAO.getUserById(userId);
	}

}
