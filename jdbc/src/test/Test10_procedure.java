package test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import util.JDBCUtil;

public class Test10_procedure {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//execute InsertBook(1,'java~~~','한빛',27000);
		String sql = "{call InsertBook(?,?,?,?)}";
		Connection con = null;
		CallableStatement ps = null;

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareCall(sql);
			// ? 세팅
			ps.setInt(1, 2);
			ps.setString(2, "JSP");
			ps.setString(3, "홍길동");
			ps.setInt(4, 23000);
			// 실행 및 결과값 핸들링
			ps.execute();
			System.out.println("call InsertBook 수행");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
	}

}
