package day17;

public class Test01 {
	public static void main(String[] args) {
		Book1 b1=new Book1("java",900);
		System.out.println(b1);
		//Book<String> b2=new Book("sql","700");
		Book1<Double> b2=new Book1<Double>("sql",700.0);
		System.out.println(b2);
	}
}
