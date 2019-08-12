package day15_ex;


import util.MyUtil;
import static util.MyUtil.rightPad;
import static util.MyUtil.leftPad;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyUtil u=new MyUtil();
		String s=u.leftPad("ejb", 15, '^');
		System.out.println(s);
		System.out.println(MyUtil.leftPad("java",10,'#'));
		System.out.println(leftPad("java",10,'#'));
	}

}
