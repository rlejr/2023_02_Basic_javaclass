package com.KoreaIT.java;

import java.util.Scanner;

import com.KoreaIT.java.controller.ArticleController;
import com.KoreaIT.java.controller.Controller;
import com.KoreaIT.java.controller.UserController;

public class App {

	App() {

	}

	public void run() {
		System.out.println("==프로그램 시작==");
		Controller.idTryStack = 0;
		Controller.pwTryStack = 0;

		Scanner sc = new Scanner(System.in);
		UserController userController = new UserController(sc);
		ArticleController articlecontroller = new ArticleController(sc);

		articlecontroller.makeTestData();
		userController.makeTestData();

		while (true) {

			if (Controller.idTryStack == 5 || Controller.pwTryStack == 5) {
				System.out.println("==로그인 횟수 초과 프로그램 강제종료==");
				
				break;
			}
			System.out.printf("명령어 ) ");
			String command = sc.nextLine().trim();

			if (command.length() == 0) {
				System.out.println("명령어를 입력해주세요");
				continue;
			}

			if (command.equals("system exit")) {
				
				break;
			}
			String[] commandBits = command.split(" ");

			if (commandBits.length == 1) {
				System.out.println("명령어 확인 후 다시 입력해주세요");
				continue;
			}
			String controllerName = commandBits[0];
			String actionMethodName = commandBits[1];

			Controller controller = null;
			if (controllerName.equals("article")) {
				controller = articlecontroller;
			} else if (controllerName.equals("member")) {
				controller = userController;
			} else {
				System.out.println("존재하지 않는 명령어 입니다.");
				continue;
			}

			String actionName = controllerName + "/" + actionMethodName;

			switch (actionName) {
			case "article/write":
			case "article/delete":
			case "article/modify":
			case "member/logout":
				if (Controller.userUseing == 0) {
					System.out.println("로그인후 이용해주세요");
					continue;
				}
				break;
			}
			switch (actionName) {
			case "member/login":
			case "member/join":
				if (Controller.userUseing == 1) {
					System.out.println("사용자가 로그인 중입니다. 로그아웃 해주세요!");
					continue;
				}

				break;
			}
			controller.doAction(command, actionMethodName);

		}

		System.out.println("==프로그램 끝==");

		sc.close();

	}

}