package com.helloexample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet : web.xml의 서블릿 등록 + 경로 매핑과 같은 효과
// @WebServlet(urlPatterns = {"/hello2"})
@WebServlet("/hello2") // 위의 표현을 약식으로 표현한 문법
public class HelloServlet2 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello, Servlet 2</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>Hello, Servlet 2 (GET)</h2>");
		out.println("<h2>" + new Date() + "</h2>");
		out.println("</body>");
		out.println("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title></title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>Hello, Servlet 2 (POST)</h2>");
		out.println("<h2>" + new Date() + "</h2>");
		out.println("</body>");
		out.println("</html>");
		
	}
}

