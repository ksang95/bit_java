package day09;

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

	public int searchBook(String title) {
		for (int i = 0; i < count; i++) {
			if (title.equalsIgnoreCase(bookList[i].getTitle())) {
				return i;
			}
		}
		return -1;
	}

	public Book deleteBook(int index) {
		Book book = bookList[index];
		for (int j = index + 1; j < count; j++) {
			bookList[j - 1] = bookList[j];
		}
		bookList[count - 1] = null;
		count--;

		return book;
	}

}
