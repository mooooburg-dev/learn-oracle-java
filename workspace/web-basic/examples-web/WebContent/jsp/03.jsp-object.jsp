<%@page import="java.util.Date"%>
<%@ page language="java" 
		 contentType="text/html; charset=utf-8"
    	 pageEncoding="utf-8" %>
    	 

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>JSP Object</title>
</head>
<body>

	<% out.print("<h3>Hello, JSP Object</h3>"); %>
	<h3>Hello, JSP Object</h3>
	
	<%
	pageContext.setAttribute("data1", "PageContext Object Data");
	request.setAttribute("data2", "Request Object Data");
	session.setAttribute("data3", "Session Object Data");
	application.setAttribute("data4", "Application Object Data");
	%>
	
	<h3><%= pageContext.getAttribute("data1") %></h3>
	<h3><%= request.getAttribute("data2") %></h3>
	<h3><%= session.getAttribute("data3") %></h3>
	<h3><%= application.getAttribute("data4") %></h3>
	
</body>
</html>









