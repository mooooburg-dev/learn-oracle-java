<%@page import="com.example.springmvc.Person"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Result Page</title>
</head>
<body>

	<h2>Result Page3</h2>
	
	<%= "My Data : " + request.getAttribute("my_data") %>
	<br>
	<% Person person = (Person)request.getAttribute("person"); %>
	<%= "PERSON : " + person.getName() %>
	<% Person person2 = (Person)request.getAttribute("person2"); %>
	<%= "PERSON : " + person2.getName() %>
	
	<hr>
	
	<c:if test="${ not empty my_data }">
	<h2>MY DATA : ${ my_data }</h2>
	</c:if>
	
	<c:if test="${ not empty person2 }">
	<h2>[${ person2.name }][${ requestScope.person2.age }]</h2>
	</c:if>
	
	<c:if test="${ not empty person }">
	<h2>[${ person.name }][${ requestScope.person.age }]</h2>
	</c:if>
	
	<a href="/spring-mvc2/home.action">홈으로 이동</a>

</body>
</html>








