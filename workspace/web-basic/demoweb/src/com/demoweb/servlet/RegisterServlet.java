package com.demoweb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demoweb.repository.MemberRepository;
import com.demoweb.vo.MemberVO;

@WebServlet(urlPatterns = {"/account/register"})
public class RegisterServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/account/register.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1. 요청 데이터 읽기
		//HTTPServeletRequest.getParameter : form 데이터 읽기
		String memberId = req.getParameter("memberId");
		String passwd = req.getParameter("passwd");
		String email = req.getParameter("email");
		
		//2. 데이터베이스에 저장
		MemberVO member = new MemberVO();
		member.setMemberId(memberId);
		member.setPasswd(passwd);
		member.setEmail(email);
		
		MemberRepository memberRepository = new MemberRepository();
		memberRepository.insertMember(member);
		
		
		//3. 로그인 화면으로 이동
		//resp.sendRedirect("login");	// 상대경로
		resp.sendRedirect("/demoweb/account/login");	// 절대경로(브라우저가 쓰는 url)
		
	}
}
