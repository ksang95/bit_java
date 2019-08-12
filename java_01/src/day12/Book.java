package day12;

public class Book {

	private String title;
	private int price;

	public Book() {
	}

	public Book(int price, String title) {
		this.title = title;
		this.price = price;

	}

	public Book(String title, int price) {
		this.title = title;
		this.price = price;

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;

	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void print() {
		System.out.printf("Book[%s : %7d]\n", title, price);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[제목: ");
		sb.append(title);
		sb.append(", 가격: ");
		sb.append(price);
		sb.append("]");
		return sb.toString();
	}

	public boolean equals(Object o) {
//		if(!(o instanceof Book))
//				System.out.println("!");
//		else
//			System.out.println("?");
		if (o != null && o instanceof Book) {
			Book b = (Book) o;
			if (title.equals(b.title) && price == b.price)
				return true;
		}
		return false;
	}
	
	@Override
	protected void finalize() throws Throwable{
		//객체가 소멸되기 직전에 호출되는 메소드
		System.out.println("자원 반납 코드~~~~");
	}
	
	public void close() {
		System.out.println("close() 자원 반납 코드~~~~");
	}

}