package day24;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class BookMgr {
	// Book[] 관리
	List<Book> list = null;
	String fileName;

	BookMgr() {
		this("book.dat");
	}

	BookMgr(String fileName) {
		this.fileName = fileName;
		list = (List<Book>) MyFile.load(fileName);
		if (list == null) {
			list = new ArrayList<Book>();
		}
	}

	// CURD

	public boolean add(Book book) {
		boolean flag = true;
		Iterator<Book> it = list.iterator();
		while (it.hasNext()) {
			Book data = it.next();
			if (data.getTitle().equals(book.getTitle())) {
				flag = false;
			}
		}
		if (flag)
			list.add(book);
		return flag;
	}

	public boolean delete(String title) {
		boolean flag = false;
		Iterator<Book> it = list.iterator();
		while (it.hasNext()) {
			Book data = it.next();
			if (data.getTitle().equals(title)) {
				System.out.println(data + "=> 삭제됩니다.");
				it.remove();
				flag = true;
			}
		}
		return flag;
	}

	public List<Book> search(String title) {
		List<Book> slist = new ArrayList<Book>();
		Iterator<Book> it = list.iterator();
		while (it.hasNext()) {
			Book data = it.next();
			if (data.getTitle().toUpperCase().contains(title.toUpperCase())) {
				slist.add(data);
			}
		}
		return slist;

	}

	public List<Book> getBookList() {
		return list;
	}

	public void save() {
		MyFile.save(fileName, list);
	}
}
