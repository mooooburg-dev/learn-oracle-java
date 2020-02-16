<%@page import="com.demoweb.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div id="header">
	<div class="title">
		<a href="/demoweb/home">DEMO WEBSITE</a>
	</div>
	<div class="links">
		<% MemberVO member = (MemberVO)session.getAttribute("loginuser"); %>
		<% if(member == null){ %>
		<a href="/demoweb/account/login">로그인</a>
		<a href="/demoweb/account/register">가입</a>
		<%  } else { %>
		<!-- 사용자 정보 표시 -->
		<%= member.getMemberId() %> 님 환영합니다.
		<a href="/demoweb/account/logout">로그아웃</a>
		<%  } %>
	</div>
</div>        
<div id="menu">
	<div>
		<ul>
	        <!-- a : 페이지 이동을 처리하는 마크업 -->
			<li><a href="#">사용자관리</a></li>
			<li><a href="#">메일보내기</a></li>
			<li><a href="#">자료실</a></li>
			<li><a href="#">게시판</a></li>
		</ul>
	</div>
</div>
<div style="text-align:right; padding: 5px; border:solid 1px;">
	[TOTAL : <%= application.getAttribute("total") %>]
	[CURRENT : <%= application.getAttribute("current") %>]
</div>
