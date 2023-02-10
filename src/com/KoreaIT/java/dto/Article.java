package com.KoreaIT.java.dto;

public class Article extends Dto {

	
	public String title;
	public String body;
	public int hit;
	public int userId;
	public String userName;

	public Article(int id, String regDate, String updateDate, int userId,String userName, String title, String body) {
		this(id, regDate, updateDate,userId,userName, title, body, 0);
	}

	public Article(int id, String regDate, String updateDate, int userId,String userName, String title, String body, int hit) {
		this.id = id;
		this.regDate = regDate;
		this.updateDate = updateDate;
		this.userId = userId;
		this.userName = userName;
		this.title = title;
		this.body = body;
		this.hit = hit;
	}

	public void increaseHit() {
		this.hit++;
	}
}