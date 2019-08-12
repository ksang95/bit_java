package day03_ex;

import java.util.Scanner;

public class BookApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String str = "";
		String exit = null;
		while (true) {
			System.out.println("******** 명령  선택  ********");
			System.out.println("1. insert(등록)\n2. delete(삭제)\n3. update(수정)\n4. quit(종료)");
			System.out.println("************************");
			System.out.println("\n수행할 명령을 선택하세요!");
			System.out.println("1 2 3 4 중 하나를 선택하세요..");
			str = s.nextLine().trim();
			switch (str) {
			case "1":
				System.out.println("insert 작업을 수행합니다.");
				break;
			case "2":
				System.out.println("delete 작업을 수행합니다.");
				break;
			case "3":
				System.out.println("update 작업을 수행합니다.");
				break;
			case "4":
				System.out.println("정말 종료하시겠습니까? y/n");
				exit = s.nextLine().trim();
				if (exit.equals("y")||exit.equals("Y")) {
					System.out.println("프로그램을 종료합니다.");
					s.close();
					s = null;
					return;
				}
				break;
			default:
				System.out.println("잘못 입력했습니다.");
			}
		}
	}

}
