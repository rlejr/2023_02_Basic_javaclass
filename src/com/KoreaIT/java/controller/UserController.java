package com.KoreaIT.java.controller;

import java.util.List;
import java.util.Scanner;

import com.KoreaIT.java.dto.User;
import com.KoreaIT.java.util.Util;

public class UserController {

	private List<User> users;
	private Scanner sc;

	public UserController(List<User> users, Scanner sc) {
		this.users = users;
		this.sc = sc;
	}

	public void doJoin() {
		int id = users.size() + 1;
		String regDate = Util.getNowDateStr();

		String loginId = null;
		while (true) {
			System.out.printf("로그인 아이디 : ");
			loginId = sc.nextLine();

			if (isJoinableLoginId(loginId) == false) {
				System.out.println("이미 사용중인 아이디입니다.");
				continue;
			}

			break;
		}

		String loginPw = null;
		String loginPwConfirm = null;
		while (true) {
			System.out.printf("로그인 비밀번호 : ");
			loginPw = sc.nextLine();
			System.out.printf("로그인 비밀번호 확인: ");
			loginPwConfirm = sc.nextLine();

			if (loginPw.equals(loginPwConfirm) == false) {
				System.out.println("비밀번호를 다시 입력해주세요");
				continue;
			}

			break;
		}
		System.out.printf("이름 : ");
		String name = sc.nextLine();

		User user = new User(id, regDate, regDate, loginId, loginPw, name);
		users.add(user);

		System.out.printf("%d번 회원이 가입 되었습니다\n", id);

	}

	private boolean isJoinableLoginId(String loginId) {

		int index = getMemberIndexByLoginId(loginId);

		if (index == -1) {
			return true;
		}

		return false;
	}

	public int getMemberIndexByLoginId(String loginId) {
		int i = 0;
		for (User user : users) {
			if (user.userID.equals(loginId)) {
				return i;
			}
			i++;
		}
		return -1;
	}

}