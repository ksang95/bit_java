package day04;

import java.util.Arrays;

public class Test05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] scores= {88,99,100,22,56,88,99};
		String[] names= {"홍길순","김길홍","고길수","박동훈","최정이","이길림"};
		System.out.println(Arrays.toString(scores));
		System.out.println(Arrays.toString(names));
		
		for(String data : names) {
			System.out.println("**"+data.charAt(data.length()-1));
		}
	}

}
