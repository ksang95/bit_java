package day19;

import java.util.Scanner;

public class BookApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookMgr mgr = new BookMgr();
		Scanner s = new Scanner(System.in);
		String str = "";
		String exit = null;
		int ISBN=1;
		while (true) {
			System.out.println("******** 명령  선택  ********");
			System.out.println("1. insert(등록)\n2. delete(삭제)\n3. 목록 출력\n4. search(검색)\nq. quit(종료)");
			System.out.println("************************");
			System.out.println("\n수행할 명령을 선택하세요!");
			System.out.println("1 2 3 4 q 중 하나를 선택하세요..");
			str = s.nextLine().trim();
			switch (str) {
			case "1":
				System.out.println("insert 작업을 수행합니다.");
				System.out.print("Book Title 입력: ");
				String title = s.nextLine();
				System.out.print("Book Price 입력: ");
				int price = s.nextInt();
				s.nextLine();
				mgr.addBook(new Book(ISBN++,title, price));
				break;
			case "2":
				System.out.println("delete 작업을 수행합니다.");
				mgr.bookListPrint();
				System.out.print("삭제할 Book Title 입력: ");
				title = s.nextLine();
				mgr.deleteBook(title);
				break;
			case "3":
				System.out.println("목록 출력 작업을 수행합니다.");
				mgr.bookListPrint();
				break;
			case "4":
				System.out.println("검색 작업을 수행합니다.");
				System.out.print("검색할 title 입력: ");
				title = s.nextLine();
				mgr.searchBook(title);
				break;
			case "q":
				System.out.println("정말 종료하시겠습니까? y/n");
				exit = s.nextLine().trim();
				if (exit.equals("y") || exit.equals("Y")) {
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
