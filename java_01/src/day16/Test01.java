package day16;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(" main start ");
		int a = 10, b = 10;
		try {
			System.out.println(1);
			System.out.println(a / b); //throw new ArithmeticException() 예외 발생
			System.out.println(2);
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
			System.out.println(3);
		} finally {
			System.out.println("항상수행");
		}
		System.out.println(" main end ");
	}

}
