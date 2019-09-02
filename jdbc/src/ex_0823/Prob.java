package ex_0823;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.JDBCUtil;

public class Prob {

	private static void show(int DEPARTMENT_ID) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="SELECT d.dname as 부서명, AVG(sal) as 평균급여 FROM emp e JOIN dept d ON e.deptno=d.deptno WHERE d.deptno= ? GROUP BY d.deptno, dname";
		String deptno=Integer.toString(DEPARTMENT_ID);
		try {
			con=JDBCUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, deptno);
			rs=ps.executeQuery();
			if(rs.next()) {
				System.out.print(rs.getString("부서명")+"\t");
				System.out.print(rs.getDouble("평균급여")+"\n");
			} else
				System.out.println("해당 부서번호가 없습니다.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			JDBCUtil.close(con, ps, rs);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		show(10);
		System.out.println("============================");
		show(50);
	}

}
