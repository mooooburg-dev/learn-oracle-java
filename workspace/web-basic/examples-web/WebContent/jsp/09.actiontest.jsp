<%@page import="com.exampleweb.vo.Member"%>
<%@ page language="java" 
		 contentType="text/html; charset=utf-8"
    	 pageEncoding="utf-8"%>

<%-- <% Member member = new Member() %> --%>
<jsp:useBean id="member" class="com.exampleweb.vo.Member" />

<%-- <% member.setMemberId(request.getParameter("memberId")) --%>
<%-- 
<jsp:setProperty property="memberId" name="member" />
<jsp:setProperty property="passwd" name="passwd" />
--%>

<jsp:setProperty property="*" name="member" />

           <%-- <%= member.getMemberId() %> --%>
MEMBERID : <jsp:getProperty name="member" property="memberId" />
<br>
EMAIL : <jsp:getProperty name="member" property="email" />