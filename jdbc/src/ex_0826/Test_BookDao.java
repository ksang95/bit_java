package ex_0826;


public class Test_BookDao {
	public static void main(String[] args) {
		BookDao bd=new BookDao();
		bd.insertBook(new Book(3,"ball","출판",5000));
		bd.getAllBookRec().forEach(i->System.out.println(i));
		System.out.println("-----------------------");
		bd.updateBook(new Book(3,"ball","출판사",5500));
		bd.getAllBookRec().forEach(i->System.out.println(i));
		System.out.println("-----------------------");
		bd.deleteBook(3);
		bd.getAllBookRec().forEach(i->System.out.println(i));
	}
}
