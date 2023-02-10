package com.KoreaIT.java.container;

import com.KoreaIT.java.dao.ArticleDao;
import com.KoreaIT.java.dao.UserDao;

public class Container {
	public static ArticleDao articleDao;
	public static UserDao userDao;

	static {
		articleDao = new ArticleDao();
		userDao = new UserDao();
	}
}