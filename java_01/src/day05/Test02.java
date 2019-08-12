package day05;

import java.util.Arrays;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] scores= {77,99,100,85,91};
		int[] sc=new int[scores.length*2];
		
		System.arraycopy(scores, 0, sc, 0, scores.length);
		System.arraycopy(scores, 0, sc, sc.length-scores.length, scores.length);
		System.out.println(Arrays.toString(scores));
		System.out.println(Arrays.toString(sc));
	}

}
