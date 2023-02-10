package com.KoreaIT.java.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.KoreaIT.java.dto.User;
import com.KoreaIT.java.util.Util;

public class UserController extends Controller {

	private List<User> users;
	private Scanner sc;
	private String command;
	private String actionMethodName;
	private String loginId1;
	private String loginPw1;

	public UserController(Scanner sc) {
		this.users = new ArrayList<>();
		this.sc = sc;
	}

	public void doAction(String command, String actionMethodName) {
		this.command = command;
		this.actionMethodName = actionMethodName;

		switch (actionMethodName) {
		case "join":
			doJoin();
			break;

		case "login":
			doLogin();
			break;
		case "logout":
			doLogout();
			break;
		default:
			System.out.println("존재하지 않는 명령어 입니다.");
			break;
		}
	}

	public void doLogout() {
		if (userUseing == 1) {
			userUseing = 0;
			loginedUser = null;
			System.out.println("정상적으로 로그아웃 되었습니다.");
		} else {
			System.out.println("로그인이 되어있지 않습니다!");
		}

	}

	public void doLogin() {
		if (userUseing == 0) {
			while (true) {
				System.out.printf("로그인 아이디 : ");
				loginId1 = sc.nextLine();
				System.out.printf("로그인 비밀번호 : ");
				loginPw1 = sc.nextLine();

				User user = getUserByLoginId(loginId1);

				if (user == null) {
					System.out.println("해당 회원은 존재하지 않습니다.");
					continue;
				}
				if (user.userLoginPW.equals(loginPw1) == false) {
					System.out.println("비밀번호를 확인해주세요");
					continue;
				}
				loginedUser = user;
				System.out.printf("로그인 성공 %s님 환영합니다.\n", loginedUser.userName);
				userUseing = 1;
				break;
			}

		} else {
			System.out.println("사용자가 로그인 중입니다. 로그아웃 해주세요!");
		}
	}

	public void doJoin() {
		int id = users.size() + 1;
		String regDate = Util.getNowDateStr();

		String loginId = null;
		while (true) {
			System.out.printf("로그인 아이디 : ");
			loginId = sc.nextLine();
			if (loginId.length() < 5) {
				System.out.println("아이디는 5글자 이상입니다.");
				continue;
			}

			else if (isJoinableLoginId(loginId) == false) {
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

	private User getUserByLoginId(String loginId) {
		int index = getMemberIndexByLoginId(loginId);
		if (index == -1) {
			return null;
		}

		return users.get(index);
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
			if (user.userLoginID.equals(loginId)) {
				return i;
			}
			i++;
		}
		return -1;
	}

	public void makeTestData() {
		System.out.println("테스트를 위한 데이터를 생성합니다");

		users.add(new User(1, Util.getNowDateStr(), Util.getNowDateStr(), "admin", "admin", "관리자"));
		users.add(new User(2, Util.getNowDateStr(), Util.getNowDateStr(), "id2", "id2", "김기덕2"));
		users.add(new User(3, Util.getNowDateStr(), Util.getNowDateStr(), "id3", "id3", "김기덕3"));
	}

}