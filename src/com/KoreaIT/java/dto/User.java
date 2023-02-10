package com.KoreaIT.java.dto;

public class User extends Dto {
	
	public String userLoginID;
	public String userLoginPW;
	public String userName;
	
		
	public User(int id, String regDate, String regDate1, String userID, String userPW, String userName) {
		this.userLoginID = userID;
		this.userLoginPW = userPW;
		this.userName= userName;
		this.regDate = regDate;
		this.id = id;
		
	}
	
}