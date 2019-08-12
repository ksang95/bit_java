package day04;

import java.util.Arrays;

public class Test04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int scores[]=new int[5];
		String names[]=new String[5];
		scores[0]=99;
		scores[1]=100;
		scores[2]=69;
		scores[3]=79;
		scores[4]=89;
		names[0]="홍길동";
		names[1]="고길동";
		names[2]="박길동";
		names[3]="김길동";
		names[4]="강길동";
		double avg=0.0;
		int sum=0;
		for(int i=0; i<scores.length;i++) {
			sum+=scores[i];
		}
		avg=(double)sum/scores.length;
		
		System.out.println(Arrays.toString(scores));
		System.out.println(Arrays.toString(names));
		System.out.println("평균: "+avg);
		for(int i=0; i<names.length; i++) {
				System.out.printf("%c**%5d  %s\n",names[i].charAt(0),scores[i],(scores[i]>=avg?"평균이상":"평균미달"));
		}
	}

}
