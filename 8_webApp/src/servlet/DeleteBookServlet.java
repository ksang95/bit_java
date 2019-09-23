package servlet;

import java.io.File;
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

//@WebServlet("/deleteBook.do")
public class DeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String[] bookid=request.getParameterValues("bookid");
		String img=request.getParameter("img"); //파일 하나만 삭제할 때, 이미지 하나일 때..
		String fname=img.substring(img.lastIndexOf('/')+1); //이미지 경로에서 파일 이름만 받기
		String path=request.getRealPath("/upload/");
		System.out.println(path+fname);
		File f=new File(path+fname);
		if(f.exists()){
			f.delete(); //업로드된 폴더에서 이미지 파일 삭제
		}
		
		BookDAO dao = new BookDAO_Oracle();
		BookService service = new BookServiceImpl(dao);

		try {
			for(String data:bookid)
				service.deleteBook(Integer.parseInt(data));
			response.sendRedirect("listBook.do");
		}catch(Exception e) {
			request.setAttribute("exception", e);
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}

}
