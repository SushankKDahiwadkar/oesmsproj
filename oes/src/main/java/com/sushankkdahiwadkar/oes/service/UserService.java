/**
 * 
 */
package com.sushankkdahiwadkar.oes.service;

import com.sushankkdahiwadkar.oes.dao.UserDAO;
import com.sushankkdahiwadkar.oes.model.User;

/**
 * @author SushankKDahiwadkar
 *
 */
public class UserService {
	UserDAO userDAO;
	
	
	public UserService() {
		super();
		userDAO = new UserDAO();
	}


	public User createUser(User user) {
		return userDAO.createUser(user);
	}

}
