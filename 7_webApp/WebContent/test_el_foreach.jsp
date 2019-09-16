<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test el foreach</title>
</head>
<body>
	<%
		String[] names = { "홍길동", "고길동" };
		request.setAttribute("listname", names);
	%>

	<c:forEach var="data" items="${listname}">
		<h3>${data}</h3>
	</c:forEach>

	<hr>
	<c:forEach begin="1" end="9" step="2" var="data">
		${data}
	</c:forEach>


	<hr>
	<%=request.getAttribute("listname")%>
	<hr>
	${listname}
	<!-- el표현식. request-session-application 공간 순으로 검색. 없으면 아무것도 표시x -->
	<hr>
	${2+3+6}
	<hr>
	${2 lt 3}
	<!-- lt = less than -->
	<hr>
	<%=request.getParameter("id")%>
	<hr>
	${param.id}
	<!-- param.~ = request.getParameter(~) -->
	<hr>


</body>
</html>