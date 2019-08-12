package day23;

import java.util.Scanner;

public class Test02_Scanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "1 and 2 and animal and lion and tiger";
		Scanner s = new Scanner(str);
		s = s.useDelimiter("\\s*and\\s*");
		int firstToken = s.nextInt();
		int secondToken = s.nextInt();
		String thirdToken = s.next();
		String fourthToken = s.next();
		String fifthToken = s.next();
		System.out.printf("%d, %d, %s, %s, %s", firstToken, secondToken, thirdToken, fourthToken, fifthToken);
	}

}
