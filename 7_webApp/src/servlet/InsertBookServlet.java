package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;
import dao.BookDAO_Oracle;
import service.BookService;
import service.BookServiceImpl;
import vo.BookVO;

@WebServlet("/insertBook.do")
public class InsertBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		System.out.println("/listBook.do 요청 처리");

		BookDAO dao = new BookDAO_Oracle();
		BookService service = new BookServiceImpl(dao);

		BookVO vo = new BookVO();
		vo.setPrice(Integer.parseInt(request.getParameter("price")));
		vo.setBookname(request.getParameter("bookname"));
		vo.setPublisher(request.getParameter("publisher"));
		try {
			service.addBook(vo);
			response.sendRedirect("listBook.do"); // 기존의 request,response객체 파괴되고 이동, url변화
		} catch (Exception e) {
			request.setAttribute("exception", e);
			getServletContext().getRequestDispatcher("/error.jsp").forward(request, response); //예외 발생시 에러 전용 페이지로 이동
		}

	}

}
