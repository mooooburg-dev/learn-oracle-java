<%@ page language="java" 
		 contentType="text/html; charset=utf-8"
    	 pageEncoding="utf-8" %>
    	 

<%
//1. 전송된 id, passwd 읽기
String id = request.getParameter("id");
String passwd = request.getParameter("passwd");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Login</title>
</head>
<body>

	<% boolean valid = (boolean)request.getAttribute("valid"); %>
	<% if ( valid ) { %>
	<h3>로그인 성공</h3>
	<% } else { %>
	<h3>로그인 실패</h3>
	<% } %>
	
</body>
</html>









