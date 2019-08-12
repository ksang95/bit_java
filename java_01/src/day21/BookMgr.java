package day21;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookMgr {
	FileInputStream fis = null;
	FileOutputStream fos = null;
	ObjectInputStream ois = null;
	ObjectOutputStream oos = null;
	List<Book> list = null;

	public BookMgr() {
		list = new ArrayList<Book>();
	}

	public BookMgr(List<Book> list) {
		this.list = list;
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

	public boolean saveBook(String f) {
		boolean flag = false;
		try {
			fos = new FileOutputStream(f + ".dat");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
			oos.flush();
			flag = true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} finally {
			try {
				if (fos != null)
					fos.close();
				if (oos != null)
					oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}

	public boolean loadBook(String f) {
		boolean flag = false;
		try {
			fis = new FileInputStream(f + ".dat");
			ois = new ObjectInputStream(fis);
			list = (List<Book>) ois.readObject();
			flag = true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} finally {
			try {
				if (fis != null)
					fis.close();
				if (ois != null)
					ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}

	public int maxIsbn() {
		int max = 0;
		Iterator<Book> it=list.iterator();
		while(it.hasNext()) {
			Book data=it.next();
			if(data.getIsbn()>max)
				max=data.getIsbn();
		}
		return max;
	}

}
