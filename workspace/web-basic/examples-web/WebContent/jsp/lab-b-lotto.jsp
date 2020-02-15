<%@page import="com.exampleweb.service.Lotto"%>
<%@ page language="java" 
		 contentType="text/html; charset=utf-8"
    	 pageEncoding="utf-8" %>
    	 
<%!
public int[] selectGoldenNumbers() {

	int[] numbers = null;
	int average = 0;
	do {
		numbers = selectBasicNumbers();
		
		average = calculateMean(numbers);
		
	} while (average < 20 || average > 26);//3. 평균 검사 (20 ~ 26, 실패하면 1부터 다시)
		
	return numbers;
}
			

public int[] selectBasicNumbers() {
	int[] numbers = new int[6];
	for (int i = 0; i < 6; i = i + 1) {
		numbers[i] = (int)(Math.random() * 45) + 1; // 1 ~ 45
		for (int j = 0; j < i; j = j + 1) {
			if (numbers[i] == numbers[j]) {
				//i = i - 1;//i의 위치를 감소시켜서 증감식의 증가 효과를 제거
				i = -1; //처음부터 다시 뽑기
			}
		}
	}
	return numbers;
}

public int calculateMean(int[] numbers) {
	int sum = 0; //각 숫자를 더하기 전에 기존에 저장된 값을 제거
	for (int i = 0; i < 6; i = i + 1) {
		sum = sum + numbers[i];
	}
	int average = sum / 6;
	
	return average;
}
%>

<%
	//Lotto.java 파일의 selectGoldenNumbers 메서드와 관련 메서드를 사용해서 당첨예상번호 뽑기
	//뽑힌 번호는 배열 변수에 저장
	
	//int[] numbers = selectGoldenNumbers(); // JSP 선언문에서 만든 메서드 호출
	
	Lotto lotto = new Lotto();
	int[] numbers = lotto.selectGoldenNumbers(); // 별도의 Lotto 객체의 메서드 호출
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Lotto Numbers</title>
</head>
<body>
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









