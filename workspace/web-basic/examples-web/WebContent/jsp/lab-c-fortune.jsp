<%@ page language="java" 
		 contentType="text/html; charset=utf-8"
    	 pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Today's Fortune</title>
</head>
<body>

	<%-- 뽑힌 숫자에 해당하는 행운 메시지 출력 --%>	
	<h2><%= request.getAttribute("message") %></h2>
	
</body>
</html>









