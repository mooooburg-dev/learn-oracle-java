<%@ page language="java" 
		 contentType="text/html; charset=utf-8" 
		 pageEncoding="utf-8"%>

		<div id="header">    	
            <div class="title">
                <a href="/">DEMO WEBSITE</a>
            </div>
            <div class="links">

            	<a href="/account/login">로그인</a>
                <a href="/account/register">회원가입</a>

            	${ loginuser.memberId }님 환영합니다.
            	<a href="/account/logout">로그아웃</a>
            </div>
        </div>
                
        <div id="menu">
            <div>
                <ul>
                    <li><a href="#">사용자관리</a></li>
					<li><a href="#">메일보내기</a></li>
					<li><a href="/upload/list">자료실</a></li>
					<li><a href="#">게시판</a></li>
                </ul>
            </div>
		</div>