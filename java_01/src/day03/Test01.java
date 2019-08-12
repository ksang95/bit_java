package day03;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num1=99;
		int num2=99;
		String name1="홍길동";
		String name2="홍길동";
		String msg1=new String("Hello");
		String msg2=new String("Hello");
		System.out.println("num1==num2 => "+(num1==num2));
		//System.out.println("name1==name2 => "+(name1==name2));
		System.out.println("name1==name2 => "+name1.equals(name2));
		System.out.println("msg1==msg2 => "+msg1.equals(msg2));
	}

}
