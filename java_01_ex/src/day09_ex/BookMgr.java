package day09_ex;

public class BookMgr {

	private Book[] bookList;
	int count = 0;

	public BookMgr() {
		this(10);
		// bookList=new Book[10];
	}

	public BookMgr(int size) {
		bookList = new Book[size];
	}

//	public Book[] getBookList() {
//		return bookList;
//	}

	public void setBookList(Book[] bookList) {
		this.bookList = bookList;
	}

	public void addBook(Book book) {
		if (count == bookList.length) {
			Book[] copy = new Book[bookList.length * 2];
			System.arraycopy(bookList, 0, copy, 0, bookList.length);
			bookList = copy;
		}
		bookList[count++] = book;
	}

	public void bookListPrint() {
		System.out.println("============Book List============");
		for (int i = 0; i < count; i++)
			bookList[i].print();
		// System.out.println("총 "+count+"권");
		System.out.println("=================================");

	}

	public int bookTotalPrice() {
		int sum = 0;
		for (int i = 0; i < count; i++) {
			sum += bookList[i].getPrice();
		}
		return sum;
	}

	public void searchBook(String title) {
		for (Book book : bookList) {
			if (book == null)
				return;
			if (book.getTitle().toUpperCase().contains(title.toUpperCase())) {
				book.print();
			}
		}
		System.out.println("-------------------------------");
	}

	public void deleteBook(String title) {
		for (int i = 0; i < count; i++) {
			if (bookList[i].getTitle().equals(title)) {
				System.out.println(bookList.length);
				System.out.println(i+1);
				System.arraycopy(bookList, i + 1, bookList, i, count - i - 1);
				count--;
				System.out.println(title + " 삭제되었습니다.");
				return;
			}
		}
		System.out.println(title + " 도서가 없습니다.");
	}

}
