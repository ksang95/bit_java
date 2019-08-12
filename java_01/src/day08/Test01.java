package day08;

import util.MyUtil;

public class Test01 {
	public static void main(String[] args) {
       
		System.out.println(MyUtil.max(5,6,88,-999,-4444));
		System.out.println(MyUtil.max(-4444));
		System.out.println(MyUtil.max(new int[] {5,6,88,-999,-4444}));
		
		
	}
}
