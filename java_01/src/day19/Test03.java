package day19;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("java01", "1234");
		map.put("java02", "1234");
		map.put("admin", "admin");
		for (int i = 0; i < 30; i++) {
			map.put("test" + i, (int) (Math.random() * 3) + "00");
		}
		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.println("  로그인 처리  ");
			System.out.println("ID/PW 형식으로 입력해 주세요.");
			String data = s.nextLine();
			String[] idpw = data.split("/");
			String id = idpw[0];
			String pw = idpw[1];
			if (map.containsKey(id)) {
				if (map.get(id).equals(pw)) {
					System.out.println("로그인 성공");
					break;
				} else {
					System.out.println("pw 불일치");
					System.out.println("다시 로그인하세요.");
				}
			} else {
				System.out.println("id가 존재하지 않습니다.");
				System.out.println("회원가입 후 이용하세요...");
			}
		}
		System.out.println(" 이제부터 서비스 이용이 가능 합니다. ");
	}

}
