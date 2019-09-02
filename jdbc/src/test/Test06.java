package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.JDBCUtil;

public class Test06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Emp6.searchEname("s");
		System.out.println("-------------------------");
		Emp6.searchEname("S");

	}

}

class Emp6 {
	public static void searchEname(String ename) {
		//String sql = "SELECT * FROM emp WHERE lower(ename) LIKE lower('%'||?||'%')";
		//String sql = "SELECT * FROM emp WHERE lower(ename) LIKE '%'||lower(?)||'%'";
		String sql = "SELECT * FROM emp WHERE lower(ename) LIKE ?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ? 세팅
			ps.setString(1, "%"+ename.toLowerCase()+"%");

			// 실행 및 결과값 핸들링
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.print(rs.getInt("empno") + "  ");
				System.out.print(rs.getString("ename") + "  ");
				System.out.print(rs.getString("job") + "  ");
				System.out.print(rs.getInt("sal") + "  ");
				System.out.print(rs.getInt("comm") + "  ");
				System.out.print(rs.getDate("hiredate") + "  ");
				System.out.print(rs.getInt("deptno") + "  ");
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
	}
}