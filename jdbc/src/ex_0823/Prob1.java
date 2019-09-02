package ex_0823;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.JDBCUtil;

public class Prob1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Emp.show(10);
		System.out.println("============================");
		Emp.show(50);
	}

}

class Emp {
	public static void show(int deptno) {
		String sql = "SELECT ROUND(AVG(sal),2) as \"부서별 평균 급여\" FROM emp e WHERE deptno= ?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, deptno);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(deptno + " 부서");
				System.out.println(rs.getString("부서별 평균 급여"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(con, ps, rs);
		}

	}
}