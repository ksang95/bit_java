package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;
import vo.Dept;

public class DeptDao {

	//Dept 테이블의 모든 레코드 정보
	public List<Dept> getAllDeptRec() {
		String sql="select * from dept order by deptno";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<Dept> list=new ArrayList<Dept>();
		try {
			System.out.println("*****con 할당*****");
			con=JDBCUtil.getConnection();
			ps=con.prepareStatement(sql);
			//? 세팅
			
			//실행 및 결과값 핸들링
			rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new Dept(rs.getInt("deptno"),rs.getString("dname"),rs.getString("loc")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
			System.out.println("*****con 반납*****");
		}
		return list;
	}
		
	public List<Dept> getDeptRec(int page, int n) {
		String sql="select * from ( " + 
				"select rownum row#, deptno, dname, loc " + 
				"from (select * from dept order by deptno) " + 
				") where row# between ? and ?";
		int start=n*(page-1)+1;
		int end=start+n-1;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<Dept> list=new ArrayList<Dept>();
		try {
			con=JDBCUtil.getConnection();
			ps=con.prepareStatement(sql);
			//? 세팅
			ps.setInt(1, start);
			ps.setInt(2, end);
			//실행 및 결과값 핸들링
			rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new Dept(rs.getInt("deptno"),rs.getString("dname"),rs.getString("loc")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		return list;
	}
	
	
	public int insertDept(Dept dept) {

		String sql = "INSERT INTO dept(deptno,dname,loc) VALUES(?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ? 세팅
			ps.setInt(1, dept.getDeptno());
			ps.setString(2, dept.getDname());
			ps.setString(3, dept.getLoc());
			// 실행 및 결과값 핸들링
			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		return result;
	}

	public int updateDept(Dept dept) {

		String sql = "UPDATE dept SET dname=?,loc=? WHERE deptno=?";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ? 세팅
			ps.setString(1, dept.getDname());
			ps.setString(2, dept.getLoc());
			ps.setInt(3, dept.getDeptno());
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
