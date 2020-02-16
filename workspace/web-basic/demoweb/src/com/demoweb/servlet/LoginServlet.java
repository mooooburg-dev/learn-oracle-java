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

@WebServlet(urlPatterns = {"/account/login"})
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/account/login.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1. 요청 데이터 읽기
		String memberId = req.getParameter("memberId");
		String passwd = req.getParameter("passwd");
		
		// 2. 데이터 베이스에서 데이터 조회
		MemberRepository memberRepository = new MemberRepository();
		MemberVO member = memberRepository.selectMemberByIdAndPasswd(memberId, passwd);
		
		// 3. 
		if (member != null) { // 성공하면 -> home 화면으로 이동
			
			// 로그인 처리 : session 객체에 데이터 저장
			HttpSession session = req.getSession();	// 서블릿에는 session 객체가 없기때문에 req 객체에서 가져옵니다.
			session.setAttribute("loginuser", member);
			
			// 홈 화면으로 이동
			resp.sendRedirect("/demoweb/home");
		}
		else {	// 실패하면 -> 로그인 화면으로 이동
			resp.sendRedirect("/demoweb/account/login");
		}
		
		
		
	}
}
