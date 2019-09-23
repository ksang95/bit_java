<%@page import="vo.BookVO"%>
<%@page import="java.util.List"%>
<%@page import="service.BookServiceImpl"%>
<%@page import="dao.BookDAO_Oracle"%>
<%@page import="service.BookService"%>
<%@page import="dao.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>book list</title>
<link type="text/css" rel="stylesheet" href="./css/table.css">
</head>
<body>
	<h3>book list</h3>
	<table class="tablea">
	<tr><th>bookid</th><th>bookname</th><th>publisher</th><th>price</th></tr>
	
	<%
//		BookDAO dao = new BookDAO_Oracle();
//		BookService service = new BookServiceImpl(dao);
//		List<BookVO> list = service.bookList();
		List<BookVO> list=(List<BookVO>)request.getAttribute("booklist"); //request 공유 영역에서 데이터 꺼내기->캐스팅, jsp에는 db연동코드없음
		for(BookVO data:list){
	%>
	<tr>
		<td><%=data.getBookid() %></td>
		<td><%=data.getBookname() %></td>
		<td><%=data.getPublisher() %></td>
		<td><%=data.getPrice() %></td>
	</tr>
	<%} %>
	</table>
	
</body>
</html>