package com.abc.model;

public class Login {

	    private String username;
	    private String password;
	    private String usertype;

	    // Constructor
	    public Login(String username, String password, String usertype) {
	        this.username = username;
	        this.password = password;
	        this.usertype = usertype;
	    }

	    // Getter and Setter for username
	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    // Getter and Setter for password
	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    // Getter and Setter for userType
	    public String getUserType() {
	        return usertype;
	    }

	    public void setUserType(String usertype) {
	        this.usertype = usertype;
	    }

	    @Override
	    public String toString() {
	        return "Login [username=" + username + ", usertype=" + usertype + "]";
	    }

}
