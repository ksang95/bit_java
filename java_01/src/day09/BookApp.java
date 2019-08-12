package day09;

import java.util.Scanner;

public class BookApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookMgr mgr = new BookMgr();
		Scanner s = new Scanner(System.in);
		String str = "";
		String exit = null;
		while (true) {
			System.out.println("******** 명령  선택  ********");
			System.out.println("1. insert(등록)\n2. delete(삭제)\n3. 목록 출력\n4. quit(종료)");
			System.out.println("************************");
			System.out.println("\n수행할 명령을 선택하세요!");
			System.out.println("1 2 3 4 중 하나를 선택하세요..");
			str = s.nextLine().trim();
			switch (str) {
			case "1":
				System.out.println("insert 작업을 수행합니다.");
				System.out.print("Book Title 입력: ");
				String title = s.nextLine();
				System.out.print("Book Price 입력: ");
				int price = s.nextInt();
				s.nextLine();
				mgr.addBook(new Book(title, price));
				System.out.printf("Book[%s : %d]를 등록하였습니다.\n", title, price);
				break;
			case "2":
				System.out.println("delete 작업을 수행합니다.");
				mgr.bookListPrint();
				System.out.print("삭제할 Book Title 입력: ");
				title = s.nextLine();
				int index = mgr.searchBook(title);
				if (index == -1)
					System.out.println("삭제할 책이 없습니다.");
				else {
					Book book = mgr.deleteBook(index);
					System.out.printf("Book[%s : %d]를 삭제하였습니다.\n", title, book.getPrice());
				}
				break;
			case "3":
				System.out.println("목록 출력 작업을 수행합니다.");
				mgr.bookListPrint();
				break;
			case "4":
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
