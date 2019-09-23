package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/hello", "/hello.do" }, loadOnStartup = 1) //서버 시작하면 요청들어오지 않아도 바로 서블릿 객체 생성
//@WebServlet({ "/hello", "/hello.do" }) //서블릿이 들어오는 이름 마음대로 지정 가능
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HelloServlet() {
        super();
        System.out.println("HelloServlet() 객체 생성");
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() 호출");
	}

	public void destroy() { //웹페이지 실행 중에 코드가 수정되면 destroy 호출되면서 메모리에 떠있던 애가 파괴됨
		System.out.println("destroy() 호출");
	}

/*	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//이미 한번 들어갔던 페이지 다시 들어가면 doGet 호출하여 메모리에 있는 것 이용
		response.setContentType("text/html;charset=utf-8");
		System.out.println("doGet() 호출");
		
		response.getWriter().append("Served at: ").append(request.getContextPath()); //getContextPath: 서블릿 경로(프로젝트경로)
		PrintWriter out = response.getWriter();
		out.print("<h1> HelloServlet page 입니다. </h1>"); //접속한 클라이언트에게 보내는 내용
		String name=request.getParameter("name");
		String id=request.getParameter("id");
		out.print("<h1>"+name+"||"+id+"</h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		System.out.println("doPost() 호출");

		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		out.print("<h1> HelloServlet page 입니다. </h1>");
		String name=request.getParameter("name");
		String id=request.getParameter("id");
		out.print("<h1>"+name+"||"+id+"</h1>");
	}
*/
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get, post 둘다 처리
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		System.out.println("service() 호출");

		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		out.print("<h1> HelloServlet page 입니다. </h1>");
		String name=request.getParameter("name");
		String id=request.getParameter("id");
		out.print("<h1>"+name+"||"+id+"</h1>");
	}

}
