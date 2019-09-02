<%@page import="vo.UserVO"%>
<%@page import="dao.UserDAO"%>
<%@page import="service.UserServiceImpl"%>
<%@page import="service.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>adduser.jsp</title>
</head>
<body>
	<h3>회 원 가 입 처 리</h3>

	<%
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String role = request.getParameter("role");

		UserDAO dao = new UserDAO();
		UserService service = new UserServiceImpl(dao);
		
		UserVO vo=new UserVO();
		vo.setId(id);
		vo.setName(name);
		vo.setPassword(pw);
		vo.setRole(role);
		int c=service.addUsers(vo);
	%>


	입력정보 :	<%=id%> / <%=pw%> /	<%=name%> / <%=role%> <br />
	<% 
		if(c==0){
	%>
	<h4>회원가입 실패</h4>
	<%
		} else {}
	%>
	

	<a href="index.html">HOME으로</a>
</body>
</html>