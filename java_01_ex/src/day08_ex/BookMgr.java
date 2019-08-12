package day08_ex;

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
		if (count == bookList.length){
			Book[] copy = new Book[bookList.length * 2];
			System.arraycopy(bookList, 0, copy, 0, bookList.length);
			bookList = copy;
		}
		bookList[count++] = book;
	}
	public void bookListPrint() {
		for (int i=0; i<count; i++)
			bookList[i].print();
	}
	public int bookTotalPrice() {
		int sum=0;
		for(int i=0; i<count; i++) {
			sum+=bookList[i].getPrice();
		}
		return sum;
	}

}
