package day21_ex;

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

	public boolean addBook(Book book) {
		return list.add(book);
	}

	public List<Book> bookList() {
		return list;
	}
	
	public List<Book> searchBook(String title) {
		List<Book> slist=new ArrayList<Book>();
		Iterator<Book> it=list.iterator();
		while(it.hasNext()) {
			Book data=it.next();
			if(data.getTitle().toUpperCase().contains(title.toUpperCase())) {
				slist.add(data);
			}
		}
		return slist;
	}

	public boolean deleteBook(String title) {
		boolean flag=false;
		Iterator<Book> it=list.iterator();
		while(it.hasNext()) {
			Book data=it.next();
			if(data.getTitle().equals(title)) {
				System.out.println(data+"=> 삭제됩니다.");
				it.remove();
				flag=true;
			}
		}
		return flag;
	}

}
