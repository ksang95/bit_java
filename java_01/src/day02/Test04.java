package day02;

public class Test04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("byte type max value => "+Byte.MAX_VALUE);
		System.out.println("int type max value => "+Integer.MAX_VALUE);
		System.out.println("long type max value => "+Long.MAX_VALUE);
		
		char c='a';
		System.out.println(c+" 숫자니? "+Character.isDigit(c));
		
		int s1=Integer.parseInt("1")+Integer.parseInt("1");
		System.out.println(s1);
	}

}
