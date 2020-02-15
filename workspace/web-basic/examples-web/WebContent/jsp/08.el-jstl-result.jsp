<%@ page import="com.exampleweb.servlet.DepartmentVO"%>
<%@ page language="java" 
	contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
    
<%-- JSTL을 사용하기 위해 등록하는 설정 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>EL & JSTL Result</title>
</head>
<body>
	<h2>EL TEST</h2>
	<h3><%= request.getAttribute("req_data") %></h3>
	<h3>${ req_data }</h3><%-- request, session, application 등에서 데이터 검색 --%>
	<h3>${ requestScope.req_data }</h3>
	<h3><%= session.getAttribute("sess_data") %></h3>
	<h3>${ sess_data }</h3><%-- request, session, application 등에서 데이터 검색 --%>
	<h3>${ sessionScope.sess_data }</h3>
	<hr>
	<% DepartmentVO dpv = (DepartmentVO)request.getAttribute("dp"); %>	
	<h3><%= dpv.getDepartmentId() %> / <%= dpv.getDepartmentName() %></h3>	
	<h3>${ dp.departmentId } / ${ dp.departmentName }</h3>
	<hr>
	<h3>${ al[0].departmentId } / ${ al[0].departmentName }</h3>
	<h3>${ al[1] }</h3>
	<hr>
	<h2>JSTL TEST</h2>
	<c:set var="my_name" value="John Doe" /> <%-- pageContext.setAttribute("my_name", "John Doe") --%>
	<h3><%= pageContext.getAttribute("my_name") %></h3>
	<h3>${ my_name }</h3>
	<hr>
	<c:if test="${ not empty al }">
	<h3>조건식을 만족했기 때문에 이 메시지가 표시됩니다.</h3>
	</c:if>
	<hr>
	<c:forEach var="o" items="${ al }"> <%-- for (Object o : al) { } --%>
		<h3>${ o }</h3>
	</c:forEach>
</body>
</html>











