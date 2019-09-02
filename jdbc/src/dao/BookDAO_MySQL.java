package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;
import vo.BookVO;

public class BookDAO_MySQL extends BookDAO {

	public List<BookVO> getBookRec() {
		System.out.println("BookDAO_MySQL getBookRec");
		List<BookVO> list=new ArrayList<BookVO>();
		return list;
	}

	public List<BookVO> getBookRec(int page, int n) {
		System.out.println("BookDAO_MySQL getBookRec");
		List<BookVO> list=new ArrayList<BookVO>();
		return list;
	}

	public int insertBook(BookVO book) {
		System.out.println("BookDAO_MySQL insertBook");
		return 0;
	}

	public int deleteBook(int bookid) {
		System.out.println("BookDAO_MySQL deleteBook");
		return 0;
	}

	public int updateBook(BookVO book) {
		System.out.println("BookDAO_MySQL updateBook");
		return 0;
	}

}
