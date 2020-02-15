<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>File Upload</title>
</head>
<body>

	<h2>File Upload Test</h2>
	<form action="07.process-upload.jsp" method="post" enctype="multipart/form-data">
		<input type="text" name="data1"><br>
		<input type="text" name="data2"><br>
		<input type="file" name="file1"><br>
		<input type="submit" value="전송">
	</form>

</body>
</html>