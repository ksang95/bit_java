package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.JDBCUtil;

public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int deptno = 10;
		if (args.length != 0) {
			deptno = Integer.parseInt(args[0]);
		}
		String sql = "select * from emp where deptno=" + deptno;

		System.out.println("******* JDBC TEST *******");

		Connection con = null;
		Statement st = null;
		ResultSet rs = null; // select 결과값
		int result = 0; // dml 결과값

		try {
			con = JDBCUtil.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.print(rs.getInt("empno") + "\t"); // 대응되는 타입으로 가져올수있음
				System.out.print(rs.getString("ename") + "\t");
				System.out.print(rs.getString("job") + "\t");
				System.out.print(rs.getString("mgr") + "\t");
				System.out.print(rs.getDate("hiredate") + "\t");
				System.out.print(rs.getString("sal") + "\t");
				System.out.print(rs.getString("comm") + "\t");
				System.out.print(rs.getString("deptno") + "\n");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(con, st, rs);
		}

		System.out.println("********** END **********");
	}

}
