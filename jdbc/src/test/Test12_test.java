package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import util.JDBCUtil;

public class Test12_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sname=JOptionPane.showInputDialog("검색할 부서명 입력");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql="select * from dept where lower(dname) like lower('%'||?||'%')";
			con=JDBCUtil.getConnection();
			ps=con.prepareStatement(sql);
			//? 세팅
			ps.setString(1, sname);
			//실행 및 결과값 핸들링
			rs=ps.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getString("dname")+" ");
				System.out.print(rs.getString("deptno")+" ");
				System.out.print(rs.getString("loc")+"\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
	}

}
