package day19;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test06_Command_Map {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<String, Command> map = new HashMap<String, Command>();
		map.put("insert", new InsertCommand());
		map.put("update", new UpdateCommand());
		map.put("select", new SelectCommand());
		map.put("delete", new DeleteCommand());
		map.put("new",new Command() {

			@Override
			public void exec() {
				// TODO Auto-generated method stub
				System.out.println("기능 추가");
			}});
		
		Scanner s = new Scanner(System.in);
		System.out.println("delete update select insert 중 하나 입력하세요.");
		String cmd = s.nextLine();
		if (map.get(cmd) != null)
			map.get(cmd).exec();
		else
			System.out.println("잘못 입력했습니다.");
		/*
		 * switch (cmd) { case "insert": insert.exec(); break; case "update":
		 * update.exec(); break; case "select": select.exec(); break; case "delete":
		 * delete.exec(); break; default: System.out.println("잘못 입력했습니다."); break; }
		 */
	}

}
