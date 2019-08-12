package day05_ex;

import java.util.Arrays;

public class Prob5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//서술형 시험 문제 예정
		int[] num = null;
		num = new int[6];
		for (int i = 0; i < num.length; i++){
			num[i]=(int)(Math.random()*45)+1;
			for(int j=0; j<i;j++) {
				if(num[j]==num[i]) {
					i--;
					break;
				}
			}
		}
		System.out.println(Arrays.toString(num));

		int count=0;
		int min;
		for (int i = 0; i < num.length - 1; i++) {
			min=i;
			for (int j = i + 1; j < num.length; j++) {
				if (num[min] > num[j]) {
					min=j;
				}
			}
			if(i!=min) {
				int temp=num[i];
				num[i]=num[min];
				num[min]=temp;
				count++;
			}
		}
		System.out.println(count);
		System.out.println(Arrays.toString(num));
	}
}
