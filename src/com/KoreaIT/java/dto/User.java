package com.KoreaIT.java.dto;

public class User extends Dto {
	
	public String userID;
	public String userPW;
	public String userName;
	
		
	public User(int id, String userID, String userPW, String userName, String regDate, String name) {
		this.userID = userID;
		this.userPW = userPW;
		this.userName= userName;
		this.regDate = regDate;
		this.id = id;
		
	}
	
}
