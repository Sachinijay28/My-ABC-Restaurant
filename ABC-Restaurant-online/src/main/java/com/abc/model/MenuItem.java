package com.abc.model;

public class MenuItem {
	
	private int id;
    private String name;
    private double price;
    private String category;

    // Constructor, getters, and setters
    public MenuItem(int id, String name, double price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // Getters and setters
    public int getId() 
    { 
    	return id; 
    }
    public void setId(int id)
    { 
    	this.id = id; 
    }
    public String getName() 
    { 
    	return name; 
    }
    public void setName(String name) 
    { 
    	this.name = name; 
    }
    public double getPrice() 
    { 
    	return price; 
    }
    public void setPrice(double price) 
    { 
    	this.price = price; 
    }
    public String getCategory() 
    { 
    	return category; 
    }
    public void setCategory(String category) 
    { 
    	this.category = category; 
    }


}
