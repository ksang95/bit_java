<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- 확장된 태그 라이브러리 사용 : maven repository - jstl 1.2 - jar 파일 lib 폴더로 -->

<c:import var="data" url="http://www.weather.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=109"></c:import> <!-- url이 변수 data로 -->

${data} <!-- data출력 -->