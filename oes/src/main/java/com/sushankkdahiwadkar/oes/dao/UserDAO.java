package com.sushankkdahiwadkar.oes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sushankkdahiwadkar.oes.model.User;
import com.sushankkdahiwadkar.oes.util.ConnectionUtil;

public class UserDAO {
	
	private Connection connection;
	
	public UserDAO() {
		super();
		connection = ConnectionUtil.getConnection();
	}

	public User createUser(User user) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("insert into userdetails(firstname, lastname, email, username, password) values (?, ?, ?, ?, ? )", PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getUserName());
			preparedStatement.setString(5, user.getPassword());
			preparedStatement.executeUpdate();
			ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
			
			if(generatedKeys.next()){
				user.setUserId(generatedKeys.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

	public List<User> getAllUsers() {
		List<User> listUser = new ArrayList<User>();
		try {
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM userdetails";
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()){
				User user = new User();
				user.setUserId(resultSet.getInt("userid"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
