package com.abc.model;

public class Menu {
	public class MenuItem {
	    private String item;
	    private double price;

	    // Constructor
	    public MenuItem(String item, double price) {
	        this.item = item;
	        this.price = price;
	    }

	    // Getter for item
	    public String getName() {
	        return item;
	    }

	    // Setter for item
	    public void setName(String item) {
	        this.item = item;
	    }

	    // Getter for price
	    public double getPrice() {
	        return price;
	    }

	    // Setter for price
	    public void setPrice(double price) {
	        this.price = price;
	    }
	}
}

