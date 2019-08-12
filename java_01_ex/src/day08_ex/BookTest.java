package day08_ex;

import java.util.Arrays;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookMgr mgr = new BookMgr(5);
		mgr.addBook(new Book("빨강머리 앤", 5000));
		mgr.addBook(new Book("은노기의 JSP 웹 프로그래밍 입문", 28000));
		mgr.addBook(new Book("명품 JAVA 프로그래밍", 30000));
		mgr.addBook(new Book("html", 25000));
		mgr.addBook(new Book("db", 25000));
		mgr.addBook(new Book("sql", 25000));
//		System.out.println(Arrays.toString(mgr.getBookList()));

		/*
		 * for (Book data : mgr.getBookList()) { if (data != null) data.print(); }
		 * Book[]b=mgr.getBookList(); for(int i=0; i<b.length; i++) { b[i].print(); }
		 */
		mgr.bookListPrint();
		System.out.println("총 가격: "+mgr.bookTotalPrice());
	}

}
