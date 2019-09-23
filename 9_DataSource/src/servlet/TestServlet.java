package servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/test.do")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DataSource dataSource = null;
		try {
			InitialContext context=new InitialContext();
			dataSource=(DataSource)context.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataSource.getConnection(); //connection을 서버단에서 관리
			System.out.println("Connection "+con);
		} catch (Exception e) {

		}
	}

}
