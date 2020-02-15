<%@ page language="java" 
		 contentType="text/html; charset=utf-8"
    	 pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Lotto Numbers</title>
</head>
<body>
	<%-- 서블릿에서 저장한 데이터를 읽어서 변수에 저장 (이 때 Object 형식으로 주기 때문에 형변환 필요 --%>
	<% int[] numbers = (int[])request.getAttribute("numbers"); %>
	
	<%-- 뽑힌 숫자를 표시 (반복문을 사용해서 표시) --%>
	<h2>[ SELECED NUMBERS ]</h2>
	<table border="1">
	<tr style="height:50px">
	<% for (int i = 0; i < numbers.length; i++) { %>
		<td style="text-align:center;width:50px"><%= numbers[i] %></td>
	<% } %>
	</tr>
	</table>
	
	<hr>
	
	<%-- 뽑힌 숫자를 표시 (반복문을 사용해서 표시) --%>
	<h2>[ SELECED NUMBERS ]</h2>
	<table border="1">
	<tr style="height:50px">
	<% 
	for (int i = 0; i < numbers.length; i++) { 
		out.print("<td style='text-align:center;width:50px'>" + numbers[i] + "</td>");
	}
	%>
	</tr>
	</table>
	
</body>
</html>









