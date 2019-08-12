package day03;

import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int jumsu;
		System.out.println("점수를 입력하세요.");
		jumsu = s.nextInt();
		System.out.println(jumsu);
		s.nextLine();
		String grade = "F";
		if (jumsu >= 90)
			grade = "A";
		else if (jumsu >= 80)
			grade = "B";
		else if (jumsu >= 70)
			grade = "C";
		else if (jumsu >= 60)
			grade = "D";
		System.out.printf("점수 %d는 %s입니다\n", jumsu, grade);
		grade = jumsu >= 90 ? "A" : jumsu >= 80 ? "B" : jumsu >= 70 ? "C" : jumsu >= 60 ? "D" : "F";
		System.out.printf("점수 %d는 %s입니다\n", jumsu, grade);
		switch (jumsu / 10) {
		case 10:
		case 9:
			grade = "A";
			break;
		case 8:
			grade = "B";
			break;
		case 7:
			grade = "C";
			break;
		case 6:
			grade = "D";
			break;
		default:
			grade = "F";
		}
		System.out.printf("점수 %d는 %s입니다\n", jumsu, grade);
		s.close();
		s = null;
	}

}
