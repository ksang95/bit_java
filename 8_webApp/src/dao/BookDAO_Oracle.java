package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;
import vo.BookVO;

public class BookDAO_Oracle extends BookDAO{
	public List<BookVO> searchBook(String condition, String keyword){
 		String sql =
 				"select * from ( "+
 					   "select rownum row#,bookid, bookname, publisher, price , img "+
 					   "from (select * from Book where "+condition+" like '%'||?||'%' " +"order by bookid desc) "+ 
 					    ") where row# between ? and ? ";
 					    		
 					    		
 		List<BookVO> list = new ArrayList<BookVO>();
 		
 		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ? 세팅
			ps.setString(1, keyword);
			ps.setInt(2, 1);
			ps.setInt(3, 5);
			
			//실행 및 결과값 핸들링
            rs = ps.executeQuery();
            while (rs.next()) {
				BookVO vo = new BookVO();
				vo.setBookid(rs.getInt("bookid"));
				vo.setBookname(rs.getString("bookname"));
				vo.setPublisher(rs.getString("publisher"));
				vo.setPrice(rs.getInt("price"));
				vo.setImg(rs.getString("img"));
				list.add(vo);
			}
            
		}catch (Exception e) {
           e.printStackTrace();
		}finally {
			JDBCUtil.close(con, ps, rs);
		}
 		return list;
	}
	
	
	public List<BookVO> getBookRec(){
		String sql=
				"select * from ( "
				+ "select rownum row#,bookid,bookname,publisher,price,img "
				+ "from (select * from book order by bookid desc) "
				+ ") where row# between ? and ?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<BookVO> list=new ArrayList<BookVO>();
		try {
			con=JDBCUtil.getConnection();
			ps=con.prepareStatement(sql);
			//? 세팅
			ps.setInt(1, 1);
			ps.setInt(2, 5);
			//실행 및 결과값 핸들링
			rs=ps.executeQuery();
			while(rs.next()) {
				BookVO vo=new BookVO();
				vo.setBookid(rs.getInt("bookid"));
				vo.setBookname(rs.getString("bookname"));
				vo.setPublisher(rs.getString("publisher"));
				vo.setPrice(rs.getInt("price"));
				vo.setImg(rs.getString("img"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		return list;
	}
	
	public List<BookVO> getBookRec(int page, int n){
		String sql="select * from ("
				+ "select rownum row#,bookid,bookname,publisher,price "
				+ "from (select * from book order by bookid)) "
				+ "where row# between ? and ?";
		int start=(page-1)*n+1;
		int end=start+n-1;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<BookVO> list=new ArrayList<BookVO>();
		try {
			con=JDBCUtil.getConnection();
			ps=con.prepareStatement(sql);
			//? 세팅
			ps.setInt(1, start);
			ps.setInt(2, end);
			//실행 및 결과값 핸들링
			rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new BookVO(rs.getInt("bookid"),rs.getString("bookname"),rs.getString("publisher"),rs.getInt("price")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		return list;
	}
	
	public int insertBook(BookVO book) throws Exception {
		String sql = "insert into book(bookid,bookname,publisher,price,img) values((select nvl(MAX(bookid),0)+1 from book),?,?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con=JDBCUtil.getConnection();
			ps=con.prepareStatement(sql);
			//? 세팅
			ps.setString(1, book.getBookname());
			ps.setString(2,book.getPublisher());
			ps.setInt(3,book.getPrice());
			ps.setString(4, book.getImg());
			//실행 및 결과값 핸들링
			result=ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		return result;
	}
	
	public int deleteBook(int bookid) {
		String sql = "delete from book where bookid=?";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			con=JDBCUtil.getConnection();
			ps=con.prepareStatement(sql);
			//? 세팅
			ps.setInt(1, bookid);
			//실행 및 결과값 핸들링
			result=ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		return result;
	}
	
	public int updateBook(BookVO book) {
		String sql = "update book set price=? where bookid=?";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			con=JDBCUtil.getConnection();
			ps=con.prepareStatement(sql);
			//? 세팅
			ps.setInt(1, book.getPrice());
			ps.setInt(2, book.getBookid());
			//실행 및 결과값 핸들링
			result=ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		return result;
	}
	
}
