package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;
import vo.BoardVO;

public class BoardDAO {
	public List<BoardVO> getBoardRec() {
		List<BoardVO> list = new ArrayList<BoardVO>();
		String sql = "select * from ("
				+ "select rownum row#,seq,title,content,regdate,cnt,id "
				+ "from (select * from board order by seq)"
				+ ") where row# between ? and ?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ? 세팅
			ps.setInt(1, 1);
			ps.setInt(2, 5);
			// 실행 및 결과값 핸들링
			rs = ps.executeQuery();
			while (rs.next()) {
				BoardVO vo=new BoardVO();
				vo.setSeq(rs.getInt("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setRegdate(rs.getDate("regdate"));
				vo.setCnt(rs.getInt("cnt"));
				vo.setId(rs.getString("id"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		return list;
	}
	
	public List<BoardVO> getBoardRec(int page, int n) {
		List<BoardVO> list = new ArrayList<BoardVO>();
		String sql = "select * from ("
				+ "select rownum row#,seq,title,content,regdate,cnt,id "
				+ "from (select * from board order by seq)"
				+ ") where row# between ? and ?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int start=(page-1)*n+1;
		int end=start+n-1;
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ? 세팅
			ps.setInt(1, start);
			ps.setInt(2, end);
			// 실행 및 결과값 핸들링
			rs = ps.executeQuery();
			while (rs.next()) {
				BoardVO vo=new BoardVO();
				vo.setSeq(rs.getInt("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setRegdate(rs.getDate("regdate"));
				vo.setCnt(rs.getInt("cnt"));
				vo.setId(rs.getString("id"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		return list;
	}
	
	public int insertBoard(BoardVO vo) {
		String sql = "insert into board(seq,title,content,regdate,id) "
				+ "values((select nvl(max(seq),0)+1 from board),?,?,sysdate,?)";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			con=JDBCUtil.getConnection();
			ps=con.prepareStatement(sql);
			//? 세팅
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getContent());
			ps.setString(3, vo.getId());
			//실행 및 결과값 핸들링
			result=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		return result;
	}
	
	public int deleteBoard(int seq) {
		String sql = "delete from board where seq=?";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			con=JDBCUtil.getConnection();
			ps=con.prepareStatement(sql);
			//? 세팅
			ps.setInt(1, seq);
			//실행 및 결과값 핸들링
			result=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		return result;
	}
	
	public int updateBoard(BoardVO vo) {
		String sql = "update board set title=?,content=? where seq=?";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			con=JDBCUtil.getConnection();
			ps=con.prepareStatement(sql);
			//? 세팅
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getContent());
			ps.setInt(3, vo.getSeq());
			//실행 및 결과값 핸들링
			result=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		return result;
	}
	
	public List<BoardVO> searchBoard(String word) {
		List<BoardVO> list = new ArrayList<BoardVO>();
		String sql = "select * from ("
				+ "select rownum row#,seq,title,content,regdate,cnt,id "
				+ "from (select * from board "
				+ "where (upper(title) like upper('%'||?||'%'))"
				+ "or upper(content) like upper('%'||?||'%') "
				+ "order by seq)"
				+ ") where row# between ? and ?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ? 세팅
			ps.setString(1, word);
			ps.setString(2, word);
			ps.setInt(3, 1);
			ps.setInt(4, 5);
			// 실행 및 결과값 핸들링
			rs = ps.executeQuery();
			while (rs.next()) {
				BoardVO vo=new BoardVO();
				vo.setSeq(rs.getInt("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setRegdate(rs.getDate("regdate"));
				vo.setCnt(rs.getInt("cnt"));
				vo.setId(rs.getString("id"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		return list;
	}
	
	public int countBoard() {
		List<BoardVO> list = new ArrayList<BoardVO>();
		String sql = "select count(*) from board";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count=0;
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ? 세팅
			// 실행 및 결과값 핸들링
			rs = ps.executeQuery();
			while (rs.next()) {
				count=rs.getInt("count(*)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		return count;
	}	
	
	public List<BoardVO> searchTitle(String title) {
		List<BoardVO> list = new ArrayList<BoardVO>();
		String sql = "select * from ("
				+ "select rownum row#,seq,title,content,regdate,cnt,id "
				+ "from (select * from board "
				+ "where upper(title) like upper('%'||?||'%') order by seq)"
				+ ") where row# between ? and ?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ? 세팅
			ps.setString(1, title);
			ps.setInt(2, 1);
			ps.setInt(3, 5);
			// 실행 및 결과값 핸들링
			rs = ps.executeQuery();
			while (rs.next()) {
				BoardVO vo=new BoardVO();
				vo.setSeq(rs.getInt("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setRegdate(rs.getDate("regdate"));
				vo.setCnt(rs.getInt("cnt"));
				vo.setId(rs.getString("id"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		return list;
	}
	
	public List<BoardVO> searchId(String id) {
		List<BoardVO> list = new ArrayList<BoardVO>();
		String sql = "select * from ("
				+ "select rownum row#,seq,title,content,regdate,cnt,id "
				+ "from (select * from board "
				+ "where id=? order by seq)"
				+ ") where row# between ? and ?";
		//select * from (select rownum row#,seq,title,content,regdate,cnt,id from (select * from board where id='sql' order by seq)) where row# between 1 and 5
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ? 세팅
			ps.setString(1, id);
			ps.setInt(2, 1);
			ps.setInt(3, 5);
			// 실행 및 결과값 핸들링
			rs = ps.executeQuery();
			while (rs.next()) {
				BoardVO vo=new BoardVO();
				vo.setSeq(rs.getInt("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setRegdate(rs.getDate("regdate"));
				vo.setCnt(rs.getInt("cnt"));
				vo.setId(rs.getString("id"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		return list;
	}
}
