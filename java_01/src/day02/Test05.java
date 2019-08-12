package day02;

import java.util.Scanner;

public class Test05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		
		String name = null;
		int score = 0;

		System.out.println("학생 이름을 입력하세요: ");
		name=input.nextLine();
		System.out.println("학생 점수를 입력하세요: ");
		score=input.nextInt();
		System.out.printf("이름 : %s, 점수 : %d", name, score);
		
		input.close();
		input=null;
	}

}
