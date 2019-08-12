package day16;

import java.io.IOException;

public class Test04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main start");
		// throw new RuntimeException("~~~문제 발생~~~");
		int jumsu = 90;
		try {
			if (!(jumsu >= 0 && jumsu <= 100))
				throw new IOException("jumsu가 유효하지 않습니다.");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("main end");
	}

}
