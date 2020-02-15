package com.exampleweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/handle-request.action") // 요청 매핑 : 지정된 요청이 발생하면 이 서블릿을 호출하세요
public class HandleRequestServlet extends HttpServlet { // 서블릿이 되기 위한 상속 

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//HttpServletRequest.getParameter : 요청 데이터를 읽는 메서드
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		
		System.out.printf("[%s][%s]\n", name, email); //서버의 콘솔에 출력
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter(); // 네트워크로 데이터를 전송하는 IO 객체
		String message = String.format("<h2>[%s][%s]</h2>", name, email);
		out.append(message);//브라우저로 데이터 보내기
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("HANDLE POST REQUEST");
		
		req.setCharacterEncoding("utf-8"); //post 요청은 인코딩 지정을 해야 합니다.
		
		doGet(req, resp);
	}
	
}
