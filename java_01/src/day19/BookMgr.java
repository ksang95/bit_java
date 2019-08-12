package day19;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookMgr {

	private List<Book> bookList;
	
	public BookMgr() {
		bookList = new ArrayList<Book>();
	}

//	public Book[] getBookList() {
//		return bookList;
//	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	public void addBook(Book book) {
		if (!bookList.contains(book)) {
			bookList.add(book);
			System.out.printf("Book[%d : %s : %d]를 등록하였습니다.\n", book.getISBN(),book.getTitle(), book.getPrice());	
		}
		else
			System.out.println("동일한 ISBN을 가진 책이 있습니다.");
	}

	public void bookListPrint() {
		System.out.println("============Book List============");
		bookList.forEach(b -> System.out.println(b));
		System.out.println("=================================");

	}

	public void searchBook(String title) {
		Iterator<Book> it = bookList.iterator();
		while (it.hasNext()) {
			Book book = it.next();
			if (book.getTitle().toUpperCase().contains(title.toUpperCase())) {
				System.out.println(book);
			}
		}
		System.out.println("-------------------------------");
	}

	public void deleteBook(String title) {
		Iterator<Book> it = bookList.iterator();
		while (it.hasNext()) {
			Book book = it.next();
			if (book.getTitle().equals(title)) {
				bookList.remove(book);
				System.out.println(title + " 삭제되었습니다.");
				return;
			}
		}

		System.out.println(title + " 도서가 없습니다.");
	}

}
