package day19_ex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class BookMgr {

	//private Book[] bookList;
	//int count = 0;
	List<Book> list=null;
	
	public BookMgr() {
		//list=new LinkedList<Book>();
		//list=new Vector<Book>();
		list=new ArrayList<Book>();
	}

	public BookMgr(List<Book> list) {
		 this.list=list;
	}

	public void addBook(Book book) {
		list.add(book);
	}

	public void bookListPrint() {
		Collections.sort(list);
		System.out.println("============Book List============");
		list.forEach(i->System.out.println(i));
		System.out.println("=================================");

	}
	
	public void searchBook(String title) {
		System.out.println(title+ " 검색");
		Iterator<Book> it=list.iterator();
		while(it.hasNext()) {
			Book data=it.next();
			if(data.getTitle().toUpperCase().contains(title.toUpperCase())) {
				System.out.println(data);
			}
		}
		System.out.println("-------------------------------");
	}

	public void deleteBook(String title) {
		Iterator<Book> it=list.iterator();
		while(it.hasNext()) {
			Book data=it.next();
			if(data.getTitle().equals(title)) {
				System.out.println(data+"=> 삭제됩니다.");
				it.remove();
			}
		}
	}

}
