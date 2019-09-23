package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;
import vo.BookVO;

public class BookDAO {
	
	public List<BookVO> getBookRec(){
		return null;
	}
	
	public List<BookVO> getBookRec(int page, int n){
		return null;
	}
	
	public int insertBook(BookVO book) throws Exception {
		return 0;
	}
	
	public int deleteBook(int bookid) {
		return 0;
	}
	
	public int updateBook(BookVO book) {
		return 0;
	}
	
	public List<BookVO> searchBook(String condition, String keyword){
		return null;
	}
	
}
