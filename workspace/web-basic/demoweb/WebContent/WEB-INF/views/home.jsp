<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8" />
    <title></title>
    <link rel="Stylesheet" href="/demoweb/styles/default.css" />
</head>
<body>

    <div id="pageContainer">
    
		<!-- Page Module 사용  -->
    	<%-- <% pageContext.include("/WEB-INF/views/include/header.jsp"); %> --%>
    	<%-- <%@ include file="/WEB-INF/views/include/header.jsp" %> --%>
    	<jsp:include page="/WEB-INF/views/include/header.jsp" />
    
        <div id="content">
        	<br /><br /><br /><br /><br />
        	<h2 style='text-aling:center'>
				Hello Demo Web Site Main Page !!!
			</h2>
        </div>
    </div>
    
</body>
</html>