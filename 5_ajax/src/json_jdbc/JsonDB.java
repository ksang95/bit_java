package json_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import util.JDBCUtil;

public class JsonDB {
	/*
	public static void main(String[] args) {
		System.out.println(getJsonDept("20"));
		System.out.println("================");
		System.out.println(getALLJsonDept());
	}
	*/
	
	public static String idCheck(String id) {
		String sql = "select * from users where id=?";
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Map<String, String> map = new HashMap<String, String>();
		try {
			con= JDBCUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				map.put("id", rs.getString("id"));
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		
		
		return JSONObject.toJSONString(map); //map을 json 객체 형태의 String으로
	}
	
	public static String getALLJsonDept() {
		String sql = "select * from dept";
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		JSONArray array=new JSONArray();
		Map<String, String> map = new HashMap<String, String>();
		try {
			con= JDBCUtil.getConnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				map.put("deptno", rs.getString("deptno"));
				map.put("dname", rs.getString("dname"));
				map.put("loc", rs.getString("loc"));
				JSONObject obj=new JSONObject(map); //map을 JSON 객체로
				array.add(obj); //JSON 배열에 JSON 객체 하나씩 추가
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		
		
		return JSONArray.toJSONString(array); //JSON 배열을 String으로
	}
	
	public static String getJsonDept(String deptno) {
		String sql = "select * from dept where deptno=?";
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Map<String, String> map = new HashMap<String, String>();
		try {
			con= JDBCUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, deptno);
			rs=ps.executeQuery();
			while(rs.next()) {
				map.put("deptno", rs.getString("deptno"));
				map.put("dname", rs.getString("dname"));
				map.put("loc", rs.getString("loc"));
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		
		
		return JSONObject.toJSONString(map); //map을 json 객체 형태의 String으로
	}
	
	public String temp(String deptno) {
		String sql = "select * from dept where deptno=?";
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			con= JDBCUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, deptno);
			rs=ps.executeQuery();
			while(rs.next()) {
				
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		
		
		return "";
	}
}
