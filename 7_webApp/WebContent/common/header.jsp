<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

 <header>
       <hgroup>
		   <h1>Page Title</h1> 
		   <h2> Page SubTitle</h2>
		</hgroup>
	 </header>	
	 
		<nav>
		   <ul>
		      <li> <a href="index.jsp">Home</a></li>
		      <li class="dropbox"> 
		            <a id="etc" href="#">게시판</a>
		          <span class="dropmenu">
			          <span> <a href="table1.html">자유게시판</a></span>
				      <span> <a href="table2.html">문의게시판</a></span>
				      <span> <a href="listBook.do">bookList</a></span>
				      <span> <a href="#">Link 4</a></span>
				      <span> <a href="#">Link 5</a></span>
		          </span>
		      </li>
		      <li> <a href="#">Tutorials</a></li>
		      <li> <a href="#">About</a></li>
		      <c:if test="${empty login}">
		      <li> <a href="login.jsp">LOGIN</a></li>
		      </c:if>
		      <c:if test="${!empty login}">
		      <li id="lgt"> <a href="logout.do">LOGOUT</a>(로그인 정보:${login})</li>
		      </c:if>
		   </ul>
		</nav>