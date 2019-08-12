package day04;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("알파벳 아스키 코드 값 확인");
		char a = 'a';
		for (int i = 0; i < 26; i++) {
			System.out.println(a + " : " + (int) a++);
		}
		char A = 'A';
		for (int i = 0; i < 26; i++) {
			System.out.println(A + " : " + (int) A++);
		}

		Scanner s = new Scanner(System.in);
		System.out.println("문자열 입력");
		String msg = s.nextLine();
		for (int i = 0; i < msg.length(); i++) {
			char ch = msg.charAt(i);
			//char result = (ch >= 'A' && ch <= 'Z') ? (char) (ch - 'A' + 'a') : ch;
			//System.out.print(result);
			if(ch>='A'&&ch<='Z')
				System.out.print((char)(ch-'A'+'a'));
			else if(ch>='a'&&ch<='z')
				System.out.print((char)(ch-'a'+'A'));
		}
		
	}

}
