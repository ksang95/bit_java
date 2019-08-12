package day19_ex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public class BookMgr2 {

	// private Book[] bookList;
	// int count = 0;
	Map<Integer, Book> map = null;

	public BookMgr2() {
		// list=new LinkedList<Book>();
		// list=new Vector<Book>();
		map = new HashMap<Integer, Book>();
	}

	public void addBook(Book book) {
		map.put(book.getIsbn(), book);
	}

	public void bookListPrint() {

		System.out.println("============Book List============");
		/*map.forEach(new BiConsumer<Integer, Book>() {

			@Override
			public void accept(Integer key, Book value) {
				// TODO Auto-generated method stub
				System.out.println(key + " : " + value);
			}
		});*/
		//map.forEach((Integer k, Book v) -> System.out.println(k + " : " + v));
		map.forEach((k, v) -> System.out.println(v));
		System.out.println("=================================");

	}

	public void searchBook(String title) {
		System.out.println(title + " 검색");
		Iterator<Integer> it = map.keySet().iterator();
		while (it.hasNext()) {
			Integer isbn = it.next();
			Book data = map.get(isbn);
			if (data.getTitle().toUpperCase().contains(title.toUpperCase())) {
				System.out.println(data);
			}
		}
		System.out.println("-------------------------------");
	}

	public void deleteBook(String title) {
		Iterator<Integer> it = map.keySet().iterator();
		while (it.hasNext()) {
			Integer isbn = it.next();
			Book data = map.get(isbn);
			if (data.getTitle().equals(title)) {
				System.out.println(data + " 삭제됩니다.");
				// map.remove(isbn);
				it.remove();
			}
		}
	}

}
