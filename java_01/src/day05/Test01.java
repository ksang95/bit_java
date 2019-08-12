package day05;

import java.util.Arrays;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n1= {11,22,33,44,55,66,77};
		int[] n2=n1;
		int[] n3=new int[n1.length];
		for(int i=0; i<n1.length; i++) {
			n3[i]=n1[i];
		}
		System.out.println(Arrays.toString(n1));
		System.out.println(Arrays.toString(n2));
		System.out.println(Arrays.toString(n3));
		n1[2]=0;
		System.out.println(Arrays.toString(n1));
		System.out.println(Arrays.toString(n2));
		System.out.println(Arrays.toString(n3));
		
	}

}
