<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>File List</title>
</head>
<body>

<a href="07.file-upload-form.jsp">파일 업로드</a>

<hr>

<%
//application.getRealPath("웹경로"); -> "컴퓨터 경로" 반환
// "http://...." -> "C:\...."
String path = application.getRealPath("/upload-files");

File file = new File(path); //File : 파일 또는 디렉터리 정보를 관리하는 클래스 (여기서는 디렉터리)
File[] files = file.listFiles(); // 지정된 디렉터리에 포함된 모든 파일 및 디렉터리 목록 반환
%>
	<h3>File List</h3>
	<% for (File f : files) { %>
	<p><a href="/examples-web/download.action?file=<%= f.getName() %>"><%= f.getName() %></a></p>
	<% } %>

</body>
</html>




