package com.abc.model;

public class Contact {
	
	private String name;
    private String email;
    private String contactNumber;
    private String message;

    public Contact(String name, String email, String contactNumber, String message) {
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
        this.message = message;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
