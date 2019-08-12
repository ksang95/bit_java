package day19;

import java.util.Scanner;

public class Test05_Command {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Command delete = new DeleteCommand();
		Command update = new UpdateCommand();
		Command select = new SelectCommand();
		Command insert = new InsertCommand();
		Scanner s=new Scanner(System.in);
		System.out.println("delete update select insert 중 하나 입력 하세요.");
		String cmd = s.nextLine();
		switch (cmd) {
		case "insert":
			insert.exec();
			break;
		case "update":
			update.exec();
			break;
		case "select":
			select.exec();
			break;
		case "delete":
			delete.exec();
			break;
		default:
			System.out.println("잘못 입력했습니다.");
			break;
		}
	}

}
