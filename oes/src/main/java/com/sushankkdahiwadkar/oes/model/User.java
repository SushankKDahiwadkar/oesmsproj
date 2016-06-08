/**
 * 
 */
package com.sushankkdahiwadkar.oes.model;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * This is the user model class. This class is exactly similar to userdetails table in the database.
 */

@XmlRootElement
public class User {
	int userId;
	String firstName;
	String lastName;
	String email;
	String userName;
	String password;
	
	/**
	 * Simple Constructor.
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * parameterised constructor.
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param userName
	 * @param password
	 */
	public User(String firstName, String lastName, String email, String userName, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.password = password;
	}

	// Below are the getter and setter methods for all the variables.
	
	
	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", userName=" + userName + ", password=" + password + "]";
	}
	
	

}
