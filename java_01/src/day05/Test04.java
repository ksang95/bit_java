package day05;

import java.util.Arrays;

public class Test04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n[] = new int[5];
		for (int i = 0; i < n.length; i++) {
			n[i] = (int) (Math.random() * 45) + 1;
		}
		System.out.println(Arrays.toString(n));
		int temp;
		int count = 0;
		int min=0;
		for (int i = 0; i < n.length - 1; i++) {
			min=i;
			for (int j = i + 1; j < n.length; j++) {
				if (n[min] > n[j]) {
					min=j;
				}
			}
			temp=n[i];
			n[i]=n[min];
			n[min]=temp;
			count++;
		}
		System.out.println(count);
		System.out.println(Arrays.toString(n));

		// 스와핑 작업을 최소한 수행하게 코드 수정
	}

}
