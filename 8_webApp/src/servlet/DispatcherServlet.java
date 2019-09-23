package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.BookDAO;
import dao.BookDAO_Oracle;
import service.BookService;
import service.BookServiceImpl;
import vo.BookVO;

@WebServlet("*.do")
@MultipartConfig(maxFileSize = 1024*1024*5)
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		
		String uri=request.getRequestURI();
		String action= uri.substring(uri.lastIndexOf("/"));
		System.out.println(action);
		if(action.equals("/login.do")) {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");

			System.out.println("/login.do");
			System.out.println(id + "/" + pw);

			if (id == null || pw == null || id.length() == 0 || pw.length() == 0) {
				// response.sendRedirect("./login.jsp"); //redirect - 로그인 불가한 이유를 알려줄 수 없음
				request.setAttribute("msg", "pw 정보를 입력하세요");
				request.setAttribute("id", id);
				request.getRequestDispatcher("login.jsp").forward(request, response); // forwarding
				return;
			}
			if (id.equals("java01") && pw.equals("1234")) {
				HttpSession session = request.getSession();
				session.setAttribute("login", id+"/홍자바");
				request.getRequestDispatcher("index.jsp").forward(request, response);
				
			}else {
				request.setAttribute("msg", "로그인 실패");
				request.setAttribute("id", id);
				
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			return;
		}
		if(action.equals("/listBook.do")) {
			HttpSession session = request.getSession();
			if (session.getAttribute("login") == null) {
				request.setAttribute("msg", "로그인이 필요한 서비스입니다.");
				getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
			} else {

				BookDAO dao = new BookDAO_Oracle();
				BookService service = new BookServiceImpl(dao);

				List<BookVO> list = service.bookList();

				request.setAttribute("booklist", list); // request공간에 데이터 넣기
				String view = "/booklist.jsp";

				getServletContext().getRequestDispatcher(view).forward(request, response); // view 페이지로 forwarding(제어권 넘김,
																							// url변화x), 서블릿에는 ui코드 없음.
			}
			return;
		}
		if(action.equals("/deleteBook.do")) {
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
			return;
		}
		if(action.equals("/logout.do")) {
			HttpSession session=request.getSession();
			if(session!=null) {
				session.invalidate(); //session 객체 파괴->로그인 정보 삭제
			}
			response.sendRedirect("./index.jsp");
			return;
		}
		if(action.equals("/insertBook.do")) {
			BookDAO dao = new BookDAO_Oracle();
			BookService service = new BookServiceImpl(dao);

			BookVO vo = new BookVO();
			vo.setPrice(Integer.parseInt(request.getParameter("price")));
			vo.setBookname(request.getParameter("bookname"));
			vo.setPublisher(request.getParameter("publisher"));
			
			String path=request.getRealPath("/upload/");
			Collection<Part> parts=request.getParts();
			for(Part p:parts) {
				if(p.getContentType()!=null) {
					String fileName=p.getSubmittedFileName();
					if(fileName!=null&&fileName.length()!=0) {
						p.write(path+fileName);
						vo.setImg("./upload/"+fileName);
						System.out.println(vo);
					}
				}
			}
			
			
			try {
				service.addBook(vo);
				response.sendRedirect("listBook.do");
			} catch (Exception e) {
				request.setAttribute("exception", new Exception("등록 데이터 확인후 다시 등록하세요"));
				getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
			}
		}
		 if(action.equals("/search.do")) {
	       	 HttpSession session = request.getSession();
	            String login = (String) session.getAttribute("login");
	            if(login ==  null) {
	            	request.setAttribute("msg", "로그인이 필요한 서비스입니다.");
	            	request.getRequestDispatcher("login.jsp").forward(request, response);
	            	return;
	            }
	            
	    		String condition = request.getParameter("condition");
	    		String keyword = request.getParameter("keyword");
	    		
	    		BookDAO dao = new BookDAO_Oracle();
	    		BookService service = new BookServiceImpl(dao);
	    		List<BookVO> list = service.searchBook(condition, keyword);
	    		
	    		request.setAttribute("booklist", list);
	    		String view ="/booklist.jsp";
	    		
	    		getServletContext().getRequestDispatcher(view).forward(request, response);
	    		
	       	
	       	return;
	       }
	}

}
