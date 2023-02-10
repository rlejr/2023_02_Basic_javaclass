package com.KoreaIT.java.controller;

import com.KoreaIT.java.dto.User;

public abstract class Controller {
	public static int idTryStack = 0;
	public static int pwTryStack = 0;
	public static int userUseing = 0;
	public static User loginedUser = null;
	public abstract void doAction(String command, String actionMethodName);
	public abstract void makeTestData();
	
	
		
	
}