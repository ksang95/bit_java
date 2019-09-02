package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import util.JDBCUtil;

public class Test05_login2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("  로그인 처리    ");

		Connection con = null;
		Statement st = null; // ? 처리 안된다
		PreparedStatement ps=null; // ? 처리 가능
		ResultSet rs = null;
		
		String id="html";
		String pw="1111";
		//String sql = "select * from users where id='"+id+"' and password='"+pw+"'"; //보안상 취약
		String sql = "select * from users where id= ? and password= ?"; //보안상 안전+성능좋음
		
		try {
			con=JDBCUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				System.out.println(rs.getString("id")+" 님 로그인되었습니다.");
				System.out.printf("%s / %s", rs.getString("id"),rs.getString("name"));
			}else {
				System.out.println("로그인 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}

	}

}
