package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.JDBCUtil;
import vo.Dept;
import vo.Employee;

public class Test09_update {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Emp9 emp = new Emp9();
		Employee e=new Employee();
		e.setEmpno(7777);
		e.setSal(5000);
		int count=emp.updateEmp(e);
		System.out.println(count+" : update");
		Dept d=new Dept();
		d.setDeptno(50);
		d.setDname("기술부");
		d.setLoc("제주도");
		count=emp.updateDept(d);
		System.out.println(count+" => 갱신");
	}

}

class Emp9 {
	public int updateEmp(Employee emp) {

		String sql = "UPDATE emp SET sal=? WHERE empno=?";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ? 세팅
			ps.setInt(1, emp.getSal());
			ps.setInt(2, emp.getEmpno());
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
			con=JDBCUtil.getConnection();
			ps=con.prepareStatement(sql);
			//? 세팅
			ps.setString(1, dept.getDname());
			ps.setString(2, dept.getLoc());
			ps.setInt(3, dept.getDeptno());
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