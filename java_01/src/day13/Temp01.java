package day13;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Temp01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str=" 홍길동 / 이순신/김유신 /박철 ";
		StringTokenizer st=new StringTokenizer(str,"/");
		String[] a=new String[st.countTokens()];
		int i=0;
		while(st.hasMoreTokens())
			a[i++]=st.nextToken().trim();
		//System.out.println(Arrays.deepToString(a));
		for(String data:a) {
			System.out.print(data.charAt(0));
			for(i=1; i<data.length(); i++)
				System.out.print("*");
			System.out.print(" ");
		}
			
	}

}

