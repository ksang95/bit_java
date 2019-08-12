package day03;

import java.util.Scanner;

public class BookApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int i = 0;
		while (i!=4) {
			String work="";
			System.out.println("******** 명령  선택  ********");
			System.out.println("1. insert(등록)\n2. delete(삭제)\n3. update(수정)\n4. quit(종료)");
			System.out.println("************************");
			System.out.println("\n수행할 명령을 선택하세요!");
			System.out.println("1 2 3 4 중 하나를 선택하세요..");
			i = s.nextInt();
			s.nextLine();
			switch (i) {
			case 1:
				work="등록";
				break;
			case 2:
				work="삭제";
				break;
			case 3:
				work="수정";
			case 4:
				break;
			default:
				System.out.println("잘못 입력했습니다.");
			}
			if(!work.equals(""))
				System.out.println(work+" 작업을 수행합니다.");
		}
		s.close();
		s=null;
	}

}
