package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;
import vo.UserVO;

public class UserDAO {
	public List<UserVO> getUserRec() {
		List<UserVO> list = new ArrayList<UserVO>();
		String sql = "select * from ("
				+ "select rownum row#, id, password, name, role "
				+ "from (select * from users order by id)"
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
				UserVO vo = new UserVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setPassword(rs.getString("password"));
				vo.setRole(rs.getString("role"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		return list;
	}

	public List<UserVO> getUserRec(int page, int n) {
		List<UserVO> list = new ArrayList<UserVO>();
		String sql = "select * from ("
				+ "select rownum row#, id, password, name, role "
				+ "from (select * from users order by id)"
				+ ") where row# between ? and ?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int start = (page - 1) * n + 1;
		int end = start + n - 1;

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ? 세팅
			ps.setInt(1, start);
			ps.setInt(2, end);
			// 실행 및 결과값 핸들링
			rs = ps.executeQuery();
			while (rs.next()) {
				UserVO vo = new UserVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setPassword(rs.getString("password"));
				vo.setRole(rs.getString("role"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		return list;
	}

	public UserVO loginUsers(UserVO vo) {
		String sql = "select * from users where id=? and password=?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserVO data = null;
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ? 세팅
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPassword());
			// 실행 및 결과값 핸들링
			rs = ps.executeQuery();
			if (rs.next()) {
				data = new UserVO();
				data.setId(rs.getString("id"));
				data.setName(rs.getString("name"));
				data.setPassword(rs.getString("password"));
				data.setRole(rs.getString("role"));
			} else {
				System.out.println("로그인 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		return data;
	}

	public int insertUsers(UserVO vo) {
		String sql = "insert into users(id,password,name,role) values(?,?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ? 세팅
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPassword());
			ps.setString(3, vo.getName());
			ps.setString(4, vo.getRole());
			// 실행 및 결과값 핸들링
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		return result;
	}

	public int deleteUsers(String id) {
		String sql = "delete from users where id=?";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ? 세팅
			ps.setString(1, id);
			// 실행 및 결과값 핸들링
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		return result;
	}

	public int updateUsers(UserVO vo) {
		String sql = "update users set password=?,name=?,role=? where id=?";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ? 세팅
			ps.setString(1, vo.getPassword());
			ps.setString(2, vo.getName());
			ps.setString(3, vo.getRole());
			ps.setString(4, vo.getId());
			// 실행 및 결과값 핸들링
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		return result;
	}
}
