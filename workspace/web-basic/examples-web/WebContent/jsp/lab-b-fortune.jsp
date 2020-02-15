<%@ page language="java" 
		 contentType="text/html; charset=utf-8"
    	 pageEncoding="utf-8" %>

<%-- 
하나의 jsp 파일은 _jspService 메서드 영역에 포함
- 하나의 지역이기 때문에 서로 다른 스크립트릿 영역에서 변수를 공유할 수 있습니다. 
--%>
<%
//1. 문자열 배열(또는 가변배열 - ArrayList) 만들기
String[] messages = new String[10]; //이 변수는 다른 스크립트릿 영역에서 사용할 수 있습니다.

//2. 배열에 10개의 행운 메시지 추가 할당
for (int i = 0; i < messages.length; i++) {
	messages[i] = "행운 메시지 " + (i + 1);
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Today's Fortune</title>
</head>
<body>

	<%
	//Random 숫자 뽑기 (0 ~ 9)
	int r = (int)(Math.random() * 10);	
	%>	
	<%-- 뽑힌 숫자에 해당하는 행운 메시지 출력 --%>	
	<h2><%= messages[r] %></h2>
	
</body>
</html>









