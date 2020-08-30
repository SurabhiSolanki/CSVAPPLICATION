package com.java.model;


//the pojo file Plain Object Java Object

//its a model 
public class Railway {
	
	private int id;
	private String username;
	private String password;
	private String meals;
	private String gender;
	private String FromStation;
	private String ToStation;
	
	
	public Railway(int id, String username, String password, String meals, String gender, String fromStation,
			String toStation) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.meals = meals;
		this.gender = gender;
		FromStation = fromStation;
		ToStation = toStation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMeals() {
		return meals;
	}
	public void setMeals(String meals) {
		this.meals = meals;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getFromStation() {
		return FromStation;
	}
	public void setFromStation(String fromStation) {
		FromStation = fromStation;
	}
	public String getToStation() {
		return ToStation;
	}
	public void setToStation(String toStation) {
		ToStation = toStation;
	}
	
	
	

}
