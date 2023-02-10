package com.KoreaIT.java.dao;

import java.util.ArrayList;
import java.util.List;

import com.KoreaIT.java.dto.User;

public class UserDao {
	public List<User> users;

	public UserDao() {
		users = new ArrayList<>();
	}
}
