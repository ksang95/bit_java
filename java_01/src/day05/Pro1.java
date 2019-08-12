package day05;

import java.util.Arrays;

public class Pro1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] num = new int[6];
		for (int i = 0; i < num.length; i++) {
			num[i] = (int) (Math.random() * 45) + 1;
			for (int j = i - 1; j >= 0; j--) {
				if (num[j] == num[i]) {
					i--;
					break;
				}

			}
		}
		for (int i = 0; i < num.length - 1; i++) {
			for (int j = i + 1; j < num.length; j++) {
				if (num[j] < num[i]) {
					int temp=num[i];
					num[i]=num[j];
					num[j]=temp;
				}
			}
		}
		System.out.print(Arrays.toString(num));
	}

}
