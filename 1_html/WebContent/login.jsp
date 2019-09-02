<%@ page import="vo.UserVO, dao.UserDAO, service.UserService, service.UserServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
</head>
<body>
<h3> login 처리</h3>


<!-- java code 영역 -->
<%
	String id=request.getParameter("id");
	String pw=request.getParameter("pw");
	
	UserDAO dao=new UserDAO();
	UserService service=new UserServiceImpl(dao);
	
	UserVO vo=new UserVO();
	vo.setId(id);
	vo.setPassword(pw);
	
	UserVO data=service.login(vo);
	
%>

입력 정보: <%=id %>/<%=pw %><br/>
로그인 정보: <%=data %><br/>

<a href="index.html">Home으로</a>
</body>
</html>