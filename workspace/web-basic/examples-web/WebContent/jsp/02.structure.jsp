<%@page import="java.util.Date"%>
<%@ page language="java" 
		 contentType="text/html; charset=utf-8"
    	 pageEncoding="utf-8" %>
    	 

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Page Structure</title>
</head>
<body>

	<%-- JSP 주석 or 서버 주석 : 서버에서 주석 처리, 브라우저에 응답되지 않습니다. --%>
	<!-- HTML 주석 or 클라이언트 주석 : 브라우저에서 주석 처리, 서버에서는 HTML로 해석 (응답) -->
	
	<%-- 스크립트릿 : 일반적인 자바 코드를 삽입하는 구문 --%>
	<h2>
	<% 
	Date d = new Date();
	out.write(d.toString()); //응답 스트림에 출력하는 명령
	%>
	</h2>
	<h2>
	<%-- 표현식 : 값을 응답스트림에 출력하는 코드를 삽입하는 구문 --%>
	<%= d.toString() %>	
	</h2>
	<h2>
	<%-- 선언문 : 메서드 또는 필드를 선언하는 구문 --%>
	<%!
	String timeString() {
		Date d = new Date();
		return d.toString();
	}
	%>
	<%= timeString() %>
	</h2>

</body>
</html>









