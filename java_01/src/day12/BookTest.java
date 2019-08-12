package day12;


public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String msg1="hello";
		String msg2="hello";
		System.out.println(msg1);
		System.out.println(msg2);
		System.out.println(msg1.equals(msg2));
		
		Book b1=new Book("Java",700);
		Book b2=new Book("Java",700);
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b1.equals(b2));
		//msg2=null;
		//b2=null;
		//System.out.println(b1.equals(b2));
		//System.out.println(b1.equals(null));
		//System.out.println(b1.equals(msg2));
		b1.close();
		b2.close();
		b1=null;
		b2=null;
		System.gc();
		System.out.println("=== main end ===");
	}

}
