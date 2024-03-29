<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/prob1.css">
<link rel="stylesheet" href="css/table.css">
<style type="text/css">
.bookimg {
	width: 50px;
	height: 70px;
}
</style>

<script type="text/javascript">
	function f1() {
		return confirm("정말 삭제할거니?");
	}
</script>
</head>
<body>
	<%@include file="common/header.jsp"%>
	<div id="output">
		<section>
			<form action="${pageContext.request.contextPath}/search.do"
				method="post">
				<table>
					<tr>
						<td>
						<select name="condition">
								<option value="bookname">도서제목</option>
								<option value="publisher">출판사</option>
						</select>
						<input type="text" name="keyword">
						<input type="submit" value="검색">
						</td>
					</tr>
				</table>
			</form>
			<hr>
			<h3>book list</h3>
			<form action="deleteBook.do" method="get">
				<table class="tablea">
					<tr>
						<th>bookid</th>
						<th>bookname</th>
						<th>publisher</th>
						<th>price</th>
						<th>img</th>
						<th><input type="submit" id="del" value="삭제"
							onclick="return f1()"></th>
					</tr>
					<c:forEach var="data" items="${booklist}">
						<tr>
							<td>${data.bookid}</td>
							<td><a href="viewBook.do?bookid=${data.bookid}">${data.bookname}</a></td>
							<td><a href="viewpublisher.do?publisher=${data.publisher}">${data.publisher}</a></td>
							<td>${data.price}</td>
							<td><img src="${data.img}" class="bookimg"></td>
							<td><input type="checkbox" name="bookid"
								value="${data.bookid}"></td>
						</tr>
						<input type="hidden" name="img" value="${data.img}" />
						<!-- bookid로 db 검색하는 함수가 dao에 없으므로 따로 img input -> 어떤 이미지가 input 될지 모른다... 좋은 방법이 아님 -->
					</c:forEach>
				</table>
			</form>
		</section>
	</div>

	<%@include file="common/footer.jsp"%>
</body>
</html>