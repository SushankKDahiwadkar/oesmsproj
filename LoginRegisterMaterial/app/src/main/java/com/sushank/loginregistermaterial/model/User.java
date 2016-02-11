package com.sushank.loginregistermaterial.model;

/**
 * Created by SushankKDahiwadkar on 2/4/2016.
 */
public class User {
    int userId;
    String firstName;
    String lastName;
    String email;
    String userName;
    String password;

    public User() {
        super();
        // TODO Auto-generated constructor stub
    }


    public User(int userId, String firstName, String lastName, String email, String userName) {
        super();
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
    }


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
