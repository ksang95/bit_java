package day04;

public class Prob3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sourceString = "everyday we have is one more than we deserve";
		String encodedString = "";

		// 프로그램을 구현부 시작.
		char ch;
		for (int i = 0; i < sourceString.length(); i++) {
			ch = sourceString.charAt(i);
			if (ch != ' ') {
				if (ch >= 'x')
					ch = (char) (ch - 23);
				else
					ch = (char) (ch + 3);
			}
			encodedString = encodedString + ch;
		}
		// 참고 : 문자 'a'의 정수값은 97이며, 'z'는 122입니다.

		// 프로그램 구현부 끝.

		System.out.println("암호화할 문자열 : " + sourceString);
		System.out.println("암호화된 문자열 : " + encodedString);
		
		int sum=0;
		for(int i=1; i<=10; i++)
			for(int j=1; j<=i; j++) {
				sum+=j;
			}
		System.out.print("1+(1+2)+(1+2+3)+...+(1+2+3+...+10)="+sum);
	}

}
