package day23;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BookMgr {
	//버린것
	List<Book> list = new ArrayList<Book>();
	Set<String> name = new HashSet<String>();

	public BookMgr() {
		list = new ArrayList<Book>();
		name = (Set<String>) MyFile.load("lists.data");
		if (name == null)
			name = new HashSet<String>();
	}

	public BookMgr(List<Book> list) {
		this.list = list;
		name = (Set<String>) MyFile.load("lists.data");
		if (name == null)
			name = new HashSet<String>();
	}

	public void setList(List<Book> list) {
		this.list = list;
	}

	public boolean addBook(Book book) {
		return list.add(book);
	}

	public List<Book> bookListPrint() {
		return list;
	}

	public List<Book> searchBook(String title) {
		List<Book> temp = new ArrayList<Book>();
		Iterator<Book> it = list.iterator();
		while (it.hasNext()) {
			Book data = it.next();
			if (data.getTitle().toUpperCase().contains(title.toUpperCase())) {
				temp.add(data);
			}
		}
		return temp;
	}

	public boolean deleteBook(String title) {
		boolean flag = false;
		Iterator<Book> it = list.iterator();
		while (it.hasNext()) {
			Book data = it.next();
			if (data.getTitle().equals(title)) {
				it.remove();
				flag = true;
			}
		}
		return flag;
	}

	public void saveBook(String f) {
		MyFile.save(f, list);
		name.add(f);
		MyFile.save("lists.data", name);
	}

	public void loadBook(String f) {
		List<Book> miniList = new ArrayList<Book>();
		Object o = null;
		miniList = (List<Book>) MyFile.load(f);
		if (miniList != null)
			list = miniList;

		Iterator<String> it = name.iterator();
		while (it.hasNext()) {
			String data=it.next();
			miniList = (List<Book>) MyFile.load(data);
			if (miniList != null)
				miniList.forEach(i -> {
					if (!(list.contains(i))) {
						list.add(i);
					}
				});
			else {
				it.remove();
				MyFile.save("lists.data", name);
			}
		}
	}

	public int maxIsbn() {
		int max = 0;
		Iterator<Book> it = list.iterator();
		while (it.hasNext()) {
			Book data = it.next();
			if (data.getIsbn() > max)
				max = data.getIsbn();
		}
		return max;
	}

}
