package day17;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book b1 = new Book("java", 900);
		System.out.println(b1);
		if (b1.getTitle() instanceof String)
			System.out.println(((String) b1.getTitle()).charAt(0));
		Book<String, Integer> b2 = new Book<String, Integer>("SQL", 400);
		System.out.println(b2);
		System.out.println(b2.getTitle().charAt(0));
		
		//Object[] obj= {1,2,3};
		Book<?,Integer> b3=new Book<String,Integer>("Spring",4400);
		System.out.println(b3.getTitle());
		Book<?,? extends Number> b4=new Book<String,Integer>("Spring",4400);
		System.out.println(b4.getPrice());
		Book<?,? super Number> b5=new Book<String,Number>("Spring",4400);
		
	}

}
