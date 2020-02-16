package com.demoweb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demoweb.repository.MemberRepository;
import com.demoweb.vo.MemberVO;

@WebServlet(urlPatterns = {"/account/logout"})
public class LogoutServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1.로그아웃 처리
		HttpSession session = req.getSession();
		session.removeAttribute("loginuser");	// 세션의 지정된 데이터만 제거
		//session.invalidate();// 세션의 모든 데이터 제거(세션 초기화)
		
		// 2.페이지 이동
		resp.sendRedirect("/demoweb/home");
		
	}
}
