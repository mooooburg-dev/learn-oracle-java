<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %><%-- JSTL의 함수를 제공하는 taglib --%>
    
<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8" />
	<title>자료업로드</title>
	<link rel="Stylesheet" href="/resources/styles/default.css" />
	<link rel="Stylesheet" href="	/resources/styles/input.css" />
</head>
<body>

	<div id="pageContainer">
	
		<jsp:include page="/WEB-INF/views/include/header.jsp" />
		
		<div style="padding-top:25px;text-align:center">
		<div id="inputcontent">
		    <div id="inputmain">
		        <div class="inputsubtitle">업로드 자료 정보</div>
		        <table>
		            <tr>
		                <th>제목</th>
		                <td>${ upload.title }</td>
		            </tr>
		            <tr>
		                <th>작성자</th>
		                <td>${ upload.uploader }</td>
		            </tr>
		            <tr>
		            	<th>조회수</th>
		            	<td>${ upload.readCount }</td>
		            </tr>
		            <tr>
		            	<th>등록일자</th>
		            	<td>${ upload.regDate }</td>
		            </tr>
		            <tr>
		                <th>첨부자료</th>
		                <td>								<!-- EL/jstl에서 upload.files는 upload.getFiles()와 같다 -->
		                <c:forEach var="file" items="${ upload.files }">
		                	<div>${ file.userFileName } [${ file.downloadCount }]</div>
		                </c:forEach>
		                </td>
		            </tr>
		            <tr>
		                <th>자료설명</th>
		                <td>${ upload.content }</td>
		            </tr>
		        </table>
		        <div class="buttons">
		        	
		        	<input type="button" id="update_button" value="편집" style="height:25px" />
		        	<input type="button" id="delete_button" value="삭제" style="height:25px" />
		        	
		        	<input type="button" id="cancel_button" value="목록보기" style="height:25px" />
		        	<script type="text/javascript">
		        	//브라우저가 html을 모두 읽고 처리할 준비가 되었을 때 호출할 함수 지정
		        	window.addEventListener('load', function(event) {//js의 main 함수 역할
		        		
		        		var btnCancel = document.querySelector('#cancel_button');
		        		btnCancel.addEventListener('click', function(event) {
		        			//history.back();
		        			location.href = "/upload/list";
		        		});
		        		
		        		var btnDelete = document.querySelector('#delete_button');
		        		btnDelete.addEventListener('click', function(event) {
		        			location.href = "/upload/delete/${upload.uploadNo}";
		        		});
		        		
		        		var btnUpdate = document.querySelector('#update_button');
		        		btnUpdate.addEventListener('click', function(event) {
		        			
		        		});
		        		
		        	});
		        	</script>
		        </div>
		    </div>
		</div>   	
	
	</div>
	</div>

</body>
</html>